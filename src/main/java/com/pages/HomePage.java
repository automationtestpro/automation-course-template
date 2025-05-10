package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends PageBase {
    
    public HomePage(WebDriver givenDriver) { // constructor
        super(givenDriver);
    }

    // Locators
    private By clickSearch=By.xpath("(//input[@id='s'])[1]");
    private By selectitem =By.xpath("//a[contains(text()=\"Bơm nước xe \"]");
    private By selectitem1 =By.xpath("//select[@id=\"pa_xuat-xu\"]");
    private By selecoption =By.xpath("//option[@value=\"england\"]");
    private By clickbtn=By.xpath("(//button[@type=\"submit\"])[2]");


    // Methods
    public HomePage clickSearch(String keyword) {
        findElement(clickSearch).sendKeys(keyword);
        return this;
    }

    public HomePage clickItem() {
        findElement(selectitem).click();
        return this;
    }

    public HomePage clickItem1() {
        findElement(selectitem1).click();
        return this;
    }
    public HomePage selectOption(){
        findElement(clickbtn).click();
        return this;
        
    }

     public HomePage clickItemlist(String itemlist) {
        String locator = "//a[contains(text(),'" + itemlist + "')]";
        findElement(By.xpath(locator)).click();
        return this;
    }

    public HomePage clickXs(String itemlist1)
    {
        String locator1 = "//option[@value='" + itemlist1 + "']";
        findElement(By.xpath(locator1)).click();
        return this;
    }
  
}