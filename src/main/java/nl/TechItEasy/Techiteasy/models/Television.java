package nl.TechItEasy.Techiteasy.models;

import org.hibernate.Hibernate;
import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "televisions")

public class Television {
    // Instance variabelen.
    @Id
    @GeneratedValue
    public int id;
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

    @OneToOne
    private RemoteController remoteController;

    // Override to string.
    @Override
    public String toString() {
        return "Television{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", price=" + price +
                ", type='" + type + '\'' +
                ", availableSize=" + availableSize +
                ", refreshRate=" + refreshRate +
                ", screenType=" + screenType +
                ", screenQuality=" + screenQuality +
                ", smartTv=" + smartTv +
                ", wifi=" + wifi +
                ", speech=" + speech +
                ", HDR=" + HDR +
                ", bluetooth=" + bluetooth +
                ", ambiLight=" + ambiLight +
                ", originalStock=" + originalStock +
                ", sold=" + sold +
                ", voiceControl=" + voiceControl +
//                ", remoteController=" + remoteController +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Television that = (Television) o;
        return id != 0 && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }



    // Getters.
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getBrand() {
        return brand;
    }

    public int getPrice() {
        return price;
    }

    public boolean isHDR() {
        return HDR;
    }

    public boolean isBluetooth() {
        return bluetooth;
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

    public boolean isHDR(boolean HDR) {
        return this.HDR;
    }

    public boolean isBluetooth(boolean bluetooth) {
        return this.bluetooth;
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

    public boolean isVoiceControl() {return voiceControl;}

    public RemoteController getRemoteController() {return remoteController;}


    // Setters.
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBrand(String brand) {this.brand = brand;}

    public void setType(String type) {this.type = type;}

    public void setPrice(int price) {
        this.price = price;
    }

    public void setAvailableSize(int availableSize) {
        this.availableSize = availableSize;
    }

    public void setRefreshRate(double refreshRate) {
        this.refreshRate = refreshRate;
    }

    public void setScreenType(double screentype) {
        this.screenType = screentype;
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

    public void setRemoteController(RemoteController remoteController) {this.remoteController = remoteController;}


}


