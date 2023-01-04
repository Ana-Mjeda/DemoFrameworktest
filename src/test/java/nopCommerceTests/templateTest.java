package nopCommerceTests;

import Base.BrowserFactory;
import nopCommerce.TemplatePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.URL;

public class templateTest {

    public TemplatePage templatePage;

    @BeforeClass
    public void beforeClass(){
        WebDriver driver = BrowserFactory.startBrowser("www.google.com");
        templatePage = new TemplatePage(driver);
    }
    @Test
    public void Step1(){
        templatePage.clickLoginButton("hello", "world")
                .clickLogin();
    }
}
