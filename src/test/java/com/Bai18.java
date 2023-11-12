package com;

import java.util.ArrayList;
import java.util.List;

// import java.time.Duration;
// import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.utils.BasicTest;

public class Bai18 extends BasicTest {
    @Test()
    public void loginTest() throws Exception {
        // Launch website

        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Assert.assertEquals(driver.getCurrentUrl(), url);

        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement loginbutton = driver.findElement(By.xpath("//button[contains(text(),'Đăng nhập')]"));
        username.sendKeys("hoangtri88888@gmail.com");
        password.sendKeys("hoangtri88888");
        loginbutton.click();




        // Open a new tab
        ((JavascriptExecutor) driver).executeScript("window.open()");

        // Get id of current tab
        String currentTabId = driver.getWindowHandle();

        // Lấy danh sách tất cả cửa sổ/tab
        driver.switchTo().window(currentTabId).close();
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());



        // Chuyển sang tab mới
        driver.switchTo().window(tabs.get(0));
        driver.get(url);
        WebElement trangchu = driver.findElement(By.cssSelector("li[id='menu-item-330'] a"));
        trangchu.click();

        // Đóng tab cũ
        // driver.switchTo().window(currentTabId).close();

        // driver.switchTo().window(tabs.get(1));
        WebElement dangnhap = driver.findElement(By.cssSelector("strong[class='block']"));
        dangnhap.click();
        String title = driver.getTitle();
        System.out.println("Tiêu đề trang là: " + title);
        assert title.contains("Tài khoản | Hà Thành Auto");

        
       

    }


}
