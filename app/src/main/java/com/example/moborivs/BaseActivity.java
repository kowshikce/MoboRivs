package com.example.moborivs;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.moborivs.ui.sharePreference.SessionManager;

public class BaseActivity extends AppCompatActivity {
    private SessionManager sessionManager;

    public static final String TAG1 = "pxxi";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sessionManager = SessionManager.getInstance(getApplicationContext());
        Log.i(TAG1, "baseActivity oncreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        verifyLogin();
        Log.i(TAG1, "BaseActivity onStart");
    }

    private void verifyLogin(){
        if(!sessionManager.isLogin()){
            Log.i(TAG1, "baseActivity Welcome");
            startActivity(new Intent(BaseActivity.this, WelcomeActivity.class));
            finish();
        }
    }
}
