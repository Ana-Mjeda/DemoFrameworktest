package util;

import java.io.BufferedReader;
import java.io.FileReader;
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

        email = "hera" + DateTimeGenerator.getDateTime() + "@test.com";
        //System.out.println(email);

        FileWriter myEmail = new FileWriter("emailtest.txt");
        myEmail.write(email);
        myEmail.close();
        System.out.println("Successfully wrote to the file.");
    }

    public static void readGeneratedRandomEmail() {

        String fileName = "emailtest.txt";
        try {
            //Create object of FileReader
            FileReader inputFile = new FileReader(fileName);

            //Instantiate the BufferedReader Class
            BufferedReader bufferReader = new BufferedReader(inputFile);

            //Variable to hold the one line data
            String line;

            // Read file line by line and print on the console
            while ((line = bufferReader.readLine()) != null) {
                System.out.println(line);
            }
            //Close the buffer reader
            bufferReader.close();
        } catch (Exception e) {
            System.out.println("Error while reading file line by line:" + e.getMessage());
        }
    }
}
