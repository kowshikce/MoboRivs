package com.example.moborivs.persiststorage;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LiveData;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AccountRepository {
    private UserDao userDao;
    volatile List<Account> accounts = null;
    volatile String Usertoken = null;
    public static final String TAG4 = "pxx";
    private volatile Account singleAccount = null;


    public AccountRepository(Application application){
        AccountDatabase db = AccountDatabase.getInstance(application);
        userDao = db.userDao();
    }

    //NEW METHOD FOR THE TESTING IF SUCCESSFUL IT WILL REPLACE THE OTHER"S
    //METHOD NEEDED AND HOPEFULLY DELETE THE INTERFACE FOR DATA-HANDALING.
    //AND THIS HOPEFULLY WORKS .
    public Account getSingleAccount() throws InterruptedException {
        Thread x = new Thread(new Runnable() {
            @Override
            public void run() {
                if(userDao.getAccounts().size()  > 1){
                    singleAccount = userDao.getAccounts().get(userDao.getAccounts().size() - 1);
                }else{
                    singleAccount = userDao.getAccounts().get(0);
                }
            }
        });
        x.start();
        x.join();
        return this.singleAccount;

    }


    public List<Account> getAccounts(){
        AccountDatabase.AccountDbExecutor.execute(new Runnable() {
            @Override
            public void run() {
                accounts = userDao.getAccounts();
                Log.i(TAG4, accounts.get(0).getUsername());
            }
        });

        return this.accounts;
    }

    public String getToken(final String userId){
        AccountDatabase.AccountDbExecutor.execute(new Runnable() {
            @Override
            public void run() {
                Usertoken = userDao.getTokenOnly(userId);
            }
        });
        return this.Usertoken;
    }

    public void update(final String token, final String UserId){
        AccountDatabase.AccountDbExecutor.execute(new Runnable() {
            @Override
            public void run() {
                userDao.update(token, UserId);
            }
        });
    }

    public void insertAll(final Account... accounts){
        AccountDatabase.AccountDbExecutor.execute(new Runnable() {
            @Override
            public void run() {
                userDao.insertALl(accounts);
            }
        });
    }

    public void deleteAll(){
        AccountDatabase.AccountDbExecutor.execute(new Runnable() {
            @Override
            public void run() {
                Log.i(TAG4, "Deleting all Shits.");
                userDao.deleteAll();
            }
        });

    }


}
