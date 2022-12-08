package nl.TechItEasy.Techiteasy.models;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "cimodules")
public class CiModule {
    // Instance variabelen.
    @Id
    @GeneratedValue
    public Integer id;

    public String name;
    public String type;
    public Double price;

//    @ManyToOne
//    private Television television;

}


