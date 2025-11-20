package com;

import org.testng.Assert;
import org.testng.annotations.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement; 
import org.openqa.selenium.interactions.Actions; 
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.utils.BasicTest;
import com.utils.Utils;

public class Bai21_BreadcrumbTest extends BasicTest {
    @Test()
    public void breadcrumbTest() throws Exception {
        // Launch website
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);

        // Input username & Password & Login
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='username']"))).sendKeys("mdangdn29@gmail.com");
        WebElement passwordInp = driver.findElement(By.xpath("//*[@id='password']"));
        passwordInp.sendKeys("D@ng291199");
        WebElement loginBtn = driver.findElement(By.xpath("//button[text()='Đăng nhập']"));
        loginBtn.click();
        
        // Chờ nút login biến mất
        boolean isLoginDisplay = isElementDisplayed(By.xpath("//button[text()='Đăng nhập']"));
        Assert.assertFalse(isLoginDisplay);
        
        // --- XỬ LÝ CHUỖI TƯƠNG TÁC MENU (Bổ sung Scroll trước khi Clickable) ---
        
        By menuItemLocator = By.xpath("//a[text()='Hệ thống truyền động, Khung gầm']");
        
        // 1. Tìm MenuItem, Cuộn đến nó, sau đó Chờ Clickable
        WebElement MenuItem = driver.findElement(menuItemLocator);
        // Cuộn để đảm bảo phần tử nằm trong viewport và kích hoạt render
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", MenuItem); 

        // Chờ MenuItem hiển thị và sẵn sàng tương tác (Dòng 41 cũ - đã được Scroll)
        MenuItem = wait.until(ExpectedConditions.elementToBeClickable(menuItemLocator));
        String MenuItemText = MenuItem.getText().trim();
        
        // 2. Hover vào MenuItem
        Actions builder = new Actions(driver);
        builder.moveToElement(MenuItem).perform(); 
        
        // 3. Chờ SupItem xuất hiện (Sử dụng visibilityOfElementLocated)
        By supItemLocator = By.xpath("//a[text()='Hệ thống phanh']");
        WebElement SupItem = wait.until(ExpectedConditions.visibilityOfElementLocated(supItemLocator));
        String MenuSupItem = SupItem.getText().trim();
        
        // 4. Hover vào SupItem (Không cần scroll vì nó đã nằm trong menu thả xuống)
        builder.moveToElement(SupItem).perform(); 
        
        // 5. Chờ DoubleSubItem xuất hiện
        By douSupItemLocator = By.xpath("(//a[text()=\"Phanh tay ô tô\"])[1]");
        WebElement douSupItem = wait.until(ExpectedConditions.visibilityOfElementLocated(douSupItemLocator));
        String douSupItemText = douSupItem.getText().trim();
        
        // 6. Click vào DoubleSubItem
        douSupItem.click(); // Click để chuyển trang

        String Expectedtext = ("Trang chủ / Sản phẩm / "+ MenuItemText+" / "+MenuSupItem +" / "+douSupItemText);
        System.out.println("Đường dẫn mong đợi: " + Expectedtext);
        
        
        // --- Xử lý Breadcrumb sau khi chuyển trang ---
        By breadcrumbLocator = By.xpath("//section[@class='flw section section-breacrumb']");
        
        // 1. Chờ Breadcrumb xuất hiện (Sử dụng presenceOfElementLocated vì nó là phần tử trên trang mới)
        WebElement BreadcrumbNavim = wait.until(ExpectedConditions.presenceOfElementLocated(breadcrumbLocator));
        
        // 2. Thực hiện cuộn (scrollIntoView) đến phần tử breadcrumb
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", BreadcrumbNavim);
        
        // 3. Kiểm tra tính hiển thị bằng phương thức isElementDisplayed
        boolean BreadcrumbNav = isElementDisplayed(breadcrumbLocator); 
        Assert.assertTrue(BreadcrumbNav, "Breadcrumb navigation không hiển thị sau khi cuộn.");

        
        // 4. Lấy văn bản và so sánh
        String BreadcrumbNavText = BreadcrumbNavim.getText().trim();
        Assert.assertEquals(BreadcrumbNavText, Expectedtext,"Sai đường dẫn ");

    }
    
     public boolean isElementDisplayed(By by) {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(by)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}