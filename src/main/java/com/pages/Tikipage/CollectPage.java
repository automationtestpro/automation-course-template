package com.pages.Tikipage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v117.domstorage.model.Item;
import org.openqa.selenium.interactions.Actions; 
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.pages.BasePage;


public class CollectPage extends BasePage{
    public CollectPage(WebDriver givenDriver) {
        super(givenDriver);
    }


public By MenuItem = By.xpath("(//div[@class='sc-9f1e84db-3 jhfSVS'])[1]");
public By ItemView = By.xpath("(//div[@class='sc-d785edce-0 gjLnmh'])[1]");
// steps click item
public CollectPage clickMenu() {

        wait.until(ExpectedConditions.elementToBeClickable(MenuItem)).click();
        return this;
    }   
// choose one item
public CollectPage clickItem() {
      
    WebElement scrollElement = driver.findElement(ItemView);
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scrollElement);
    //Thread.sleep(500); 
        // 6. Click: Tìm lại phần tử và chờ clickability
        wait.until(ExpectedConditions.elementToBeClickable(ItemView)).click(); 
        return this;
        // WebElement clickableElement = wait.until(ExpectedConditions.elementToBeClickable(ItemView)); 
        // js.executeScript("arguments[0].click();", clickableElement);
    }
}