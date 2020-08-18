package com.example.moborivs.apiservices.SignupModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SignupReq {
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("dateOfBirth")
    @Expose
    private String dateOfBirth;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("Phone")
    @Expose
    private String phone;

    public SignupReq(String email, String password, String dateOfBirth, String username, String phone) {
        this.email = email;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.username = username;
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
