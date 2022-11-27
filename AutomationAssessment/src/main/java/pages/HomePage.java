package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.BasePage;

import static helpers.BrowserNavigation.getDriver;

public class HomePage extends BasePage {

    public HomePage() {
        super();
    }

    public WebElement emailAddress(){
        return getDriver().findElement(By.id("inputEmail"));
    }

    public WebElement password() {
        return getDriver().findElement(By.id("inputPassword"));
    }

    public void enterEmailAddress(String email){
        sendKeys(emailAddress(), email);
    }

    public void enterPassword(String password){
        sendKeys(password(), password);
    }
}
