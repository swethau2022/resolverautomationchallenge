import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.BaseTest;

public class AssessmentTest extends BaseTest {
    HomePage page = new HomePage();

    @Test
    public void testOne() {
        verifyTrue(page.emailAddress().isDisplayed(), "Email Address input is not displayed");
        verifyTrue(page.password().isDisplayed(), "password is not displayed");
        verifyTrue(page.signInButton().isDisplayed(), "SignIn button is not displayed");
        page.enterEmailAddress("swetha@gmail.com");
        page.enterPassword("123445");
    }

    @Test
    public void testTwo() {
        verifyEquals(page.groupListItems().size(), 3, "Count is more than expected");
        verifyEquals(page.groupListItems().get(1).getText().trim(), "List Item 2 6", "text is not displayed correctly");
        verifyEquals(page.groupListItemsValue().get(1).getText().trim(), "6", "value is not displayed correctly");
    }

    @Test
    public void testThree() {
        verifyEquals(page.optionButton().getText().trim(), "Option 1", "Option 1 is not displayed");
        page.selectOption(2); //selects option 3
        verifyEquals(page.optionButton().getText().trim(), "Option 3", "Option 3 is not displayed");
    }

    @Test
    public void testFour() {
        verifyTrue(page.primaryButton().isEnabled(), "Button1 is not selected");
        verifyFalse(page.secondaryButton().isEnabled(), "Button1 is selected");

    }

    @Test
    public void tesFive() {
        waitTo().until(ExpectedConditions.elementToBeClickable(page.test5Button())).click();
        verifyEquals(page.alertMessage().getText().trim(), "You clicked a button!", "success message not displayed");
        verifyFalse(page.test5Button().isEnabled(), "button is enabled");
    }

    @Test
    public void testSix() {
        verifyEquals(page.getRowData(3, 3), "Ventosanzap", "Ventosanzap text is not displayed");
    }
}
