package com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pages.LoginPage;
import com.utils.BasicTest;
import com.utils.DriverManager;
import com.utils.Utils;

public class LoginTest1 extends BasicTest {


    @Test()
    public void loginTest() throws Exception {

        WebDriver driver = DriverManager.getDriver();

        // Launch website
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);

        // read info 

        // WebElement email= driver.findElement(By.xpath("//[@id='username']"));
        // email.sendKeys("duykhanhrc@gmail.com");

        // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//[@id='username']"))).sendKeys("duykhanhrc@gmail.com");

        // // WebElement pass= driver.findElement(By.xpath("//[@id='password']")); 
        // // pass.sendKeys("123456");

        // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//[@id='password']"))).sendKeys("123456");


        // WebElement click=driver.findElement(By.xpath("//*[@id='customer_login']/div[1]/form/p[3]/button"));
        // click.click();

        // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@id=\"menu-item-369\"]")));

        // WebElement menu369 = driver.findElement(By.xpath("//li[@id=\"menu-item-369\"]"));

        // Actions action = new Actions(driver);

        // action.moveToElement(menu369).perform();

        // WebElement menu370 = driver.findElement(By.xpath("//li[@id=\"menu-item-370\"]"));
        // menu370.click();


        // Utils.hardWait(5000);




        // int count = driver.findElements(By.xpath("//div[@class=\"item-product\"]")).size();  // -> return 20

        // logger.info("Product quantity: " + count);

        // Assert.assertEquals(count, 10); // sai expected

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail("duykhanhrc@gmail.com");
        loginPage.enterPass("123456");
        loginPage.clickLogin();


        Utils.hardWait(5000);

    }

}
