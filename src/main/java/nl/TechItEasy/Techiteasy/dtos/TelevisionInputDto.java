package nl.TechItEasy.Techiteasy.dtos;

import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import nl.TechItEasy.Techiteasy.models.RemoteController;

public class TelevisionInputDto {

    // InputDto variabelen.
    public String name;
    public String brand;

    public int price;

    public String type;

    public int availableSize;

    public double refreshRate;

    public double screenType;

    public double screenQuality;

    public Boolean smartTv;

    public Boolean wifi;

    public Boolean speech;

    public Boolean HDR;

    public Boolean bluetooth;

    public Boolean ambiLight;

    public Integer originalStock;

    public Integer sold;

    public boolean voiceControl;

    @JsonIncludeProperties("id")
    private RemoteController remoteController;





    // Getters & Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAvailableSize() {
        return availableSize;
    }

    public void setAvailableSize(int availableSize) {
        this.availableSize = availableSize;
    }

    public double getRefreshRate() {
        return refreshRate;
    }

    public void setRefreshRate(double refreshRate) {
        this.refreshRate = refreshRate;
    }

    public double getScreenType() {
        return screenType;
    }

    public void setScreenType(double screenType) {
        this.screenType = screenType;
    }

    public double getScreenQuality() {
        return screenQuality;
    }

    public void setScreenQuality(double screenQuality) {
        this.screenQuality = screenQuality;
    }

    public boolean isSmartTv() {
        return smartTv;
    }

    public void setSmartTv(boolean smartTv) {
        this.smartTv = smartTv;
    }

    public boolean isWifi() {
        return wifi;
    }

    public String getType()
    {return type;}

    public void setType(String type)
    {this.type = type;}

    public void setWifi(boolean wifi) {
        this.wifi = wifi;
    }

    public boolean isSpeech() {
        return speech;
    }

    public void setSpeech(boolean speech) {
        this.speech = speech;
    }

    public boolean isHDR() {
        return HDR;
    }

    public void setHDR(boolean HDR) {
        this.HDR = HDR;
    }

    public boolean isBluetooth() {
        return bluetooth;
    }

    public void setBluetooth(boolean bluetooth) {
        this.bluetooth = bluetooth;
    }

    public boolean isAmbiLight() {
        return ambiLight;
    }

    public void setAmbiLight(boolean ambiLight) {
        this.ambiLight = ambiLight;
    }

    public int getOriginalStock() {
        return originalStock;
    }

    public void setOriginalStock(int originalStock) {
        this.originalStock = originalStock;
    }

    public int getSold() {
        return sold;
    }

    public void setSold(int sold) {
        this.sold = sold;
    }

    public Boolean isVoiceControl() {
        return voiceControl;
    }

    public void setVoiceControl(boolean voiceControl) {
        this.voiceControl = voiceControl;
    }

}
