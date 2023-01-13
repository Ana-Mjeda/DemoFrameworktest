package page;

import base.BaseUI;
import io.qameta.allure.Step;
import nopCommerce.TemplatePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;


public class CellPhonesPage extends TemplatePage {
    BaseUI baseUI;

    public CellPhonesPage(WebDriver driver) {
        super(driver);
        baseUI = new BaseUI(driver);
    }

    @FindBy(xpath = "//a[normalize-space()='Electronics']")
    WebElement electronics;

    @FindBy(xpath = "//a[normalize-space()='Cell phones']")
    WebElement cellPhones;

    public void selectCellPhonesPage() throws InterruptedException {
        Actions action = new Actions(driver);
        WebElement menu = electronics;
        action.moveToElement(menu);

        WebElement subMenu = cellPhones;
        action.moveToElement(subMenu);

        action.moveToElement(menu).moveToElement(subMenu).click().build().perform();

    }


    @FindBy(xpath = "//*[@class='button-2 product-box-add-to-cart-button']")
    WebElement addToCart;

    public void clickAddToCartButton() {
        baseUI.click(addToCart);
        System.out.println("Add To Cart Button clicked");
    }

//    @Step("Select add to cart button below HTC One Mini Phone")
//    public WebElement clickAddToCartHTC() {
//
//        List<WebElement> phones = driver.findElements(By.xpath("//h2[@class='product-title'] //a"));
//        List<WebElement> buttons = driver.findElements(By.xpath("//div[@class='item-box'] //*[@class='button-2 product-box-add-to-cart-button']"));
//        for (int i = 0; i < phones.size(); i++) {
//            WebElement phone = phones.get(i);
//            if (phone.getText().equals("htc-one-mini-blue")) {
//                System.out.println("found");
//                buttons.get(i).click();
//            }
//        }
//    }

    @Step("Seclect mobile")
    public void addMobileToCart(String mobileName) {

        By mobileLocator = By.xpath("//h2//a[text()='" + mobileName + "']//ancestor::div//*[@class='buttons'] //*[@class='button-2 product-box-add-to-cart-button']");

        driver.findElement(mobileLocator).click();
    }

    @Step("Select mobile")
    public void clickMobile(String mobileName) {

        By mobileLocator = By.xpath("//h2//a[text()='" + mobileName + "']");

        driver.findElement(mobileLocator).click();

    }

    @FindBy(xpath = "//*[@class='bar-notification success']")
    WebElement barNotification;

    public String barNotificationAttribute() {
        return barNotification.getText();
    }

    @FindBy(xpath = "//*[@id='bar-notification'] //a")
    WebElement shoppingCartLink;


    public void clickShoppingCartLink() {
        shoppingCartLink.click();
        System.out.println("Shopping Cart link clicked");
    }

    @FindBy(xpath = "//*[@class='close']")
    WebElement closeButton;

    public void clickCloseButton() {
        baseUI.click(closeButton);
    }

    @FindBy(xpath = "//*[@id='product_enteredQuantity_19']")
    WebElement numberInputField;

    public void numberInputFieldSetText(String text) {
        baseUI.sendText(numberInputField, text);
    }

    @FindBy(xpath = "//*[@id='add-to-cart-button-19']")
    WebElement addToCartButtonInSelectedPhone;

    public void clickAddToCartButtonInSelectedPhone() {
        baseUI.click(addToCartButtonInSelectedPhone);
        System.out.println("Add To Cart Button clicked");
    }

    @FindBy(xpath = "//*[@class='qty-input']")
    WebElement qtyInputField;

    public String getQtyAttribute() {
        return qtyInputField.getAttribute("value");
    }

    @FindBy(xpath = "//*[@id='termsofservice']")
    WebElement checkbox;

    public void clickCheckbox() {
        baseUI.click(checkbox);
        System.out.println("Checkbox clicked");
    }

    public void clickCheckoutButton() {
        WebElement checkoutButton = driver.findElement(By.id("checkout"));
        checkoutButton.click();
        System.out.println("Checkout button clicked");
    }
}


