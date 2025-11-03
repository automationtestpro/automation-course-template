package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.Keys;
public class Homepage extends BasePage {

    //public  WebDriver driver;

    public Homepage(WebDriver givenDriver) {
        super(givenDriver);
    }

    //By username = By.xpath("//input[@id='username']");
    
    public By address = By.xpath("//*[@placeholder='Bạn muốn đi đâu?']");
    public By checkin = By.xpath("(//div[@class='sb-dropdown__result-item ng-star-inserted'])[1]");
    public By date = By.xpath("(//*[@type='button'])[1]");
    public By fistdate = By.xpath("//div[@id='2025-11-12']");
    public By seconddate = By.xpath("//div[@id='2025-11-15']");
    public By searchBy = By.xpath("(//span[contains(text(),'Tìm')])[1]");

    public void fillAddress(String string) {
       //findElement(address).sendKeys(string, Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOfElementLocated(address)).sendKeys(string);
    }
    public void clickCheckin() {
        
        wait.until(ExpectedConditions.elementToBeClickable(checkin)).click();
        //findElement(checkin).click();
    }
    public void clickDate() {   
        //findElement(date).click();
        wait.until(ExpectedConditions.elementToBeClickable(date)).click();
    }
    public void clickDatefirst() {   
        //findElement(fistdate).click();
        wait.until(ExpectedConditions.elementToBeClickable(fistdate)).click();
    
    }
    public void clickDatesecond() {   
        //findElement(seconddate).click();
        wait.until(ExpectedConditions.elementToBeClickable(seconddate)).click();
    }

    public void search() {
        // TODO Auto-generated method stub
        findElement(searchBy).click();
        wait.until(ExpectedConditions.elementToBeClickable(searchBy)).click();  
    }
    
}
