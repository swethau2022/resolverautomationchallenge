package utilities;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import helpers.BrowserNavigation;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.List;

import static helpers.BrowserNavigation.getDriver;

public class BaseTest {

    @BeforeClass
    public void setup() {
        BrowserNavigation.getDriver();
    }

    @BeforeMethod
    public void getHomePage() {
        BrowserNavigation.getDriver().get(System.getProperty("user.dir") + "\\app\\QE-index.html");
    }

    @AfterClass
    public void teardown() {
        BrowserNavigation.closeDriver();
    }

    public void verifyEquals(String actual, String expected, String message) {
        Assert.assertEquals(actual, expected, message);
    }

    public void verifyEquals(int actual, int expected, String message) {
        Assert.assertEquals(actual, expected, message);
    }

    public void verifyEquals(List<String> actual, List<String> expected, String message) {
        Assert.assertEquals(actual, expected, message);
    }

    public void verifyTrue(Boolean actual, String message) {
        Assert.assertTrue(actual, message);
    }

    public void verifyFalse(Boolean actual, String message){
        Assert.assertFalse(actual, message);
    }

    public WebDriverWait waitTo(){
        WebDriverWait w;
        return w = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
    }
}
