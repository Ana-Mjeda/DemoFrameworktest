package nopCommerceTests;

import Base.BrowserFactory;
import Base.OrderDetails;
import Base.PageHeader;
import Base.TopMenu;
import Page.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginWithNewAccount {

    private RegisterPage registerPage;
    private HomePage homePage;
    private PageHeader pageHeader;
    private LoginPage loginPage;
    private final TopMenu topMenu = new TopMenu(BrowserFactory.getDriver());
    private final CellPhonesPage cellPhonesPage = new CellPhonesPage(BrowserFactory.getDriver());
    private final CheckoutPage checkoutPage = new CheckoutPage(BrowserFactory.getDriver());
    private final OrderDetails orderDetails = new OrderDetails(BrowserFactory.getDriver());
    String email = "heraspi@test.com";

    @BeforeClass
    void prepare() {
        WebDriver driver = BrowserFactory.startBrowser("https://demo.nopcommerce.com/");
        homePage = new HomePage(driver);
        registerPage = new RegisterPage(driver);
        pageHeader = new PageHeader(driver);
        loginPage = new LoginPage(driver);
    }

    @Test
    public void loginWithNewAccount() throws InterruptedException {

        pageHeader.clickLoginButton();

        // test if it's on register page by url
        Assert.assertTrue(BrowserFactory.getDriver().getCurrentUrl().startsWith("https://demo.nopcommerce.com/login"));

        loginPage.emailInputFieldSetText("test.com");
        loginPage.passwordInputFieldSetText("");
        loginPage.getEmailAttribute();
        System.out.println("Message: " + loginPage.getEmailAttribute());
        Assert.assertEquals(loginPage.getEmailAttribute(), "Wrong email");

        loginPage.emailInputFieldSetText(email);
        System.out.println("Entered Email is: " + loginPage.getEmailAttribute());

        loginPage.passwordInputFieldSetText("t");
        loginPage.clickLoginButton();

        System.out.println("Message: " + loginPage.getPasswordAttribute());
        Assert.assertEquals(loginPage.getPasswordAttribute(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");

        loginPage.passwordInputFieldSetText("secret");
        System.out.println("Password is entered");

        loginPage.clickLoginButton();

        Assert.assertTrue(BrowserFactory.getDriver().getCurrentUrl().startsWith("https://demo.nopcommerce.com/"));

        pageHeader.clickMyAccountButton();
        Assert.assertEquals(pageHeader.getMyAccountButtonAttribute(), "My account");

        pageHeader.clickLogoutButton();
        Assert.assertEquals(pageHeader.getLogoutAttribute(), "Log out");

        pageHeader.clickLogoutButton();
        System.out.println("Log out button on header page is clicked");
        Thread.sleep(3000);
    }

    @AfterClass
    public void afterClass() {
        BrowserFactory.getDriver().quit();
    }
}

