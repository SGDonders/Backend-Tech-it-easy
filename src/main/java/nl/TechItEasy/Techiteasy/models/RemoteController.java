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

//    @OneToOne(mappedBy = "remoteController")
//    @JoinColumn(name = "televisions_id")
//    private Television television;
    public String compatibleWith;
    public String batteryType;
    public String name;
    public String brand;
    public Double price;
    public Integer originalStock;
}