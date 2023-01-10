package nopCommerce;

import Base.BaseUI;
import Base.BrowserFactory;
import org.openqa.selenium.WebDriver;

public class TemplatePage extends BrowserFactory {
    BaseUI ui;

    public TemplatePage(WebDriver driver) {
        super(driver);
        // ui = new BaseUI(driver);
    }

}
