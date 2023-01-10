package Page;

import Base.BaseUI;
import Base.BrowserFactory;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BrowserFactory {
    BaseUI baseUI;

    public RegisterPage(WebDriver driver) {
        super(driver);
        baseUI = new BaseUI(driver);
    }

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
    @FindBy(id = "gender-female")
    WebElement genderFemale;


    @Step("Click Register Button")
    public void clickRegisterButton() {
        //registerButton.click();
        baseUI.Click(registerButton);
        System.out.println("Register button on bottom of the page clicked");
    }

    @Step("Click Continue Button")
    public void clickContinueButton() {
        baseUI.Click(continueButton);
        System.out.println("Continue button clicked");
    }

    @Step("Click Gender Female")
    public void clickGenderFemale() {
        genderFemale.click();
        System.out.println("Gender female is clicked");
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
        emailError.getText();
        System.out.println("Message: " + emailError.getText());
    }

    @Step("Enter password less then 6 characters")
    public void enterInvalidPasswordLessThen(String invalidPassword) {
        baseUI.sendText(passwordInputField, invalidPassword);
        passwordError.getText();
        System.out.println("Message: " + passwordError.getText());
    }

    @Step("Enter confirm password that is different then password")
    public void enterInvalidConfirmPasswordDifferent(String invalidConfirmPassword) {
        baseUI.sendText(confirmPasswordInputField, invalidConfirmPassword);
        confirmPasswordError.getText();
        System.out.println("Message: " + confirmPasswordError.getText());
    }

    @Step("Fill Form with valid data")
    public RegisterPage fillFormWithValidData(String firstName, String lastName, String day, String month, String year, String email, String company, String password, String confirmPassword) {
        baseUI.sendText(firstNameInputField, firstName);
        baseUI.sendText(lastNameInputField, lastName);
        baseUI.sendText(emailInputField, email);
        baseUI.sendText(passwordInputField, password);
        baseUI.sendText(confirmPasswordInputField, confirmPassword);
        baseUI.sendText(companyInputField, company);

        dateOfBirthDay(day);
        monthOfBirthMonth(month);
        yearOfBirthYear(year);

        return this;
    }

    @FindBy(className = "result")
    WebElement registrationMessage;

    @Step("Get Registration Message")
    public void getRegistrationMessage() {
        registrationMessage.getText();
        System.out.println("Message: " + registrationMessage.getText());
    }

    @FindBy(xpath = "//li[.='The specified email already exists']")
    WebElement messageError;

    @Step("Get Invalid Email Message")
    public void getMessageError() {
        messageError.getText();
        System.out.println("Message: " + messageError.getText());
    }

}