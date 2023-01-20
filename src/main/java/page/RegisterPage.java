package page;

import base.BaseUI;
import base.BrowserFactory;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class RegisterPage extends BrowserFactory {

    BaseUI baseUI;

    @FindBy(xpath = "//*[@class='page-title'")
    WebElement h1;

    @FindBy(id = "register-button")
    WebElement registerButton;

    @FindBy(xpath = "//a[@class='button-1 register-continue-button']")
    WebElement continueButton;

    @FindBy(id = "FirstName")
    WebElement firstNameInputField;

    @FindBy(id = "LastName")
    WebElement lastNameInputField;

    @FindBy(id = "Email")
    WebElement emailInputField;

    @FindBy(id = "Password")
    WebElement passwordInputField;

    @FindBy(id = "ConfirmPassword")
    WebElement confirmPasswordInputField;

    @FindBy(id = "Company")
    WebElement companyInputField;

    @FindBy(id = "FirstName-error")
    WebElement firstNameError;

    @FindBy(id = "LastName-error")
    WebElement lastNameError;

    @FindBy(id = "Email-error")
    WebElement emailError;

    @FindBy(id = "Password-error")
    WebElement passwordError;

    @FindBy(id = "ConfirmPassword")
    WebElement confirmPasswordError;

    @FindBy(name = "DateOfBirthDay")
    WebElement dateOfBirthDay;

    @FindBy(name = "DateOfBirthMonth")
    WebElement monthOfBirthDay;

    @FindBy(name = "DateOfBirthYear")
    WebElement yearOfBirthDay;

    @FindBy(id = "gender-male")
    WebElement genderMale;

    @FindBy(id = "gender-female")
    WebElement genderFemale;

    @FindBy(className = "result")
    WebElement registrationMessage;

    @FindBy(xpath = "//li[.='The specified email already exists']")
    WebElement messageError;

    public RegisterPage(WebDriver driver) {
        super(driver);
        baseUI = new BaseUI(driver);
    }

    @Step("Register text is displayed")
    public void getH1() {
        h1.isDisplayed();
        System.out.println(h1.getText());
    }

    @Step("Click Register Button")
    public void clickRegisterButton() {
        //registerButton.click();
        baseUI.click(registerButton);
        System.out.println("Register button on bottom of the page clicked");
    }

    @Step("Click Continue Button")
    public void clickContinueButton() {
        baseUI.click(continueButton);
        System.out.println("Continue button clicked");
    }

    @Step("Select date of birth dropdown")
    public void dateOfBirthDay(String day) {
        baseUI.clickDropdown(dateOfBirthDay, day);
    }

    @Step("Select month of birth dropdown")
    public void yearOfBirthYear(String year) {
        baseUI.clickDropdown(yearOfBirthDay, year);
    }

    @Step("Select year of birth dropdown")
    public void monthOfBirthMonth(String month) {
        baseUI.clickDropdown(monthOfBirthDay, month);
    }

    @Step("Enter invalid email")
    public void enterInvalidEmail(String invalidEmail) {
        baseUI.sendText(emailInputField, invalidEmail);
        System.out.println("Message: " + emailError.getText());

    }

    @Step("Enter password less then 6 characters")
    public void enterInvalidPasswordLessThen(String invalidPassword) {
        baseUI.sendText(passwordInputField, invalidPassword);
        System.out.println("Message: " + passwordError.getText());
    }

    @Step("Enter confirm password that is different then password")
    public void enterInvalidConfirmPasswordDifferent(String invalidConfirmPassword) {
        baseUI.sendText(confirmPasswordInputField, invalidConfirmPassword);
        System.out.println("Message: " + confirmPasswordError.getText());
    }

    @Step("Fill Form with valid data")
    public void fillFormWithValidData(Gender gender, String firstName, String lastName, String day, String month, String year, String email, String company, String password, String confirmPassword) {
        clickGender(gender);
        baseUI.sendText(firstNameInputField, firstName);
        baseUI.sendText(lastNameInputField, lastName);
        baseUI.sendText(emailInputField, email);
        baseUI.sendText(passwordInputField, password);
        baseUI.sendText(confirmPasswordInputField, confirmPassword);
        baseUI.sendText(companyInputField, company);

        dateOfBirthDay(day);
        monthOfBirthMonth(month);
        yearOfBirthYear(year);
    }

    private void clickGender(Gender gender) {
        if (gender == Gender.MALE) {
            baseUI.click(genderMale);
        } else if (gender == Gender.FEMALE) {
            baseUI.click(genderFemale);
        } else {
            System.err.println("Gender not selected");
        }
    }

    @Step("Get Registration Message")
    public void getRegistrationMessage() {
        registrationMessage.getText();
        System.out.println("Message: " + registrationMessage.getText());
    }

    @Step("Get Invalid Email Message")
    public void getMessageError() {
        messageError.getText();
        System.out.println("Message: " + messageError.getText());
    }

    @Step("Get Invalid First Name Message")
    public void getNameError() {
        Assert.assertEquals(firstNameError.getText(), "First name is required.");
    }

    @Step("Get Invalid Last Name Message")
    public void getLastNameError() {
        Assert.assertEquals(lastNameError.getText(), "Last name is required.");
    }

    @Step("Get Invalid Email Message")
    public void getEmailError() {
        Assert.assertEquals(emailError.getText(), "Email is required.");
    }

    @Step("Get Password error message")
    public void getPasswordError() {
        Assert.assertEquals(passwordError.getText(), "Password is required.");
    }

    @Step("Get Confirm Password error message")
    public void getConfirmPasswordError() {
        Assert.assertEquals(confirmPasswordError.getText(), "Password is required.");
    }


}