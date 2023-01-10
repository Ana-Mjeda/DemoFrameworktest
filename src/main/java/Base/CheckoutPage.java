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
        System.out.println("Continue Button is clicked");
    }

    public boolean getCheckBoxValue() {
        WebElement checkBox = driver.findElement(By.xpath("//*[@id=\"ShipToSameAddress\"]"));
        return checkBox.isSelected();
    }

    public WebElement getShippingMethod() {
        return driver.findElement(By.xpath("//*[@id=\"opc-shipping_method\"]/div[1]/h2"));
    }

    public String getShippingMethodAttribute() {
        return getShippingMethod().getText();
    }

    public void clickNextDayAirRadioButton() {
        WebElement nextDayAirRadioButton = driver.findElement(By.id("shippingoption_1"));
        nextDayAirRadioButton.click();
        System.out.println("Next Day Air Radio Button is clicked");
    }

    public void clickShippingMethodContinueButton() {
        WebElement shippingMethodContinueButton = driver.findElement(By.xpath("//*[@id=\"shipping-method-buttons-container\"]/button"));
        shippingMethodContinueButton.click();
        System.out.println("Continue Button is clicked");
    }

    public WebElement getPaymentMethod() {
        return driver.findElement(By.xpath("//*[@id=\"opc-payment_method\"]/div[1]/h2"));
    }

    public String getPaymentMethodAttribute() {
        return getPaymentMethod().getText();
    }

    public void clickCheckMoneyRadioButton() {
        WebElement checkMoneyRadioButton = driver.findElement(By.xpath("//*[@id=\"paymentmethod_0\"]"));
        checkMoneyRadioButton.click();
        System.out.println("Check/Money radio button is clicked");
    }

    public void clickPaymentMethodContinueButton() {
        WebElement paymentMethodContinueButton = driver.findElement(By.xpath("//*[@id=\"payment-method-buttons-container\"]/button"));
        paymentMethodContinueButton.click();
        System.out.println("Continue Button is clicked");
    }

    public WebElement getPaymentInformation() {
        return driver.findElement(By.xpath("//*[@id=\"opc-payment_info\"]/div[1]/h2"));
    }

    public String getPaymentInformationAttribute() {
        return getPaymentInformation().getText();
    }

    public void clickPaymentInformationContinueButton() {
        WebElement paymentInformationContinueButton = driver.findElement(By.xpath("//*[@id=\"payment-info-buttons-container\"]/button"));
        paymentInformationContinueButton.click();
        System.out.println("Continue Button is clicked");
    }

    public WebElement getConfirmOrder() {
        return driver.findElement(By.xpath("//*[@id=\"opc-confirm_order\"]/div[1]/h2"));
    }

    public String getConfirmOrderAttribute() {
        return getConfirmOrder().getText();
    }

    public WebElement getBillingName() {
        return driver.findElement(By.xpath("//*[@id=\"checkout-confirm-order-load\"]/div/div/div/div/div[1]/div[1]/ul/li[1]"));
    }

    public String getBillingNameAttribute() {
        return getBillingName().getText();
    }

    public WebElement getBillingEmail() {
        return driver.findElement(By.xpath("//*[@id=\"checkout-confirm-order-load\"]/div/div/div/div/div[1]/div[1]/ul/li[2]"));
    }

    public String getBillingEmailAttribute() {
        return getBillingEmail().getText();
    }

    public WebElement getBillingPhone() {
        return driver.findElement(By.xpath("//*[@id=\"checkout-confirm-order-load\"]/div/div/div/div/div[1]/div[1]/ul/li[3]"));
    }

    public String getBillingPhoneAttribute() {
        return getBillingPhone().getText();
    }

    public WebElement getBillingCompany() {
        return driver.findElement(By.xpath("//*[@id=\"checkout-confirm-order-load\"]/div/div/div/div/div[1]/div[1]/ul/li[5]"));
    }

    public String getBillingCompanyAttribute() {
        return getBillingCompany().getText();
    }

    public WebElement getBillingAddress1() {
        return driver.findElement(By.xpath("//*[@id=\"checkout-confirm-order-load\"]/div/div/div/div/div[1]/div[1]/ul/li[6]"));
    }

    public String getBillingAddress1Attribute() {
        return getBillingAddress1().getText();
    }

    public WebElement getBillingCity() {
        return driver.findElement(By.xpath("//*[@id=\"checkout-confirm-order-load\"]/div/div/div/div/div[1]/div[1]/ul/li[7]"));
    }

    public String getBillingCityAttribute() {
        return getBillingCity().getText();
    }

    public WebElement getBillingCountry() {
        return driver.findElement(By.xpath("//*[@id=\"checkout-confirm-order-load\"]/div/div/div/div/div[1]/div[1]/ul/li[8]"));
    }

    public String getBillingCountryAttribute() {
        return getBillingCountry().getText();
    }

    public WebElement getBillingPayment() {
        return driver.findElement(By.xpath("//*[@id=\"checkout-confirm-order-load\"]/div/div/div/div/div[1]/div[2]/ul/li"));
    }

    public String getBillingPaymentAttribute() {
        return getBillingPayment().getText();
    }


    public WebElement getShippingName() {
        return driver.findElement(By.xpath("//*[@id=\"checkout-confirm-order-load\"]/div/div/div/div/div[2]/div[1]/ul/li[1]"));
    }

    public String getShippingNameAttribute() {
        return getShippingName().getText();
    }

    public WebElement getShippingEmail() {
        return driver.findElement(By.xpath("//*[@id=\"checkout-confirm-order-load\"]/div/div/div/div/div[2]/div[1]/ul/li[2]"));
    }

    public String getShippingEmailAttribute() {
        return getShippingEmail().getText();
    }

    public WebElement getShippingPhone() {
        return driver.findElement(By.xpath("//*[@id=\"checkout-confirm-order-load\"]/div/div/div/div/div[2]/div[1]/ul/li[3]"));
    }

    public String getShippingPhoneAttribute() {
        return getShippingPhone().getText();
    }

    public WebElement getShippingCompany() {
        return driver.findElement(By.xpath("//*[@id=\"checkout-confirm-order-load\"]/div/div/div/div/div[2]/div[1]/ul/li[5]"));
    }

    public String getShippingCompanyAttribute() {
        return getShippingCompany().getText();
    }

    public WebElement getShippingAddress1() {
        return driver.findElement(By.xpath("//*[@id=\"checkout-confirm-order-load\"]/div/div/div/div/div[2]/div[1]/ul/li[6]"));
    }

    public String getShippingAddress1Attribute() {
        return getShippingAddress1().getText();
    }

    public WebElement getShippingCity() {
        return driver.findElement(By.xpath("//*[@id=\"checkout-confirm-order-load\"]/div/div/div/div/div[2]/div[1]/ul/li[7]"));
    }

    public String getShippingCityAttribute() {
        return getShippingCity().getText();
    }

    public WebElement getShippingCountry() {
        return driver.findElement(By.xpath("//*[@id=\"checkout-confirm-order-load\"]/div/div/div/div/div[2]/div[1]/ul/li[8]"));
    }

    public String getShippingCountryAttribute() {
        return getShippingCountry().getText();
    }

    public WebElement getShipping() {
        return driver.findElement(By.xpath("//*[@id=\"checkout-confirm-order-load\"]/div/div/div/div/div[2]/div[2]/ul/li"));
    }

    public String getShippingAttribute() {
        return getShipping().getText();
    }

    public WebElement getProductName() {
        return driver.findElement(By.xpath("//*[@id=\"shopping-cart-form\"]/div[1]/table/tbody/tr/td[3]/a"));
    }

    public String getProductNameAttribute() {
        return getProductName().getText();
    }

    public WebElement getProductQty() {
        return driver.findElement(By.xpath("//*[@id=\"shopping-cart-form\"]/div[1]/table/tbody/tr/td[5]"));
    }

    public String getProductQtyAttribute() {
        return getProductQty().getText();
    }

    public void clickConfirmButtonOnBottomOfPage() {
        WebElement confirmButtonOnBottomOfPage = driver.findElement(By.xpath("//*[@id=\"confirm-order-buttons-container\"]/button"));
        confirmButtonOnBottomOfPage.click();
        System.out.println("Confirm Button is clicked");
    }

    public void clickHereForOrdersLink() {
        WebElement HereForOrdersLink = driver.findElement(By.xpath("//*[@id=\"confirm-order-buttons-container\"]/button"));
        HereForOrdersLink.click();
        System.out.println("Click here for orders link is clicked");
    }
}
