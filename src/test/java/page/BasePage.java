package page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import testValues.TestValues;

import java.util.List;
import java.util.NoSuchElementException;

public abstract class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;


    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 25);
    }

    //Waiting for elements to appear
    public void waitVisability(WebElement webElement){
        WebDriverWait waitForClick = new WebDriverWait(driver, 25);
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    //Hovering the mouse over an element
    public void mouseOver(WebElement webElement){
        waitVisability(webElement);
        Actions actions = new Actions(driver);
        actions.moveToElement(webElement).build().perform();
    }

    //Click Method
    public void clickElement(WebElement webElement){
        mouseOver(webElement);
        Actions actions = new Actions(driver);
        actions.moveToElement(webElement).click().build().perform();
//        webElement.click();
    }

   //Is element Displayed
   public void isElementDisplayed(WebElement webElement){
       waitVisability(webElement);
       webElement.isDisplayed();
   }

   //Is element getText
   public String isElementGetText(WebElement webElement){
       waitVisability(webElement);
       return webElement.getText();
   }

    public void writeText(WebElement webElement, String text){
        clickElement(webElement);
//        webElement.clear();
        webElement.sendKeys(text);
    }

    //Press ctrl and enter for choose Participants
    public void chooseValue(WebElement webElement, String text){
        writeText(webElement, text);
        webElement.sendKeys(Keys.ARROW_DOWN);
        webElement.sendKeys(Keys.ENTER);
    }

//    //select values from the ajax list
    public void selectValue(String xpathSearch, String text){
//        Actions actions = new Actions(driver);
        List<WebElement> listStage = driver.findElements(By.xpath(xpathSearch));
        for (WebElement st : listStage) {
            if (st.getText().equals(text)) {
                wait.until(ExpectedConditions.elementToBeClickable(st));
                clickElement(st);
//                actions.moveToElement(st).click().build().perform();
                break;
            }
        }
    }

//    //select values from the ajax list
//    public void selectValue(WebElement webElement, String text){
//        List<WebElement> countA = driver.findElements((By) webElement);
//        Select select = new Select(webElement);
//        for (int i=0; i<countA.size(); i++) {
//            if(countA.contains(text)) {
//                select.click();
//            }
//        }
//    }

////    //select values from the ajax list
//    public void selectValue(WebElement webElement, String text){
//        WebElement webElement1 = driver.findElement((By) webElement);
//        Select dropdown = new Select(webElement1);
//        dropdown.selectByVisibleText(text);
//    }
}
