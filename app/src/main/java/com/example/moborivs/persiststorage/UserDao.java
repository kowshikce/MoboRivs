package com.example.moborivs.persiststorage;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UserDao {

    @Query("SELECT * FROM Account")
    List<Account> getAccounts();

    @Query("UPDATE Account SET Token = :token WHERE UserID LIKE :UserId")
    void update(String token, String UserId);

    @Query("SELECT Token FROM Account WHERE UserID LIKE :userId")
    String getTokenOnly(String userId);

    @Insert
    void insertALl(Account... accounts);

    @Query("DELETE FROM Account")
    void deleteAll();

}
