package page;

import base.BaseUI;
import base.BrowserFactory;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LoginPage extends BrowserFactory {

    BaseUI baseUI;

    @FindBy(id = "Email")
    WebElement emailInputField;

    @FindBy(id = "Password")
    WebElement passwordInputField;

    @FindBy(xpath = "//button[@class='button-1 login-button']")
    WebElement loginButton;

    @FindBy(xpath = "//span[@id='Email-error']")
    WebElement emailError;

    @FindBy(xpath = "//*[@class='message-error validation-summary-errors']")
    WebElement passwordError;

    public LoginPage(WebDriver driver) {
        super(driver);
        baseUI = new BaseUI(driver);
    }

    @Step("Click Login Button")
    public void clickLoginButton() {
        baseUI.click(loginButton);
        System.out.println("Login button on bottom of Returning Customer clicked");
    }
    public void emailInputFieldSetText(String text) {
        baseUI.sendText(emailInputField, text);
    }


    public void passwordInputFieldSetText(String text) {
        baseUI.sendText(passwordInputField, text);
    }


    @Step("Fill fields for login")
    public void fillLoginFields(String email, String password) {
        emailInputFieldSetText(email);
        passwordInputFieldSetText(password);
        clickLoginButton();
    }

    @Step("Get Wrong Email Message")
    public void verifyEmailError() {
        Assert.assertEquals(emailError.getText(), "Wrong email");
    }

    @Step("Get Password Error Message")
    public void verifyPasswordError() {
        Assert.assertEquals(passwordError.getText(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
    }
}


