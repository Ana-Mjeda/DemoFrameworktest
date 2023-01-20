package nopCommerceTests;


import base.BrowserFactory;
import base.PageHeader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.Gender;
import page.LoginPage;
import page.RegisterPage;
import util.DateTimeGenerator;

import java.io.IOException;

import static base.BrowserFactory.driver;

public class TC02LoginWithNewAccount {
    private PageHeader pageHeader;
    private LoginPage loginPage;
    private RegisterPage registerPage;

    String email;
    String password = "secret";
    String invalidEmail = "test.com";
    String invalidPassword = "test";

    @BeforeClass
    void prepare() throws IOException {
        WebDriver driver = BrowserFactory.startBrowser("https://demo.nopcommerce.com/");

        registerPage = new RegisterPage(driver);
        pageHeader = new PageHeader(driver);
        loginPage = new LoginPage(driver);

        //DateTimeGenerator.generateRandomEmail();
        email = "hera" + DateTimeGenerator.getDateTime() + "@test.com";
        System.out.println(email);
    }

    public void createAccount() {
        pageHeader.clickRegisterButton();
        registerPage.fillFormWithValidData(Gender.FEMALE, "test", "test", "17", "April", "1989", email, "company", password, password);
        registerPage.clickRegisterButton();

    }

    @Test(priority = 3)
    public void loginWithNewAccount() {
        createAccount();

        pageHeader.clickLoginButton();
        pageHeader.urlCheck();
        loginPage.emailInputFieldSetText(invalidEmail);
        loginPage.clickLoginButton();
        loginPage.getEmailError();
        loginPage.fillLoginFields(email, invalidPassword);
        loginPage.getPasswordError();
        loginPage.fillLoginFields(email, password);
        pageHeader.urlCheck();
        pageHeader.checkMyaccount();
        pageHeader.checkLogout();
        pageHeader.clickLogoutButton();

    }

    @AfterTest
    public void closeDriver() {
        //closes the browser instance
        driver.close();
    }
}
