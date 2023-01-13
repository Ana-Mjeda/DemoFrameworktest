package page;

import base.BaseUI;
import base.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BrowserFactory {
    BaseUI baseUI;

    public CheckoutPage(WebDriver driver) {
        super(driver);
        baseUI = new BaseUI(driver);
    }

    @FindBy(xpath = "//div //*[@class='title'][text()='Billing address']")
    WebElement billingAddress;

    public String getBillingAddressAttribute() {
        return billingAddress.getText();
    }

    @FindBy(name = "BillingNewAddress.CountryId")
    WebElement country;

    public void selectCountryFromDropdown(String text) {
        baseUI.clickDropdown(country, text);
    }

    @FindBy(name = "BillingNewAddress.City")
    WebElement cityInputField;

    public void cityInputFieldSetText(String text) {
        baseUI.sendText(cityInputField, text);
    }

    public String getCityAttribute() {
        return cityInputField.getAttribute("value");
    }

    @FindBy(name = "BillingNewAddress.Address1")
    WebElement address1InputField;

    public void address1InputFieldSetText(String text) {
        baseUI.sendText(address1InputField, text);
    }

    public String getAddress1Attribute() {
        return address1InputField.getAttribute("value");
    }

    @FindBy(name = "BillingNewAddress.ZipPostalCode")
    WebElement postalCodeInputField;

    public void postalCodeInputFieldSetText(String text) {
        baseUI.sendText(postalCodeInputField, text);
    }

    public String getPostalCodeAttribute() {
        return postalCodeInputField.getAttribute("value");
    }

    @FindBy(name = "BillingNewAddress.PhoneNumber")
    WebElement phoneNumberInputField;

    public void phoneNumberInputFieldSetText(String text) {
        baseUI.sendText(phoneNumberInputField, text);
    }

    public String getPhoneNumberAttribute() {
        return phoneNumberInputField.getAttribute("value");
    }

    @FindBy(xpath = "//div //*[@name='save'][@class='button-1 new-address-next-step-button']")
    WebElement continueButton;

    public void clickContinueButton() {
        baseUI.click(continueButton);
        System.out.println("Continue Button is clicked");
    }

    @FindBy(xpath = "//*[@id=\"ShipToSameAddress\"]")
    WebElement checkBox;

    public boolean getCheckBoxValue() {
        return checkBox.isSelected();
    }

    @FindBy(xpath = "//div //*[@class='title'][text()='Shipping method']")
    WebElement shippingMethod;

    public String getShippingMethodAttribute() {
        return shippingMethod.getText();
    }

    @FindBy(id = "shippingoption_1")
    WebElement nextDayAirRadioButton;

    public void clickNextDayAirRadioButton() {
        baseUI.click(nextDayAirRadioButton);
        System.out.println("Next Day Air Radio Button is clicked");
    }

    @FindBy(xpath = "//*[@id=\"shipping-method-buttons-container\"]/button")
    WebElement shippingMethodContinueButton;

    public void clickShippingMethodContinueButton() {
        baseUI.click(shippingMethodContinueButton);
        System.out.println("Continue Button is clicked");
    }

    @FindBy(xpath = "//div //*[@class='title'][text()='Payment method']")
    WebElement paymentMethod;

    public String getPaymentMethodAttribute() {
        return paymentMethod.getText();
    }

    @FindBy(xpath = "//*[@id=\"paymentmethod_0\"]")
    WebElement checkMoneyRadioButton;

    public void clickCheckMoneyRadioButton() {
        baseUI.click(checkMoneyRadioButton);
        System.out.println("Check/Money radio button is clicked");
    }

    @FindBy(xpath = "//*[@id=\"payment-method-buttons-container\"]/button")
    WebElement paymentMethodContinueButton;

    public void clickPaymentMethodContinueButton() {
        baseUI.click(paymentMethodContinueButton);
        System.out.println("Continue Button is clicked");
    }

    @FindBy(xpath = "//div //*[@class='title'][text()='Payment information']")
    WebElement paymentInformation;

    public String getPaymentInformationAttribute() {
        return paymentInformation.getText();
    }

    @FindBy(xpath = "//*[@id=\"payment-info-buttons-container\"]/button")
    WebElement paymentInformationContinueButton;

    public void clickPaymentInformationContinueButton() {
        baseUI.click(paymentInformationContinueButton);
        System.out.println("Continue Button is clicked");
    }

    @FindBy(xpath = "//div //*[@class='title'][text()='Confirm order']")
    WebElement confirmOrder;

    public String getConfirmOrderAttribute() {
        return confirmOrder.getText();
    }

    @FindBy(xpath = "//div[@class='billing-info'] //ul[@class='info-list'] //li[@class='address1']")
    WebElement confirmBillingAddress;

    public String getConfirmBillingAddressAttribute() {
        return confirmBillingAddress.getText();
    }

    public void compareAddresses() {
        String billingAddress = driver.findElement(By.xpath("//div[@class='billing-info'] //ul[@class='info-list'] //li[@class='address1']")).getText();
        String shippingAddress = driver.findElement(By.xpath("//div[@class='shipping-info'] //ul[@class='info-list'] //li[@class='address1']")).getText();
        if (billingAddress.equalsIgnoreCase(shippingAddress)) {
            System.out.println("The Billing Address is same as Shipping Address ");
        }


        //@FindBy(xpath = "//*[@id=\"confirm-order-buttons-container\"]/button")
        // WebElement confirmButtonOnBottomOfPage;

//    public void clickConfirmButtonOnBottomOfPage() {
//        baseUI.click(confirmButtonOnBottomOfPage);
//        System.out.println("Confirm Button is clicked");
//    }

//    public void clickHereForOrdersLink() {
//        WebElement HereForOrdersLink = driver.findElement(By.xpath("//*[@id=\"confirm-order-buttons-container\"]/button"));
//        HereForOrdersLink.click();
//        System.out.println("Click here for orders link is clicked");
//    }

    }
}
