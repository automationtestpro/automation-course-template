package com.pages.Hathanhpage.Page; // Đã đổi package

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement; // Vẫn cần cho hàm getCurrentCartQuantity
import org.openqa.selenium.support.ui.ExpectedConditions;


import com.pages.BasePage;

public class CartHTPage extends BasePage { // Đã đổi tên class

    public CartHTPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    // public void xpathCart (WebDriver driver) {
    //     plusItemBy = By.xpath("//button[@class='plus']");
    //     updateCartButtonLocator = By.xpath("//button[text()='Cập nhật giỏ hàng']");
    //     cartQuantityBy = By.xpath("//a[@title='Giỏ hàng của baise']/b");
    //     unitPriceBaseBy = By.xpath("(//span[@class='woocommerce-Price-amount amount'])[1]");
    //     tempPriceElementBy = By.xpath("(//td[@data-title='Tạm tính'])[1]");
    //     nameItemBy = By.xpath("//a[contains(text(),'Bơm nước xe Mercedes SLK200, SLK300, GLK200, E260, C350-2742000207 - England')]");
    // }


    public By plusItemBy = By.xpath("//button[@class='plus']");
    public By updateCartButtonLocator = By.xpath("//button[text()='Cập nhật giỏ hàng']");
    public By cartQuantityBy = By.xpath("//a[@title='Giỏ hàng của bạn']/b");
    public By unitPriceBaseBy = By.xpath("(//span[@class='woocommerce-Price-amount amount'])[1]");
    public By tempPriceElementBy = By.xpath("(//td[@data-title='Tạm tính'])[1]");
    public By nameItemBy = By.xpath("//a[contains(text(),'Bơm nước xe Mercedes SLK200, SLK300, GLK200, E260, C350-2742000207 - England')]");

    //public int expectedQuantity = 0; 
    public CartHTPage plusItem() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(plusItemBy)).click();
        return this;
    }

    public CartHTPage updateCart() {
        wait.until(ExpectedConditions.elementToBeClickable(updateCartButtonLocator)).click();
        return this;
    } 
    
    public String getUnitPriceBaseText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(unitPriceBaseBy)).getText();
    }
    
    public String getTempPriceText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(tempPriceElementBy)).getText();
    }
    
    public String getNameItemcart() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(nameItemBy)).getText();
    }
    
    public boolean isUpdateCartDisabled() {
        try {
            wait.until(ExpectedConditions.attributeToBe(updateCartButtonLocator, "disabled", "true"));
            return true; 
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean isCartQuantityTextCorrect(String expectedText) {
        try {
            // Sửa lại: Dùng ...ElementLocated(By by, ...)
            wait.until(ExpectedConditions.textToBePresentInElementLocated(cartQuantityBy, expectedText));
            return true; 
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isElementDisplayed(By by) {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(by)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    } 
    
    public double parsePrice(String priceText) {
        String cleanedPrice = priceText.replace("₫", "").replace(".", "").replace(",", "").trim();
        return Double.parseDouble(cleanedPrice);
    }
    
    public int getCurrentCartQuantity() {
        try {
            // Dùng By locator để tìm element
            WebElement cartElement = wait.until(ExpectedConditions.visibilityOfElementLocated(cartQuantityBy));
            // Lấy text từ element đã tìm được
            String cartQuantityText = cartElement.getText().trim();
            
            if (cartQuantityText.isEmpty()) {
                return 0;
            }
            return Integer.parseInt(cartQuantityText);
        } catch (Exception e) {
            return 0; 
        }
    }   
}