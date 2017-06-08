package com.example.mypc.retrofitexample.actvity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.mypc.retrofitexample.R;
import com.example.mypc.retrofitexample.model.User;
import com.example.mypc.retrofitexample.repository.CallBackData;
import com.example.mypc.retrofitexample.repository.RepositoryService;
import com.example.mypc.retrofitexample.repository.TicketboxRepository;
import com.example.mypc.retrofitexample.sharedpreference.GetTimeToMilliSecond;
import com.example.mypc.retrofitexample.sharedpreference.SharedPreference;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText edtEmail,edtPassword;
    private Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialView();
        addEvent();
        checkLogged();
    }

    private void checkLogged() {

    }

    private void addEvent() {
        btnLogin.setOnClickListener(this);
    }

    private void initialView() {
        edtEmail = (EditText) findViewById(R.id.edtEmail);
        edtPassword = (EditText) findViewById(R.id.edtPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnLogin:
                btnLoginButton();
                break;
        }
    }

    private void btnLoginButton() {
        TicketboxRepository repository = new RepositoryService();
        repository.login(this, edtEmail.getText().toString(), edtPassword.getText().toString(), new CallBackData<User>() {
            @Override
            public void onResponseData(User user) {
                Log.e("Log","Login Finish");
                saveStartTime(user);
                loadActivityStatus();
            }

            @Override
            public void onFailed(String message) {

            }
        });
    }

    private void loadActivityStatus() {
        Intent intent = new Intent(this,EventActivity.class);
        startActivity(intent);
    }
    private void saveStartTime(User user){
        Long startTime = user.getExpired_time()+ GetTimeToMilliSecond.getTimeLocal();
        SharedPreference.saveLong(startTime,SharedPreference.KEY_START_TIME,this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
     /*   Realm realm = Realm.getInstance(getRealmConfig(this));
        RealmResults<User> results = realm.where(User.class).findAll();
        realm.beginTransaction();
        results.deleteAllFromRealm();
        realm.commitTransaction();*/

        Log.e("Clear","Realm");
    }
}
