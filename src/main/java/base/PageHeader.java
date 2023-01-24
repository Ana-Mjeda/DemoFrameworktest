package base;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class PageHeader extends BrowserFactory {

    BaseUI baseUI;

    @FindBy(className = "ico-register")
    WebElement registerButton;

    @FindBy(className = "ico-account")
    WebElement myAccountButton;

    @FindBy(className = "ico-login")
    WebElement loginButton;

    @FindBy(className = "ico-logout")
    WebElement logoutButton;

    @FindBy(xpath = "//*[@id='topcartlink'] //a //*[@class='cart-label']")
    WebElement shoppingCart;
    @FindBy(xpath = "//span[@class='cart-qty']")
    WebElement shoppingCartQty;

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

    @Step("Click my account button")
    public void clickMyAccountButton() {
        baseUI.click(myAccountButton);
        System.out.println("My account button clicked");
    }

    @Step("Click login button")
    public void clickLoginButton() {
        baseUI.click(loginButton);
        System.out.println("Login button clicked");
    }

    public WebElement logoutButton() {
        return logoutButton;
    }

    @Step("Click logout button")
    public void clickLogoutButton() {
        baseUI.click(logoutButton());
        System.out.println("Logout button clicked");
    }

    @Step("Click shopping cart button")
    public void clickShoppingCart() {
        baseUI.click(shoppingCart);
        System.out.println("Shopping cart clicked");
    }

    @Step("Check if My account is displayed")
    public void checkMyAccount() {
        Assert.assertEquals(myAccountButton.getText(), "My account");
    }

    @Step("Check if Logout is displayed")
    public void checkLogout() {
        Assert.assertEquals(logoutButton.getText(), "Log out");
    }

    @Step("Check if Shopping cart has inserted value")
    public void checkShoppingCartValue(String number) {
        Assert.assertEquals(shoppingCartQty.getText(), number);
    }
}
