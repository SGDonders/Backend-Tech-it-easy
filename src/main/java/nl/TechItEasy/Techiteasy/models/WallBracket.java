package nl.TechItEasy.Techiteasy.models;

import lombok.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@ToString
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="wallBrackets")
public class WallBracket {
    // Instance variabelen.
    @Id
    @GeneratedValue
    public Integer id;
    public String size;
    public Boolean adjustable;
    public String name;
    public Double price;
}