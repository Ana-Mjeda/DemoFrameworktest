package nopCommerceTests;

import base.BrowserFactory;
import base.PageHeader;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.Gender;
import page.RegisterPage;
import util.DateTimeGenerator;

import java.io.IOException;

import static base.BrowserFactory.driver;

public class TC01CreateNewAccountTest {
    private RegisterPage registerPage;
    private PageHeader pageHeader;

    Gender gender = Gender.FEMALE;
    String name = "Hera";
    String lastName = "Syndulla";
    String day = "17";
    String month = "April";
    String year = "1980";
    String email;
    String company = "Phoenix";
    String password = "secret";
    String invalidEmail = "test.com";
    String invalidPassword = "test";
    String invalidConfirmPassword = "tostiran";

    @BeforeClass
    void prepare() throws IOException {
        WebDriver driver = BrowserFactory.startBrowser("https://demo.nopcommerce.com/");
        registerPage = new RegisterPage(driver);
        pageHeader = new PageHeader(driver);

        //DateTimeGenerator.generateRandomEmail();

        email = "hera" + DateTimeGenerator.getDateTime() + "@test.com";
        System.out.println(email);
    }

    @Test(priority = 1)
    public void createNewAccount() {
        pageHeader.clickRegisterButton();

        registerPage.clickRegisterButton();
        registerPage.enterInvalidEmail(invalidEmail);
        registerPage.enterInvalidPasswordLessThen(invalidPassword);
        registerPage.enterInvalidConfirmPasswordDifferent(invalidConfirmPassword);
        //registerPage.clickGender(radioButtons,"female");
        registerPage.fillFormWithValidData(gender, name, lastName, day, month, year, email, company, password, password);
        registerPage.clickRegisterButton();
        Assert.assertTrue(BrowserFactory.getDriver().getCurrentUrl().startsWith("https://demo.nopcommerce.com/"));

        registerPage.getRegistrationMessage();
        registerPage.clickContinueButton();

        Assert.assertEquals(BrowserFactory.getDriver().getCurrentUrl(), "https://demo.nopcommerce.com/");
    }
    @Test(priority = 2)
    public void createAccountWithExistingEmail() {
        pageHeader.clickRegisterButton();
        //registerPage.clickGender();
        registerPage.fillFormWithValidData(gender, name, lastName, day, month, year, email, company, password, password);
        registerPage.clickRegisterButton();
        registerPage.getMessageError();
    }

    @AfterTest
    public void closeDriver() {
        //closes the browser instance
        driver.close();
    }
}