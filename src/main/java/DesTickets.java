import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;

/**
 *
 */
@Data
public class DesTickets {
    @JsonProperty(value = "tickets")
    private ArrayList<TicketsJSON> tickets;

}
