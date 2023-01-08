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
}
