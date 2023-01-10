package nopCommerceTests;

import org.testng.annotations.Test;
import util.DateTimeGenerator;

public class DateTimeGeneratorTest {

    @Test
    public void basicTest() {
        System.out.println(DateTimeGenerator.getDateTime());
    }

}
