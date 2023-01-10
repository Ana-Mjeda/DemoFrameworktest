package page;

import base.BaseUI;
import base.BrowserFactory;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BrowserFactory {

    BaseUI baseUI;

    @FindBy(xpath = "//input[@class='email']")
    WebElement EmailInputField;

    @FindBy(xpath = "//input[@class='password']")
    WebElement PasswordInputField;

    @FindBy(xpath = "//input[@class='button-1 login-button']")
    WebElement LoginButton;

    @FindBy(xpath = "//*[@id='Email-error']")
    WebElement emailError;

    @FindBy(xpath = "//a[@class='message-error validation-summary-errors']")
    WebElement passwordError;

    public LoginPage(WebDriver driver) {
        super(driver);
        baseUI = new BaseUI(driver);
    }

    @Step("Click Login Button")
    public void clickLoginButton() {
        baseUI.click(LoginButton);
        System.out.println("Login button on bottom of Returning Customer clicked");
    }

    public void emailInputFieldSetText(String text) {
        baseUI.sendText(EmailInputField, text);
    }

    public String getEmailAttribute() {
        return emailError.getAttribute("value");
    }

    public void passwordInputFieldSetText(String text) {
        baseUI.sendText(PasswordInputField, text);
    }

    public String getPasswordAttribute() {
        return passwordError.getAttribute("value");
    }
}
