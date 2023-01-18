package nopCommerceTests;

import base.BrowserFactory;
import base.PageHeader;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.CellPhonesPage;
import page.CustomerPage;
import page.LoginPage;
import page.RegisterPage;
import util.DateTimeGenerator;

import java.io.IOException;

import static base.BrowserFactory.driver;

public class AddProduct {
    private PageHeader pageHeader;
    private LoginPage loginPage;
    private RegisterPage registerPage;
    private CustomerPage customerPage;
    private CellPhonesPage cellPhonesPage;

    String email;
    String password = "secret";

    @BeforeClass
    void prepare() throws IOException {
        WebDriver driver = BrowserFactory.startBrowser("https://demo.nopcommerce.com/");

        registerPage = new RegisterPage(driver);
        pageHeader = new PageHeader(driver);
        loginPage = new LoginPage(driver);
        customerPage = new CustomerPage(driver);
        cellPhonesPage = new CellPhonesPage(driver);

        //DateTimeGenerator.generateRandomEmail();
        email = "hera" + DateTimeGenerator.getDateTime() + "@test.com";
        System.out.println(email);
    }

    public void createAccount() {
        pageHeader.clickRegisterButton();
        registerPage.fillFormWithValidData("test", "test", "17", "April", "1989", email, "company", password, password);
        registerPage.clickRegisterButton();
    }

    @Test(priority = 4)
    public void addProductStep1() throws InterruptedException {
        createAccount();

        pageHeader.clickLoginButton();
        loginPage.fillLoginFields(email, password);

        Assert.assertTrue(BrowserFactory.getDriver().getCurrentUrl().startsWith("https://demo.nopcommerce.com/"));
        cellPhonesPage.selectCellPhonesPage();
        cellPhonesPage.clickAddToCartHTC("HTC One Mini Blue");
        Assert.assertEquals(cellPhonesPage.barNotificationAttribute(), "The product has been added to your shopping cart");

        cellPhonesPage.clickShoppingCartLink();
        Assert.assertEquals(BrowserFactory.getDriver().getCurrentUrl(), "https://demo.nopcommerce.com/cart");
        cellPhonesPage.selectCellPhonesPage();
        cellPhonesPage.clickMobile("HTC One Mini Blue");
        Assert.assertEquals(BrowserFactory.getDriver().getCurrentUrl(), "https://demo.nopcommerce.com/htc-one-mini-blue");
        cellPhonesPage.numberInputFieldSetText("2");
        cellPhonesPage.clickAddToCartButtonInSelectedPhone();
        Assert.assertEquals(cellPhonesPage.barNotificationAttribute(), "The product has been added to your shopping cart");
        cellPhonesPage.clickCloseButton();

        Thread.sleep(2000);
        pageHeader.clickShoppingCart();
        Assert.assertEquals(cellPhonesPage.getQtyAttribute(), "3");


        pageHeader.clickLogoutButton();
        Assert.assertEquals(pageHeader.getShoppingCartAttribute(), "(0)");

        pageHeader.clickLoginButton();
        loginPage.fillLoginFields(email, password);
        Thread.sleep(1000);

        Assert.assertEquals(pageHeader.getShoppingCartAttribute(), "(3)");

        pageHeader.clickLogoutButton();

    }

    @AfterTest
    public void closeDriver() {
        //closes the browser instance
        driver.close();
    }
}
