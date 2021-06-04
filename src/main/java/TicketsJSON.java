import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

/**
 *
 */
@Data
public class TicketsJSON {

    @JsonProperty(value = "origin")
    private String origin;

    @JsonProperty(value = "origin_name")
    private String origin_name;

    @JsonProperty(value = "destination")
    private String destination;

    @JsonProperty(value = "destination_name")
    private String destination_name;

    @JsonProperty(value = "departure_date")
    @JsonFormat
            (shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yy")
    private Date departure_date;

    @JsonProperty(value = "departure_time")
    @JsonFormat
            (shape = JsonFormat.Shape.STRING, pattern = "hh:mm")
    Date departure_time;

    @JsonProperty(value = "arrival_date")
    @JsonFormat
            (shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yy")
    private Date arrival_date;

    @JsonProperty(value = "arrival_time")
    @JsonFormat
            (shape = JsonFormat.Shape.STRING, pattern = "hh:mm")
    private Date arrival_time;

    @JsonProperty(value = "carrier")
    private String carrier;

    @JsonProperty(value = "stops")
    private Long stops;

    @JsonProperty(value = "price")
    private Long price;
}

