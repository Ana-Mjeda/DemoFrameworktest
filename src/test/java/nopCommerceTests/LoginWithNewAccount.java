package nopCommerceTests;

import Base.BrowserFactory;
import Base.CustomerPage;
import Base.LoginPage;
import Base.PageHeader;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginWithNewAccount extends TemplateTest {

    private final LoginPage loginPage = new LoginPage(BrowserFactory.getDriver());

    private final PageHeader pageHeader = new PageHeader(BrowserFactory.getDriver());

    private final CustomerPage customerPage = new CustomerPage(BrowserFactory.getDriver());

    @Test
    public void step2() throws InterruptedException {

        pageHeader.clickLoginButton();

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

        pageHeader.clickLogoutButton();
        System.out.println("Log out button on header page is clicked");
        Thread.sleep(3000);

    }

    @Test
    public void step3() {

        pageHeader.clickLoginButton();

        loginPage.emailInputFieldSetText("herasrp@test.com");
        loginPage.passwordInputFieldSetText("secret");

        loginPage.clickLoginButton();

        pageHeader.clickMyAccountButton();

        Assert.assertEquals(BrowserFactory.getDriver().getCurrentUrl(), "https://demo.nopcommerce.com/customer/info");

        customerPage.clickChangePassword();

        customerPage.oldPasswordInputFieldSetText("secret");
        System.out.println("Old Password is entered");

        customerPage.newPasswordInputFieldSetText("secret");
        System.out.println("New Password is entered");

        customerPage.confirmNewPasswordInputFieldSetText("secret");
        System.out.println("Confirmed New Password is entered");

        customerPage.clickChangePasswordButton();

        System.out.println("Message: " + customerPage.getSamePasswordError().getText());
        Assert.assertEquals(customerPage.getSamePasswordError().getText(), "You entered the password that is the same as one of the last passwords you used. Please create a new password.");

        customerPage.oldPasswordInputFieldSetText("ghosty");
        customerPage.newPasswordInputFieldSetText("ghosty");
        customerPage.confirmNewPasswordInputFieldSetText("ghosty");

        customerPage.clickChangePasswordButtonWhenErrorIsPresent();

        System.out.println("Message: " + customerPage.getOldPasswordMatchError().getText());
        Assert.assertEquals(customerPage.getOldPasswordMatchError().getText(), "Old password doesn't match");
    }
}
