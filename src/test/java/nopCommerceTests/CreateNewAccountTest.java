package nopCommerceTests;

import Base.BrowserFactory;
import Base.HomePage;
import Base.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateNewAccountTest extends TemplateTest {

    private final RegisterPage registerPage = new RegisterPage(BrowserFactory.getDriver());

    private final HomePage homePage = new HomePage(BrowserFactory.getDriver());

    @Test
    public void Step1() throws InterruptedException {
        homePage.clickRegisterButton();

        BrowserFactory.getDriver().getCurrentUrl();
        // test if it's on register page by url
        Assert.assertTrue(BrowserFactory.getDriver().getCurrentUrl().startsWith("https://demo.nopcommerce.com/register"));

        registerPage.clickRegisterButton();

        Assert.assertEquals(registerPage.getFirstNameInputField().getText(), "");
        Assert.assertEquals(registerPage.getFirstNameError().getText(), "First name is required.");
        System.out.println("Message: " + registerPage.getFirstNameError().getText());

        Assert.assertEquals(registerPage.getLastNameInputField().getText(), "");
        Assert.assertEquals(registerPage.getLastNameError().getText(), "Last name is required.");
        System.out.println("Message: " + registerPage.getLastNameError().getText());

        Assert.assertEquals(registerPage.getEmailInputField().getText(), "");
        Assert.assertEquals(registerPage.getEmailError().getText(), "Email is required.");
        System.out.println("Message: " + registerPage.getEmailError().getText());

        Assert.assertEquals(registerPage.getPasswordInputField().getText(), "");
        Assert.assertEquals(registerPage.getPasswordError().getText(), "Password is required.");
        System.out.println("Message: " + registerPage.getPasswordError().getText());

        Assert.assertEquals(registerPage.getConfirmPasswordInputField().getText(), "");
        Assert.assertEquals(registerPage.getConfirmPasswordError().getText(), "Password is required.");
        System.out.println("Message: " + registerPage.getConfirmPasswordError().getText());

        registerPage.emailInputFieldSetText("test.com");
        System.out.println("Message: " + registerPage.getEmailError().getText());
        Assert.assertEquals(registerPage.getEmailError().getText(), "Wrong email");


        registerPage.passwordInputFieldSetText("p");
        System.out.println("Message: " + registerPage.getPasswordError().getText());

        registerPage.confirmPasswordInputFieldSetText("a");
        System.out.println("Message: " + registerPage.getConfirmPasswordError().getText());

        registerPage.genderFemale().click();
        System.out.println("Gender is clicked");

        registerPage.firstNameInputFieldSetText("Hera");
        System.out.println("Entered First Name is: " + registerPage.getFirstNameInputField().getAttribute("value"));

        registerPage.lastNameInputFieldSetText("Syndulla");
        System.out.println("Entered Last Name is: " + registerPage.getLastNameInputField().getAttribute("value"));

        registerPage.selectDayFromDropdown("5");
        Thread.sleep(3000);
        System.out.println("Day is selected");

        registerPage.selectMonthFromDropdown("April");
        Thread.sleep(3000);
        System.out.println("Month is selected");

        registerPage.selectYearFromDropdown("1979");
        Thread.sleep(3000);
        System.out.println("Year is selected");

        // pri svakom testu emaila, moram novi da unesem da bi prosao test
        registerPage.getEmailInputField().clear();
        registerPage.emailInputFieldSetText("herasy@test.com");
        System.out.println("Entered Email is: " + registerPage.getEmailInputField().getAttribute("value"));

        registerPage.companyInputFieldSetText("Phoenix Squadron");
        System.out.println("Company name is entered: " + registerPage.getCompanyInputField().getAttribute("value"));

        registerPage.getPasswordInputField().clear();
        registerPage.passwordInputFieldSetText("secret");
        System.out.println("Password is entered");

        registerPage.getConfirmPasswordInputField().clear();
        registerPage.confirmPasswordInputFieldSetText("secret");
        System.out.println("Confirm password is entered");

        registerPage.clickRegisterButton();

        Assert.assertEquals(registerPage.getRegistrationMessage().getText(), "Your registration completed");

        registerPage.clickContinueButton();


    }
}