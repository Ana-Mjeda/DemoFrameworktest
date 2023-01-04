package Base;

import nopCommerce.TemplatePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage extends TemplatePage {

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public void clickRegisterButton() {
        WebElement registerButton = driver.findElement(By.id("register-button"));
        registerButton.click();
        System.out.println("Register button on bottom of the page clicked");
    }

    public WebElement getFirstNameInputField() {
        return driver.findElement(By.id("FirstName"));
    }

    public void firstNameInputFieldSetText(String text) {
        WebElement firstNameInputField = getFirstNameInputField();
        firstNameInputField.sendKeys(text);
    }

    // Error that's shown beneath the input field if the input field is empty
    public WebElement getFirstNameError() {
        return driver.findElement(By.id("FirstName-error"));
    }

    public String getFirstNameAttribute(){
        return getFirstNameInputField().getAttribute("value");
    }
    public WebElement getLastNameInputField() {
        return driver.findElement(By.id("LastName"));
    }

    public void lastNameInputFieldSetText(String text) {
        WebElement lastNameInputField = getLastNameInputField();
        lastNameInputField.sendKeys(text);
    }

    // Error that's shown beneath the input field if the input field is empty
    public WebElement getLastNameError() {
        return driver.findElement(By.id("LastName-error"));
    }
    public String getLastNameAttribute(){
        return getLastNameInputField().getAttribute("value");
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
        return driver.findElement(By.id("Password-error"));
    }
    public String getPasswordAttribute(){
        return getPasswordInputField().getAttribute("value");
    }
    public WebElement getConfirmPasswordInputField() {
        return driver.findElement(By.id("ConfirmPassword"));
    }

    public void confirmPasswordInputFieldSetText(String text) {
        WebElement confirmPasswordInputField = getConfirmPasswordInputField();
        confirmPasswordInputField.sendKeys(text);
    }

    // Error that's shown beneath the input field if the input field is empty
    public WebElement getConfirmPasswordError() {
        return driver.findElement(By.id("ConfirmPassword-error"));
    }
    public String getConfirmPasswordAttribute(){
        return getConfirmPasswordInputField().getAttribute("value");
    }
    public WebElement genderFemale() {
        return driver.findElement(By.id("gender-female"));
    }

    public WebElement genderMale() {
        return driver.findElement(By.id("gender-male"));
    }

    public WebElement dayDropdown() {
        return driver.findElement(By.name("DateOfBirthDay"));
    }

    public void selectDayFromDropdown(String day) {
        Select d = new Select(dayDropdown());
        d.selectByVisibleText(day);
    }

    public WebElement monthDropdown() {
        return driver.findElement(By.name("DateOfBirthMonth"));
    }
    public void selectMonthFromDropdown(String month) {
        Select select = new Select(monthDropdown());
        select.selectByVisibleText(month);
    }

    public WebElement yearDropdown() {
        return driver.findElement(By.name("DateOfBirthYear"));
    }
    public void selectYearFromDropdown(String year) {
        Select select = new Select(yearDropdown());
        select.selectByVisibleText(year);
    }

    public WebElement getCompanyInputField() {
        return driver.findElement(By.id("Company"));
    }

    public void companyInputFieldSetText(String text) {
        WebElement companyInputField = getCompanyInputField();
        companyInputField.sendKeys(text);
    }
    public String getCompanyAttribute(){
        return getCompanyInputField().getAttribute("value");
    }
    public WebElement getRegistrationMessage() {
        return driver.findElement(By.className("result"));
    }

    public void clickContinueButton() {
        WebElement continueButton = driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[2]/a"));
        continueButton.click();
        System.out.println("Continue button is clicked");
    }

    public WebElement getEmailMessage() {
        return driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/form/div[1]"));
    }
}
