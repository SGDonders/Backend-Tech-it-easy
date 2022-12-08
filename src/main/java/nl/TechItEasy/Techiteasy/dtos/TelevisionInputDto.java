package nl.TechItEasy.Techiteasy.dtos;

import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import lombok.Getter;
import lombok.Setter;
import nl.TechItEasy.Techiteasy.models.RemoteController;

@Setter
@Getter
public class TelevisionInputDto {

    // InputDto variabelen.
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

    @JsonIncludeProperties("id")
    private RemoteController remoteController;


}