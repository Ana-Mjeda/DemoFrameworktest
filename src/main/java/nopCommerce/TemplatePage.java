package nopCommerce;

import Base.BaseUI;
import Base.BrowserFactory;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TemplatePage extends BrowserFactory {
    BaseUI ui;

    public TemplatePage(WebDriver driver) {
        super(driver);
        // ui = new BaseUI(driver);
    }

}
