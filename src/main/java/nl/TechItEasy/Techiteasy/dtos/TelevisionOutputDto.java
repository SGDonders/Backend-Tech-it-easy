package nl.TechItEasy.Techiteasy.dtos;


import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import nl.TechItEasy.Techiteasy.models.RemoteController;

public class TelevisionOutputDto {
    // OutputDto variabelen
    public String name;
    public String brand;

    public int price;

    public String type;

    public int availableSize;

    public double refreshRate;

    public double screenType;

    public double screenQuality;

    public boolean smartTv;

    public boolean wifi;

    public boolean speech;

    public boolean HDR;

    public boolean bluetooth;

    public boolean ambiLight;

    public int originalStock;

    public int sold;

    public boolean voiceControl;

    @JsonIncludeProperties("id")
    private RemoteController remoteController;





    // Getters.
    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public int getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    public int getAvailableSize() {
        return availableSize;
    }

    public double getRefreshRate() {
        return refreshRate;
    }

    public double getScreenType() {
        return screenType;
    }

    public double getScreenQuality() {
        return screenQuality;
    }

    public boolean isSmartTv() {
        return smartTv;
    }

    public boolean isWifi() {
        return wifi;
    }

    public boolean isSpeech() {
        return speech;
    }

    public boolean isHDR() {
        return HDR;
    }

    public boolean isBluetooth() {
        return bluetooth;
    }

    public boolean isAmbiLight() {
        return ambiLight;
    }

    public int getOriginalStock() {
        return originalStock;
    }

    public int getSold() {
        return sold;
    }

    public boolean isVoiceControl() {
        return voiceControl;
    }


    // Setters.
    public void setName(String name) {
        this.name = name;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setAvailableSize(int availableSize) {
        this.availableSize = availableSize;
    }

    public void setRefreshRate(double refreshRate) {
        this.refreshRate = refreshRate;
    }

    public void setScreenType(double screenType) {
        this.screenType = screenType;
    }

    public void setScreenQuality(double screenQuality) {
        this.screenQuality = screenQuality;
    }

    public void setSmartTv(boolean smartTv) {
        this.smartTv = smartTv;
    }

    public void setWifi(boolean wifi) {
        this.wifi = wifi;
    }

    public void setSpeech(boolean speech) {
        this.speech = speech;
    }

    public void setHDR(boolean HDR) {
        this.HDR = HDR;
    }

    public void setBluetooth(boolean bluetooth) {
        this.bluetooth = bluetooth;
    }

    public void setAmbiLight(boolean ambiLight) {
        this.ambiLight = ambiLight;
    }

    public void setOriginalStock(int originalStock) {
        this.originalStock = originalStock;
    }

    public void setSold(int sold) {
        this.sold = sold;
    }

    public void setVoiceControl(boolean voiceControl) {
        this.voiceControl = voiceControl;
    }
}
