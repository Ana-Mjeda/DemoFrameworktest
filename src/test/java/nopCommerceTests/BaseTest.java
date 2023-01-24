package nopCommerceTests;

import base.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    protected final static String URL = "https://demo.nopcommerce.com/";

    protected WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = BrowserFactory.startBrowser(URL);
    }

    protected void checkUrl() {
        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.startsWith(URL));
    }
}
