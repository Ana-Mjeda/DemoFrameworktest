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

    public void clickMyAccountButton() {
        baseUI.click(myAccountButton);
        System.out.println("My account button clicked");
    }

    public void clickLoginButton() {
        baseUI.click(loginButton);
        System.out.println("Login button clicked");
    }
    public WebElement logoutButton() {
        return logoutButton;
    }

    public void clickLogoutButton() {
        baseUI.click(logoutButton());
        System.out.println("Logout button clicked");
    }

    public void clickShoppingCart() {
        baseUI.click(shoppingCart);
        System.out.println("Shopping cart clicked");
    }

    public void urlCheck() {
        String URL = driver.getCurrentUrl();
        Assert.assertTrue(URL.startsWith("https://demo.nopcommerce.com/"));
    }

    @Step("Check if My account is displayed")
    public void checkMyaccount() {
        Assert.assertEquals(myAccountButton.getText(), "My account");
    }

    @Step("Check if Logout is displayed")
    public void checkLogout() {
        Assert.assertEquals(logoutButton.getText(), "Log out");
    }

    @Step("Check if Shopping cart has value of 3")
    public void checkShoppingCartValue3() {
        Assert.assertEquals(shoppingCartQty.getText(), "(3)");
    }

    @Step("Check if Shopping cart has value of 0")
    public void checkShoppingCartValue0() {
        Assert.assertEquals(shoppingCartQty.getText(), "(0)");
    }
}
