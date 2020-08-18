
package com.example.moborivs.apiservices.SpecificModel;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SpecificResp {

    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("request")
    @Expose
    private String request;
    @SerializedName("Message")
    @Expose
    private String message;
    @SerializedName("hostname")
    @Expose
    private String hostname;
    @SerializedName("protocol")
    @Expose
    private String protocol;
    @SerializedName("numberOfBrands")
    @Expose
    private Integer numberOfBrands;
    @SerializedName("numberOfModels")
    @Expose
    private Integer numberOfModels;
    @SerializedName("models")
    @Expose
    private List<Object> models = null;
    @SerializedName("smartphone")
    @Expose
    private Smartphone smartphone;
    @SerializedName("errors")
    @Expose
    private List<Object> errors = null;
    @SerializedName("brands")
    @Expose
    private List<Object> brands = null;

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

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public Integer getNumberOfBrands() {
        return numberOfBrands;
    }

    public void setNumberOfBrands(Integer numberOfBrands) {
        this.numberOfBrands = numberOfBrands;
    }

    public Integer getNumberOfModels() {
        return numberOfModels;
    }

    public void setNumberOfModels(Integer numberOfModels) {
        this.numberOfModels = numberOfModels;
    }

    public List<Object> getModels() {
        return models;
    }

    public void setModels(List<Object> models) {
        this.models = models;
    }

    public Smartphone getSmartphone() {
        return smartphone;
    }

    public void setSmartphone(Smartphone smartphone) {
        this.smartphone = smartphone;
    }

    public List<Object> getErrors() {
        return errors;
    }

    public void setErrors(List<Object> errors) {
        this.errors = errors;
    }

    public List<Object> getBrands() {
        return brands;
    }

    public void setBrands(List<Object> brands) {
        this.brands = brands;
    }

}
