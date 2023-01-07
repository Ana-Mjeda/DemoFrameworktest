package Base;

import nopCommerce.TemplatePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CustomerPage extends TemplatePage {

    public CustomerPage(WebDriver driver) {
        super(driver);
    }

    public void clickChangePassword() {
        WebElement changePassword = driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[1]/div/div[2]/ul/li[7]/a"));
        changePassword.click();
        System.out.println("Change Password link clicked");
    }

    public void clickChangePasswordButton() {
        WebElement changePasswordButton = driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[2]/div/div[2]/form/div[2]/button"));
        changePasswordButton.click();
        System.out.println("Change Password Button clicked");
    }

    public void clickChangePasswordButtonWhenErrorIsPresent() {
        WebElement changePasswordButton = driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[2]/div/div[2]/form/div[3]/button"));
        changePasswordButton.click();
        System.out.println("Change Password Button clicked");
    }

    public WebElement getOldPasswordInputField() {
        return driver.findElement(By.id("OldPassword"));
    }

    public void oldPasswordInputFieldSetText(String text) {
        WebElement oldPasswordInputField = getOldPasswordInputField();
        oldPasswordInputField.sendKeys(text);
    }

    // Error that's shown beneath the input field if the input field is empty
    public WebElement getOldPasswordError() {
        return driver.findElement(By.id("OldPassword-error"));
    }

    public String getOldPasswordAttribute() {
        return getOldPasswordInputField().getAttribute("value");
    }

    public WebElement getNewPasswordInputField() {
        return driver.findElement(By.id("NewPassword"));
    }

    public void newPasswordInputFieldSetText(String text) {
        WebElement newPasswordInputField = getNewPasswordInputField();
        newPasswordInputField.sendKeys(text);
    }

    // Error that's shown beneath the input field if the input field is empty
    public WebElement getNewPasswordError() {
        return driver.findElement(By.id("NewPassword-error"));
    }

    public String getNewPasswordAttribute() {
        return getNewPasswordInputField().getAttribute("value");
    }

    public WebElement getConfirmNewPasswordInputField() {
        return driver.findElement(By.id("ConfirmNewPassword"));
    }

    public void confirmNewPasswordInputFieldSetText(String text) {
        WebElement confirmNewPasswordInputField = getConfirmNewPasswordInputField();
        confirmNewPasswordInputField.sendKeys(text);
    }

    // Error that's shown beneath the input field if the input field is empty
    public WebElement getConfirmNewPasswordError() {
        return driver.findElement(By.id("ConfirmNewPassword-error"));
    }

    public String getConfirmNewPasswordAttribute() {
        return getConfirmNewPasswordInputField().getAttribute("value");
    }

    public WebElement getSamePasswordError() {
        return driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[2]/div/div[2]/form/div[1]/ul/li"));
    }

    public WebElement getOldPasswordMatchError() {
        return driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[2]/div/div[2]/form/div[1]/ul/li"));
    }

    public WebElement getConfirmNewPasswordMatchError() {
        return driver.findElement(By.id("ConfirmNewPassword-error"));
    }

    public WebElement getPasswordChangedSuccessfulMessage() {
        return driver.findElement(By.xpath("//*[@id=\"bar-notification\"]/div/p"));
    }

    public WebElement getCloseButton() {
        return driver.findElement(By.className("close"));
    }
}

