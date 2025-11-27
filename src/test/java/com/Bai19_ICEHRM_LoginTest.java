package com;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.utils.BasicTest;
import com.utils.Utils;
// import org.openqa.selenium.we;


public class Bai19_ICEHRM_LoginTest extends BasicTest {


    @Test(dataProvider = "loginDataFeed")
    public void loginTest(String email, String password , String expectedMessage) throws Exception {
        // Mở trang đăng nhập
        String url = "https://icehrm-open.gamonoid.com/login.php";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);

        //Nhập email
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='username']"))).sendKeys(email);


        //Nhập password
         WebElement passwordInput = driver.findElement(By.xpath("//*[@id='password']"));
         passwordInput.sendKeys(password);

         //Click nút đăng nhập
        By loginBtnLocator = By.xpath("(//*[@type='button'])[1]");
        WebElement loginBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(loginBtnLocator));
        loginBtn.click();
        
        //wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("(//*[@type='button'])[1]")));
        // Kiểm tra đăng nhập thành công
        // boolean isLoginDisplay  = isElementDisplayed(By.xpath("(//*[@type='button'])[1]"));
        //Assert.assertFalse(isLoginDisplay);
        if (expectedMessage.isEmpty()) { // KIỂM TRA ĐĂNG NHẬP THÀNH CÔNG
        
            // Chờ phần tử độc đáo của Dashboard )
            By dashboardLocator = By.xpath("//div[@class='ant-alert-message']"); 
        
            // Chờ trang Dashboard hiển thị
            wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardLocator));

            // Kiểm tra thông báo hiển thị
            boolean isLoginDisplay = isElementDisplayed(dashboardLocator);
            Assert.assertTrue(isLoginDisplay, "Nút thông báo vẫn hiển thị");
        
            // KHÔNG CẦN kiểm tra errorMessageText
            return; // Thoát khỏi hàm nếu thành công
    }
      

        // kiểm tra message hiện ra 
        By byElementlocator = By.xpath("//*[@class='alert alert-danger']");
        String errorMessageText = getErrorMessage(byElementlocator);
        System.out.println("Error Message: " + errorMessageText);
        Assert.assertEquals(errorMessageText, expectedMessage); 
    }
    @DataProvider(name = "loginDataFeed")
    public Object[][] testDataFeed(){
        return new Object[][] {
            // Test Case 1: Valid Login (Expected to succeed)
            {"admin", "admin", ""}, 
            // Test Case 2: Invalid Password (Expected to fail)
            {"admin", "admin123", "Login failed"}
        };  
    }
    // @DataProvider(name = "loginData2")
    // public Object[][] loginData2(){
    //     return new Object[][] {
    //         {"mdangdn29@gmail.com","D@ng291199" ,"error message"},
    //         {"","D@ng291199"},
    //         {"mdangdn29","123456"}
    //     };  
    // }

    public boolean isElementDisplayed(By by) {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(by)).isDisplayed();
        } catch (Exception e) {
            return false;// TODO: handle exception
        }
    }
        public String getErrorMessage(By byElementlocator){
        
            try {
                WebElement element = driver.findElement(byElementlocator);
                return element.getText();
            } catch (Exception e) {
                // TODO: handle exception
                return "";
            }

        }
        

}
