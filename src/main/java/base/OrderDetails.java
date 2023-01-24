package base;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class OrderDetails extends BrowserFactory {
    BaseUI baseUI;

    @FindBy(css = "h1")
    WebElement orderInformation;
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

    @Step("Check Shipping address")
    public void shippingAddressAttribute(String shipping) {
        Assert.assertEquals(shippingAddress.getText(), shipping);
    }

    @Step("Check Billing address")
    public void billingAddressAttribute(String billing) {
        Assert.assertEquals(billingAddress.getText(), billing);
    }

    @Step("Check if order information is displayed")
    public void orderInformationAttribute() {
        Assert.assertEquals(orderInformation.getText(), "Order information");
    }

    @Step("Check payment method")
    public void billingPaymentMethodAttribute(String method) {
        Assert.assertEquals(billingPaymentMethod.getText(), method);
    }

    @Step("Check Shipping method")
    public void shippingMethodAttribute(String method) {
        Assert.assertEquals(shippingShippingMethod.getText(), method);
    }

    @Step("Check quantity")
    public void shippingQtyAttribute(String val) {
        Assert.assertEquals(shippingQty.getText(), val);
    }
}