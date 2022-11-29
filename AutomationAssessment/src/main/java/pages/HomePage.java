package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.BasePage;

import java.util.List;

import static helpers.BrowserNavigation.getDriver;

public class HomePage extends BasePage {

    public HomePage() {
        super();
    }

    //Email Address locator
    public WebElement emailAddress() {
        return getDriver().findElement(By.id("inputEmail"));
    }

    //Password locator
    public WebElement password() {
        return getDriver().findElement(By.id("inputPassword"));
    }

    //Sig-in button locator
    public WebElement signInButton() {
        return getDriver().findElement(By.xpath("//button[.='Sign in']"));
    }

    /***for test2***/
    //Returns List of items in the Test 2
    public List<WebElement> groupListItems() {
        return getDriver().findElements(By.cssSelector("li.list-group-item.justify-content-between"));
    }

    //Returns List of values/badges of items in the Test 2
    public List<WebElement> groupListItemsValue() {
        return getDriver().findElements(By.xpath("//span[@class='badge badge-pill badge-primary']"));
    }

    /****for test 3****/
    //Dropdown button locator
    public WebElement optionButton() {
        return getDriver().findElement(By.id("dropdownMenuButton"));
    }

   //Returns Dropdown options in the Test 3
    public List<WebElement> dropDownOptions() {
        return getDriver().findElements(By.xpath("//a[@class='dropdown-item']"));
    }

    /****for Test 4*****/
    public WebElement primaryButton() {
        return getDriver().findElement(By.xpath("//h1[.='Test 4']/following-sibling::button[@class='btn btn-lg btn-primary']"));
    }

    public WebElement secondaryButton() {
        return getDriver().findElement(By.xpath("//h1[.='Test 4']/following-sibling::button[@class='btn btn-lg btn-secondary']"));
    }

    /****** for test 5********/
    public WebElement test5Button() {
        return getDriver().findElement(By.id("test5-button"));
    }

    public WebElement alertMessage() {
        return getDriver().findElement(By.id("test5-alert"));
    }

    /****** for test 6*******/
    public WebElement tableData(int row, int column) {
        return getDriver().findElement(By.xpath("//table[@class='table table-bordered table-dark']/tbody/tr[" + row + "]/td[" + column + "]"));
    }


    /**********method starts here***********/

    /***** This step is to enter email address ***/
    public void enterEmailAddress(String email) {
        sendKeys(emailAddress(), email);
    }

    /***** This step is to enter password ***/
    public void enterPassword(String password) {
        sendKeys(password(), password);
    }

    /***** This step is to click option button and select option from dropdown based on it's index ***/
    public void selectOption(int optionIndex){
        click(optionButton());
        click(dropDownOptions().get(optionIndex));
    }

    /**
     * Using getRowData function we can get any cell data by passing Row and Columns numbers.
     * By passing Row and Column numbers we're returning Cell data/string
     * example: getRowData(1,2) returns 'Tinmouth' text in the given Test 6 table
     *
     * @param row    - Row number
     * @param column - column number
     * @return
     */
    public String getRowData(int row, int column) {
        return tableData(row, column).getText().trim();
    }
}
