package com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.utils.Utils;
import com.utils.BasicTest;

public class Bai20_ShoppingCartTest extends BasicTest {
    @Test()
    public void  loginTest() throws Exception {
        // Launch website
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        //Utils.hardWait();
         //email
        //WebElement email=driver.findElement(By.xpath("//input[@id='username']"));
        //email.sendKeys("thanhvinh231198@gmail.com");
         wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='username']"))).sendKeys("thanhvinh231198@gmail.com");
        //pass
        //Utils.hardWait();
        //WebElement pass=driver.findElement(By.xpath("//input[@name='password']"));
        //pass.sendKeys("Vinhkute98@");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='password']"))).sendKeys("Vinhkute98@");
        //CLickbtn
       // Utils.hardWait(3);
        //WebElement click=driver.findElement(By.xpath("//button[@name='login']"));
        //click.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@name='login']"))).click();

       // WebElement content=driver.findElement(By.xpath("//div[@class='woocommerce-MyAccount-content']"));
        //Assert.assertTrue(content.getText().contains("thanhvinh231198"));
        String message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='woocommerce-MyAccount-content']"))).getText();

        // WebElement errorMessage = driver.findElement(By.xpath("//ul[@class='woocommerce-error']"));
        Assert.assertTrue(message.contains("thanhvinh231198"));
       
       
        //WebElement clicksearch=driver.findElement(By.xpath("(//input[@id='s'])[1]"));
        //clicksearch.sendKeys("merc");
        //Utils.hardWait();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='s'])[1]"))).sendKeys("merc");
        
        
        //WebElement clickitem=driver.findElement(By.xpath("//a[text()=\"Bơm nước xe \"]"));
        //clickitem.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()=\"Bơm nước xe \"]"))).click();

        //Utils.hardWait();
        //WebElement pickXS=driver.findElement(By.xpath("//select[@id=\"pa_xuat-xu\"]"));
        //pickXS.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id=\"pa_xuat-xu\"]"))).click();


       // Utils.hardWait();
        //WebElement clickSX=driver.findElement(By.xpath("//option[@value=\"england\"]"));
        //clickSX.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//option[@value=\"england\"]"))).click();
        
        //Utils.hardWait();
        //WebElement submit=driver.findElement(By.xpath("(//button[@type=\"submit\"])[2]"));
        //submit.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[@type=\"submit\"])[2]"))).click();
        

        //Utils.hardWait();
        //WebElement verify=driver.findElement(By.xpath("//div[@class='woocommerce-notices-wrapper']//div"));
       // String a=verify.getText();
        //System.out.println("======" + a + "===============" );
        //Assert.assertTrue(a.contains("đã được thêm vào giỏ hàng"));
        String message1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='woocommerce-notices-wrapper']//div"))).getText();

        // WebElement errorMessage = driver.findElement(By.xpath("//ul[@class='woocommerce-error']"));
        Assert.assertTrue(message1.contains("đã được thêm vào giỏ hàng"));
    }
    }

