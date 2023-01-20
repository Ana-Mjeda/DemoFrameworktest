package page;

import base.BaseUI;
import base.BrowserFactory;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class CheckoutPage extends BrowserFactory {
    BaseUI baseUI;


    @FindBy(xpath = "//div //*[@class='title'][text()='Billing address']")
    WebElement billingAddress;
    @FindBy(name = "BillingNewAddress.CountryId")
    WebElement country;
    @FindBy(name = "BillingNewAddress.City")
    WebElement cityInputField;
    @FindBy(name = "BillingNewAddress.Address1")
    WebElement address1InputField;
    @FindBy(name = "BillingNewAddress.ZipPostalCode")
    WebElement postalCodeInputField;
    @FindBy(name = "BillingNewAddress.PhoneNumber")
    WebElement phoneNumberInputField;
    @FindBy(xpath = "//div //*[@name='save'][@class='button-1 new-address-next-step-button']")
    WebElement continueButton;
    @FindBy(xpath = "//*[@id=\"ShipToSameAddress\"]")
    WebElement checkBox;
    @FindBy(xpath = "//div //*[@class='title'][text()='Shipping method']")
    WebElement shippingMethod;
    @FindBy(id = "shippingoption_1")
    WebElement nextDayAirRadioButton;
    @FindBy(xpath = "//*[@id=\"shipping-method-buttons-container\"]/button")
    WebElement shippingMethodContinueButton;
    @FindBy(xpath = "//div //*[@class='title'][text()='Payment method']")
    WebElement paymentMethod;
    @FindBy(xpath = "//*[@id=\"paymentmethod_0\"]")
    WebElement checkMoneyRadioButton;
    @FindBy(xpath = "//*[@id=\"payment-method-buttons-container\"]/button")
    WebElement paymentMethodContinueButton;
    @FindBy(xpath = "//div //*[@class='title'][text()='Payment information']")
    WebElement paymentInformation;
    @FindBy(xpath = "//*[@id=\"payment-info-buttons-container\"]/button")
    WebElement paymentInformationContinueButton;
    @FindBy(xpath = "//div //*[@class='title'][text()='Confirm order']")
    WebElement confirmOrder;
    @FindBy(xpath = "//div[@class='billing-info'] //ul[@class='info-list'] //li[@class='address1']")
    WebElement confirmBillingAddress;
    @FindBy(xpath = "//li[@class='payment-method'] //span[@class='value']")
    WebElement billingPaymentMethod;
    @FindBy(xpath = "//li[@class='shipping-method'] //span[@class='value']")
    WebElement shippingShippingMethod;
    @FindBy(xpath = "//span[@class='product-quantity'][text()='3']")
    WebElement shippingQty;
    @FindBy(xpath = "//button[@class='button-1 confirm-order-next-step-button']")
    WebElement confirmButtonOnBottomOfPage;
    @FindBy(css = "h1")
    WebElement thankYou;
    @FindBy(linkText = "Click here for order details.")
    WebElement orderDetailsLink;
    @FindBy(xpath = "//div[@class='billing-info'] //li[@class='address1'])")
    WebElement billingAddressCheckout;
    @FindBy(xpath = "//div[@class='shipping-info'] //li[@class='address1']")
    WebElement shippingAddressCheckout;

    public CheckoutPage(WebDriver driver) {
        super(driver);
        baseUI = new BaseUI(driver);
    }

    @Step("Check if Billing method is displayed")
    public void getBillingAddressAttribute() {
        Assert.assertEquals(billingAddress.getText(), "Billing address");
    }

    public void selectCountryFromDropdown(String text) {
        baseUI.clickDropdown(country, text);
    }

    public void cityInputFieldSetText(String text) {
        baseUI.sendText(cityInputField, text);
    }

    public void address1InputFieldSetText(String text) {
        baseUI.sendText(address1InputField, text);
    }

    public void postalCodeInputFieldSetText(String text) {
        baseUI.sendText(postalCodeInputField, text);
    }

    public void phoneNumberInputFieldSetText(String text) {
        baseUI.sendText(phoneNumberInputField, text);
    }

    @Step("Click continue button under Billing Address form")
    public void clickContinueButton() {
        baseUI.click(continueButton);
        System.out.println("Continue Button is clicked");
    }

    public boolean getCheckBoxValue() {
        return checkBox.isSelected();
    }

    @Step("Check if Shipping method is displayed")
    public void getShippingMethodAttribute() {
        Assert.assertEquals(shippingMethod.getText(), "Shipping method");
    }

    @Step("Select a radio button")
    public void clickRadioButtonInShippingMethod(String button) {
        if (button.equals("Next Day Air")) {
            baseUI.click(nextDayAirRadioButton);
            System.out.println("Next Day Air Radio Button is clicked");
        } else {
            System.err.println("Button not selected");
        }
    }

    @Step("Click continue button under Shipping method")
    public void clickShippingMethodContinueButton() {
        baseUI.click(shippingMethodContinueButton);
        System.out.println("Continue Button is clicked");
    }

    @Step("Check if Payment method is displayed")
    public void getPaymentMethodAttribute() {
        Assert.assertEquals(paymentMethod.getText(), "Payment method");
    }

    @Step("Select a radio button")
    public void clickRadioButtonInPaymentMethod(String button) {
        if (button.equals("Check / Money Order")) {
            baseUI.click(checkMoneyRadioButton);
            System.out.println("Check/Money radio button is clicked");
        } else {
            System.err.println("Button not selected");
        }
    }

    @Step("Click continue button under Payment method")
    public void clickPaymentMethodContinueButton() {
        baseUI.click(paymentMethodContinueButton);
        System.out.println("Continue Button is clicked");
    }

    @Step("Check if Payment information is displayed")
    public void getPaymentInformationAttribute() {
        Assert.assertEquals(paymentInformation.getText(), "Payment information");
    }

    @Step("Click continue button under Payment information")
    public void clickPaymentInformationContinueButton() {
        baseUI.click(paymentInformationContinueButton);
        System.out.println("Continue Button is clicked");
    }

    @Step("Check if Confirm order is displayed")
    public void getConfirmOrderAttribute() {
        Assert.assertEquals(confirmOrder.getText(), "Confirm order");
    }

    @Step("Check Confirm Billing address")
    public void getConfirmBillingAddressAttribute(String address) {
        Assert.assertEquals(confirmBillingAddress.getText(), address);
    }

    @Step("Check Shipping Billing address")
    public void getShippingAddressAttributeCheckout(String address) {
        Assert.assertEquals(shippingAddressCheckout.getText(), address);
    }

    @Step("Checking billing payment method")
    public void getBillingPaymentMethodAttribute(String check) {
        Assert.assertEquals(billingPaymentMethod.getText(), check);
    }

    @Step("Checking shipping  method")
    public void getShippingShippingMethodAttribute(String next) {
        Assert.assertEquals(shippingShippingMethod.getText(), next);
    }

    @Step("Checking shipping quantity")
    public void getShippingQtyAttribute(String val) {
        Assert.assertEquals(shippingQty.getText(), val);
    }

    @Step("Click continue button on bottom of page")
    public void clickConfirmButtonOnBottomOfPage() {
        baseUI.click(confirmButtonOnBottomOfPage);
        System.out.println("Confirm Button is clicked");
    }

    @Step("Checking if Thank you is displayed")
    public void getThankYouAttribute() {
        Assert.assertEquals(thankYou.getText(), "Thank you");
    }

    @Step("Clicking on order details link")
    public void clickOrderDetailsLink() {
        baseUI.click(orderDetailsLink);
    }
}
