package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageHeader extends BrowserFactory {

    BaseUI baseUI;

    @FindBy(className = "ico-register")
    WebElement registerButton;

    @FindBy(className = "ico-account")
    WebElement myAccountButton;

    @FindBy(className = "ico-login")
    WebElement loginButton;

    @FindBy(css = "a[span.cart-label]")
    WebElement shoppingCart;

    public PageHeader(WebDriver driver) {
        super(driver);
        baseUI = new BaseUI(driver);
    }

    /**
     * @Author Ana Mjeda
     * @Description Click on Register link in header
     */
    public void clickRegisterButton() {
        baseUI.click(registerButton);
        System.out.println("Register link in header clicked");
    }

    public void clickMyAccountButton() {
        baseUI.click(myAccountButton);
        System.out.println("My account button clicked");
    }

    public String getMyAccountButtonAttribute() {
        return myAccountButton.getAttribute("value");
    }

    public void clickLoginButton() {
        baseUI.click(loginButton);
        System.out.println("Login button clicked");
    }

    public WebElement logoutButton() {
        return loginButton;
    }

    public void clickLogoutButton() {
        baseUI.click(logoutButton());
    }

    public String getLogoutAttribute() {
        return logoutButton().getAttribute("value");
    }

    public void clickShoppingCart() {
        baseUI.click(shoppingCart);
        System.out.println("Shopping cart clicked");
    }

    @FindBy(xpath = "a.span.cart-qty")
    WebElement shoppingCartQty;

    public String getShoppingCartAttribute() {
        return shoppingCartQty.getText();
    }
}
