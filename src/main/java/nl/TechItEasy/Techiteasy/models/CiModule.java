package nl.TechItEasy.Techiteasy.models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "CiModules")
public class CiModule {
    // Instance variabelen.
    @Id
    @GeneratedValue
    public Integer id;
    public String name;
    public String type;
    public Double price;

}


