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


    @FindBy(xpath = "//a[text()='Electronics ']")
    WebElement electronics;
    @FindBy(xpath = "//a[text()='Cell phones ']")
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
    @FindBy(xpath = "//*[@id='checkout']")
    WebElement checkoutButton;
    @FindBy(xpath = "//*[@class='qty-input']")
    WebElement qtyInputField;
    @FindBy(xpath = "//*[@id='termsofservice']")
    WebElement checkbox;
    @FindBy(xpath = "//h2[@class='product-title'] //a")
    List<WebElement> productTitle;
    @FindBy(xpath = "//div[@class='item-box'] //*[@class='button-2 product-box-add-to-cart-button']")
    List<WebElement> addToCartButton;
    @FindBy(xpath = "//ul[@class='top-menu notmobile']//li")
    List<WebElement> topMenuCategories;


    public CellPhonesPage(WebDriver driver) {
        super(driver);
        baseUI = new BaseUI(driver);
    }

    @Step("Method to click category after hover category ")
    public CellPhonesPage chooseCategory(String menuName, String category) throws InterruptedException {
        boolean productFound = false;

        System.out.println(topMenuCategories.size());
        first:
        for (int i = 0; i < topMenuCategories.size(); i++) {
            WebElement li = topMenuCategories.get(i);
            WebElement menu = li.findElement(By.xpath(".//a"));
//            System.out.println(menu.getText());
            if (menu.getText().equals(menuName)) {
                productFound = true;
                Actions action = new Actions(driver);
                action.moveToElement(menu).perform();
                System.out.println("Menu category: '" + menuName + " found");

                List<WebElement> elements = li.findElements(By.xpath("//ul[@class='sublist first-level']//li//a"));
                for (WebElement element : elements) {
                    if (category.equals(element.getText())) {
                        baseUI.click(element);
                        break first;
                    }
                    System.out.println(element.getText());
                }
            }
        }
        if (!productFound) {
            Assert.fail("Unsupported category " + category);
        }
        return this;
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

    @Step("Click shopping cart link in green bar")
    public void clickShoppingCartLink() {
        shoppingCartLink.click();
        System.out.println("Shopping Cart link clicked");
    }

    @Step("Click x button in green bar")
    public void clickCloseButton() {
        baseUI.click(closeButton);
    }

    @Step("Setting number in input field")
    public void numberInputFieldSetText(String text) {
        baseUI.sendText(numberInputField, text);
    }

    @Step("Select add to cart button in product page")
    public void clickAddToCartButtonInSelectedPhone() {
        baseUI.click(addToCartButtonInSelectedPhone);
        System.out.println("Add To Cart Button clicked");
    }

    @Step("Click I agree with the terms of service checkbox")
    public void termsOfServiceCheckbox() {
        baseUI.click(checkbox);
        System.out.println("Checkbox clicked");
    }

    @Step("Click checkout button")
    public void clickCheckoutButton() {
        checkoutButton.click();
        System.out.println("Checkout button clicked");
    }
}


