package nopCommerceTests;

import Base.BrowserFactory;
import nopCommerce.TemplatePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TemplateTest {

    public TemplatePage templatePage;

    @BeforeClass
    public void beforeClass() {
        WebDriver driver = BrowserFactory.startBrowser("https://demo.nopcommerce.com/");
        templatePage = new TemplatePage(driver);
    }

    @Test
    public void Step1() {
//        templatePage.clickLoginButton("hello", "world")
//                .clickLogin();
        System.out.println("done");
    }

    @AfterClass
    public void afterClass() {
        BrowserFactory.getDriver().quit();
    }
}
