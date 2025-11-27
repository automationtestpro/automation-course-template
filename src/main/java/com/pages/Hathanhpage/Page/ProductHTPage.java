package com.pages.Hathanhpage.Page; // Đã đổi package

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
// Xóa import cho WebElement và FindBy
import org.openqa.selenium.support.ui.ExpectedConditions;
// Xóa import của Assert (không nên Assert trong Page)

import com.pages.BasePage;

// Đổi tên class để khớp với cấu trúc mới
public class ProductHTPage extends BasePage {

    public ProductHTPage(WebDriver givenDriver) {
        super(givenDriver);
    }

   
    public By optionElementBy = By.xpath("//select[@id='pa_xuat-xu']");

    public By resultEnglBy = By.xpath("//select[@id='pa_xuat-xu']/option[2]");

    public By addToCartLocator = By.xpath("//button[@class='single_add_to_cart_button button alt']");
        

    public ProductHTPage option_Element() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(optionElementBy)).click();
        return this;
    }

    public ProductHTPage result_Engl() {
        wait.until(ExpectedConditions.elementToBeClickable(resultEnglBy)).click();
        return this;
    } 
    
    public ProductHTPage addToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(addToCartLocator)).click();
        return this;
    }

    public boolean isElementDisplayed(By by) {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(by)).isDisplayed();
        } catch (Exception e) {
            return false;// TODO: handle exception
        }
    } 
}