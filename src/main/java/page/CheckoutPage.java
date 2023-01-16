package page;

import base.BaseUI;
import base.BrowserFactory;
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
    @FindBy(xpath = "//span[@class='product-quantity'][normalize-space()='3']")
    WebElement shippingQty;
    @FindBy(xpath = "//button[@class='button-1 confirm-order-next-step-button']")
    WebElement confirmButtonOnBottomOfPage;
    @FindBy(css = "h1")
    public WebElement thankYou;
    @FindBy(xpath = "div.title")
    private WebElement orderCompleteMsg;
    @FindBy(linkText = "Click here for order details.")
    private WebElement orderDetailsLink;
    @FindBy(xpath = "//div[@class='billing-info'] //ul[@class='info-list'] //li[@class='address1'])")
    private WebElement billingAddressCheckout;
    @FindBy(xpath = "//div[@class='shipping-info'] //ul[@class='info-list'] //li[@class='address1']")
    private WebElement shippingAddressCheckout;

    public CheckoutPage(WebDriver driver) {
        super(driver);
        baseUI = new BaseUI(driver);
    }

    public String getBillingAddressAttribute() {
        return billingAddress.getText();
    }

    public void selectCountryFromDropdown(String text) {
        baseUI.clickDropdown(country, text);
    }

    public void cityInputFieldSetText(String text) {
        baseUI.sendText(cityInputField, text);
    }

    public String getCityAttribute() {
        return cityInputField.getAttribute("value");
    }

    public void address1InputFieldSetText(String text) {
        baseUI.sendText(address1InputField, text);
    }

    public String getAddress1Attribute() {
        return address1InputField.getAttribute("value");
    }

    public void postalCodeInputFieldSetText(String text) {
        baseUI.sendText(postalCodeInputField, text);
    }

    public String getPostalCodeAttribute() {
        return postalCodeInputField.getAttribute("value");
    }

    public void phoneNumberInputFieldSetText(String text) {
        baseUI.sendText(phoneNumberInputField, text);
    }

    public String getPhoneNumberAttribute() {
        return phoneNumberInputField.getAttribute("value");
    }

    public void clickContinueButton() {
        baseUI.click(continueButton);
        System.out.println("Continue Button is clicked");
    }

    public boolean getCheckBoxValue() {
        return checkBox.isSelected();
    }

    public String getShippingMethodAttribute() {
        return shippingMethod.getText();
    }

    public void clickNextDayAirRadioButton() {
        baseUI.click(nextDayAirRadioButton);
        System.out.println("Next Day Air Radio Button is clicked");
    }

    public void clickShippingMethodContinueButton() {
        baseUI.click(shippingMethodContinueButton);
        System.out.println("Continue Button is clicked");
    }


    public String getPaymentMethodAttribute() {
        return paymentMethod.getText();
    }

    public void clickCheckMoneyRadioButton() {
        baseUI.click(checkMoneyRadioButton);
        System.out.println("Check/Money radio button is clicked");
    }

    public void clickPaymentMethodContinueButton() {
        baseUI.click(paymentMethodContinueButton);
        System.out.println("Continue Button is clicked");
    }


    public String getPaymentInformationAttribute() {
        return paymentInformation.getText();
    }


    public void clickPaymentInformationContinueButton() {
        baseUI.click(paymentInformationContinueButton);
        System.out.println("Continue Button is clicked");
    }


    public String getConfirmOrderAttribute() {
        return confirmOrder.getText();
    }


    public String getConfirmBillingAddressAttribute() {
        return confirmBillingAddress.getText();
    }

    public String getBillingAddressAttributeCheckout() {
        return billingAddressCheckout.getText();
    }

    public String getShippingAddressAttributeCheckout() {
        return shippingAddressCheckout.getText();
    }

    public void compareAddresses() {
        String billing = getBillingAddressAttributeCheckout();
        String shipping = getShippingAddressAttributeCheckout();

        if (billing.equalsIgnoreCase(shipping)) {
            System.out.println("The Billing Address is same as Shipping Address ");
        }
        Assert.fail("Billing address '" + billing + "' and shipping address '" + shipping + "' do not match.");
    }


    public String getBillingPaymentMethodAttribute() {
        return billingPaymentMethod.getText();
    }


    public String getShippingShippingMethodAttribute() {
        return shippingShippingMethod.getText();
    }


    public String getShippingQtyAttribute() {
        return shippingQty.getText();
    }


    public void clickConfirmButtonOnBottomOfPage() {
        baseUI.click(confirmButtonOnBottomOfPage);
        System.out.println("Confirm Button is clicked");
    }

    public String getThankYouAttribute() {
        return thankYou.getText();
    }

    public void clickOrderDetailsLink() {
        baseUI.click(orderDetailsLink);
    }
}
