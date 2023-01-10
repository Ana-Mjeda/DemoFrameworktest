package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class PageHeader extends BrowserFactory {
    BaseUI baseUI;

    public PageHeader(WebDriver driver) {
        super(driver);
        baseUI = new BaseUI(driver);
    }

    /**
     * @Author Ana Mjeda
     * @Description Test for getting register button
     * @return
     */

    @FindBy(className = "ico-register")
    WebElement registerButton;

    /**
     * @Description Click on Register link in header
     */
    public void clickRegisterButton() {
        baseUI.Click(registerButton);
        System.out.println("Register link in header clicked");
    }

    @FindBy(className = "ico-account")
    WebElement myAccountButton;

    public void clickMyAccountButton() {
        baseUI.Click(myAccountButton);
        System.out.println("My account button clicked");
    }

    public String getMyAccountButtonAttribute() {
        return myAccountButton.getAttribute("value");
    }

    @FindBy(className = "ico-login")
    WebElement loginButton;

    public void clickLoginButton() {
        baseUI.Click(loginButton);
        System.out.println("Login button clicked");
    }

    public WebElement logoutButton() {
        return loginButton;
    }

    public void clickLogoutButton() {
        baseUI.Click(logoutButton());
    }

    public String getLogoutAttribute() {
        return logoutButton().getAttribute("value");
    }

    @FindBy(xpath = "//a[@id='topcartlink']/a/span[1]")
    WebElement shoppingCart;

    public void clickShoppingCart() {
        baseUI.Click(shoppingCart);
        System.out.println("Shopping cart clicked");
    }

    public WebElement getShoppingCartQty() {
        return driver.findElement(By.xpath("//*[@id=\"topcartlink\"]/a/span[2]"));
    }

    public String getShoppingCartAttribute() {
        return getShoppingCartQty().getText();
    }
}
