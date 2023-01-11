package util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class DateTimeGenerator {
    public static String email;

    public static String getDateTime() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddhhmmss"));
    }

    public static void generateRandomEmail() {
        email = "hera" + DateTimeGenerator.getDateTime() + "@test.com";
        System.out.println(email);
    }

}
