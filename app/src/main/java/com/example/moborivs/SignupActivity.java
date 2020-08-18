package com.example.moborivs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.moborivs.apiservices.ConfirmationModel.ConfirmReq;
import com.example.moborivs.apiservices.ServiceMainApi;
import com.example.moborivs.apiservices.SignupModel.SignupReq;
import com.example.moborivs.apiservices.SignupModel.SignupResp;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignupActivity extends AppCompatActivity{

    TextView textView;
    EditText Name, Email, Year, Month, Day, PhoneNumber, Password, ConfirmPassword;
    Button Signup;

    public static final String TAG1 = "x";
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        context = getApplicationContext();

        Signup = findViewById(R.id.sing_up_button_id);

        //Deaclaring all editField
        Name = findViewById(R.id.sign_up_name_tv_id);
        Email = findViewById(R.id.sign_up_email_tv_id);
        Year = findViewById(R.id.sing_up_year_tv_id);
        Month = findViewById(R.id.sign_up_month_tv_id);
        Day = findViewById(R.id.sing_up_day_tv_id);
        PhoneNumber = findViewById(R.id.sing_up_number_tv_id);
        Password = findViewById(R.id.sing_up_password_tv_id);
        ConfirmPassword = findViewById(R.id.sign_up_confirm_password_tv_id);

        Signup.setOnClickListener(ButtonListener);

        textView = findViewById(R.id.back);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignupActivity.this, WelcomeActivity.class));
                finish();
            }
        });
    }

    private View.OnClickListener ButtonListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            Log.i(TAG1, String.valueOf(ifTrue(Name.getText().toString(), Email.getText().toString(), String.format("%s-%s-%s", Year.getText().toString(), Month.getText().toString(), Day.getText().toString()),
                    PhoneNumber.getText().toString(), Password.getText().toString(), ConfirmPassword.getText().toString())));


        }
    };

    private boolean ifTrue(String name, String email, String date, String phone, String password, String confirmPassword){
        if(name.isEmpty()){
            Name.setError("NAME MUST NOT BE EMPTY.");
            return false;
        }else if(email.isEmpty()){
            Email.setError("EMAIL MUST NOT BE EMPTY.");
            return false;
        }else if(date.isEmpty()){
            Year.setError("EMPTY.");
            Month.setError("EMPTY.");
            Day.setError("EMPTY");
            return false;
        }else if(phone.isEmpty()){
            PhoneNumber.setError("NUMBER MUST NOT BE EMPTY.");
            return false;
        }else if(password.isEmpty()){
            Password.setError("PASSWORD MUST NOT BE EMPTY.");
            return false;
        }else if(confirmPassword.isEmpty()){
            ConfirmPassword.setError("CONFIRM PASSWORD MUST NOT BE EMPTY.");
            return false;
        }else {
            if(password.equals(confirmPassword)){
                Call<SignupResp> response = ServiceMainApi.getApi().getSignResponse(new SignupReq(email, password, date, name, phone));
                response.enqueue(new Callback<SignupResp>() {
                    @Override
                    public void onResponse(Call<SignupResp> call, Response<SignupResp> response) {
                        if(!response.isSuccessful()){
                            if(response.code() == 409) {
                                Toast.makeText(context, "USER ALREADY EXITS", Toast.LENGTH_SHORT).show();
                            }else{
                                Toast.makeText(context, "SIGNUP FAILED.", Toast.LENGTH_SHORT).show();
                            }

                        }else {
                            Intent intent = new Intent(SignupActivity.this, VerifyActivity.class);
                            startActivity(intent);
                        }
                    }

                    @Override
                    public void onFailure(Call<SignupResp> call, Throwable t) {
                        Toast.makeText(context, String.format("Failure %s.", t.getMessage()), Toast.LENGTH_SHORT).show();
                    }
                });
                return true;
            }else {
                Toast.makeText(this, "PASSWORD DON'T MATCH.", Toast.LENGTH_SHORT).show();
                return false;
            }
        }
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(SignupActivity.this, WelcomeActivity.class));
        finish();
    }
}
