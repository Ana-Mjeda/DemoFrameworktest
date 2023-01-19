package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import static com.google.common.base.Ascii.equalsIgnoreCase;

public class OrderDetails extends BrowserFactory {
    BaseUI baseUI;

    @FindBy(css = "h1")
    public WebElement orderInformation;
    @FindBy(xpath = "//li[@class='payment-method'] //span[@class='value']")
    WebElement billingPaymentMethod;
    @FindBy(xpath = "//li[@class='shipping-method'] //span[@class='value']")
    WebElement shippingShippingMethod;
    @FindBy(xpath = "//span[@class='product-quantity']")
    WebElement shippingQty;
    @FindBy(xpath = "//div[@class='billing-info'] //li[@class='address1']")
    WebElement billingAddress;
    @FindBy(xpath = "//div[@class='shipping-info'] //li[@class='address1']")
    WebElement shippingAddress;

    public OrderDetails(WebDriver driver) {
        super(driver);
        baseUI = new BaseUI(driver);

    }

    public String shippingAddressAttribute() {
        return shippingAddress.getText();
    }

    public String billingAddressAttribute() {
        return billingAddress.getText();
    }

    public void compareAddresses() {
        boolean addressFound = false;
        
        if (equalsIgnoreCase(billingAddressAttribute(), shippingAddressAttribute())) {
            addressFound = true;
            System.out.println("The Billing Address is same as Shipping Address ");
        }
        if (!addressFound) {
            Assert.fail("Billing address '" + billingAddress + "' and shipping address '" + shippingAddress + "' do not match.");
        }
    }

    public void getOrderInformationAttribute() {
        orderInformation.getText();
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
}