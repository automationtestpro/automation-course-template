package com;

import org.testng.Assert;
import org.testng.annotations.Test;

//import static org.junit.jupiter.api.Assertions.fail;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.utils.BasicTest;
import com.utils.Utils;

import java.time.Duration;
//import java.util.ArrayList;

public class Bai18_TabTestcopy extends BasicTest {
    @Test()
    public void tabTest() throws Exception {
        // Launch website
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);

        // Input username
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='username']"))).sendKeys("mdangdn29@gmail.com");

        // Input password
        WebElement passwordInp = driver.findElement(By.xpath("//*[@id='password']"));
        passwordInp.sendKeys("D@ng291199");

        // Click login button
        WebElement loginBtn = driver.findElement(By.xpath("//button[text()='Đăng nhập']"));
        loginBtn.click();

        // Add a small wait to ensure the element is not displayed anymore
        boolean isLoginDisplay = isElementDisplayed(By.xpath("//button[text()='Đăng nhập']"));
        Assert.assertFalse(isLoginDisplay, "Nút đăng nhập vẫn hiển thị sau khi đăng nhập thành công.");

        // 1. Lưu lại handle của tab cũ
        String oldTabHandle = driver.getWindowHandle();

        // 2. Mở tab mới và chuyển sang tab đó
        driver.switchTo().newWindow(WindowType.TAB);
        String newTabHandle = driver.getWindowHandle();

        // 3. Điều hướng đến URL mới trong tab mới
        String urlnew = "https://bantheme.xyz/hathanhauto";
        driver.get(urlnew);
        // Chờ cho URL được cập nhật và xác thực nó. Thêm dấu "/" vì trang web có thể tự động redirect.
        wait.until(ExpectedConditions.urlToBe(urlnew + "/"));
        Assert.assertEquals(driver.getCurrentUrl(), urlnew + "/", "URL của tab mới không chính xác.");
        System.out.println("Đã chuyển đến URL mới thành công: " + driver.getCurrentUrl());

        // 4. Quay lại tab cũ và đóng nó
        driver.switchTo().window(oldTabHandle);
        driver.close();
        System.out.println("Đã đóng tab cũ.");

        // 5. Chuyển sang tab mới (bây giờ là tab duy nhất còn lại)
        driver.switchTo().window(newTabHandle);
        //startWith giúp trang web truy cập đúng  URL dù có dấu "/" ở cuối hay không
        System.out.println("Đã chuyển về tab mới. URL hiện tại: " + driver.getCurrentUrl());
        Assert.assertTrue(driver.getCurrentUrl().startsWith(urlnew), "Không chuyển về đúng tab mới.");

        //On the new tab, click on the "Login" button
        WebElement Personalbutton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'relative login-item')]")));
        //Personalbutton.click();
        Assert.assertTrue(isElementDisplayed(By.xpath("//div[contains(@class,'relative login-item')]")), "Nút cá nhân không hiển thị sau khi nhấn vào.");

        WebElement loginNavBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//strong[@class='block']")));
        loginNavBtn.click();
        //wait.until(ExpectedConditions.invisibilityOf(loginNavBtn));
        Assert.assertFalse(isElementDisplayed(By.xpath("//strong[@class='block']")), "Nút đăng nhập vẫn hiển thị sau khi nhấn vào.");

        //wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//strong[@class='block']")));
        //Assert.assertFalse(isElementDisplayed2(By.xpath("//strong[@class='block']")), "Nút đăng nhập vẫn hiển thị sau khi nhấn vào.");

        //Verify user is still logged in using the Assert method
        WebElement correctMessage = driver.findElement(By.xpath("//div[@class='woocommerce-MyAccount-content']"));
        String correctMessageText = correctMessage.getText();
        System.out.println("correct Message: " + correctMessageText);
        Assert.assertTrue(correctMessageText.contains("Xin chào mdangdn29 (không phải tài khoản mdangdn29?")); // muốn lấy từ biến email sendkey

    }

     public boolean isElementDisplayed(By by) {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(by)).isDisplayed();
        } catch (Exception e) {
            return false;// TODO: handle exception
        }
    }
    public boolean isElementDisplayed2(By by) {
        try {
            return wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
        } catch (Exception e) {
            return false;// TODO: handle exception
        }    
    }
}