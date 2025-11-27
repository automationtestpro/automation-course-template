package com.pages.Tikipage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions; 
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.pages.BasePage;


public class CartPage extends BasePage{
    public CartPage(WebDriver givenDriver) {
        super(givenDriver);
    }

//public By cartItem = By.xpath("//img[@class='menu-item-icon cart-icon']");
public By plusBtnItem = By.xpath("//button[./img[@alt='add-icon']]");
public By UnitPrice = By.xpath("//div[@class='product-price__current-price']");
public By TotolPrice = By.xpath("//div[@class='sc-31ecf63b-1 fgrIVW']");
public By Quantity = By.xpath("//input[@class='input']");
public By BoderItem = By.xpath("(//div[@class='border'])[1]");

// steps click additem
public int addItemCart() {
    ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 100);");
        int targetClicks = 3; 
        
        // 1. Lấy số lượng ban đầu
        String initialQuantityStr = Quantity();
        int currentQuantity = Integer.parseInt(initialQuantityStr.trim());
        
        for (int i = 1; i <= targetClicks; i++) {
            
            // Tìm lại WebElement để tránh Stale Element Reference
            WebElement plusButton = wait.until(ExpectedConditions.elementToBeClickable(plusBtnItem)); 
            
            // 2. Click bằng JavaScript
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", plusButton);
            
            // 3. Tính toán số lượng kỳ vọng sau lần click này
            currentQuantity++; 
            String expectedNewQuantity = String.valueOf(currentQuantity);
            
            // 🚀 THAY THẾ Thread.sleep bằng Explicit Wait
            // Chờ cho thuộc tính 'value' của ô Quantity cập nhật thành số lượng mới
            try {
                wait.until(ExpectedConditions.attributeToBe(Quantity, "value", expectedNewQuantity));
            } catch (Exception e) {
                // Nếu timeout, in ra lỗi và ném lại (hoặc log)
                System.err.println("Timeout: Số lượng không cập nhật lên " + expectedNewQuantity);
                throw e; // Ném lỗi để dừng test
            }

            // 4. (Tùy chọn) Thread.sleep(100) có thể được sử dụng ở đây nếu cần ổn định UI
            // Không cần thiết nếu đã dùng Explicit Wait
        }
        
        // Trả về số lượng cuối cùng (ví dụ: 4)
        return currentQuantity; 
    }
    // PHƯƠNG THỨC LẤY GIÁ TRỊ GIÁ SẢN PHẨM (UnitPrice) 
public String getUnitPrice() {
        return findElement(UnitPrice).getText();
    }
    
    // PHƯƠNG THỨC LẤY GIÁ TRỊ TỔNG TIỀN (TotolPrice)
public String getTotalPrice() {
        return findElement(TotolPrice).getText();
    }    
public String Quantity() {
        return findElement(Quantity).getAttribute("value");
    }    
public CartPage clickBorder() {

        wait.until(ExpectedConditions.elementToBeClickable(BoderItem)).click();
        return this;
    }
public CartPage clickPlus(){
    wait.until(ExpectedConditions.elementToBeClickable(plusBtnItem)).click();
        return this;
}
}
