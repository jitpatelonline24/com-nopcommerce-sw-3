package utilities;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Utility extends BaseTest {
    /**
     * This method will check on element
     */
    public void clickOnElement(By by){
        driver.findElement(by).click();
    }

    /**
     * This method will send text to element
     */
    public void sendTextToElement(By by,String text){
        driver.findElement(by).sendKeys(text);
    }

    /**
     * This method will get Text from Element
     */
    public String getTextFromElement(By by){
        return driver.findElement(by).getText();
    }
    /**
     * This method will find an element
     */
    public WebElement findElementFromWebPage(By by){
        return driver.findElement(by);
    }
    /**
     * This method will find list of elements
     */
    public List<WebElement> findElementsFromWebPage(By by){
        return driver.findElements(by);
    }
    /**
     * This method will verify the element
     */
    public void verifyElements(String displayMessage,String expectedMessage,By by){
        String actualMessage = getTextFromElement(by);
        Assert.assertEquals(displayMessage,actualMessage);
    }
    /**
     * This method will mouse hover on element
     */
    public void mouseHoverToElement(By by){
        Actions actions = new Actions(driver);
        WebElement mouseHover1 = driver.findElement(by);
        actions.moveToElement(mouseHover1).build().perform();
    }
    public void mouseHoverAndClick(By by){
        Actions actions = new Actions(driver);
        WebElement mouseHover2 = driver.findElement(by);
        actions.moveToElement(mouseHover2).click().build().perform();
    }
    /**
     * This method will select the option visible text from dropdown menu
     */
    public void selectByVisibleTextFromDropdown(By by,String text){
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByVisibleText(text);
    }
    public void verifyText(String expectedText, String actualText) {
    }

    public void mouseHoverOnElement(By by) {
        WebElement element = driver.findElement(by);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }

    /**
     * This method will mouse hover and click on the element
     */
    public void mouseHoverOnElementAndClick(By by) {
        WebElement element = driver.findElement(by);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();
    }

    //******************************** Select Class ********************************************//

    /**
     * This method will select the element from drop-down by VALUE
     */
    public void selectByValueFromDropDown(By by, String value) {
        WebElement dropdown = driver.findElement(by);
        Select select = new Select(dropdown);
        select.selectByValue(value);
    }

    /**
     * This method will select the element from drop-down by VISIBLE TEXT
     */
    public void selectByVisibleTextFromDropDown(By by, String value) {
        WebElement dropdown = driver.findElement(by);
        Select select = new Select(dropdown);
        select.selectByVisibleText(value);
    }

    /**
     * This method will select the element from drop-down by INDEX
     */
    public void selectByIndexFromDropDown(By by, int value) {
        WebElement dropdown = driver.findElement(by);
        Select select = new Select(dropdown);
        select.selectByIndex(value);
    }

    //******************************** DropDown Menu Without Select Tag ********************************************//

    /**
     * This method will select the element from drop-down which does not have SELECT tag
     */
    public void dropDownWithList(By by, String option) {
        List<WebElement> list = driver.findElements(by);
        for (WebElement e: list) {
            if(e.getText().equalsIgnoreCase(option)) {
                e.click();
                break;
            }
        }
    }

    //**************************** Asceding and Descending order ***********************************************//

    /**
     * This method will verify whether the elements are in DESCENDING ORDER or not
     */
    public boolean verifyTheListIsDescendingOrder(By by) {
        List<WebElement> list = driver.findElements(by);

        boolean isDecending = false;

        for (int i = 0; i < list.size()-1; i++) {
            System.out.println(list.get(i).getText());
            if (list.get(i).getText().compareTo(list.get(i + 1).getText()) < 0) {
                isDecending=true;
            }
        }
        return isDecending;
    }

    /**
     * This method will verify whether the elements are in ASCENDING ORDER or not
     */
    public boolean verifyTheListIsAscedingOrder(By by) {
        List<WebElement> list = driver.findElements(by);

        boolean isAsceding = false;

        for (int i = 0; i < list.size()-1; i++) {
            // System.out.println(list.get(i).getText());
            if (list.get(i).getText().compareTo(list.get(i + 1).getText()) > 0) {
                isAsceding=true;
            }
        }
        return isAsceding;
    }

    //********************************* Relative Locator *************************************//

    /**
     * This method will find the ABOVE element with reference to the given locator
     */
    public void findToAboveofElement(By exactLocation, By referenceLocation){
        driver.findElement(RelativeLocator.with(exactLocation).above(referenceLocation));
    }

    /**
     * This method will find the BELOW element with reference to the given locator
     */
    public void findToBelowofElement(By exactLocation, By referenceLocation){
        driver.findElement(RelativeLocator.with(exactLocation).below(referenceLocation));
    }

    /**
     * This method will find the NEAR element with reference to the given locator
     */
    public void findToNearofElement(By exactLocation, By referenceLocation){
        driver.findElement(RelativeLocator.with(exactLocation).near(referenceLocation));
    }

    /**
     * This method will find the RIGHT SIDE element with reference to the given locator
     */
    public void findToRightOfElement(By exactLocation, By referenceLocation){
        driver.findElement(RelativeLocator.with(exactLocation).toRightOf(referenceLocation));
    }

    /**
     * This method will find the LEFT SIDE element with reference to the given locator
     */
    public void findToLeftOfElement(By exactLocation, By referenceLocation){
        driver.findElement(RelativeLocator.with(exactLocation).toLeftOf(referenceLocation));
    }

    //************************ Verify the Message or Title **********************************//

    /**
     * This method will verify the two text from the elements
     */
    public void verifyTheStringMessage(By by, String actualMessage) {
        String expected = getTextFromElement(by);
        String expectedString = expected.substring(0, actualMessage.length());
        Assert.assertEquals(expectedString, actualMessage);
    }
}

