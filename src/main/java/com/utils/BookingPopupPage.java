package com.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BookingPopupPage extends BasicTest {


    public BookingPopupPage(WebDriver driver) {
    this.driver = driver; 
    PageFactory.initElements(driver, this);
}


    By popupTitle = By.xpath("//span[text()='Yêu cầu đặt Combo']");
    By nameInput = By.xpath("//input[@name='fullName']");
    By phoneInput = By.xpath("//input[@name='phoneNumber']");
    By emailInput = By.xpath("//input[@name='email']");
    By messageInput = By.xpath("//textarea[contains(@placeholder,'Ví dụ')]");

    public boolean isPopupDisplayed() {
        return waitElementVisible(popupTitle).isDisplayed();
    }

    // Verify các field hiển thị
    public boolean areFieldsDisplayed() {
        waitElementVisible(popupTitle); 
         return waitElementVisible(nameInput).isDisplayed()
            && waitElementVisible(phoneInput).isDisplayed()
            && waitElementVisible(emailInput).isDisplayed()
            && waitElementVisible(messageInput).isDisplayed();
    }


    // Lấy giá trị field verify thông tin)
    public String getName() {
        return waitElementVisible(nameInput).getAttribute("value");
    }

    public String getPhone() {
        return waitElementVisible(phoneInput).getAttribute("value");
    }

    public String getEmail() {
        return waitElementVisible(emailInput).getAttribute("value");
    }

    public String getMessage() {
        return waitElementVisible(messageInput).getAttribute("value");
    }

}