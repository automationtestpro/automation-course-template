package com;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.utils.BasicTest;
import com.utils.Utils;
// import org.openqa.selenium.we;


public class Bai18_TabTestcopy extends BasicTest {


    @Test(dataProvider = "loginData")
    public void tabTest(String email, String password , String expectedMessage) throws Exception {
        // Mở trang đăng nhập
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);

        //Nhập email
        WebElement emailInput = driver.findElement(By.xpath("//*[@id='username']"));
        emailInput.sendKeys(email);

        //Nhập password
         WebElement passwordInput = driver.findElement(By.xpath("//*[@id='password']"));
         passwordInput.sendKeys(password);

         //Click nút đăng nhập
        WebElement loginBtn = driver.findElement(By.xpath("//button[@name='login']"));
        loginBtn.click();
        Utils.hardWait(3000);

        // Kiểm tra đăng nhập thành công
        //boolean isLoginDisplay  = isElementDisplayed(loginBtn);
        //Assert.assertFalse(isLoginDisplay);
        //Utils.hardWait(3000);

       // WebElement errorMessage = driver.findElement(By.xpath("//ul[@class='woocommerce-error']"));
        By byElementlocator = By.xpath("//ul[@class='woocommerce-error']");
        String errorMessageText = getErrorMessage(byElementlocator);
        System.out.println("Error Message: " + errorMessageText);
       // Assert.assertTrue(errorMessageText.contains(expectedMessage));  

        Assert.assertEquals(errorMessageText, expectedMessage); 


        // WebElement body = driver.findElement(By.tagName("body"));

        // Object[] windowHandles=driver.getWindowHandles().toArray();
        // driver.switchTo().window((String) windowHandles[1]);
        // driver.switchTo().newWindow(WindowType.TAB);


    //     String oldTab = driver.getWindowHandle();

    //     //mở tab mới
    //    ((JavascriptExecutor) driver).executeScript("window.open('https://bantheme.xyz/hathanhauto','_blank');");
    //    ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
    //    driver.switchTo().window(tabs.get(1));
    //    Assert.assertEquals(driver.getCurrentUrl(), "https://bantheme.xyz/hathanhauto/");
    //    Utils.hardWait(2000);

    //    driver.switchTo().window(oldTab);
    //    driver.close();
    //    System.out.println("Closed the old tab.");
    //    Utils.hardWait(2000);

    //    driver.switchTo().window(tabs.get(1));
    //    Utils.hardWait(2000);

    //    WebElement lgBtn = driver.findElement(By.xpath("//strong[text()='Đăng nhập']"));
    //    lgBtn.click();
    //    Utils.hardWait(2000);

    //    WebElement verifyAccount = driver.findElement(By.xpath("//p/strong[1]"));
    //    Assert.assertTrue(verifyAccount.isDisplayed(),("Không tìm thấy tài khoản"));


    }
    @DataProvider(name = "loginData")
    public Object[][] loginData(){
        return new Object[][] {
            {"mdangdn29@gmail.com","D@ng291199",""},
            {"","D@ng291199","error message"},
            {"mdangdn29","123456","error message2"}
        };  
    }
    @DataProvider(name = "loginData2")
    public Object[][] loginData2(){
        return new Object[][] {
            {"mdangdn29@gmail.com","D@ng291199" ,"error message"},
            {"","D@ng291199"},
            {"mdangdn29","123456"}
        };  
    }

    public boolean isElementDisplayed(WebElement element){

        try {
            return element.isDisplayed();
        } catch (Exception e) {
            // TODO: handle exception
            return false;
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
