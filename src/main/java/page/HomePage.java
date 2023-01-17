package page;

import base.BaseUI;
import base.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BrowserFactory {
    BaseUI baseUI;
    @FindBy(className = "ico-register")
    WebElement registerButton;
    @FindBy(className = "ico-login")
    WebElement loginButton;
    @FindBy(className = "ico-logout")
    WebElement logoutButton;

    public HomePage(WebDriver driver) {
        super(driver);
        baseUI = new BaseUI(driver);
    }

    public void clickRegisterButton() {
        baseUI.click(registerButton);
        System.out.println("Register button clicked");
    }

    public void clickLoginButton() {
        baseUI.click(loginButton);
        System.out.println("Login button clicked");
    }

    public void clickLogoutButton() {
        baseUI.click(logoutButton);
        System.out.println("Logout button clicked");
    }
}
