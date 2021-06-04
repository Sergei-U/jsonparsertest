import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.Map;

/**
 *
 */
@Data
public class DesTickets {
    @JsonProperty(value = "tickets")
    private ArrayList<TicketsJSON> tickets;

}
