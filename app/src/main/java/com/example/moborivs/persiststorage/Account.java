package com.example.moborivs.persiststorage;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Account {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    public int uid;

    @ColumnInfo(name = "Date")
    public String date;

    @ColumnInfo(name = "Token")
    public String token;


    @ColumnInfo(name = "UserID")
    public String UserId;

    @ColumnInfo(name = "Username")
    public String Username;

    @ColumnInfo(name = "Email")
    public String Email;

    @ColumnInfo(name = "DateOfBirth")
    public String DateOfBirth;

    @ColumnInfo(name = "Phone")
    public String Phone;

    public Account(){

    }

    public Account( String date, String token, String userId, String username, String email, String dateOfBirth, String phone) {
        this.date = date;
        this.token = token;
        UserId = userId;
        Username = username;
        Email = email;
        DateOfBirth = dateOfBirth;
        Phone = phone;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }
}
