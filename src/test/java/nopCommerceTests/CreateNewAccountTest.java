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

import java.io.IOException;

import static base.BrowserFactory.driver;

public class CreateNewAccountTest {
    private RegisterPage registerPage;
    private HomePage homePage;
    private PageHeader pageHeader;
    private LoginPage loginPage;
    private CustomerPage customerPage;
    private CellPhonesPage cellPhonesPage;

    private CheckoutPage checkoutPage;
    private OrderDetails orderDetails;

    String name = "Hera";

    String lastName = "Syndulla";

    String day = "17";

    String month = "April";

    String year = "1980";

    String email = "hera20230111020250@test.com";
    //String email;
    //String email;
    String company = "Phoenix";

    String password = "secret";

    String confirmPassword = "secret";

    String invalidEmail = "test.com";

    String invalidPassword = "test";
    String invalidPassword1 = "testiran";

    String invalidConfirmPassword = "tostiran";

    String newPassword = "ghosty";

    @BeforeClass
    void prepare() throws IOException {
        WebDriver driver = BrowserFactory.startBrowser("https://demo.nopcommerce.com/");
        homePage = new HomePage(driver);
        registerPage = new RegisterPage(driver);
        pageHeader = new PageHeader(driver);
        loginPage = new LoginPage(driver);
        customerPage = new CustomerPage(driver);
        cellPhonesPage = new CellPhonesPage(driver);
        checkoutPage = new CheckoutPage(driver);
        orderDetails = new OrderDetails(driver);

        //DateTimeGenerator.generateRandomEmail();


        //email = "hera" + DateTimeGenerator.getDateTime() + "@test.com";
        //System.out.println(email);
    }

    @Test(priority = 1)
    public void stepCreateAccount() {
        homePage.clickRegisterButton();
        registerPage.clickRegisterButton();
        registerPage.enterInvalidEmail(invalidEmail);
        registerPage.enterInvalidPasswordLessThen(invalidPassword);
        registerPage.enterInvalidConfirmPasswordDifferent(invalidConfirmPassword);
        registerPage.clickGenderFemale();
        registerPage.fillFormWithValidData(name, lastName, day, month, year, email, company, password, confirmPassword);
        registerPage.clickRegisterButton();
        Assert.assertTrue(BrowserFactory.getDriver().getCurrentUrl().startsWith("https://demo.nopcommerce.com/"));

        registerPage.getRegistrationMessage();
        registerPage.clickContinueButton();

        Assert.assertEquals(BrowserFactory.getDriver().getCurrentUrl(), "https://demo.nopcommerce.com/");
    }

    @Test(priority = 2)
    public void createAccountWithExistingEmail() {
        pageHeader.clickRegisterButton();
        registerPage.clickGenderFemale();
        registerPage.fillFormWithValidData(name, lastName, day, month, year, email, company, password, confirmPassword);
        registerPage.clickRegisterButton();
        registerPage.getMessageError();
    }

    @Test(priority = 3)
    public void loginWithNewAccount() {
        pageHeader.clickLoginButton();
        Assert.assertTrue(BrowserFactory.getDriver().getCurrentUrl().startsWith("https://demo.nopcommerce.com/login"));

        loginPage.emailInputFieldSetText(invalidEmail);
        loginPage.clickLoginButton();

        Assert.assertEquals(loginPage.getEmailErrorAttribute(), "Wrong email");

        loginPage.emailInputFieldSetText(email);
        loginPage.passwordInputFieldSetText(invalidPassword);
        loginPage.clickLoginButton();

        Assert.assertEquals(loginPage.getPasswordErrorAttribute(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");

        loginPage.fillLoginFields(email, password);

        Assert.assertTrue(BrowserFactory.getDriver().getCurrentUrl().startsWith("https://demo.nopcommerce.com/"));

        Assert.assertEquals(pageHeader.getMyAccountButtonAttribute(), "My account");
        Assert.assertEquals(pageHeader.getLogoutAttribute(), "Log out");

        pageHeader.clickLogoutButton();

    }

    @Test(priority = 6)
    public void changePassword() throws InterruptedException {
        pageHeader.clickLoginButton();
        loginPage.fillLoginFields(email, password);
        pageHeader.clickMyAccountButton();

        Assert.assertEquals(BrowserFactory.getDriver().getCurrentUrl(), "https://demo.nopcommerce.com/customer/info");

        customerPage.clickChangePassword();

        customerPage.fillFieldsWithPassword(password, password, password);
        Assert.assertEquals(customerPage.getSamePasswordErrorAttribute(), "You entered the password that is the same as one of the last passwords you used. Please create a new password.");

        driver.get("https://demo.nopcommerce.com/customer/changepassword");
        customerPage.fillFieldsWithPassword(invalidPassword1, invalidPassword1, invalidPassword1);
        Assert.assertEquals(customerPage.getSamePasswordErrorAttribute(), "Old password doesn't match");

        driver.get("https://demo.nopcommerce.com/customer/changepassword");
        customerPage.fillFieldsWithPassword(password, invalidPassword1, invalidConfirmPassword);
        Assert.assertEquals(customerPage.getConfirmNewPasswordErrorAttribute(), "The new password and confirmation password do not match.");

        driver.get("https://demo.nopcommerce.com/customer/changepassword");
        customerPage.fillFieldsWithPassword(password, newPassword, newPassword);
        Assert.assertEquals(customerPage.getPasswordChangedAttribute(), "Password was changed");

        customerPage.clickCloseButtonOnBar();
        Thread.sleep(2000);

        pageHeader.clickLogoutButton();
        pageHeader.clickLoginButton();

        loginPage.fillLoginFields(email, password);

        Assert.assertEquals(loginPage.getPasswordErrorAttribute(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");

        loginPage.passwordInputFieldSetText(newPassword);

        loginPage.clickLoginButton();
        pageHeader.clickLogoutButton();
    }

    @Test(priority = 4)
    public void addProductStep1() throws InterruptedException {
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

    }

    @Test(priority = 5)
    public void checkoutStep1() throws InterruptedException {

        pageHeader.clickLoginButton();
        loginPage.fillLoginFields(email, password);

        Assert.assertEquals(pageHeader.getShoppingCartAttribute(), "(3)");

        pageHeader.clickShoppingCart();
        cellPhonesPage.clickCheckbox();
        cellPhonesPage.clickCheckoutButton();

        Assert.assertEquals(checkoutPage.getBillingAddressAttribute(), "Billing address");

        checkoutPage.selectCountryFromDropdown("Sweden");
        checkoutPage.cityInputFieldSetText("Gothenburg");
        checkoutPage.address1InputFieldSetText("Nya Bergets Vag 50");
        checkoutPage.postalCodeInputFieldSetText("412 76");
        checkoutPage.phoneNumberInputFieldSetText("+46 31 55 83 00");

        Assert.assertTrue(checkoutPage.getCheckBoxValue());
        checkoutPage.clickContinueButton();

        Assert.assertEquals(checkoutPage.getShippingMethodAttribute(), "Shipping method");

        checkoutPage.clickNextDayAirRadioButton();
        checkoutPage.clickShippingMethodContinueButton();

        Assert.assertEquals(checkoutPage.getPaymentMethodAttribute(), "Payment method");

        checkoutPage.clickCheckMoneyRadioButton();
        checkoutPage.clickPaymentMethodContinueButton();

        Assert.assertEquals(checkoutPage.getPaymentInformationAttribute(), "Payment information");
        checkoutPage.clickPaymentInformationContinueButton();
        Assert.assertEquals(checkoutPage.getConfirmOrderAttribute(), "Confirm order");

        Assert.assertEquals(checkoutPage.getConfirmBillingAddressAttribute(), "Nya Bergets Vag 50");
        checkoutPage.compareAddresses();
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
    }

    @AfterTest
    public void closeDriver() {
        //closes the browser instance
        driver.close();
    }
}