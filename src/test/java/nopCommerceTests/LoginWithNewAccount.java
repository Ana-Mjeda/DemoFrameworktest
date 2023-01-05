package nopCommerceTests;

import Base.BrowserFactory;
import Base.HomePage;
import Base.LoginPage;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginWithNewAccount extends TemplateTest {

    private final HomePage homePage = new HomePage(BrowserFactory.getDriver());

    private final LoginPage loginPage = new LoginPage(BrowserFactory.getDriver());

    @Test
    public void step2 () {

        homePage.clickLoginButton();

        BrowserFactory.getDriver().getCurrentUrl();

        // test if it's on register page by url
        Assert.assertTrue(BrowserFactory.getDriver().getCurrentUrl().startsWith("https://demo.nopcommerce.com/login"));

        loginPage.emailInputFieldSetText("test.com");
        loginPage.getEmailInputField().sendKeys(Keys.RETURN);
        System.out.println("Message: " + loginPage.getEmailError().getText());
        Assert.assertEquals(loginPage.getEmailError().getText(), "Wrong email");

        loginPage.getEmailInputField().clear();
        loginPage.emailInputFieldSetText("test@test.com");
        System.out.println("Entered Email is: " + loginPage.getEmailAttribute());

        loginPage.passwordInputFieldSetText("t");
        loginPage.getPasswordInputField().sendKeys(Keys.RETURN);
        System.out.println("Message: " + loginPage.getPasswordError().getText());
        Assert.assertEquals(loginPage.getPasswordError().getText(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");

    }

}
