package com.utils;

import java.util.List;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;



public class HotelPage extends BasicTest {

    WebDriver driver;
    WebDriverWait wait;


    By hotelList = By.xpath("//span[contains(@class,'pdv__hotel--name')]");
    By hotelDetailTitle = By.xpath("h1.ho2__title--hotel-name");

    public HotelPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }


    public void selectHotel() {
        // Chờ danh sách hotel hiển thị
        wait.until(ExpectedConditions.visibilityOfElementLocated(hotelList));
        List<WebElement> hotels = driver.findElements(hotelList);
        Random random = new Random();
        int randomIndex = random.nextInt(hotels.size());
        hotels.get(randomIndex).click();

        // Chuyển sang tab mới
        switchToNewTab();
    }

    private void switchToNewTab() {
        String originalTab = driver.getWindowHandle();
        wait.until(driver -> driver.getWindowHandles().size() > 1);
        for (String tab : driver.getWindowHandles()) {
            if (!tab.equals(originalTab)) {
                driver.switchTo().window(tab);
                break;
            }
        }
    }
}