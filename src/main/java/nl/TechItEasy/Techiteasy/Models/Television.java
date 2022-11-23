package nl.TechItEasy.Techiteasy.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "televisions")
public class Television {
    @Id
    @GeneratedValue
    public int id;
    public String name;
    public String brand;
    public int price;
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

    public Television() {
    }

    public Television(int id, String name, String brand, int price, int availableSize, double refreshRate,
                      double screenType, double screenQuality, boolean smartTv, boolean wifi, boolean speech, boolean HDR,
                      boolean bluetooth, boolean ambiLight, int originalStock, int sold) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.availableSize = availableSize;
        this.refreshRate = refreshRate;
        this.screenType = screenType;
        this.screenQuality = screenQuality;
        this.smartTv = smartTv;
        this.wifi = wifi;
        this.speech = speech;
        this.HDR = HDR;
        this.bluetooth = bluetooth;
        this.ambiLight = ambiLight;
        this.originalStock = originalStock;
        this.sold = sold;
    }

    @Override
    public String toString() {
        return "Television{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", price=" + price +
                ", availableSize=" + availableSize +
                ", refreshRate=" + refreshRate +
                ", screentype=" + screenType +
                ", screenQuality=" + screenQuality +
                ", smartTv=" + smartTv +
                ", wifi=" + wifi +
                ", speech=" + speech +
                ", HDR=" + HDR +
                ", bleutooth=" + bluetooth +
                ", ambiLight=" + ambiLight +
                ", originalStock=" + originalStock +
                ", sold=" + sold +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public int getPrice() {
        return price;
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

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

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

    public void setBluetooth(boolean bleutooth) {
        this.bluetooth = bleutooth;
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

}

