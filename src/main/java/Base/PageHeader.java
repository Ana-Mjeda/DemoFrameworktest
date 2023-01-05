package Base;

import nopCommerce.TemplatePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageHeader extends TemplatePage {

    public PageHeader(WebDriver driver) {
        super(driver);
    }

    public WebElement getRegisterButton() {
        return driver.findElement(By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[1]/a"));
    }

    public WebElement getMyAccountButton() {
        return getRegisterButton();
    }

    public WebElement getLoginButton() {
        return driver.findElement(By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a"));
    }

    public WebElement getLogoutButton() {
        return getLoginButton();
    }
}
