package nopCommerceTests;

import Base.BrowserFactory;
import Base.HomePage;
import Base.LoginPage;
import Base.PageHeader;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginWithNewAccount extends TemplateTest {

    private final HomePage homePage = new HomePage(BrowserFactory.getDriver());

    private final LoginPage loginPage = new LoginPage(BrowserFactory.getDriver());

    private final PageHeader pageHeader = new PageHeader(BrowserFactory.getDriver());

    @Test
    public void step2() {

        homePage.clickLoginButton();

        BrowserFactory.getDriver().getCurrentUrl();

        // test if it's on register page by url
        Assert.assertTrue(BrowserFactory.getDriver().getCurrentUrl().startsWith("https://demo.nopcommerce.com/login"));

        loginPage.emailInputFieldSetText("test.com");
        loginPage.getEmailInputField().sendKeys(Keys.RETURN);
        System.out.println("Message: " + loginPage.getEmailError().getText());
        Assert.assertEquals(loginPage.getEmailError().getText(), "Wrong email");

        loginPage.getEmailInputField().clear();
        loginPage.emailInputFieldSetText("herasrp@test.com");
        System.out.println("Entered Email is: " + loginPage.getEmailAttribute());

        loginPage.passwordInputFieldSetText("t");

        loginPage.clickLoginButton();

        System.out.println("Message: " + loginPage.getPasswordError().getText());
        Assert.assertEquals(loginPage.getPasswordError().getText(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");

        loginPage.getPasswordInputField().clear();
        loginPage.passwordInputFieldSetText("secret");
        System.out.println("Password is entered");

        loginPage.clickLoginButtonWhenErrorIsPresent();

        Assert.assertEquals(BrowserFactory.getDriver().getCurrentUrl(), "https://demo.nopcommerce.com/");

        WebElement myAccountButton = pageHeader.getMyAccountButton();
        System.out.println(myAccountButton.getText() + " is displayed");
        Assert.assertEquals(myAccountButton.getText(), "My account");

        WebElement logoutButton = pageHeader.getLogoutButton();
        System.out.println(logoutButton.getText() + " is displayed");
        Assert.assertEquals(logoutButton.getText(), "Log out");

    }

}
