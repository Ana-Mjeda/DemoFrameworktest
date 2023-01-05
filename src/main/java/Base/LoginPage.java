package Base;

import nopCommerce.TemplatePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends TemplatePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void clickLoginButton() {
        WebElement loginButton = driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[2]/form/div[3]/button"));
        loginButton.click();
        System.out.println("Login button on bottom of Returning Customer clicked");
    }

    public void clickLoginButtonWhenErrorIsPresent() {
        WebElement loginButton = driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[2]/form/div[4]/button"));
        loginButton.click();
        System.out.println("Login button on bottom of Returning Customer clicked");
    }

    public WebElement getEmailInputField() {
        return driver.findElement(By.id("Email"));
    }

    public void emailInputFieldSetText(String text) {
        WebElement emailInputField = getEmailInputField();
        emailInputField.sendKeys(text);
    }
    // Error that's shown beneath the input field if the input field is empty
    public WebElement getEmailError() {
        return driver.findElement(By.id("Email-error"));
    }
    public String getEmailAttribute(){
        return getEmailInputField().getAttribute("value");
    }

    public WebElement getPasswordInputField() {
        return driver.findElement(By.id("Password"));
    }

    public void passwordInputFieldSetText(String text) {
        WebElement passwordInputField = getPasswordInputField();
        passwordInputField.sendKeys(text);
    }
    // Error that's shown beneath the input field if the input field is empty
    public WebElement getPasswordError() {
        return driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[2]/form/div[1]"));
    }
    public String getPasswordAttribute(){
        return getPasswordInputField().getAttribute("value");
    }
}
