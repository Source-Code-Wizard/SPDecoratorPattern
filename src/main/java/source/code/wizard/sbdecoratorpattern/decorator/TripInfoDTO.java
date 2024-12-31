package source.code.wizard.sbdecoratorpattern.decorator;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TripInfoDTO {
    @JsonProperty
    private double price;
    @JsonProperty
    private String description;

    public TripInfoDTO() {
        this.price = 0.0;
        this.description = "";
    }
    public TripInfoDTO(double price, String description) {
        this.price = price;
        this.description = description;
    }

}
