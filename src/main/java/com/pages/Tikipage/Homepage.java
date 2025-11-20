package com.pages.Tikipage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions; // Import cần thiết cho Actions
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.pages.BasePage;


public class Homepage extends BasePage{
    public Homepage(WebDriver givenDriver) {
        super(givenDriver);
    }


public By categoryItem  = By.xpath("//div[text()='Điện Thoại - Máy Tính Bảng']");


public String url ="https://tiki.vn/";
        public Homepage open(String url) {
            driver.get(url);
            return this;
        }
// steps hover "Danh cho nam"
public Homepage clickCategory() {
        wait.until(ExpectedConditions.elementToBeClickable(categoryItem)).click();
        return this;
    }  



}
