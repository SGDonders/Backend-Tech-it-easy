package nl.TechItEasy.Techiteasy.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CiModuleInputDto {
    // InputDto variabelen.
    public Integer id;
    public String name;
    public String type;
    public Double price;
}