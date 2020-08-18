
package com.example.moborivs.apiservices.SpecificModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Smartphone {

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("brand")
    @Expose
    private String brand;
    @SerializedName("model")
    @Expose
    private String model;
    @SerializedName("network_technology")
    @Expose
    private String networkTechnology;
    @SerializedName("2G_bands")
    @Expose
    private String _2GBands;
    @SerializedName("3G_bands")
    @Expose
    private String _3GBands;
    @SerializedName("4G_bands")
    @Expose
    private String _4GBands;
    @SerializedName("network_speed")
    @Expose
    private String networkSpeed;
    @SerializedName("GPRS")
    @Expose
    private String gPRS;
    @SerializedName("EDGE")
    @Expose
    private String eDGE;
    @SerializedName("announced")
    @Expose
    private String announced;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("dimentions")
    @Expose
    private String dimentions;
    @SerializedName("weight_g")
    @Expose
    private String weightG;
    @SerializedName("weight_oz")
    @Expose
    private String weightOz;
    @SerializedName("SIM")
    @Expose
    private String sIM;
    @SerializedName("display_type")
    @Expose
    private String displayType;
    @SerializedName("display_resolution")
    @Expose
    private String displayResolution;
    @SerializedName("display_size")
    @Expose
    private String displaySize;
    @SerializedName("OS")
    @Expose
    private String oS;
    @SerializedName("CPU")
    @Expose
    private String cPU;
    @SerializedName("Chipset")
    @Expose
    private String chipset;
    @SerializedName("GPU")
    @Expose
    private String gPU;
    @SerializedName("memory_card")
    @Expose
    private String memoryCard;
    @SerializedName("internal_memory")
    @Expose
    private String internalMemory;
    @SerializedName("RAM")
    @Expose
    private String rAM;
    @SerializedName("primary_camera")
    @Expose
    private String primaryCamera;
    @SerializedName("secondary_camera")
    @Expose
    private String secondaryCamera;
    @SerializedName("loud_speaker")
    @Expose
    private String loudSpeaker;
    @SerializedName("audio_jack")
    @Expose
    private String audioJack;
    @SerializedName("WLAN")
    @Expose
    private String wLAN;
    @SerializedName("bluetooth")
    @Expose
    private String bluetooth;
    @SerializedName("GPS")
    @Expose
    private String gPS;
    @SerializedName("NFC")
    @Expose
    private String nFC;
    @SerializedName("radio")
    @Expose
    private String radio;
    @SerializedName("USB")
    @Expose
    private String uSB;
    @SerializedName("sensors")
    @Expose
    private String sensors;
    @SerializedName("battery")
    @Expose
    private String battery;
    @SerializedName("colors")
    @Expose
    private String colors;
    @SerializedName("approx_price_EUR")
    @Expose
    private String approxPriceEUR;
    @SerializedName("img_url")
    @Expose
    private String imgUrl;
    @SerializedName("downloaded")
    @Expose
    private Boolean downloaded;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getNetworkTechnology() {
        return networkTechnology;
    }

    public void setNetworkTechnology(String networkTechnology) {
        this.networkTechnology = networkTechnology;
    }

    public String get2GBands() {
        return _2GBands;
    }

    public void set2GBands(String _2GBands) {
        this._2GBands = _2GBands;
    }

    public String get3GBands() {
        return _3GBands;
    }

    public void set3GBands(String _3GBands) {
        this._3GBands = _3GBands;
    }

    public String get4GBands() {
        return _4GBands;
    }

    public void set4GBands(String _4GBands) {
        this._4GBands = _4GBands;
    }

    public String getNetworkSpeed() {
        return networkSpeed;
    }

    public void setNetworkSpeed(String networkSpeed) {
        this.networkSpeed = networkSpeed;
    }

    public String getGPRS() {
        return gPRS;
    }

    public void setGPRS(String gPRS) {
        this.gPRS = gPRS;
    }

    public String getEDGE() {
        return eDGE;
    }

    public void setEDGE(String eDGE) {
        this.eDGE = eDGE;
    }

    public String getAnnounced() {
        return announced;
    }

    public void setAnnounced(String announced) {
        this.announced = announced;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDimentions() {
        return dimentions;
    }

    public void setDimentions(String dimentions) {
        this.dimentions = dimentions;
    }

    public String getWeightG() {
        return weightG;
    }

    public void setWeightG(String weightG) {
        this.weightG = weightG;
    }

    public String getWeightOz() {
        return weightOz;
    }

    public void setWeightOz(String weightOz) {
        this.weightOz = weightOz;
    }

    public String getSIM() {
        return sIM;
    }

    public void setSIM(String sIM) {
        this.sIM = sIM;
    }

    public String getDisplayType() {
        return displayType;
    }

    public void setDisplayType(String displayType) {
        this.displayType = displayType;
    }

    public String getDisplayResolution() {
        return displayResolution;
    }

    public void setDisplayResolution(String displayResolution) {
        this.displayResolution = displayResolution;
    }

    public String getDisplaySize() {
        return displaySize;
    }

    public void setDisplaySize(String displaySize) {
        this.displaySize = displaySize;
    }

    public String getOS() {
        return oS;
    }

    public void setOS(String oS) {
        this.oS = oS;
    }

    public String getCPU() {
        return cPU;
    }

    public void setCPU(String cPU) {
        this.cPU = cPU;
    }

    public String getChipset() {
        return chipset;
    }

    public void setChipset(String chipset) {
        this.chipset = chipset;
    }

    public String getGPU() {
        return gPU;
    }

    public void setGPU(String gPU) {
        this.gPU = gPU;
    }

    public String getMemoryCard() {
        return memoryCard;
    }

    public void setMemoryCard(String memoryCard) {
        this.memoryCard = memoryCard;
    }

    public String getInternalMemory() {
        return internalMemory;
    }

    public void setInternalMemory(String internalMemory) {
        this.internalMemory = internalMemory;
    }

    public String getRAM() {
        return rAM;
    }

    public void setRAM(String rAM) {
        this.rAM = rAM;
    }

    public String getPrimaryCamera() {
        return primaryCamera;
    }

    public void setPrimaryCamera(String primaryCamera) {
        this.primaryCamera = primaryCamera;
    }

    public String getSecondaryCamera() {
        return secondaryCamera;
    }

    public void setSecondaryCamera(String secondaryCamera) {
        this.secondaryCamera = secondaryCamera;
    }

    public String getLoudSpeaker() {
        return loudSpeaker;
    }

    public void setLoudSpeaker(String loudSpeaker) {
        this.loudSpeaker = loudSpeaker;
    }

    public String getAudioJack() {
        return audioJack;
    }

    public void setAudioJack(String audioJack) {
        this.audioJack = audioJack;
    }

    public String getWLAN() {
        return wLAN;
    }

    public void setWLAN(String wLAN) {
        this.wLAN = wLAN;
    }

    public String getBluetooth() {
        return bluetooth;
    }

    public void setBluetooth(String bluetooth) {
        this.bluetooth = bluetooth;
    }

    public String getGPS() {
        return gPS;
    }

    public void setGPS(String gPS) {
        this.gPS = gPS;
    }

    public String getNFC() {
        return nFC;
    }

    public void setNFC(String nFC) {
        this.nFC = nFC;
    }

    public String getRadio() {
        return radio;
    }

    public void setRadio(String radio) {
        this.radio = radio;
    }

    public String getUSB() {
        return uSB;
    }

    public void setUSB(String uSB) {
        this.uSB = uSB;
    }

    public String getSensors() {
        return sensors;
    }

    public void setSensors(String sensors) {
        this.sensors = sensors;
    }

    public String getBattery() {
        return battery;
    }

    public void setBattery(String battery) {
        this.battery = battery;
    }

    public String getColors() {
        return colors;
    }

    public void setColors(String colors) {
        this.colors = colors;
    }

    public String getApproxPriceEUR() {
        return approxPriceEUR;
    }

    public void setApproxPriceEUR(String approxPriceEUR) {
        this.approxPriceEUR = approxPriceEUR;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Boolean getDownloaded() {
        return downloaded;
    }

    public void setDownloaded(Boolean downloaded) {
        this.downloaded = downloaded;
    }

}
