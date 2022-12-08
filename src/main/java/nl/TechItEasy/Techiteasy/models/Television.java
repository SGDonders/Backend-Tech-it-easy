package nl.TechItEasy.Techiteasy.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;
import java.util.List;

// Lombok annotaties.
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder

@Entity
@Table(name = "televisions") // Table naam voor in de database.

public class Television {
    // Instance variabelen instantie.
    @Id
    @GeneratedValue// Geeft de entiteit automatisch een id.
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

    // One to One relatie met remoteController
    // waarbij de televisie de eigenaar is.
    @OneToOne
    private RemoteController remoteController;

//    @OneToMany(mappedBy = "television")
//    @JsonIgnore
//    private List<CiModule> ciModuleList;

}


