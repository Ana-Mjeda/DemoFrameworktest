package Base;

import nopCommerce.TemplatePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TopMenu extends TemplatePage {
    public TopMenu(WebDriver driver) {
        super(driver);
    }

    public WebElement getElectronicsMenu() {
        return driver.findElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[2]/a"));
    }

    public void clickElectronics() {
        WebElement myElectronics = driver.findElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[2]/a"));
        myElectronics.click();
        System.out.println("Electronics menu clicked");
    }

}
