package nopCommerceTests;

import base.BrowserFactory;
import base.PageHeader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.CustomerPage;
import page.Gender;
import page.LoginPage;
import page.RegisterPage;
import util.DateTimeGenerator;

import java.io.IOException;

import static base.BrowserFactory.driver;

public class TC03ChangePassword {

    private PageHeader pageHeader;
    private LoginPage loginPage;
    private RegisterPage registerPage;
    private CustomerPage customerPage;

    String email;
    String password = "secret";
    String invalidPassword = "testiran";
    String invalidConfirmPassword = "tostiran";
    String newPassword = "ghosty";

    @BeforeClass
    void prepare() throws IOException {
        WebDriver driver = BrowserFactory.startBrowser("https://demo.nopcommerce.com/");

        registerPage = new RegisterPage(driver);
        pageHeader = new PageHeader(driver);
        loginPage = new LoginPage(driver);
        customerPage = new CustomerPage(driver);

        //DateTimeGenerator.generateRandomEmail();
        email = "hera" + DateTimeGenerator.getDateTime() + "@test.com";
        System.out.println(email);
    }

    public void createAccount() {
        pageHeader.clickRegisterButton();
        registerPage.fillFormWithValidData(Gender.FEMALE, "test", "test", "17", "April", "1989", email, "company", password, password);
        registerPage.clickRegisterButton();

    }

    @Test(priority = 6)
    public void changePassword() throws InterruptedException {
        createAccount();
        pageHeader.clickLoginButton();
        loginPage.fillLoginFields(email, password);
        pageHeader.clickMyAccountButton();

        pageHeader.urlCheck();
        customerPage.clickChangePassword();

        customerPage.fillFieldsWithPassword(password, password, password);
        customerPage.getSamePasswordError();

        driver.navigate().refresh();
        customerPage.fillFieldsWithPassword(invalidPassword, invalidPassword, invalidPassword);
        customerPage.getOldPasswordError();

        driver.navigate().refresh();
        customerPage.fillFieldsWithPassword(password, invalidPassword, invalidConfirmPassword);
        customerPage.getConfirmNewPasswordError();

        driver.navigate().refresh();
        customerPage.fillFieldsWithPassword(password, newPassword, newPassword);
        customerPage.getPasswordChanged();

        customerPage.clickCloseButtonOnBar();
        Thread.sleep(2000);

        pageHeader.clickLogoutButton();
        pageHeader.clickLoginButton();

        loginPage.fillLoginFields(email, password);

        loginPage.getPasswordError();
        loginPage.passwordInputFieldSetText(newPassword);

        loginPage.clickLoginButton();
        pageHeader.clickLogoutButton();
    }

    @AfterTest
    public void closeDriver() {
        //closes the browser instance
        driver.close();
    }
}
