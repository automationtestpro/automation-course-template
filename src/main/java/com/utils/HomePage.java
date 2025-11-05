package com.utils;

import java.time.LocalDate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


public class HomePage extends BasicTest {

    public HomePage(WebDriver givenDriver) {
        PageFactory.initElements(BasicTest.driver, this);
    }

    By locatorInp = By.xpath("//input[@placeholder='Bạn muốn đi đâu?']");
    By suggestion = By.xpath("//div[@class='sb-dropdown__item-box ng-star-inserted'][4]");
    By checkInDate = By.xpath("//button[contains(@class,'ds__btn-left')]");
    By checkOutDate = By.xpath("//button[contains(@class,'ds__btn-right')]");
    By searchBtn = By.xpath("//button[.//span[text()='Tìm']]");
    By hotelListPageTitle = By.xpath("//h1[@class='rmi__hotel-name']");
    

    public void selectSuggestion(String location){
        driver.findElement(locatorInp).click();
        waitElementVisible(suggestion);
        driver.findElement(suggestion).click();
    }

    public void selectDate(){
        driver.findElement(checkInDate).click();

        LocalDate today = LocalDate.now();
        LocalDate checkIn = today.plusWeeks(1);
        LocalDate checkOut = checkIn.plusDays(3);

        String checkInDay = checkIn.toString();
        String checkoutDay = checkOut.toString();

        By checkInLocator = By.xpath("//div[contains(@class,'day-item') and @id='" + checkInDay + "']"); 
        waitElementVisible(checkInLocator);
        driver.findElement(checkInLocator).click();

        driver.findElement(checkOutDate).click();
        By checkOutLocator =By.xpath("//div[contains(@class,'day-item') and @id='" + checkoutDay + "']");
        waitElementVisible(checkOutLocator);
        driver.findElement(checkOutLocator).click();

    }

    public void Search(){
        driver.findElement(searchBtn).click();
    }

    public boolean verifyHotelPage() {

        WebElement titleElement = waitElementVisible(hotelListPageTitle);
        String title = titleElement.getText();
        boolean verifyTitle = title.contains("Phú Quốc");
        return verifyTitle;
    
    }
}
