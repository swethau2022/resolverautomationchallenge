package helpers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserNavigation {
    private BrowserNavigation() {
    }

    private static WebDriver driver;


    /**
     * TheadLocal allows us to store WebDriver that will be accessible only by a specific thread
     */
    private static ThreadLocal<WebDriver> th = new ThreadLocal<WebDriver>();

    /**
     * This function is used for Set-up chrome driver
     */
    private static void setUpChromeDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        th.set(driver);
    }

    /**
     * This function gets the chromeDriver and returns WebDriver instance
     * @return
     */
    public static WebDriver getDriver() {
        if (th.get() == null)
            BrowserNavigation.setUpChromeDriver();
        return th.get();
    }

    /**
     * This function driver closes the driver and removes the local Thread
     */
    public static void closeDriver() {
        th.get().close();
        th.remove();
    }
}
