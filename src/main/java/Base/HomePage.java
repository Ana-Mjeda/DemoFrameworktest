package Base;

import nopCommerce.TemplatePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends TemplatePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickRegisterButton() {
        WebElement registerButton = driver.findElement(By.className("ico-register"));
        registerButton.click();
        System.out.println("Register button clicked");
    }
}
