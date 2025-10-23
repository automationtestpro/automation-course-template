package com;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

//import static org.junit.jupiter.api.Assertions.fail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement; // Import this
import com.utils.BasicTest;
import com.utils.Utils;

public class Bai16_LoginTest extends BasicTest {
    @Test(dataProvider = "loginData")
    public void loginTestSuccess(String email, String password, String expectedMessage) throws Exception {
        // Launch website
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);

        // Input username
        WebElement emailInp = driver.findElement(By.xpath("//*[@id='username']"));
        emailInp.sendKeys(email);

        // Input password
        WebElement passwordInp = driver.findElement(By.xpath("//*[@id='password']"));
        passwordInp.sendKeys(password);

        // Click login button
        WebElement loginBtn = driver.findElement(By.xpath("//button[text()='Đăng nhập']"));
        loginBtn.click();

        // Add a small wait to ensure the element is not displayed anymore
        Utils.hardWait(2000);
        // boolean isLoginDisplay = isElementDisplayed(loginBtn);
        // Assert.assertFalse(isLoginDisplay);
    

        //Utils.hardWait(5000);
        // check login message
        // WebElement errorMessage = driver.findElement(By.xpath("//ul[@class='woocommerce-error']"));


        By byElementLocator = By.xpath("//ul[@class='woocommerce-error']");
        String errorMessageText = getErrorMessage(byElementLocator);
        System.out.println("Error Message: " + errorMessageText);

        // Assert.assertTrue(errorMessageText.contains(expectedMessage));
        Assert.assertEquals(errorMessageText, expectedMessage);
    }
   
    // @Test()
    // public void loginTestFailed() throws Exception {
    //     // Launch website
    //     String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
    //     driver.get(url);
    //     Assert.assertEquals(driver.getCurrentUrl(), url);

    //     // Input username
    //     WebElement emailInp = driver.findElement(By.xpath("//*[@id='username']"));
    //     emailInp.sendKeys("mdangdn29@gmail.com");

    //     // Input password
    //     WebElement passwordInp = driver.findElement(By.xpath("//*[@id='password']"));
    //     passwordInp.sendKeys("");

    //     // Click login button
    //     WebElement loginBtn = driver.findElement(By.xpath("//button[text()='Đăng nhập']"));
    //     loginBtn.click();

    //     // Add a small wait to ensure the element is not displayed anymore
    //     //Utils.hardWait(2000);
    //     //boolean isLoginDisplay = isElementDisplayed(loginBtn);
    //     //Assert.assertFalse(isLoginDisplay);
    

    //     Utils.hardWait(5000);

    //     //check login fail
    //     WebElement errorMessage = driver.findElement(By.xpath("//ul[@class='woocommerce-error']"));
    //     String errorMessageText = errorMessage.getText();
    //     System.out.println("Error Message: " + errorMessageText);
    //     Assert.assertTrue(errorMessageText.contains("Mục nhập mật khẩu trống."));   
    // }

    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        return new Object[][] {
            {"mdangdn29@gmail.com", "D@ng291199", ""},
            {" ", "D@ng291199", "error message 1"},
            {"mdangdn29", "12342342", "error message 2"}
        };
    }

    public boolean isElementDisplayed(WebElement element){
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            return false;// TODO: handle exception
        }
    }


    public String getErrorMessage(By byElementLocator){
        try {
            WebElement element = driver.findElement(byElementLocator);
            return element.getText();
        } catch (Exception e) {
            return "";
        }
    }
}