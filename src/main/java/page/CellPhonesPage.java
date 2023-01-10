package page;

import nopCommerce.TemplatePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class CellPhonesPage extends TemplatePage {
    public CellPhonesPage(WebDriver driver) {
        super(driver);
    }

    public void clickCellPhones() {
        WebElement cellPhones = driver.findElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[2]/ul/li[2]/a"));
        cellPhones.click();
        System.out.println("Cell Phones clicked");
    }

    public void selectCellPhones() {
        Actions action = new Actions(driver);
        WebElement electronics = driver.findElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[2]/a"));
        action.moveToElement(electronics).moveToElement(driver.findElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[2]/ul/li[2]/a"))).click().build().perform();
    }

    public void clickAddToCartButton() {
        WebElement addToCart = driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[2]/div/div[2]/div[3]/div[2]/button[1]"));
        addToCart.click();
        System.out.println("Add To Cart Button clicked");
    }

    public WebElement getBarNotification() {
        return driver.findElement(By.xpath("//*[@id=\"bar-notification\"]/div/p"));
    }

    public WebElement getCloseButton() {
        return driver.findElement(By.className("close"));
    }

    public void clickShoppingCartLink() {
        WebElement shoppingCartLink = driver.findElement(By.xpath("//*[@id=\"bar-notification\"]/div/p/a"));
        shoppingCartLink.click();
        System.out.println("Shopping Cart link clicked");
    }

    public void clickHTCOneMiniBlue() {
        WebElement htcOneMiniBlue = driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[2]/div/div[2]/h2/a"));
        htcOneMiniBlue.click();
        System.out.println("HTC One Mini Blue clicked");
    }

    public WebElement getNumberInputField() {
        return driver.findElement(By.xpath("//*[@id=\"product_enteredQuantity_19\"]"));
    }

    public void numberInputFieldSetText(String text) {
        WebElement numberInputField = getNumberInputField();
        numberInputField.sendKeys(text);
    }

    public void clickAddToCartButtonInSelectedPhone() {
        WebElement addToCart = driver.findElement(By.xpath("//*[@id=\"add-to-cart-button-19\"]"));
        addToCart.click();
        System.out.println("Add To Cart Button clicked");
    }

    public WebElement getQtyInputField() {
        return driver.findElement(By.className("qty-input"));
    }

    public String getQtyAttribute() {
        return getQtyInputField().getAttribute("value");
    }

    public void clickCheckbox() {
        WebElement checkbox = driver.findElement(By.xpath("//*[@id=\"termsofservice\"]"));
        checkbox.click();
        System.out.println("Checkbox clicked");
    }

    public void clickCheckoutButton() {
        WebElement checkoutButton = driver.findElement(By.id("checkout"));
        checkoutButton.click();
        System.out.println("Checkout button clicked");
    }
}


