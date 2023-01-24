package nopCommerceTests;

import base.PageHeader;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.Gender;
import page.RegisterPage;
import util.DateTimeGenerator;

public class TC01CreateNewAccountTest extends BaseTest {
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
    public void beforeClass() {
        super.beforeClass();
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
        registerPage.nameError();
        registerPage.lastNameError();
        registerPage.emailError();
        registerPage.passwordError();

        registerPage.fillEmailField(invalidEmail);
        registerPage.fillPasswordField(invalidPassword);
        registerPage.fillConfirmPasswordField(invalidConfirmPassword);
        registerPage.fillFormWithValidData(gender, name, lastName, day, month, year, email, company, password, password);
        registerPage.clickRegisterButton();
        checkUrl();

        registerPage.registrationMessage();
        registerPage.clickContinueButton();
        checkUrl();
    }

    @Test(priority = 2)
    public void createAccountWithExistingEmail() {
        pageHeader.clickRegisterButton();
        registerPage.fillFormWithValidData(gender, name, lastName, day, month, year, email, company, password, password);
        registerPage.clickRegisterButton();
        registerPage.sameEmailMessageThatAppearsUnderRegisterText();
    }

    @AfterTest
    public void closeDriver() {
        //closes the browser instance
        driver.close();
    }
}