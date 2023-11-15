package com;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.utils.BasicTest;
import com.utils.Utils;

public class LoginTest extends BasicTest {

    public void ClickRegisterBtn() {
        WebElement registerBtn = driver.findElement(By.xpath("//*[@name='register']"));
        registerBtn.click();
        Utils.hardWait();
    }

    public void ClickLoginBtn() {
        WebElement loginBtn = driver.findElement(By.xpath("//*[@name='login']"));
        loginBtn.click();
        Utils.hardWait();
    }

    public void verifyTextRegisterAndEmailInvalid() {
        WebElement message = driver.findElement(By.xpath("//*[text()=' Vui lòng cung cấp địa chỉ email hợp lệ.\t\t']"));
        String actual = message.getText().trim();
        String expected = "Lỗi: Vui lòng cung cấp địa chỉ email hợp lệ.";
        Assert.assertEquals(expected, actual);
        Utils.hardWait();
    }

    public void InputText(By element, String text) {
        WebElement emailEle1 = driver.findElement(element);
        emailEle1.sendKeys(text);
    }

    public void Login() {
        By userNameEle = By.xpath("//*[@name='username']");
        String username = "huou@gmail.com";
        InputText(userNameEle, username);
        By passEle = By.xpath("//*[@name='password']");
        String pass = "Huou123@123";
        InputText(passEle, pass);
        ClickLoginBtn();

    }

    public void Launchwebsite() {
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

    @Test(enabled = true)
    public void loginTestBai16() {
        // Launch website
        Launchwebsite();
        // Homework 16
        // Case register
        ClickRegisterBtn();
        verifyTextRegisterAndEmailInvalid();

        // Case emailInvalid
        By emailEle1 = By.id("reg_email");
        String email = "123@456";
        InputText(emailEle1, email);
        ClickRegisterBtn();
        // Verify emailInvalid
        verifyTextRegisterAndEmailInvalid();
        Utils.hardWait();

        // Case emailValid
        WebElement emailEle2 = driver.findElement(By.id("reg_email"));
        emailEle2.clear();
        emailEle2.sendKeys("qwerty@gmail.com");
        ClickRegisterBtn();
        // Verify emailValid
        WebElement messageEmailValid = driver
                .findElement(By.xpath("//*[text()=' Vui lòng nhập mật khẩu tài khoản.\t\t']"));
        String actualEmailValid = messageEmailValid.getText().trim();
        String expectedEmailValid = "Lỗi: Vui lòng nhập mật khẩu tài khoản.";
        Assert.assertEquals(expectedEmailValid, actualEmailValid);

    }

    @Test(enabled = true)
    public void loginTestBai17() {
        // Launch website
        Launchwebsite();

        // Homework 17
        // Case Login
        // WebElement userNameEle =
        // driver.findElement(By.xpath("//*[@name='username']"));
        // userNameEle.sendKeys("huou@gmail.com");
        // WebElement passEle = driver.findElement(By.xpath("//*[@name='password']"));
        // passEle.sendKeys("Huou123@123");
        Login();
        WebElement exitElement = driver.findElement(By.xpath("//*[text()='Thoát']"));
        Actions action = new Actions(driver);
        action.moveToElement(exitElement).click(exitElement).build().perform();
        Utils.hardWait();
        driver.navigate().back();
        Utils.hardWait();
        WebElement verifyHeader = driver.findElement(By.xpath("//h1[contains(text(),'Tài khoản')]"));
        Assert.assertTrue(verifyHeader.isDisplayed());

    }

    @Test(enabled = true)
    public void loginTestBai18() {
        // Launch website
        Launchwebsite();

        // Homework 18
        // Case Login
        Login();
        // Way 1
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");
        // Switch focus to new tab
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
        // Launch URL in the new tab
        driver.get("https://bantheme.xyz/hathanhauto/");
        Assert.assertEquals(driver.getCurrentUrl(), "https://bantheme.xyz/hathanhauto/");

    }
}
