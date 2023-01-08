package Base;

import nopCommerce.TemplatePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends TemplatePage {
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getBillingAddress() {
        return driver.findElement(By.xpath("//*[@id=\"opc-billing\"]/div[1]/h2"));
    }

    public String getBillingAddressAttribute() {
        return getBillingAddress().getText();
    }

    public WebElement countryDropdown() {
        return driver.findElement(By.name("BillingNewAddress.CountryId"));
    }

    public void selectCountryFromDropdown(String country) {
        Select select = new Select(countryDropdown());
        select.selectByVisibleText(country);
    }

    public WebElement getCityInputField() {
        return driver.findElement(By.name("BillingNewAddress.City"));
    }

    public void cityInputFieldSetText(String text) {
        WebElement cityInputField = getCityInputField();
        cityInputField.sendKeys(text);
    }

    public String getCityAttribute() {
        return getCityInputField().getAttribute("value");
    }

    public WebElement getAddress1InputField() {
        return driver.findElement(By.name("BillingNewAddress.Address1"));
    }

    public void address1InputFieldSetText(String text) {
        WebElement address1InputField = getAddress1InputField();
        address1InputField.sendKeys(text);
    }

    public String getAddress1Attribute() {
        return getAddress1InputField().getAttribute("value");
    }

    public WebElement getPostalCodeInputField() {
        return driver.findElement(By.name("BillingNewAddress.ZipPostalCode"));
    }

    public void postalCodeInputFieldSetText(String text) {
        WebElement postalCodeInputField = getPostalCodeInputField();
        postalCodeInputField.sendKeys(text);
    }

    public String getPostalCodeAttribute() {
        return getPostalCodeInputField().getAttribute("value");
    }

    public WebElement getPhoneNumberInputField() {
        return driver.findElement(By.name("BillingNewAddress.PhoneNumber"));
    }

    public void phoneNumberInputFieldSetText(String text) {
        WebElement phoneNumberInputField = getPhoneNumberInputField();
        phoneNumberInputField.sendKeys(text);
    }

    public String getPhoneNumberAttribute() {
        return getPhoneNumberInputField().getAttribute("value");
    }

    public void clickContinueButton() {
        WebElement continueButton = driver.findElement(By.xpath("//*[@id=\"billing-buttons-container\"]/button[4]"));
        continueButton.click();
        System.out.println("Continue Button is  clicked");
    }

    public boolean getCheckBoxValue(String text) {
        WebElement checkBox = driver.findElement(By.xpath("//*[@id=\"ShipToSameAddress\"]"));
        return checkBox.isSelected();
    }
}
