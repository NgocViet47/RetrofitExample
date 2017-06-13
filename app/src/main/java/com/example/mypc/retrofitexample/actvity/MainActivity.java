package com.example.mypc.retrofitexample.actvity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mypc.retrofitexample.R;
import com.example.mypc.retrofitexample.model.User;
import com.example.mypc.retrofitexample.repository.CallBackData;
import com.example.mypc.retrofitexample.repository.RepositoryService;
import com.example.mypc.retrofitexample.repository.TicketboxRepository;
import com.example.mypc.retrofitexample.sharedpreference.GetTimeToMilliSecond;
import com.example.mypc.retrofitexample.sharedpreference.SharedPreference;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtEmail, edtPassword;
    private Button btnLogin;
    private ImageView imgLoginBack;
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
        imgLoginBack.setOnClickListener(this);
    }

    private void initialView() {
        edtEmail = (EditText) findViewById(R.id.edtEmail);
        edtPassword = (EditText) findViewById(R.id.edtPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        tvForgotPassword = (TextView) findViewById(R.id.tvForgotPassword);
        imgLoginBack = (ImageView) findViewById(R.id.imgLoginBack);
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
            case R.id.imgLoginBack:
                imgLoginBackButton();
                break;
        }
    }

    private void imgLoginBackButton() {
        finish();
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
                saveStartTime(user);
                loadActivityStatus();
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
        Long startTime = user.getExpired_time() + GetTimeToMilliSecond.getTimeLocal();
        SharedPreference.saveLong(startTime, SharedPreference.KEY_START_TIME, this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.e("Clear", "Realm");
    }
}
