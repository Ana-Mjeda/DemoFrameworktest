package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

    public OrderDetails(WebDriver driver) {
        super(driver);
        baseUI = new BaseUI(driver);

    }


    public void compareAddresses() {
        String billingAddress = driver.findElement(By.xpath("//div[@class='billing-info'] //li[@class='address1']")).getText();
        String shippingAddress = driver.findElement(By.xpath("//div[@class='shipping-info'] //li[@class='address1']")).getText();
        if (billingAddress.equalsIgnoreCase(shippingAddress)) {
            System.out.println("The Billing Address is same as Shipping Address ");
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