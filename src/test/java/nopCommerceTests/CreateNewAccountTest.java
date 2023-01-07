package nopCommerceTests;

import Base.BrowserFactory;
import Base.HomePage;
import Base.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateNewAccountTest extends TemplateTest {

    private final RegisterPage registerPage = new RegisterPage(BrowserFactory.getDriver());

    private final HomePage homePage = new HomePage(BrowserFactory.getDriver());

    String email = "herasit@test.com";

    @Test
    public void step1() throws InterruptedException {
        homePage.clickRegisterButton();

        // test if it's on register page by url
        Assert.assertTrue(BrowserFactory.getDriver().getCurrentUrl().startsWith("https://demo.nopcommerce.com/register"));

        registerPage.clickRegisterButton();

        Assert.assertEquals(registerPage.getFirstNameAttribute(), "");
        Assert.assertEquals(registerPage.getFirstNameError().getText(), "First name is required.");
        System.out.println("Message: " + registerPage.getFirstNameError().getText());

        Assert.assertEquals(registerPage.getLastNameAttribute(), "");
        Assert.assertEquals(registerPage.getLastNameError().getText(), "Last name is required.");
        System.out.println("Message: " + registerPage.getLastNameError().getText());

        Assert.assertEquals(registerPage.getEmailAttribute(), "");
        Assert.assertEquals(registerPage.getEmailError().getText(), "Email is required.");
        System.out.println("Message: " + registerPage.getEmailError().getText());

        Assert.assertEquals(registerPage.getPasswordAttribute(), "");
        Assert.assertEquals(registerPage.getPasswordError().getText(), "Password is required.");
        System.out.println("Message: " + registerPage.getPasswordError().getText());

        Assert.assertEquals(registerPage.getConfirmPasswordAttribute(), "");
        Assert.assertEquals(registerPage.getConfirmPasswordError().getText(), "Password is required.");
        System.out.println("Message: " + registerPage.getConfirmPasswordError().getText());

        registerPage.emailInputFieldSetText("test.com");
        System.out.println("Message: " + registerPage.getEmailError().getText());
        Assert.assertEquals(registerPage.getEmailError().getText(), "Wrong email");

        registerPage.passwordInputFieldSetText("p");
        System.out.println("Message: " + registerPage.getPasswordError().getText());
        Assert.assertEquals(registerPage.getPasswordError().getText(), "Password must meet the following rules:\nmust have at least 6 characters");

        registerPage.confirmPasswordInputFieldSetText("a");
        System.out.println("Message: " + registerPage.getConfirmPasswordError().getText());
        Assert.assertEquals(registerPage.getConfirmPasswordError().getText(), "The password and confirmation password do not match.");

        registerPage.genderFemale().click();
        System.out.println("Gender is clicked");

        registerPage.firstNameInputFieldSetText("Hera");
        System.out.println("Entered First Name is: " + registerPage.getFirstNameAttribute());

        String lastName = "Syndulla";
        registerPage.lastNameInputFieldSetText(lastName);
        Assert.assertEquals(registerPage.getLastNameAttribute(), lastName);

        System.out.println("Entered Last Name is: " + registerPage.getLastNameAttribute());

        registerPage.selectDayFromDropdown("5");
        System.out.println("Day is selected");

        registerPage.selectMonthFromDropdown("April");
        System.out.println("Month is selected");

        registerPage.selectYearFromDropdown("1979");
        System.out.println("Year is selected");

        // pri svakom testu emaila, moram novi da unesem da bi prosao test
        registerPage.getEmailInputField().clear();
        registerPage.emailInputFieldSetText(email);
        System.out.println("Entered Email is: " + registerPage.getEmailAttribute());

        registerPage.companyInputFieldSetText("Phoenix Squadron");
        System.out.println("Company name is entered: " + registerPage.getCompanyAttribute());

        registerPage.getPasswordInputField().clear();
        registerPage.passwordInputFieldSetText("secret");
        System.out.println("Password is entered");

        registerPage.getConfirmPasswordInputField().clear();
        registerPage.confirmPasswordInputFieldSetText("secret");
        System.out.println("Confirm password is entered");

        registerPage.clickRegisterButton();

        Assert.assertEquals(registerPage.getRegistrationMessage().getText(), "Your registration completed");

        registerPage.clickContinueButton();
        Thread.sleep(3000);

        Assert.assertEquals(BrowserFactory.getDriver().getCurrentUrl(), "https://demo.nopcommerce.com/");
    }

    @Test
    public void step4() throws InterruptedException {
        homePage.clickRegisterButton();

        registerPage.genderFemale().click();

        registerPage.firstNameInputFieldSetText("Hera");

        registerPage.lastNameInputFieldSetText("Syndulla");

        registerPage.selectDayFromDropdown("5");

        registerPage.selectMonthFromDropdown("April");

        registerPage.selectYearFromDropdown("1979");

        // pri svakom testu emaila, moram novi da unesem da bi prosao test
        registerPage.getEmailInputField().clear();
        registerPage.emailInputFieldSetText(email);
        System.out.println("Entered Email is: " + registerPage.getEmailAttribute());

        registerPage.companyInputFieldSetText("Phoenix Squadron");;

        registerPage.getPasswordInputField().clear();
        registerPage.passwordInputFieldSetText("secret");

        registerPage.getConfirmPasswordInputField().clear();
        registerPage.confirmPasswordInputFieldSetText("secret");

        registerPage.clickRegisterButton();


        String text = registerPage.getEmailMessage().getText();
        System.out.println("Message: " + text);
        Assert.assertEquals(text, "The specified email already exists");

        Thread.sleep(5000);
    }
}