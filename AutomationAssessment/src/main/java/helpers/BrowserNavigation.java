package helpers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserNavigation {
    private BrowserNavigation() {
    }

    private static WebDriver driver;

    private static ThreadLocal<WebDriver> th = new ThreadLocal<WebDriver>();

    private static void setUpChromeDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        th.set(driver);
    }

    public static WebDriver getDriver() {
        if (th.get() == null)
            BrowserNavigation.setUpChromeDriver();
        return th.get();
    }

    public static void closeDriver() {
        th.get().close();
        th.remove();
    }
}
