package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BrowserFactory {

    public static WebDriver driver;
    public static WebDriverWait wait;
    public static final int defaultWaitTime = 30;
    public static final int defaultImplicitWaitTime = 30;
    public static String browserName = "chrome";

    public BrowserFactory(WebDriver driver) {
        // ponudio intelliJ da se promeni this -> BrowserFactory
        BrowserFactory.driver = driver;
        PageFactory.initElements(BrowserFactory.driver, this);
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static WebDriver startBrowser(String url) {
        String browser = "";
        // zasto imamo ovo ako smo vec gore izmenili da je default "chrome"?
        if (browserName == null) {
            browserName = "chrome";
        }

        if (browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            browser = "Google Chrome";
        } else if (browserName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            browser = "Mozilla FireFox";
        }
        System.out.println("Opening --" + url + "-- on " + browser + " browser");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(defaultImplicitWaitTime));
        wait = new WebDriverWait(driver, Duration.ofSeconds(defaultWaitTime));

        driver.manage().window().maximize();
        driver.navigate().refresh();
        driver.get(url);

        return driver;
    }
}
