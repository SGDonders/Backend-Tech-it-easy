package nl.TechItEasy.Techiteasy.models;

import lombok.*;

import javax.persistence.*;
@ToString
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="remoteControllers")
public class RemoteController {
    // Instance variabelen.
    @Id
    @GeneratedValue
    public Integer id;

    @OneToOne(mappedBy = "remoteController")
    private Television television;

    public String compatible_with;
    public String battery_type;
    public String name;
    public String brand;
    public Double price;
    public Integer original_stock;
}