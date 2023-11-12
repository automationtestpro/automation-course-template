package com;

// import java.time.Duration;
// import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.utils.BasicTest;

public class Bai17 extends BasicTest {
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
        WebElement thoatbutton = driver.findElement(By.xpath("//a[contains(text(),'Thoát')]"));
        thoatbutton.click();
        driver.navigate().back();
        boolean entryHeader = driver.findElement(By.xpath("//h1[contains(text(),'Tài khoản')]")).isDisplayed();
        if (entryHeader==true) {
            System.out.println("skeep trang tài khoản");
        }

    }


}
