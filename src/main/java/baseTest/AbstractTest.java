package baseTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractTest {
    protected WebDriver driver;
    public WebDriverWait webDriverWait ;

    public AbstractTest(WebDriver driver) {
        this.driver = driver;
    }
    public void openUrl(String url) {
        driver.get(url);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
    protected void clickElement(By locator) {
        webDriverWait = new WebDriverWait(driver,30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(locator));
        findElementByLocator(locator).click();
    }

    protected  void waitForElementVisible(By locator) {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected WebElement findElementByLocator(By locator) {
        return driver.findElement(locator);
    }


    public void sendKeyToElement(By locatorType, String textValue) {
        waitForElementVisible(locatorType);
        WebElement element = findElementByLocator(locatorType);
        element.clear();
        element.sendKeys(textValue);
    }

    public String getElementValidationMessage(By locator ) {
        webDriverWait = new WebDriverWait(driver,30);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        String text = findElementByLocator(locator).getText();
        return text;
    }




}
