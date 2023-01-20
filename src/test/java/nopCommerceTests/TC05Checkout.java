package nopCommerceTests;

import base.BrowserFactory;
import base.OrderDetails;
import base.PageHeader;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.*;
import util.DateTimeGenerator;

import java.io.IOException;

import static base.BrowserFactory.driver;

public class TC05Checkout {
    private PageHeader pageHeader;
    private LoginPage loginPage;
    private RegisterPage registerPage;
    private CellPhonesPage cellPhonesPage;
    private CheckoutPage checkoutPage;
    private OrderDetails orderDetails;

    String email;
    String password = "secret";
    String country = "Sweden";
    String city = "Gothenburg";
    String address = "Nya Bergets Vag 50";
    String postalCode = "412 76";
    String phoneNumber = "+46 31 55 83 00";

    @BeforeClass
    void prepare() throws IOException {
        WebDriver driver = BrowserFactory.startBrowser("https://demo.nopcommerce.com/");

        registerPage = new RegisterPage(driver);
        pageHeader = new PageHeader(driver);
        loginPage = new LoginPage(driver);
        cellPhonesPage = new CellPhonesPage(driver);
        checkoutPage = new CheckoutPage(driver);
        orderDetails = new OrderDetails(driver);

        email = "hera" + DateTimeGenerator.getDateTime() + "@test.com";
        System.out.println(email);
    }

    public void createAccount() throws InterruptedException {
        pageHeader.clickRegisterButton();
        registerPage.fillFormWithValidData(Gender.FEMALE, "test", "test", "17", "April", "1989", email, "company", password, password);
        registerPage.clickRegisterButton();
        pageHeader.clickLoginButton();
        loginPage.fillLoginFields(email, password);
        cellPhonesPage.chooseCategory("Electronics", "Cell phones");
        cellPhonesPage.clickMobile("HTC One Mini Blue");
        cellPhonesPage.numberInputFieldSetText("3");
        cellPhonesPage.clickAddToCartButtonInSelectedPhone();
        pageHeader.clickLogoutButton();
    }

    @Test(priority = 5)
    public void checkoutStep1() throws InterruptedException {
        createAccount();

        pageHeader.clickLoginButton();
        loginPage.fillLoginFields(email, password);

        pageHeader.checkShoppingCartValue3();
        pageHeader.clickShoppingCart();
        cellPhonesPage.clickCheckbox();
        cellPhonesPage.clickCheckoutButton();
        checkoutPage.getBillingAddressAttribute();
        checkoutPage.selectCountryFromDropdown(country);
        checkoutPage.cityInputFieldSetText(city);
        checkoutPage.address1InputFieldSetText(address);
        checkoutPage.postalCodeInputFieldSetText(postalCode);
        checkoutPage.phoneNumberInputFieldSetText(phoneNumber);

        Assert.assertTrue(checkoutPage.getCheckBoxValue());
        checkoutPage.clickContinueButton();

        checkoutPage.getShippingMethodAttribute();
        checkoutPage.clickNextDayAirRadioButton();
        checkoutPage.clickShippingMethodContinueButton();

        Assert.assertEquals(checkoutPage.getPaymentMethodAttribute(), "Payment method");

        checkoutPage.clickCheckMoneyRadioButton();
        checkoutPage.clickPaymentMethodContinueButton();

        Assert.assertEquals(checkoutPage.getPaymentInformationAttribute(), "Payment information");
        checkoutPage.clickPaymentInformationContinueButton();
        Assert.assertEquals(checkoutPage.getConfirmOrderAttribute(), "Confirm order");

        Assert.assertEquals(checkoutPage.getConfirmBillingAddressAttribute(), address);
        //checkoutPage.compareAddresses();
        Assert.assertEquals(checkoutPage.getBillingPaymentMethodAttribute(), "Check / Money Order");
        Assert.assertEquals(checkoutPage.getShippingShippingMethodAttribute(), "Next Day Air");
        Assert.assertEquals(checkoutPage.getShippingQtyAttribute(), "3");

        checkoutPage.clickConfirmButtonOnBottomOfPage();
        Thread.sleep(1000);

        Assert.assertEquals(checkoutPage.getThankYouAttribute(), "Thank you");
        checkoutPage.clickOrderDetailsLink();

        orderDetails.getOrderInformationAttribute();
        orderDetails.compareAddresses();
        Assert.assertEquals(orderDetails.getBillingPaymentMethodAttribute(), "Check / Money Order");
        Assert.assertEquals(orderDetails.getShippingShippingMethodAttribute(), "Next Day Air");
        Assert.assertEquals(orderDetails.getShippingQtyAttribute(), "3");

        pageHeader.clickLogoutButton();
    }

    @AfterTest
    public void closeDriver() {
        //closes the browser instance
        driver.close();
    }
}