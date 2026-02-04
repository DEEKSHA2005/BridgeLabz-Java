package collectionstreams.regex.advanced.date;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateFormatter {


    public String formatDate(String inputDate) {
        LocalDate date = LocalDate.parse(inputDate);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return date.format(formatter);
    }
}
