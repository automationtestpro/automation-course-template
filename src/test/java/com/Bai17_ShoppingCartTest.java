package com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.utils.Utils;
import com.utils.BasicTest;

public class Bai17_ShoppingCartTest extends BasicTest {
    @Test()
    public void  ShoppingCart() throws Exception {
        HomePage homePage= new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        // Launch website
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        Utils.hardWait();
         //email
        //WebElement email=driver.findElement(By.xpath("//input[@id='username']"));
        //email.sendKeys("thanhvinh231198@gmail.com");
       //loginPage.enterUsername("thanhvinh231198@gmail.com");
        //pass
        Utils.hardWait();
        //WebElement pass=driver.findElement(By.xpath("//input[@name='password']"));
        //pass.sendKeys("Vinhkute98@");
        loginPage.enterPassword("Vinhkute98@");
        //CLickbtn
        Utils.hardWait(3);
        //WebElement click=driver.findElement(By.xpath("//button[@name='login']"));
        //click.click();
        loginPage.clickLoginButton();

        loginPage.enterUsername("thanhvinh231198@gmail.com")
        .enterPassword("Vinhkute98@")
        .clickLoginButton();
       // WebElement content=driver.findElement(By.xpath("//div[@class='woocommerce-MyAccount-content']"));
       // Assert.assertTrue(content.getText().contains("thanhvinh231198"));
        String mgs=loginPage.getErrorMessage();
        Assert.assertEquals(mgs, "thanhvinh231198");

        //WebElement clicksearch=driver.findElement(By.xpath("(//input[@id='s'])[1]"));
        //clicksearch.sendKeys("merc");
        homePage.clickSearch("merc")
        .clickItemlist("Bơm nước xe")
        .clickItem1()
        .clickXs("england")
        .selectOption();
        //homePage.clickSearch("merc");
        Utils.hardWait();
        
        //WebElement clickitem=driver.findElement(By.xpath("//a[contains()=\"Bơm nước xe \"]"));
       // clickitem.click();
       // homePage.clickItemlist("Bơm nước xe");

        Utils.hardWait();
       // WebElement pickXS=driver.findElement(By.xpath("//select[@id=\"pa_xuat-xu\"]"));
       // pickXS.click();
        


        Utils.hardWait();
        //WebElement clickSX=driver.findElement(By.xpath("//option[@value=\"england\"]"));
        //clickSX.click();
       //homePage.clickXs("germany");
       
       
       
       
       
        Utils.hardWait();
       // WebElement submit=driver.findElement(By.xpath("(//button[@type=\"submit\"])[2]"));
       // submit.click();

        Utils.hardWait();
        WebElement verify=driver.findElement(By.xpath("//div[@class='woocommerce-notices-wrapper']//div"));
        String a=verify.getText();
        System.out.println("======" + a + "===============" );
        Assert.assertTrue(a.contains("đã được thêm vào giỏ hàng"));
        
    }
    }

