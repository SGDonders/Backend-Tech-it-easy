package nl.TechItEasy.Techiteasy.dtos.outputDtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RemoteControllerOutputDto {
    // OutputDto variabelen.
    public Integer id;
    public String compatibleWith;
    public String batteryType;
    public String name;
    public String brand;
    public Double price;
    public Integer originalStock;
}