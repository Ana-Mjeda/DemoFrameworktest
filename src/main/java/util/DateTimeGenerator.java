package util;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeGenerator {
    public static String email;

    public static String getDateTime() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddhhmmss"));
    }

    public static void generateRandomEmail() throws IOException {
        FileWriter e = new FileWriter("C:\\Users\\ana.mjeda\\IdeaProjects\\DemoFrameworktest\\src\\main\\java\\util\\email.txt");


        email = "hera" + DateTimeGenerator.getDateTime() + "@test.com";
        System.out.println(email);

        e.write(email);
        e.close();
    }

}
