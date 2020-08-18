package com.example.moborivs.ui.sharePreference;

import android.content.Context;
import android.text.TextUtils;

import com.example.moborivs.apiservices.LoginModel.Resp;

public class SessionManager {
    private Context context;
    private AccountSharePreference sharePreference;

    public SessionManager(Context context) {
        this.context = context;
        sharePreference = AccountSharePreference.getInstance(context);
    }

    public static SessionManager getInstance(Context context){
        return new SessionManager(context);
    }

    public boolean isLogin(){
        return !TextUtils.isEmpty(sharePreference.getToken());
    }

    public boolean logout(){
        return sharePreference.clear();
    }

    public void setAccount(Resp resp){
        sharePreference.setAccount(resp);
    }

    public Resp getAccount(){
        return sharePreference.getAccount();
    }
}
