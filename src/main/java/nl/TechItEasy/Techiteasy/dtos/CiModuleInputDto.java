package nl.TechItEasy.Techiteasy.dtos;

public class CiModuleInputDto {
    // InputDto variabelen.
    public Integer id;
    public String name;
    public String type;
    public Double price;

    // Getters.
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public Double getPrice() {
        return price;
    }


    // Setters.
    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
