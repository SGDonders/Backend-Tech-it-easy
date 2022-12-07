package nl.TechItEasy.Techiteasy.dtos;

public class RemoteControllerInputDto {
    // inputDto variabelen.
    public Integer id;
    public String compatibleWith;
    public String batteryType;
    public String name;
    public String brand;
    public Double price;
    public Integer originalStock;

    // Getters.
    public Integer getId() {
        return id;
    }

    public String getCompatibleWith() {
        return compatibleWith;
    }

    public String getBatteryType() {
        return batteryType;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getOriginalStock() {
        return originalStock;
    }

    // Setters.
    public void setId(Integer id) {
        this.id = id;
    }

    public void setCompatibleWith(String compatibleWith) {
        this.compatibleWith = compatibleWith;
    }

    public void setBatteryType(String batteryType) {
        this.batteryType = batteryType;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setOriginalStock(Integer originalStock) {
        this.originalStock = originalStock;
    }
}
