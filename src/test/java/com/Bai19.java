package com;
import com.utils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.utils.BasicTest;
import org.testng.annotations.DataProvider;
public class Bai19 extends BasicTest {

    @Test(dataProvider = "loginAccounts")
    public void loginTest(String username, String password)  {
        // Launch website
        String url = "https://icehrm-open.gamonoid.com/login.php";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        // Enter username
        WebElement emailElement = driver.findElement(By.xpath("//*[@id=\"username\"]"));
        emailElement.sendKeys(username);
        Utils.hardWait();
        // Pass
        WebElement passElement = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        passElement.sendKeys(password);
        Utils.hardWait();
        // Login
        WebElement loginEle = driver.findElement(By.xpath("//button[text()='Log in ']"));
        loginEle.click();
        Utils.hardWait(); // 1s

        WebElement Logo = driver.findElement(By.xpath("//*[@class=\"logo logoResponsive\"]"));
        Assert.assertTrue(Logo.isDisplayed());
    }

    @DataProvider(name="loginAccounts")
    public Object[][] testData() {
        // 3 rows and 2 columns
        Object[][] data = new Object[4][2];
        // Admin
        data[0][0] = "admin";
        data[0][1] = "admin";

        // Manager
        data[1][0] = "manager";
        data[1][1] = "demouserpwd";

        // User1
        data[2][0] = "user1";
        data[2][1] = "demouserpwd";

        // User2
        data[3][0] = "user2";
        data[3][1] = "demouserpwd";

        return data;
    }
}