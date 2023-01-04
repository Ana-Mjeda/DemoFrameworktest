package nopCommerce;

import Base.BaseUI;
import Base.BrowserFactory;
import io.qameta.allure.Step;
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

    @FindBy(xpath = "")
    WebElement loginButton;
    @FindBy(xpath = "")
    List<WebElement> loginButtonList;

    /**
     * @param userName    use param to describe parameter if function requires it
     * @param userMessage message that will be displayed
     * @author Marko Javorina
     * @date 26.08.2022
     * @description This is a description of templateFunction
     */
    @Step("Clicking on Login Button {0}, {1}")
    public TemplatePage clickLoginButton(String userName, String userMessage) {
        System.out.println("hello");

        return this;
    }

    public TemplatePage clickLogin() {
        System.out.println("there");

        return this;
    }

    //            public TemplatePage clickLoginButton() {
//                System.out.println("hello");
//                loginButton.click();
//                //ui.click(loginButton);
//                return this;
//            }
}
