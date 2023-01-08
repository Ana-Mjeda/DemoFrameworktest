package Base;

import nopCommerce.TemplatePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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

}
