package nl.TechItEasy.Techiteasy.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WallBracketOutputDto {
    // OutputDto variabelen.
    public Integer id;
    public String size;
    public Boolean adjustable;
    public String name;
    public Double price;
}