import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class JsonTicketParser {
    public static void main(String[] args) {

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            DesTickets desTickets = objectMapper.readValue(new File("src/main/resources/tickets.json"), DesTickets.class);
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yy HH:mm");
            List<Duration> durationList = new ArrayList<>();
            System.out.println(desTickets.getTickets());
            Duration resultD = null;
            for (int i = 0; i < desTickets.getTickets().size(); i++) {

                LocalDateTime start = LocalDateTime.parse(desTickets.getTickets().get(i).getDeparture_date() + " " + desTickets.getTickets().get(i).getDeparture_time(), formatter);
                LocalDateTime end = LocalDateTime.parse(desTickets.getTickets().get(i).getArrival_date() + " " + desTickets.getTickets().get(i).getArrival_time(), formatter);
                Duration duration = Duration.between(end, start).abs().plusHours(7);

                System.out.printf(
                        "%dд %dч %dмин%n",
                        duration.toDays(),
                        duration.toHours() % 24,
                        duration.toMinutes() % 60
                );
                durationList.add(duration);
            }
            for(int j = 0; j<durationList.size(); j ++) {
                resultD += Duration.between(durationList.get(j));
            }
    } catch(
    IOException e)

    {
        e.printStackTrace();
    }

}
}