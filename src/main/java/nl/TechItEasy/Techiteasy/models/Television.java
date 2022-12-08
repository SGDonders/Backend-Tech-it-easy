package nl.TechItEasy.Techiteasy.models;

import lombok.*;
import org.hibernate.Hibernate;
import javax.persistence.*;
import java.util.Objects;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Entity
@Table(name = "televisions")

public class Television {
    // Instance variabelen.
    @Id
    @GeneratedValue
    private int id;
    private String type;
    private String brand;
    private String name;
    private double price;
    private double available_size;
    private double refresh_rate;
    private String screen_type;
    private String screen_quality;
    private boolean smart_tv;
    private boolean wifi;
    private boolean voice_control;
    private boolean hdr;
    private boolean bluetooth;
    private boolean ambi_light;
    private int original_stock;
    private int sold;


    @OneToOne
    private RemoteController remoteController;

}


