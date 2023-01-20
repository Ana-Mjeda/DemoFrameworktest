package nopCommerceTests;

import base.BrowserFactory;
import base.PageHeader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.CellPhonesPage;
import page.Gender;
import page.LoginPage;
import page.RegisterPage;
import util.DateTimeGenerator;

import java.io.IOException;

import static base.BrowserFactory.driver;

public class TC04AddProduct {
    private PageHeader pageHeader;
    private LoginPage loginPage;
    private RegisterPage registerPage;
    private CellPhonesPage cellPhonesPage;

    String email;
    String password = "secret";

    @BeforeClass
    void prepare() throws IOException {
        WebDriver driver = BrowserFactory.startBrowser("https://demo.nopcommerce.com/");

        registerPage = new RegisterPage(driver);
        pageHeader = new PageHeader(driver);
        loginPage = new LoginPage(driver);
        cellPhonesPage = new CellPhonesPage(driver);

        //DateTimeGenerator.generateRandomEmail();
        email = "hera" + DateTimeGenerator.getDateTime() + "@test.com";
        System.out.println(email);
    }

    public void createAccount() {
        pageHeader.clickRegisterButton();
        registerPage.fillFormWithValidData(Gender.FEMALE, "test", "test", "17", "April", "1989", email, "company", password, password);
        registerPage.clickRegisterButton();
    }

    @Test(priority = 4)
    public void addProductStep1() throws InterruptedException {
        createAccount();

        String htcOneMiniBlue = "HTC One Mini Blue";
        String electronics = "Electronics";
        String cellPhones = "Cell phones";

        pageHeader.clickLoginButton();
        loginPage.fillLoginFields(email, password);

        pageHeader.urlCheck();
        cellPhonesPage.chooseCategory(electronics, cellPhones);
        cellPhonesPage.clickAddToCartIfProductFound(htcOneMiniBlue);
        cellPhonesPage.barNotificationAttribute();
        cellPhonesPage.clickShoppingCartLink();
        pageHeader.urlCheck();

        cellPhonesPage.chooseCategory(electronics, cellPhones);
        cellPhonesPage.clickMobile(htcOneMiniBlue);
        pageHeader.urlCheck();
        cellPhonesPage.numberInputFieldSetText("2");
        cellPhonesPage.clickAddToCartButtonInSelectedPhone();
        cellPhonesPage.barNotificationAttribute();
        cellPhonesPage.clickCloseButton();
        Thread.sleep(2000);
        pageHeader.clickShoppingCart();
        pageHeader.checkShoppingCartValue3();
        pageHeader.clickLogoutButton();
        pageHeader.checkShoppingCartValue0();
        pageHeader.clickLoginButton();
        loginPage.fillLoginFields(email, password);
        Thread.sleep(1000);
        pageHeader.checkShoppingCartValue3();
        pageHeader.clickLogoutButton();

    }

    @AfterTest
    public void closeDriver() {
        //closes the browser instance
        driver.close();
    }
}
