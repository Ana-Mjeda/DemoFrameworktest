package nopCommerceTests;

import base.BrowserFactory;
import base.PageHeader;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.HomePage;
import page.LoginPage;
import page.RegisterPage;

import static base.BrowserFactory.driver;

public class CreateNewAccountTest {

    private RegisterPage registerPage;

    private HomePage homePage;

    private PageHeader pageHeader;
    private LoginPage loginPage;

    String name = "Hera";

    String lastName = "Syndulla";

    String day = "17";

    String month = "April";

    String year = "1980";

    String email = "hera20230111124104@test.com";

    String company = "Phoenix";

    String password = "secret";

    String confirmPassword = "secret";

    String invalidEmail = "test.com";

    String invalidPassword = "test";

    String invalidConfirmPassword = "tost";

    @BeforeClass
    void prepare() {
        WebDriver driver = BrowserFactory.startBrowser("https://demo.nopcommerce.com/");
        homePage = new HomePage(driver);
        registerPage = new RegisterPage(driver);
        pageHeader = new PageHeader(driver);
        loginPage = new LoginPage(driver);

        //email = "hera" + DateTimeGenerator.getDateTime() + "@test.com";
        //System.out.println(email);
    }

    @Test
    public void stepCreateAccount() {
        homePage.clickRegisterButton();
        registerPage.clickRegisterButton();
        registerPage.enterInvalidEmail(invalidEmail);
        registerPage.enterInvalidPasswordLessThen(invalidPassword);
        registerPage.enterInvalidConfirmPasswordDifferent(invalidConfirmPassword);
        registerPage.clickGenderFemale();
        registerPage.fillFormWithValidData(name, lastName, day, month, year, email, company, password, confirmPassword);
        registerPage.clickRegisterButton();
        Assert.assertTrue(BrowserFactory.getDriver().getCurrentUrl().startsWith("https://demo.nopcommerce.com/"));

        registerPage.getRegistrationMessage();
        registerPage.clickContinueButton();

        Assert.assertEquals(BrowserFactory.getDriver().getCurrentUrl(), "https://demo.nopcommerce.com/");
    }

    @Test
    public void createAccountWithExistingEmail() {
        pageHeader.clickRegisterButton();
        registerPage.clickGenderFemale();
        registerPage.fillFormWithValidData(name, lastName, day, month, year, email, company, password, confirmPassword);
        registerPage.clickRegisterButton();
        registerPage.getMessageError();
    }

    @Test
    public void loginWithNewAccount() {
        pageHeader.clickLoginButton();
        Assert.assertTrue(BrowserFactory.getDriver().getCurrentUrl().startsWith("https://demo.nopcommerce.com/login"));

        loginPage.emailInputFieldSetText(invalidEmail);
        loginPage.clickLoginButton();

        Assert.assertEquals(loginPage.getEmailErrorAttribute(), "Wrong email");

        loginPage.emailInputFieldSetText(email);
        loginPage.passwordInputFieldSetText(invalidPassword);
        loginPage.clickLoginButton();

        Assert.assertEquals(loginPage.getPasswordErrorAttribute(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");


    }

    @Test
    public void changePassword() {
        pageHeader.clickLoginButton();

    }

    @AfterTest
    public void closeDriver() {
        //closes the browser instance
        driver.close();
    }
}