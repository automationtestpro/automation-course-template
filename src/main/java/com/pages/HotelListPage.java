    package com.pages;

    import org.checkerframework.checker.units.qual.s;
    import org.openqa.selenium.By;
    import org.openqa.selenium.WebDriver;

    import com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Basic;
    import com.utils.BasicTest;

    import org.openqa.selenium.support.ui.ExpectedConditions;
    
    import org.openqa.selenium.JavascriptExecutor;
    import org.openqa.selenium.WebElement;
     public class HotelListPage extends BasePage {

        public HotelListPage(WebDriver givenDriver) {
            super(givenDriver);
        }

    
        public By continueBy = By.xpath("(//a[@class='pdv__box ng-star-inserted'])[1]");// khách sạn
        public void continueBy() {
            //findElement(continueBy).click();  
            wait.until(ExpectedConditions.elementToBeClickable(continueBy)).click();
            // wait 2 tab -> new tab
            wait.until(ExpectedConditions.numberOfWindowsToBe(2));
       // use driver give handle.
            java.util.Set<String> handles = driver.getWindowHandles();
        String originalHandle = driver.getWindowHandle();
        // switch to new tab see ID -> handle and if handle != original handle -> switch
        for (String handle : handles) {
            if (!handle.equals(originalHandle)) {
                driver.switchTo().window(handle);
                break; // switch to new tab and break
            }
        }
    }
}