package util;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class DateTimeGenerator {
    public static String email;

    public static String getDateTime() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddhhmmss"));
    }

    public static void generateRandomEmail() throws IOException {
        //FileWriter e = new FileWriter("C:\\Users\\ana.mjeda\\IdeaProjects\\DemoFrameworktest\\src\\main\\java\\util\\email.txt");

        email = "hera" + DateTimeGenerator.getDateTime() + "@test.com";
        System.out.println(email);

//        FileWriter myEmail = new FileWriter("emailtest.txt");
//        myEmail.write(email);
//        myEmail.close();
//        System.out.println("Successfully wrote to the file.");

    }

    public static void readGeneratedRandomEmail() {
        Scanner myReader = new Scanner(email);
    }
}
