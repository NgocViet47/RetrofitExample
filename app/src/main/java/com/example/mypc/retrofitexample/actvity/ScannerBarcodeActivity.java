package com.example.mypc.retrofitexample.actvity;

import android.content.pm.ActivityInfo;
import android.hardware.Camera;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mypc.retrofitexample.R;
import com.example.mypc.retrofitexample.constant.ConstantCheckIn;
import com.example.mypc.retrofitexample.model.Order;
import com.example.mypc.retrofitexample.model.StatusTicket;
import com.example.mypc.retrofitexample.model.Ticket;
import com.example.mypc.retrofitexample.model.TicketType;
import com.example.mypc.retrofitexample.utils.OrderManager;
import com.example.mypc.retrofitexample.utils.StatusManager;
import com.example.mypc.retrofitexample.utils.TicketManager;
import com.example.mypc.retrofitexample.utils.TicketTypeManager;
import com.example.mypc.retrofitexample.utils.TimeManager;

import net.sourceforge.zbar.Config;
import net.sourceforge.zbar.Image;
import net.sourceforge.zbar.ImageScanner;
import net.sourceforge.zbar.Symbol;
import net.sourceforge.zbar.SymbolSet;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ScannerBarcodeActivity extends BaseActivity {
    private Camera mCamera;
    private CameraPreviewer mPreview;
    private Handler autoFocusHandler;
    private Handler autoReplayCamera;
    private ImageScanner scanner;
    private boolean previewing = true;
    private List<Ticket> ticketList = new ArrayList<>();
    private List<Order> orderList = new ArrayList<>();
    private List<TicketType> ticketTypeList = new ArrayList<>();

    private TextView tvBaseCodeTicket,tvNameUserTicket,tvTicketStatus,tvTicketType,tvTicketSeat,tvLastSyncTime;
    private ImageView imgStatusTicket;
    private LinearLayout loStatusColor;

    private Calendar calendar = Calendar.getInstance();

    static {
        System.loadLibrary("iconv");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanner_barcode);

        initialView();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    private void initialView() {
        tvBaseCodeTicket = (TextView) findViewById(R.id.tvBaseCodeTicket);
        tvNameUserTicket = (TextView) findViewById(R.id.tvNameUserTicket);
        tvTicketSeat = (TextView) findViewById(R.id.tvTicketSeat);
        tvTicketType = (TextView) findViewById(R.id.tvTicketType);
        tvTicketStatus = (TextView) findViewById(R.id.tvStatusTicket);
        tvLastSyncTime = (TextView) findViewById(R.id.tvLastSyncTimeTicketCheckInStatus);
        imgStatusTicket = (ImageView) findViewById(R.id.imgStatusTicket);
        loStatusColor = (LinearLayout) findViewById(R.id.loStatusColor);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        autoFocusHandler = new Handler();
        mCamera = getCameraInstance();
        scanner = new ImageScanner();
        scanner.setConfig(0, Config.X_DENSITY, 3);
        scanner.setConfig(0, Config.Y_DENSITY, 3);
        mPreview = new CameraPreviewer(this, mCamera, previewCb, autoFocusCB);
        FrameLayout preview = (FrameLayout) findViewById(R.id.cameraPreview);
        preview.addView(mPreview);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");
    }

    public static Camera getCameraInstance() {
        Camera c = null;
        try {
            c = Camera.open();
        } catch (Exception e) {
        }
        return c;
    }

    private void releaseCamera() {
        if (mCamera != null) {
            previewing = true;
            mCamera.setPreviewCallback(previewCb);
            mCamera.startPreview();
        }
    }

    private Runnable doAutoFocus = new Runnable() {
        public void run() {
            if (previewing)
                mCamera.autoFocus(autoFocusCB);
        }
    };
    Camera.PreviewCallback previewCb = new Camera.PreviewCallback() {
        public void onPreviewFrame(byte[] data, Camera camera) {
            ticketList = TicketManager.getListTicket(getApplicationContext());
            orderList = OrderManager.getListOrder(getApplicationContext());
            ticketTypeList = TicketTypeManager.getListTicketType(getApplicationContext());
            Camera.Parameters parameters = camera.getParameters();
            Camera.Size size = parameters.getPreviewSize();
            Image barcode = new Image(size.width, size.height, "Y800");
            barcode.setData(data);
            int result = scanner.scanImage(barcode);
            if (result != 0) {
                previewing = false;
                mCamera.setPreviewCallback(null);
                mCamera.stopPreview();
                SymbolSet syms = scanner.getResults();
                for (Symbol sym : syms) {
                    String baseCode = sym.getData();
                    loadTicketStatus(baseCode);
                }
                autoReplayCamera = new Handler();
                autoReplayCamera.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        releaseCamera();
                    }
                },3000);
            }
        }

        private void loadTicketStatus(String baseCode) {
            for(int i = 0;i<ticketList.size();i++){
                Ticket ticket = ticketList.get(i);
                if(baseCode.equals(ticket.getBarcode())){
                    setTextViewTicketType(ticket.getTicketTypeId());
                    setTextViewNameUserOrder(ticket.getOrderId());
                    tvTicketSeat.setText(ticket.getSeatRow()+"-"+ticket.getSeatNumber());
                    tvBaseCodeTicket.setText(ticket.getBarcode()+"");
                    tvLastSyncTime.setText("Last sync: "+TimeManager.getLastSyncTimeCalendarGetInstance(calendar));
                    loadStatusTicketInListTicket(ticket.getStatus(),baseCode);
                    break;
                }else {
                    setStatusColorAndImg(ConstantCheckIn.INVALID,getResources().getColor(R.color.status_invalid),R.drawable.invalid);
                }
            }
        }

        private void loadStatusTicketInListTicket(Integer status, String baseCode) {
            if(status==11){
                setStatusColorAndImg(ConstantCheckIn.DUPLE_CATE,getResources().getColor(R.color.status_duple_cate),R.drawable.duplicate);
            }else {
                List<StatusTicket> listStatusTicket = StatusManager.getAllStatusTicket(getApplicationContext());
                for (int i = 0; i < listStatusTicket.size(); i++) {
                    if (status.equals(listStatusTicket.get(i).getData())){
                        setStatusColorAndImg(ConstantCheckIn.VALID,getResources().getColor(R.color.status_valid),R.drawable.valid);
                        TicketManager.putTicket(getApplicationContext(),baseCode,TimeManager.getStringTimeIso8601ByCalendar(calendar));
                        break;
                    }
                }
            }
        }

        private void setStatusColorAndImg(String textStatus, int colorStatus, int img) {
            tvTicketStatus.setTextColor(colorStatus);
            tvTicketStatus.setText(textStatus);
            loStatusColor.setBackgroundColor(colorStatus);
            imgStatusTicket.setImageResource(img);
        }

        private void setTextViewNameUserOrder(Integer orderId) {
            for(int i=0;i<orderList.size();i++){
                if(orderId.equals(orderList.get(i).getOrderId())){
                    tvNameUserTicket.setText(orderList.get(i).getBuyerFirstName()+" "+orderList.get(i).getBuyerLastName());
                    break;
                }
            }
        }

        private void setTextViewTicketType(Integer ticketTypeId) {
            for (int i=0;i<ticketTypeList.size();i++){
                if(ticketTypeId.equals(ticketTypeList.get(i).getTicketTypeId())){
                    tvTicketType.setText(ticketTypeList.get(i).getTitle());
                    break;
                }
            }
        }
    };
    Camera.AutoFocusCallback autoFocusCB = new Camera.AutoFocusCallback() {
        public void onAutoFocus(boolean success, Camera camera) {
            autoFocusHandler.postDelayed(doAutoFocus, 1000);
        }
    };
}