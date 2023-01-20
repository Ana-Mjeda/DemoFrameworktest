package page;

import base.BaseUI;
import io.qameta.allure.Step;
import nopCommerce.TemplatePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;


public class CellPhonesPage extends TemplatePage {
    BaseUI baseUI;


    @FindBy(xpath = "//a[normalize-space()='Electronics']")
    WebElement electronics;

    @FindBy(xpath = "//a[normalize-space()='Cell phones']")
    WebElement cellPhones;
    @FindBy(xpath = "//*[@class='button-2 product-box-add-to-cart-button']")
    WebElement addToCart;
    @FindBy(xpath = "//*[@class='bar-notification success']")
    WebElement barNotification;
    @FindBy(xpath = "//*[@id='bar-notification'] //a")
    WebElement shoppingCartLink;

    @FindBy(xpath = "//*[@class='close']")
    WebElement closeButton;
    @FindBy(xpath = "//*[@id='product_enteredQuantity_19']")
    WebElement numberInputField;
    @FindBy(xpath = "//*[@id='add-to-cart-button-19']")
    WebElement addToCartButtonInSelectedPhone;

    @FindBy(xpath = "//*[@class='qty-input']")
    WebElement qtyInputField;
    @FindBy(xpath = "//*[@id='termsofservice']")
    WebElement checkbox;
    @FindBy(xpath = "//h2[@class='product-title'] //a")
    List<WebElement> productTitle;
    @FindBy(xpath = "//div[@class='item-box'] //*[@class='button-2 product-box-add-to-cart-button']")
    List<WebElement> addToCartButton;

    public CellPhonesPage(WebDriver driver) {
        super(driver);
        baseUI = new BaseUI(driver);
    }

    public void selectCellPhonesPage() throws InterruptedException {
        Actions action = new Actions(driver);
        action.moveToElement(electronics);

        WebElement subMenu = cellPhones;
        action.moveToElement(subMenu);

        action.moveToElement(electronics).moveToElement(subMenu).click().build().perform();

    }

    public void clickAddToCartButton() {
        baseUI.click(addToCart);
        System.out.println("Add To Cart Button clicked");
    }

    @Step("Select add to cart button below a product")
    public CellPhonesPage clickAddToCartIfProductFound(String productName) {
        boolean productFound = false;

        for (int i = 0; i < productTitle.size(); i++) {
            WebElement phone = productTitle.get(i);
            if (phone.getText().equals(productName)) {
                productFound = true;
                System.out.println("Product name: '" + productName + " found");
                addToCartButton.get(i).click();
                break;
            }
        }
        if (!productFound) {
            Assert.fail("Product name: '" + productName + " not found!");
        }
        return this;
    }


    @Step("Select cell phone")
    public void clickMobile(String mobileName) {

        By mobileLocator = By.xpath("//h2//a[text()='" + mobileName + "']");

        driver.findElement(mobileLocator).click();

    }

    @Step("Get Notification Message on green bar")
    public void barNotificationAttribute() {
        Assert.assertEquals(barNotification.getText(), "The product has been added to your shopping cart");
    }


    public void clickShoppingCartLink() {
        shoppingCartLink.click();
        System.out.println("Shopping Cart link clicked");
    }

    public void clickCloseButton() {
        baseUI.click(closeButton);
    }


    public void numberInputFieldSetText(String text) {
        baseUI.sendText(numberInputField, text);
    }


    public void clickAddToCartButtonInSelectedPhone() {
        baseUI.click(addToCartButtonInSelectedPhone);
        System.out.println("Add To Cart Button clicked");
    }


    public String getQtyAttribute() {
        return qtyInputField.getAttribute("value");
    }


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


