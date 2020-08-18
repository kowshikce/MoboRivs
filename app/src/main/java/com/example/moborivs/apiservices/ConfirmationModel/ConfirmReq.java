package com.example.moborivs.apiservices.ConfirmationModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ConfirmReq {
    @SerializedName("email")
    @Expose
    private String email;

    public ConfirmReq(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
