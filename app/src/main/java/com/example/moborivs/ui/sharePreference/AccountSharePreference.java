package com.example.moborivs.ui.sharePreference;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.example.moborivs.apiservices.LoginModel.Resp;

public class AccountSharePreference {
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    public AccountSharePreference(Context context){
        sharedPreferences = context.getSharedPreferences("AccountSession", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public static AccountSharePreference getInstance(Context context){
        return new AccountSharePreference(context);
    }

    public void setAccount(Resp resp){
        editor.putInt(resp.getUserId(), 1);
        editor.putString(Constant.EMAIL, resp.getEmail());
        editor.putString(Constant.NAME, resp.getUsername());
        editor.putString(Constant.DOB, resp.getDob());
        editor.putString(Constant.TOKEN, resp.getToken());
        editor.putString(Constant.PHONE, resp.getPhone());
        editor.putString(Constant.USER_ID, resp.getUserId());
        editor.commit();
    }

    public Resp getAccount(){
        Resp resp = new Resp();
        resp.setEmail(getEmail());
        resp.setUsername(getUsername());
        resp.setDob(getDob());
        resp.setToken(getToken());
        resp.setUserId(getUserId());
        resp.setPhone(getPhone());
        return resp;
    }

    public String getEmail(){
        return sharedPreferences.getString(Constant.EMAIL, "");
    }

    public String getUsername(){
        return sharedPreferences.getString(Constant.NAME, "");
    }

    public String getDob(){
        return sharedPreferences.getString(Constant.DOB, "");
    }

    public String getToken(){
        return sharedPreferences.getString(Constant.TOKEN, "");
    }

    public String getPhone(){
        return sharedPreferences.getString(Constant.PHONE, "");
    }

    public String getUserId(){
        return sharedPreferences.getString(Constant.USER_ID, "");
    }

    public boolean clear(){
        editor.clear();
        return editor.commit();
    }


}
