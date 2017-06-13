package com.example.mypc.retrofitexample.actvity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.mypc.retrofitexample.R;
import com.example.mypc.retrofitexample.repository.RepositoryService;
import com.example.mypc.retrofitexample.repository.TicketboxRepository;

public class ForgotActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtEmailForgotPassword;
    private Button btnSendEmail;
    private ImageView imgButtonForgotPasswordBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot);
        initialView();
        setEvent();
    }

    private void setEvent() {
        btnSendEmail.setOnClickListener(this);
    }

    private void initialView() {
        edtEmailForgotPassword= (EditText) findViewById(R.id.edtEmailForgotPassword);
        btnSendEmail= (Button) findViewById(R.id.btnSendEmailForgotPassword);
        imgButtonForgotPasswordBack = (ImageView) findViewById(R.id.imgForgotPasswordBack);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnSendEmailForgotPassword:
                btnSendEmailButton();
                break;
            case R.id.imgForgotPasswordBack:
                imgButtonForgotPasswordBackButton();
                break;
        }
    }

    private void imgButtonForgotPasswordBackButton() {
        finish();
    }

    private void btnSendEmailButton() {
        TicketboxRepository repository = new RepositoryService();
        repository.resetPassword(this,edtEmailForgotPassword.getText().toString());
    }
}
