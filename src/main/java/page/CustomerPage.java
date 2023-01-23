package page;

import base.BaseUI;
import base.BrowserFactory;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class CustomerPage extends BrowserFactory {
    BaseUI baseUI;

    @FindBy(xpath = "//*[@class='change-password inactive'] //a")
    WebElement changePassword;
    @FindBy(xpath = "//button[@class='button-1 change-password-button']")
    WebElement changePasswordButton;
    @FindBy(id = "OldPassword")
    WebElement oldPasswordInputField;
    @FindBy(id = "OldPassword-error")
    WebElement newPasswordInputField;
    @FindBy(id = "NewPassword-error")
    WebElement confirmNewPasswordInputField;
    @FindBy(id = "ConfirmNewPassword-error")
    WebElement confirmNewPasswordError;
    @FindBy(xpath = "//*[@id=\"bar-notification\"]")
    WebElement passwordChangedSuccessfulMessage;
    @FindBy(xpath = "//span[@class='close']")
    WebElement closeButtonOnBar;
    @FindBy(xpath = "//*[@class='message-error validation-summary-errors']")
    WebElement passwordErrorAboveFields;

    public CustomerPage(WebDriver driver) {
        super(driver);
        baseUI = new BaseUI(driver);
    }

    public void clickChangePassword() {
        baseUI.click(changePassword);
        System.out.println("Change Password link clicked");
    }

    public void clickChangePasswordButton() {
        baseUI.click(changePasswordButton);
        System.out.println("Change Password Button clicked");
    }

    public void oldPasswordInputFieldSetText(String text) {
        baseUI.sendText(oldPasswordInputField, text);
    }

    public void newPasswordInputFieldSetText(String text) {
        baseUI.sendText(newPasswordInputField, text);
    }

    public void confirmNewPasswordInputFieldSetText(String text) {
        baseUI.sendText(confirmNewPasswordInputField, text);
    }

    @Step("Fill all fields with same password")
    public void fillFieldsWithPassword(String oldP, String newP, String confirmP) {
        oldPasswordInputFieldSetText(oldP);
        newPasswordInputFieldSetText(newP);
        confirmNewPasswordInputFieldSetText(confirmP);
        clickChangePasswordButton();
    }

    public void clickCloseButtonOnBar() {
        baseUI.click(closeButtonOnBar);
    }

    @Step("Get Password Error Message")
    public void passwordErrorThatAppearsAboveFields(String error) {
        Assert.assertEquals(passwordErrorAboveFields.getText(), error);
    }

    @Step("Get Confirm New Password Error Message")
    public void confirmNewPasswordError() {
        Assert.assertEquals(confirmNewPasswordError.getText(), "The new password and confirmation password do not match.");
    }

    @Step("Get Password Changed Message")
    public void passwordChangedMessage() {
        Assert.assertEquals(passwordChangedSuccessfulMessage.getText(), "Password was changed");
    }
}

