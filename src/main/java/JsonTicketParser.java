import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
            ArrayList<DesTickets> desTicketsArrayList = new ArrayList<>();
            desTicketsArrayList.add(desTickets);
            TicketsJSON ticketsJSON = new TicketsJSON();
            DateFormat dateFormat = new SimpleDateFormat("dd.MM.yy hh:mm");
            Date arrDate = new Date();
            Date depDate = new Date();
            for (int i=0; i<desTicketsArrayList.size(); i++) {
                ticketsJSON.getDeparture_date();
                ticketsJSON.getArrival_date();
                ticketsJSON.getDeparture_time();
                ticketsJSON.getArrival_time();
                dateFormat.format(ticketsJSON.getDeparture_date()+ticketsJSON.getDeparture_time());
            }
            System.out.println(desTicketsArrayList);
         } catch (IOException e) {
            e.printStackTrace();
        }

    }
    }