import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 *
 */
public class JsonTicketParser {
    public static void main(String[] args) {

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            DesTickets desTickets = objectMapper.readValue(new File("src/main/resources/tickets.json"), DesTickets.class);
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            System.out.println(desTickets);
            objectMapper.readValue(string, DesTickets[].class);
         } catch (IOException e) {
            e.printStackTrace();
        }

    }
    }