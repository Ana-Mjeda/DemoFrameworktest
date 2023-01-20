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
    WebElement getOldPasswordError;
    @FindBy(id = "NewPassword")
    WebElement newPasswordInputField;
    @FindBy(id = "NewPassword-error")
    WebElement getNewPasswordError;
    @FindBy(id = "ConfirmNewPassword")
    WebElement confirmNewPasswordInputField;
    @FindBy(id = "ConfirmNewPassword-error")
    WebElement getConfirmNewPasswordError;
    @FindBy(xpath = "//*[@id=\"bar-notification\"]")
    WebElement getPasswordChangedSuccessfulMessage;
    @FindBy(xpath = "//span[@class='close']")
    WebElement getCloseButtonOnBar;
    @FindBy(xpath = "//div[@class='message-error validation-summary-errors'] //li")
    WebElement oldPasswordError;
    @FindBy(xpath = "//*[@class='message-error validation-summary-errors']")
    WebElement samePasswordError;

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
        baseUI.click(getCloseButtonOnBar);
    }

    @Step("Get Same Password Error Message")
    public void getSamePasswordError() {
        Assert.assertEquals(samePasswordError.getText(), "You entered the password that is the same as one of the last passwords you used. Please create a new password.");
    }

    @Step("Get Old Password Error Message")
    public void getOldPasswordError() {
        Assert.assertEquals(oldPasswordError.getText(), "Old password doesn't match");
    }

    @Step("Get Confirm New Password Error Message")
    public void getConfirmNewPasswordError() {
        Assert.assertEquals(getConfirmNewPasswordError.getText(), "The new password and confirmation password do not match.");
    }

    @Step("Get Password Changed Message")
    public void getPasswordChanged() {
        Assert.assertEquals(getPasswordChangedSuccessfulMessage.getText(), "Password was changed");
    }
}

