package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.PropertiesReader;

import java.util.List;

public abstract class BasePage {

    private WebDriver driver;
    private WebDriverWait wait;
    private static final int TIMEOUT = 15;
    private static final int POLLING = 100;
    private PropertiesReader propertiesReader = new PropertiesReader();
    private static final Logger log = Logger.getLogger(LoginPage.class);

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, TIMEOUT, POLLING);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, TIMEOUT), this);
    }

    public PropertiesReader getPropertiesReader() {
        return propertiesReader;
    }

    //wait visibility
    public void waitVisibility(By elementBy) {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(elementBy));
    }

    public boolean isElementDisplayed(By elementBy) {
        waitUntilElementDisplay(elementBy);
        return this.driver.findElement(elementBy).isDisplayed();
    }

    private void waitUntilElementDisplay(By elementBy) {
        int counter = 0;
        System.out.println(counter);
        while (true) {
            try {
                counter++;
                System.out.println(counter);
                this.driver.findElement(elementBy); //NoSuchElementException
                break;
            } catch (NoSuchElementException e) {
                System.out.println(counter + "-> Element" + elementBy.toString() + " not found!");
                if (counter > 1000) {
                    break;
                }
            }
        }
        waitVisibility(elementBy);
    }

    //click
    public void click(By elementBy) throws InterruptedException {
        //waitUntilElementDisplay(elementBy);
        Thread.sleep(1000);
        this.driver.findElement(elementBy).click();
    }

    //write text
    public void writeText(By elementBy, String text) {
        waitVisibility(elementBy);
        this.driver.findElement(elementBy).sendKeys(text);
    }

    //read text
    public String readText(By elementBy) {
//        waitVisibility(elementBy);
        return this.driver.findElement(elementBy).getText();
    }

    //scrolls
    public void scrollByValues(String from, String to) {
        JavascriptExecutor js = (JavascriptExecutor) this.driver;
        js.executeScript("window.scrollBy(" + from + ", " + to + ")");
    }

    public void scrollDown(String from) {
        JavascriptExecutor js = (JavascriptExecutor) this.driver;
        js.executeScript("window.scrollBy(" + from + ", document.body.scrollHeight)");
    }

    public void scrollUp(String from) {
        JavascriptExecutor js = (JavascriptExecutor) this.driver;
        js.executeScript("window.scrollBy(" + from + ", -document.body.scrollHeight)");
    }

    public void scrollElement(By elementBy) {
        JavascriptExecutor js = (JavascriptExecutor) this.driver;
        js.executeScript("arguments[0].scrollIntoView(true);", elementBy);
    }

    //read Attribute
    public String readAttribute(By elementBy, String attribute) {
        waitVisibility(elementBy);
        return this.driver.findElement(elementBy).getAttribute(attribute);
    }

    //read CssValue
    public String readCSSValue(By elementBy, String style) {
        waitVisibility(elementBy);
        return this.driver.findElement(elementBy).getCssValue(style);
    }

    //assert
    public void assertEquals(By elementBy, String expectedText) {
        waitVisibility(elementBy);
        Assert.assertEquals(readText(elementBy), expectedText);
    }

    public void waitForElementToAppear(By elementBy) {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(elementBy));
    }

    public void waitForElementToDisappear(By elementBy) {
        this.wait.until(ExpectedConditions.invisibilityOfElementLocated(elementBy));
    }

    public void waitForTextToDisappear(By elementBy, String text) {
        this.wait.until(ExpectedConditions.not(ExpectedConditions.textToBe(elementBy, text)));
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void assertElementsDisplayed(List<By> byList) {

        boolean isElementDisplayed = true;
        WebElement element;
        for (By e : byList) {
            try {
                element = getDriver().findElement(e);
                log.info(e + " - is present on page");
            } catch (NoSuchElementException ex) {
                System.out.println(e + " - not found");
                log.info(e + " - not found");
                isElementDisplayed = false;
                //break
            }
        }
        Assert.assertTrue(isElementDisplayed);
    }

    public void clearField(By elementBy) {
        waitVisibility(elementBy);
        driver.findElement(elementBy).clear();
    }
}


