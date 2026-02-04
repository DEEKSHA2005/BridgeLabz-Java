package collectionstreams.regex.advanced.date;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class DateFormatterTest {


    DateFormatter formatter = new DateFormatter();


    @Test
    void testValidDate() {
        assertEquals("05-02-2026", formatter.formatDate("2026-02-05"));
    }


    @Test
    void testInvalidDate() {
        assertThrows(Exception.class, () -> {
            formatter.formatDate("2026/02/05");
        });
    }
}