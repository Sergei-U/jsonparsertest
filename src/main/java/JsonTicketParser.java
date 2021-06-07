import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
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
            List<String> durationList = new ArrayList<>();
            List<Long> durationListSeconds = new ArrayList<>();
            Long durationTime = 0L;
            Long timeTravel = 0L;

            for (int i = 0; i < desTickets.getTickets().size(); i++) {

                LocalDateTime start = LocalDateTime.parse(desTickets.getTickets().get(i).getDeparture_date() + " " + desTickets.getTickets().get(i).getDeparture_time(), formatter);
                LocalDateTime end = LocalDateTime.parse(desTickets.getTickets().get(i).getArrival_date() + " " + desTickets.getTickets().get(i).getArrival_time(), formatter);
                Duration duration = Duration.between(end, start).abs().plusHours(7);

                timeTravel = duration.toSeconds();
                String str = String.format("%d:%d:%d%n", duration.toDays(), duration.toHours() % 24, duration.toMinutes() % 60);

                durationList.add(str);
                durationListSeconds.add(timeTravel);


            }
            for(int j=0; j<durationListSeconds.size(); j++) {
                durationTime += durationListSeconds.get(j);
            }
            Duration avgTimeTravel = Duration.ofSeconds(durationTime/durationListSeconds.size());
            System.out.printf(
                        "Среднее время полета: %dд %dч %dмин%n",
                    avgTimeTravel.toDays(),
                    avgTimeTravel.toHours() % 24,
                    avgTimeTravel.toMinutes() % 60
                );

            Collections.sort(durationListSeconds);
            int index = (int) Math.ceil(90 / 100.0 * durationListSeconds.size());
            Duration persentileTime = Duration.ofSeconds(durationListSeconds.get(index-1));
            System.out.printf(
                    "90 percentile: %dд %dч %dмин%n",
                    persentileTime.toDays(),
                    persentileTime.toHours() % 24,
                    persentileTime.toMinutes() % 60
            );


    } catch(
    IOException e)

    {
        e.printStackTrace();
    }

}
}