package Base;

import nopCommerce.TemplatePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderDetails extends BrowserFactory {
    public OrderDetails(WebDriver driver) {
        super(driver);
    }

    public WebElement getBillingName() {
        return driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[2]/div[1]/div[1]/ul/li[1]"));
    }

    public String getBillingNameAttribute() {
        return getBillingName().getText();
    }

    public WebElement getBillingEmail() {
        return driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[2]/div[1]/div[1]/ul/li[2]"));
    }

    public String getBillingEmailAttribute() {
        return getBillingEmail().getText();
    }

    public WebElement getBillingPhone() {
        return driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[2]/div[1]/div[1]/ul/li[3]"));
    }

    public String getBillingPhoneAttribute() {
        return getBillingPhone().getText();
    }

    public WebElement getBillingCompany() {
        return driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[2]/div[1]/div[1]/ul/li[5]"));
    }

    public String getBillingCompanyAttribute() {
        return getBillingCompany().getText();
    }

    public WebElement getBillingAddress1() {
        return driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[2]/div[1]/div[1]/ul/li[6]"));
    }

    public String getBillingAddress1Attribute() {
        return getBillingAddress1().getText();
    }

    public WebElement getBillingCity() {
        return driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[2]/div[1]/div[1]/ul/li[7]"));
    }

    public String getBillingCityAttribute() {
        return getBillingCity().getText();
    }

    public WebElement getBillingCountry() {
        return driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[2]/div[1]/div[1]/ul/li[8]"));
    }

    public String getBillingCountryAttribute() {
        return getBillingCountry().getText();
    }

    public WebElement getBillingPayment() {
        return driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[2]/div[1]/div[2]/ul/li[1]"));
    }

    public String getBillingPaymentAttribute() {
        return getBillingPayment().getText();
    }


    public WebElement getShippingName() {
        return driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[2]/div[2]/div[1]/ul/li[1]"));
    }

    public String getShippingNameAttribute() {
        return getShippingName().getText();
    }

    public WebElement getShippingEmail() {
        return driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[2]/div[2]/div[1]/ul/li[2]"));
    }

    public String getShippingEmailAttribute() {
        return getShippingEmail().getText();
    }

    public WebElement getShippingPhone() {
        return driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[2]/div[2]/div[1]/ul/li[3]"));
    }

    public String getShippingPhoneAttribute() {
        return getShippingPhone().getText();
    }

    public WebElement getShippingCompany() {
        return driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[2]/div[2]/div[1]/ul/li[5]"));
    }

    public String getShippingCompanyAttribute() {
        return getShippingCompany().getText();
    }

    public WebElement getShippingAddress1() {
        return driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[2]/div[2]/div[1]/ul/li[6]"));
    }

    public String getShippingAddress1Attribute() {
        return getShippingAddress1().getText();
    }

    public WebElement getShippingCity() {
        return driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[2]/div[2]/div[1]/ul/li[7]"));
    }

    public String getShippingCityAttribute() {
        return getShippingCity().getText();
    }

    public WebElement getShippingCountry() {
        return driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[2]/div[2]/div[1]/ul/li[8]"));
    }

    public String getShippingCountryAttribute() {
        return getShippingCountry().getText();
    }

    public WebElement getShipping() {
        return driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[2]/div[2]/div[2]/ul/li[2]"));
    }

    public String getShippingAttribute() {
        return getShipping().getText();
    }

    public WebElement getProductName() {
        return driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[3]/div[2]/table/tbody/tr/td[3]/em/a"));
    }

    public String getProductNameAttribute() {
        return getProductName().getText();
    }

    public WebElement getProductQty() {
        return driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[3]/div[2]/table/tbody/tr/td[5]"));
    }

    public String getProductQtyAttribute() {
        return getProductQty().getText();
    }
}
