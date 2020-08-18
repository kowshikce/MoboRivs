package com.example.moborivs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.moborivs.apiservices.ConfirmationModel.ConfirmReq;
import com.example.moborivs.apiservices.ConfirmationModel.ConfirmationResp;
import com.example.moborivs.apiservices.ServiceMainApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VerifyActivity extends AppCompatActivity {


    Button button;
    EditText confirmEmail, confirmToken;
    public static final String TAG2 = "v";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify);

        button = findViewById(R.id.confirm_botton_id);
        confirmEmail = findViewById(R.id.confirm_email_id);
        confirmToken = findViewById(R.id.confirm_token_id);

        button.setOnClickListener(ButtonListener);
    }

    private View.OnClickListener ButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Log.i(TAG2, String.valueOf(ifTrue(confirmEmail.getText().toString(), confirmToken.getText().toString())));
        }
    };

    private boolean ifTrue(String email, String token) {
        if (email.isEmpty()) {
            confirmEmail.setError("EMAIL MUST NOT BE EMPTY");
            return false;
        } else if (token.isEmpty()) {
            confirmToken.setError("TOKEN MUST NOT BE EMPTY");
            return false;
        } else {
            Call<ConfirmationResp> getResp = ServiceMainApi.getApi().getConfirmation(token, new ConfirmReq(email));
            getResp.enqueue(new Callback<ConfirmationResp>() {
                @Override
                public void onResponse(Call<ConfirmationResp> call, Response<ConfirmationResp> response) {
                    if (!response.isSuccessful()) {


                        Toast.makeText(VerifyActivity.this, "EMAIL CONFIRMATION ERROR", Toast.LENGTH_SHORT).show();

                    } else {
                        Intent intent = new Intent(VerifyActivity.this, LoginActivity.class);
                        startActivity(intent);
                    }
                }

                @Override
                public void onFailure(Call<ConfirmationResp> call, Throwable t) {
                    Toast.makeText(VerifyActivity.this, String.format("%s", t.getMessage()), Toast.LENGTH_SHORT).show();
                }
            });
            return true;
        }
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(VerifyActivity.this, SignupActivity.class));
    }
}
