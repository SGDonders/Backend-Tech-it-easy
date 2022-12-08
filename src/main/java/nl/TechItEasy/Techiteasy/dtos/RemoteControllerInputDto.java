package nl.TechItEasy.Techiteasy.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RemoteControllerInputDto {
    // inputDto variabelen.
    public Integer id;
    public String compatible_with;
    public String battery_type;
    public String name;
    public String brand;
    public Double price;
    public Integer original_stock;

}