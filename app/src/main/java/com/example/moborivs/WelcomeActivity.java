package com.example.moborivs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.PrintWriter;

public class WelcomeActivity extends AppCompatActivity{

    Button button;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        button = findViewById(R.id.join_us);
        textView = findViewById(R.id.login);

        button.setOnClickListener(ButtonTabListener);
        textView.setOnClickListener(TextTabListener);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    private View.OnClickListener ButtonTabListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(WelcomeActivity.this, SignupActivity.class);
            startActivity(intent);
            finish();
        }
    };

    private View.OnClickListener TextTabListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(WelcomeActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        }
    };

}
