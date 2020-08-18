package com.example.moborivs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.moborivs.apiservices.LoginModel.LoginBody;
import com.example.moborivs.apiservices.LoginModel.LoginResp;
import com.example.moborivs.apiservices.ServiceMainApi;
import com.example.moborivs.persiststorage.Account;
import com.example.moborivs.persiststorage.AccountRepository;
import com.example.moborivs.ui.sharePreference.SessionManager;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity{

    TextView textView;
    EditText Email, Password;
    Button button;
    public static final String TAG3 = "px";
    SessionManager sessionManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Email = findViewById(R.id.login_tv_email_id);
        Password = findViewById(R.id.login_tv_password_id);
        button = findViewById(R.id.login_button_id);

        textView = findViewById(R.id.back_login_id);

        sessionManager = SessionManager.getInstance(getApplicationContext());

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, WelcomeActivity.class));
                finish();
            }
        });

        button.setOnClickListener(ButtonListener);
    }

    private View.OnClickListener ButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Log.i(TAG3, String.valueOf(isTrue(Email.getText().toString(), Password.getText().toString())));
        }
    };

    private boolean isTrue(String email, String password){
        if(email.isEmpty()){
            Email.setError("EMAIL MUST NOT BE EMPTY");
            return false;
        }else if(password.isEmpty()){
            Password.setError("PASSWORD MUST NOT BE EMPTY");
            return false;
        }else{
            Call<LoginResp> logResponse = ServiceMainApi.getApi().getLoginResponse(new LoginBody(email, password));
            logResponse.enqueue(new Callback<LoginResp>() {
                @Override
                public void onResponse(Call<LoginResp> call, Response<LoginResp> response) {
                    if(response.isSuccessful()){
                        sessionManager.setAccount(response.body().getResp());
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    }else{
                        Toast.makeText(LoginActivity.this, "LOGIN FAILED", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<LoginResp> call, Throwable t) {
                    Toast.makeText(LoginActivity.this, String.format("Failure %s", t.getMessage()), Toast.LENGTH_SHORT).show();
                }
            });
            return true;
        }
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(LoginActivity.this, WelcomeActivity.class));
        finish();
    }
}
