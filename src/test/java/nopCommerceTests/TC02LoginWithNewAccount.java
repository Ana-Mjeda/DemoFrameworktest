package nopCommerceTests;


import base.PageHeader;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.Gender;
import page.LoginPage;
import page.RegisterPage;
import util.DateTimeGenerator;

public class TC02LoginWithNewAccount extends BaseTest {
    private PageHeader pageHeader;
    private LoginPage loginPage;
    private RegisterPage registerPage;

    String email;
    String password = "secret";
    String invalidEmail = "test.com";
    String invalidPassword = "test";

    @BeforeClass
    public void beforeClass() {
        super.beforeClass();

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
        checkUrl();
        loginPage.emailInputFieldSetText(invalidEmail);
        loginPage.clickLoginButton();
        loginPage.verifyEmailError();
        loginPage.fillLoginFields(email, invalidPassword);
        loginPage.verifyPasswordError();
        loginPage.fillLoginFields(email, password);
        checkUrl();
        pageHeader.checkMyAccount();
        pageHeader.checkLogout();
        pageHeader.clickLogoutButton();
    }

    @AfterTest
    public void closeDriver() {
        //closes the browser instance
        driver.close();
    }
}
