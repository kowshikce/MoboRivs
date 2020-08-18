
package com.example.moborivs.apiservices.LoginModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginResp {

    @SerializedName("Date")
    @Expose
    private String date;
    @SerializedName("Request")
    @Expose
    private String request;
    @SerializedName("Message")
    @Expose
    private String message;
    @SerializedName("Cause")
    @Expose
    private Object cause;
    @SerializedName("Code")
    @Expose
    private Integer code;
    @SerializedName("Resp")
    @Expose
    private Resp resp;
    @SerializedName("Errors")
    @Expose
    private Object errors;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getCause() {
        return cause;
    }

    public void setCause(Object cause) {
        this.cause = cause;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Resp getResp() {
        return resp;
    }

    public void setResp(Resp resp) {
        this.resp = resp;
    }

    public Object getErrors() {
        return errors;
    }

    public void setErrors(Object errors) {
        this.errors = errors;
    }

}
