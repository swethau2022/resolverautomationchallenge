package utilities;

import helpers.BrowserNavigation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class BasePage {
    public WebDriver driver;

    public BasePage(){
        driver = BrowserNavigation.getDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
    }

    protected void click(WebElement wb){
        wb.click();
    }

    protected void sendKeys(WebElement wb, String textToType) {
        wb.sendKeys(textToType);
    }

    protected String getText(WebElement wb) {
        return wb.getText();
    }

    protected String readValue(WebElement wb) {
        return wb.getAttribute("value");
    }

    protected void moveToElement(WebElement wb){
        Actions act = new Actions(driver);
        act.moveToElement(wb).build().perform();
    }
}
