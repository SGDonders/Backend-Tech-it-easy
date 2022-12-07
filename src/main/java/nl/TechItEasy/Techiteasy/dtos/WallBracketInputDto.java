package nl.TechItEasy.Techiteasy.dtos;

public class WallBracketInputDto {
    // InputDto variabelen.
    public Integer id;
    public String size;
    public Boolean adjustable;
    public String name;
    public Double price;


    // Getters.
    public Integer getId() {
        return id;
    }

    public String getSize() {
        return size;
    }

    public Boolean getAdjustable() {
        return adjustable;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }


    // Setters.
    public void setId(Integer id) {
        this.id = id;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setAdjustable(Boolean adjustable) {
        this.adjustable = adjustable;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
