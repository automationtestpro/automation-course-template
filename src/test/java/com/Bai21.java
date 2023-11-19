package com;



// import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.utils.BasicTest;

public class Bai21 extends BasicTest {
    @Test()
    public void loginTest() throws Exception {
        // Launch website

        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Sử dụng explicit wait để đảm bảo element được tìm thấy trước khi thao tác
        WebDriverWait wait = new WebDriverWait(driver, 10);
        //wait.until(ExpectedConditions.urlToBe(url));
        Assert.assertEquals(driver.getCurrentUrl(), url);


        //WebElement menu1Element = driver.findElement(By.xpath("//li[@id='menu-item-347']//a[contains(text(),'Hệ thống truyền động, Khung gầm')]"));
        WebElement menu1Element = driver.findElement(By.xpath("//*[text()='Hệ thống truyền động, Khung gầm']"));

        Actions actions = new Actions(driver);
        //di chuyển đến menu1
        WebElement menuElement = menu1Element.findElement(By.xpath("//a[contains(text(),'Hệ thống gầm')]"));
        actions.moveToElement(menuElement).perform();

        // Thread.sleep(1000);
        //di chuyển đến menu2
        WebElement menuElement2 = menuElement.findElement(By.xpath("//a[contains(text(),'Van chia hơi nâng gầm')]"));
        actions.moveToElement(menuElement2).click().perform();
        
        

        WebElement entrElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//nav[@class='woocommerce-breadcrumb']")));
        
        if (entrElement.isDisplayed()){
            System.out.println("Đã move thành công");
        }
 

    }


}
