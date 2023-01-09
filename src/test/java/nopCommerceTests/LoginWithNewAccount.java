package nopCommerceTests;

import Base.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginWithNewAccount extends TemplateTest {

    private final LoginPage loginPage = new LoginPage(BrowserFactory.getDriver());
    private final PageHeader pageHeader = new PageHeader(BrowserFactory.getDriver());
    private final CustomerPage customerPage = new CustomerPage(BrowserFactory.getDriver());
    private final TopMenu topMenu = new TopMenu(BrowserFactory.getDriver());
    private final CellPhonesPage cellPhonesPage = new CellPhonesPage(BrowserFactory.getDriver());
    private final CheckoutPage checkoutPage = new CheckoutPage(BrowserFactory.getDriver());
    private final OrderDetails orderDetails = new OrderDetails(BrowserFactory.getDriver());
    String email = "herasi@test.com";

    @Test
    public void step2() throws InterruptedException {

        pageHeader.clickLoginButton();

        // test if it's on register page by url
        Assert.assertTrue(BrowserFactory.getDriver().getCurrentUrl().startsWith("https://demo.nopcommerce.com/login"));

        loginPage.emailInputFieldSetText("test.com");
        loginPage.getEmailInputField().sendKeys(Keys.RETURN);
        System.out.println("Message: " + loginPage.getEmailError().getText());
        Assert.assertEquals(loginPage.getEmailError().getText(), "Wrong email");

        loginPage.getEmailInputField().clear();
        loginPage.emailInputFieldSetText(email);
        System.out.println("Entered Email is: " + loginPage.getEmailAttribute());

        loginPage.passwordInputFieldSetText("t");

        loginPage.clickLoginButton();

        System.out.println("Message: " + loginPage.getPasswordError().getText());
        Assert.assertEquals(loginPage.getPasswordError().getText(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");

        loginPage.getPasswordInputField().clear();
        loginPage.passwordInputFieldSetText("secret");
        System.out.println("Password is entered");

        loginPage.clickLoginButtonWhenErrorIsPresent();

        Assert.assertTrue(BrowserFactory.getDriver().getCurrentUrl().startsWith("https://demo.nopcommerce.com/"));

        WebElement myAccountButton = pageHeader.getMyAccountButton();
        System.out.println(myAccountButton.getText() + " is displayed");
        Assert.assertEquals(myAccountButton.getText(), "My account");

        WebElement logoutButton = pageHeader.getLogoutButton();
        System.out.println(logoutButton.getText() + " is displayed");
        Assert.assertEquals(logoutButton.getText(), "Log out");

        pageHeader.clickLogoutButton();
        System.out.println("Log out button on header page is clicked");
        Thread.sleep(3000);

    }

    @Test
    public void step3() throws InterruptedException {

        pageHeader.clickLoginButton();

        loginPage.emailInputFieldSetText(email);
        loginPage.passwordInputFieldSetText("secret");
        loginPage.clickLoginButton();

        pageHeader.clickMyAccountButton();

        Assert.assertEquals(BrowserFactory.getDriver().getCurrentUrl(), "https://demo.nopcommerce.com/customer/info");

        customerPage.clickChangePassword();

        customerPage.oldPasswordInputFieldSetText("secret");
        System.out.println("Old Password is entered");
        customerPage.newPasswordInputFieldSetText("secret");
        System.out.println("New Password is entered");
        customerPage.confirmNewPasswordInputFieldSetText("secret");
        System.out.println("Confirmed New Password is entered");

        customerPage.clickChangePasswordButton();

        System.out.println("Message: " + customerPage.getSamePasswordError().getText());
        Assert.assertEquals(customerPage.getSamePasswordError().getText(), "You entered the password that is the same as one of the last passwords you used. Please create a new password.");

        customerPage.oldPasswordInputFieldSetText("ghosty");
        customerPage.newPasswordInputFieldSetText("ghosty");
        customerPage.confirmNewPasswordInputFieldSetText("ghosty");

        customerPage.clickChangePasswordButtonWhenErrorIsPresent();

        System.out.println("Message: " + customerPage.getOldPasswordMatchError().getText());
        Assert.assertEquals(customerPage.getOldPasswordMatchError().getText(), "Old password doesn't match");

        /*customerPage.getOldPasswordInputField().clear();
        Thread.sleep(1000);
        customerPage.getNewPasswordInputField().clear();
        Thread.sleep(1000);
        customerPage.getConfirmNewPasswordInputField().clear();
        Thread.sleep(1000);*/
        customerPage.oldPasswordInputFieldSetText("secret");
        customerPage.newPasswordInputFieldSetText("ghosti");
        customerPage.confirmNewPasswordInputFieldSetText("ghosta");

        customerPage.clickChangePasswordButtonWhenErrorIsPresent();

        //System.out.println("Message: " + customerPage.getConfirmNewPasswordMatchError().getText());
        //Assert.assertEquals(customerPage.getConfirmNewPasswordMatchError().getText(), "The new password and confirmation password do not match.");
        //BAG OPISAN U WORDU

        customerPage.getOldPasswordInputField().clear();
        Thread.sleep(1000);
        customerPage.getNewPasswordInputField().clear();
        Thread.sleep(1000);
        customerPage.getConfirmNewPasswordInputField().clear();
        Thread.sleep(1000);
        customerPage.oldPasswordInputFieldSetText("secret");
        customerPage.newPasswordInputFieldSetText("ghosty");
        customerPage.confirmNewPasswordInputFieldSetText("ghosty");

        customerPage.clickChangePasswordButtonWhenErrorIsPresent();

        System.out.println("Message: " + customerPage.getPasswordChangedSuccessfulMessage().getText());
        Assert.assertEquals(customerPage.getPasswordChangedSuccessfulMessage().getText(), "Password was changed");

        customerPage.getCloseButton().click();
        Thread.sleep(3000);

        pageHeader.clickLogoutButton();
        pageHeader.clickLoginButton();

        loginPage.emailInputFieldSetText(email);
        loginPage.passwordInputFieldSetText("secret");

        loginPage.clickLoginButton();

        System.out.println("Message: " + customerPage.getConfirmNewPasswordMatchError().getText());
        Assert.assertEquals(customerPage.getConfirmNewPasswordMatchError().getText(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");

        loginPage.getPasswordInputField().clear();
        loginPage.passwordInputFieldSetText("ghostly");

        loginPage.clickLoginButtonWhenErrorIsPresent();

        pageHeader.clickLogoutButton();
    }

    @Test
    public void addProductStep1() throws InterruptedException {

        pageHeader.clickLoginButton();
        loginPage.emailInputFieldSetText(email);
        loginPage.passwordInputFieldSetText("secret");
        loginPage.clickLoginButton();

        cellPhonesPage.selectCellPhones();

        Assert.assertEquals(BrowserFactory.getDriver().getCurrentUrl(), "https://demo.nopcommerce.com/cell-phones");

        cellPhonesPage.clickAddToCartButton();
        Thread.sleep(3000);

        System.out.println("Message: " + cellPhonesPage.getBarNotification().getText());
        Assert.assertEquals(cellPhonesPage.getBarNotification().getText(), "The product has been added to your shopping cart");

        cellPhonesPage.clickShoppingCartLink();

        Assert.assertEquals(BrowserFactory.getDriver().getCurrentUrl(), "https://demo.nopcommerce.com/cart");

        cellPhonesPage.selectCellPhones();
        cellPhonesPage.clickHTCOneMiniBlue();
        cellPhonesPage.getNumberInputField().clear();
        cellPhonesPage.numberInputFieldSetText("2");
        cellPhonesPage.clickAddToCartButtonInSelectedPhone();

        System.out.println("Message: " + cellPhonesPage.getBarNotification().getText());
        Assert.assertEquals(cellPhonesPage.getBarNotification().getText(), "The product has been added to your shopping cart");

        customerPage.getCloseButton().click();
        Thread.sleep(1000);

        pageHeader.clickShoppingCart();
        Assert.assertEquals(BrowserFactory.getDriver().getCurrentUrl(), "https://demo.nopcommerce.com/cart");

        System.out.println("Number of phones in shopping cart are : " + cellPhonesPage.getQtyAttribute());
        Assert.assertEquals(cellPhonesPage.getQtyAttribute(), "3");

        Thread.sleep(1000);
        pageHeader.clickLogoutButton();

        System.out.println("Shopping cart value : " + pageHeader.getShoppingCartAttribute());
        Assert.assertEquals(pageHeader.getShoppingCartAttribute(), "(0)");

        pageHeader.clickLoginButton();
        loginPage.emailInputFieldSetText(email);
        loginPage.passwordInputFieldSetText("secret");
        loginPage.clickLoginButton();

        Thread.sleep(2000);

        System.out.println("Shopping cart value : " + pageHeader.getShoppingCartAttribute());
        Assert.assertEquals(pageHeader.getShoppingCartAttribute(), "(3)");
    }

    @Test
    public void checkoutStep1() throws InterruptedException {

        pageHeader.clickLoginButton();
        loginPage.emailInputFieldSetText(email);
        loginPage.passwordInputFieldSetText("secret");
        loginPage.clickLoginButton();

        System.out.println("Shopping cart value : " + pageHeader.getShoppingCartAttribute());
        Assert.assertEquals(pageHeader.getShoppingCartAttribute(), "(3)");

        pageHeader.clickShoppingCart();

        cellPhonesPage.clickCheckbox();
        cellPhonesPage.clickCheckoutButton();

        System.out.println(checkoutPage.getBillingAddressAttribute() + " is displayed");
        Assert.assertEquals(checkoutPage.getBillingAddressAttribute(), "Billing address");

        checkoutPage.selectCountryFromDropdown("Sweden");

        checkoutPage.cityInputFieldSetText("Gothenburg");
        System.out.println("City: " + checkoutPage.getCityAttribute() + " is entered");

        checkoutPage.address1InputFieldSetText("Nya Bergets Vag 50");
        System.out.println("Address 1: " + checkoutPage.getAddress1Attribute() + " is entered");

        checkoutPage.postalCodeInputFieldSetText("412 76");
        System.out.println("Postal code: " + checkoutPage.getPostalCodeAttribute() + " is entered");

        checkoutPage.phoneNumberInputFieldSetText("+46 31 55 83 00");
        System.out.println("Phone number: " + checkoutPage.getPhoneNumberAttribute() + " is entered");

        Assert.assertTrue(checkoutPage.getCheckBoxValue());

        checkoutPage.clickContinueButton();

        System.out.println(checkoutPage.getShippingMethodAttribute() + " is displayed");
        Assert.assertEquals(checkoutPage.getShippingMethodAttribute(), "Shipping method");

        checkoutPage.clickNextDayAirRadioButton();
        checkoutPage.clickShippingMethodContinueButton();

        System.out.println(checkoutPage.getPaymentMethodAttribute() + " is displayed");
        Assert.assertEquals(checkoutPage.getPaymentMethodAttribute(), "Payment method");

        checkoutPage.clickCheckMoneyRadioButton();
        checkoutPage.clickPaymentMethodContinueButton();

        System.out.println(checkoutPage.getPaymentInformationAttribute() + " is displayed");
        Assert.assertEquals(checkoutPage.getPaymentInformationAttribute(), "Payment information");

        checkoutPage.clickPaymentInformationContinueButton();

        System.out.println(checkoutPage.getConfirmOrderAttribute() + " is displayed");
        Assert.assertEquals(checkoutPage.getConfirmOrderAttribute(), "Confirm order");

        Assert.assertEquals(checkoutPage.getBillingNameAttribute(), checkoutPage.getShippingNameAttribute());
        Assert.assertEquals(checkoutPage.getBillingEmailAttribute(), checkoutPage.getShippingEmailAttribute());
        Assert.assertEquals(checkoutPage.getBillingPhoneAttribute(), checkoutPage.getShippingPhoneAttribute());
        Assert.assertEquals(checkoutPage.getBillingCompanyAttribute(), checkoutPage.getShippingCompanyAttribute());
        Assert.assertEquals(checkoutPage.getBillingAddress1Attribute(), checkoutPage.getShippingAddress1Attribute());
        Assert.assertEquals(checkoutPage.getBillingCityAttribute(), checkoutPage.getShippingCityAttribute());
        Assert.assertEquals(checkoutPage.getBillingCountryAttribute(), checkoutPage.getShippingCountryAttribute());

        Assert.assertEquals(checkoutPage.getBillingPaymentAttribute(), "Payment Method: Check / Money Order");

        Assert.assertEquals(checkoutPage.getShippingAttribute(), "Shipping Method: Next Day Air");

        Assert.assertEquals(checkoutPage.getProductQtyAttribute(), "3");

        checkoutPage.clickConfirmButtonOnBottomOfPage();
        Thread.sleep(1000);

        Assert.assertEquals(BrowserFactory.getDriver().getCurrentUrl(), "https://demo.nopcommerce.com/checkout/completed");

        checkoutPage.clickHereForOrdersLink();

        Assert.assertEquals(BrowserFactory.getDriver().getCurrentUrl(), "/html/body/div[6]/div[3]/div/div/div/div[2]/div/div[2]/div[2]/a");

        Assert.assertEquals(orderDetails.getBillingNameAttribute(), orderDetails.getShippingNameAttribute());
        Assert.assertEquals(orderDetails.getBillingEmailAttribute(), orderDetails.getShippingEmailAttribute());
        Assert.assertEquals(orderDetails.getBillingPhoneAttribute(), orderDetails.getShippingPhoneAttribute());
        Assert.assertEquals(orderDetails.getBillingCompanyAttribute(), orderDetails.getShippingCompanyAttribute());
        Assert.assertEquals(orderDetails.getBillingAddress1Attribute(), orderDetails.getShippingAddress1Attribute());
        Assert.assertEquals(orderDetails.getBillingCityAttribute(), orderDetails.getShippingCityAttribute());
        Assert.assertEquals(orderDetails.getBillingCountryAttribute(), orderDetails.getShippingCountryAttribute());

        Assert.assertEquals(orderDetails.getBillingPaymentAttribute(), "Payment Method: Check / Money Order");

        Assert.assertEquals(orderDetails.getShippingAttribute(), "Shipping Method: Next Day Air");

        Assert.assertEquals(orderDetails.getProductQtyAttribute(), "3");

    }
}

