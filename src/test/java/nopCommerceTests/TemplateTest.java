package nopCommerceTests;

import base.BrowserFactory;
import nopCommerce.TemplatePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TemplateTest {

    public TemplatePage templatePage;

    @BeforeClass
    public void beforeClass() {
        WebDriver driver = BrowserFactory.startBrowser("https://demo.nopcommerce.com/");
        templatePage = new TemplatePage(driver);
    }

    @AfterClass
    public void afterClass() {
        BrowserFactory.getDriver().quit();
    }
}
