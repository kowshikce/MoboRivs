package com.example.moborivs.persiststorage;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Account.class},exportSchema = false, version = 1)
public abstract class AccountDatabase extends RoomDatabase {

    public abstract UserDao userDao();

    private static volatile AccountDatabase INSTANCE = null;
    private static final int NUMBER_OF_THREADS = 1;
    static final ExecutorService AccountDbExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);


    public static AccountDatabase getInstance(final Context context){
        if(INSTANCE == null){
            synchronized (AccountDatabase.class){
                if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AccountDatabase.class, "Accounts").build();
                }
            }
        }
        return INSTANCE;
    }
}
