package base;

public class derp {

//
//    @Test
//    public void checkoutStep1() throws InterruptedException {
//
//        pageHeader.clickLoginButton();
//        loginPage.emailInputFieldSetText(email);
//        loginPage.passwordInputFieldSetText("secret");
//        loginPage.clickLoginButton();
//
//        System.out.println("Shopping cart value : " + pageHeader.getShoppingCartAttribute());
//        Assert.assertEquals(pageHeader.getShoppingCartAttribute(), "(3)");
//
//        pageHeader.clickShoppingCart();
//
//        cellPhonesPage.clickCheckbox();
//        cellPhonesPage.clickCheckoutButton();
//
//        System.out.println(checkoutPage.getBillingAddressAttribute() + " is displayed");
//        Assert.assertEquals(checkoutPage.getBillingAddressAttribute(), "Billing address");
//
//        checkoutPage.selectCountryFromDropdown("Sweden");
//
//        checkoutPage.cityInputFieldSetText("Gothenburg");
//        System.out.println("City: " + checkoutPage.getCityAttribute() + " is entered");
//
//        checkoutPage.address1InputFieldSetText("Nya Bergets Vag 50");
//        System.out.println("Address 1: " + checkoutPage.getAddress1Attribute() + " is entered");
//
//        checkoutPage.postalCodeInputFieldSetText("412 76");
//        System.out.println("Postal code: " + checkoutPage.getPostalCodeAttribute() + " is entered");
//
//        checkoutPage.phoneNumberInputFieldSetText("+46 31 55 83 00");
//        System.out.println("Phone number: " + checkoutPage.getPhoneNumberAttribute() + " is entered");
//
//        Assert.assertTrue(checkoutPage.getCheckBoxValue());
//
//        checkoutPage.clickContinueButton();
//
//        System.out.println(checkoutPage.getShippingMethodAttribute() + " is displayed");
//        Assert.assertEquals(checkoutPage.getShippingMethodAttribute(), "Shipping method");
//
//        checkoutPage.clickNextDayAirRadioButton();
//        checkoutPage.clickShippingMethodContinueButton();
//
//        System.out.println(checkoutPage.getPaymentMethodAttribute() + " is displayed");
//        Assert.assertEquals(checkoutPage.getPaymentMethodAttribute(), "Payment method");
//
//        checkoutPage.clickCheckMoneyRadioButton();
//        checkoutPage.clickPaymentMethodContinueButton();
//
//        System.out.println(checkoutPage.getPaymentInformationAttribute() + " is displayed");
//        Assert.assertEquals(checkoutPage.getPaymentInformationAttribute(), "Payment information");
//
//        checkoutPage.clickPaymentInformationContinueButton();
//
//        System.out.println(checkoutPage.getConfirmOrderAttribute() + " is displayed");
//        Assert.assertEquals(checkoutPage.getConfirmOrderAttribute(), "Confirm order");
//
//        Assert.assertEquals(checkoutPage.getBillingNameAttribute(), checkoutPage.getShippingNameAttribute());
//        Assert.assertEquals(checkoutPage.getBillingEmailAttribute(), checkoutPage.getShippingEmailAttribute());
//        Assert.assertEquals(checkoutPage.getBillingPhoneAttribute(), checkoutPage.getShippingPhoneAttribute());
//        Assert.assertEquals(checkoutPage.getBillingCompanyAttribute(), checkoutPage.getShippingCompanyAttribute());
//        Assert.assertEquals(checkoutPage.getBillingAddress1Attribute(), checkoutPage.getShippingAddress1Attribute());
//        Assert.assertEquals(checkoutPage.getBillingCityAttribute(), checkoutPage.getShippingCityAttribute());
//        Assert.assertEquals(checkoutPage.getBillingCountryAttribute(), checkoutPage.getShippingCountryAttribute());
//
//        Assert.assertEquals(checkoutPage.getBillingPaymentAttribute(), "Payment Method: Check / Money Order");
//
//        Assert.assertEquals(checkoutPage.getShippingAttribute(), "Shipping Method: Next Day Air");
//
//        Assert.assertEquals(checkoutPage.getProductQtyAttribute(), "3");
//
//        checkoutPage.clickConfirmButtonOnBottomOfPage();
//        Thread.sleep(1000);
//
//        Assert.assertEquals(BrowserFactory.getDriver().getCurrentUrl(), "https://demo.nopcommerce.com/checkout/completed");
//
//        checkoutPage.clickHereForOrdersLink();
//
//        Assert.assertEquals(BrowserFactory.getDriver().getCurrentUrl(), "/html/body/div[6]/div[3]/div/div/div/div[2]/div/div[2]/div[2]/a");
//
//        Assert.assertEquals(orderDetails.getBillingNameAttribute(), orderDetails.getShippingNameAttribute());
//        Assert.assertEquals(orderDetails.getBillingEmailAttribute(), orderDetails.getShippingEmailAttribute());
//        Assert.assertEquals(orderDetails.getBillingPhoneAttribute(), orderDetails.getShippingPhoneAttribute());
//        Assert.assertEquals(orderDetails.getBillingCompanyAttribute(), orderDetails.getShippingCompanyAttribute());
//        Assert.assertEquals(orderDetails.getBillingAddress1Attribute(), orderDetails.getShippingAddress1Attribute());
//        Assert.assertEquals(orderDetails.getBillingCityAttribute(), orderDetails.getShippingCityAttribute());
//        Assert.assertEquals(orderDetails.getBillingCountryAttribute(), orderDetails.getShippingCountryAttribute());
//
//        Assert.assertEquals(orderDetails.getBillingPaymentAttribute(), "Payment Method: Check / Money Order");
//
//        Assert.assertEquals(orderDetails.getShippingAttribute(), "Shipping Method: Next Day Air");
//
//        Assert.assertEquals(orderDetails.getProductQtyAttribute(), "3");
//
//    }
}
