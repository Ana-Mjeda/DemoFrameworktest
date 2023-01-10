package util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeGenerator {

    public static String getDateTime() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddhhmmss"));
    }

}
