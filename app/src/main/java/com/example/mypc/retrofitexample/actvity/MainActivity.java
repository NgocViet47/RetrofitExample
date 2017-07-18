package com.example.mypc.retrofitexample.actvity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mypc.retrofitexample.R;
import com.example.mypc.retrofitexample.model.User;
import com.example.mypc.retrofitexample.model.responseResultModel.ResultResponse;
import com.example.mypc.retrofitexample.realm.RealmStatus;
import com.example.mypc.retrofitexample.repository.CallBackData;
import com.example.mypc.retrofitexample.repository.RepositoryService;
import com.example.mypc.retrofitexample.repository.TicketboxRepository;
import com.example.mypc.retrofitexample.sharedpreference.SharedPreference;
import com.example.mypc.retrofitexample.utils.TimeManager;

import java.util.List;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private EditText edtEmail, edtPassword;
    private Button btnLogin;
    private TextView tvForgotPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialView();
        addEvent();
    }


    private void addEvent() {
        btnLogin.setOnClickListener(this);
        tvForgotPassword.setOnClickListener(this);
    }

    private void initialView() {
        edtEmail = (EditText) findViewById(R.id.edtEmail);
        edtPassword = (EditText) findViewById(R.id.edtPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        tvForgotPassword = (TextView) findViewById(R.id.tvForgotPassword);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnLogin:
                btnLoginButton();
                break;
            case R.id.tvForgotPassword:
                tvForgotPasswordButton();
                break;
        }
    }

    private void tvForgotPasswordButton() {
        Intent intent = new Intent(this, ForgotActivity.class);
        startActivity(intent);
    }

    private void btnLoginButton() {
        TicketboxRepository repository = new RepositoryService();
        repository.login(this, edtEmail.getText().toString(), edtPassword.getText().toString(), new CallBackData<User>() {
            @Override
            public void onResponseData(User user) {
                Log.e("Log", "Login Finish");
                if (RealmStatus.getStatusTicket(getApplicationContext()) != null) {
                    RealmStatus.clearAllStatusTicket(getApplicationContext());
                }
                addRealmStatusTicket();
                saveStartTime(user);
                loadActivityStatus();
            }

            @Override
            public void onFailed(String message) {

            }
        });
    }

    private void addRealmStatusTicket() {
        TicketboxRepository repository = new RepositoryService();
        repository.getStatusTicketBox(this, new CallBackData<ResultResponse<List<Integer>>>() {
            @Override
            public void onResponseData(ResultResponse<List<Integer>> listResultResponse) {

            }

            @Override
            public void onFailed(String message) {

            }
        });
    }

    private void loadActivityStatus() {
        Intent intent = new Intent(this, EventActivity.class);
        startActivity(intent);
    }

    private void saveStartTime(User user) {
        Long startTime = user.getExpired_time() + TimeManager.getTimeLocalMiliSecond();
        SharedPreference.saveLong(startTime, SharedPreference.KEY_START_TIME, this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.e("Clear", "Realm");
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
}
