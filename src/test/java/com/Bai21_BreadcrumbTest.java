package com;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement; // Import this
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.utils.BasicTest;
import com.utils.Utils;

public class Bai21_BreadcrumbTest extends BasicTest {
    @Test()
    public void breadcrumbTest() throws Exception {
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
        Assert.assertFalse(isLoginDisplay);
        
        WebElement MenuItem = driver.findElement(By.xpath("//a[text()='Hệ thống truyền động, Khung gầm']"));
        action.moveToElement(MenuItem).perform(); //hover chuột vào menuItem
        String MenuItemText = MenuItem.getText().trim();

        WebElement SupItem = driver.findElement(By.xpath("//a[text()='Hệ thống phanh']"));
        action.moveToElement(SupItem).perform(); //hover chuột vào supitem hệ thống phanh
        String MenuSupItem = SupItem.getText().trim();


        WebElement douSupItem = driver.findElement(By.xpath("(//a[text()=\"Phanh tay ô tô\"])[1]"));
        action.moveToElement(douSupItem).perform(); //hover chuột vào phanh tay oto
        String douSupItemText = douSupItem.getText().trim();
        douSupItem.click();
        String Expectedtext = ("Trang chủ / Sản phẩm / "+ MenuItemText+" / "+MenuSupItem +" / "+douSupItemText);
        System.out.println(Expectedtext);
        
        boolean BreadcrumbNav = isElementDisplayed(By.xpath("//section[@class='flw section section-breacrumb']"));
        Assert.assertTrue(BreadcrumbNav);

        WebElement BreadcrumbNavim = driver.findElement(By.xpath("//section[@class='flw section section-breacrumb']"));
        //WebElement BreadcrumbNavi = driver.findElement(By.xpathPath(//section[@class='flw section section-breacrumb']);
        String BreadcrumbNavText = BreadcrumbNavim.getText().trim();
        Assert.assertEquals(BreadcrumbNavText, Expectedtext,"Sai đường dẫn ");

    }
   

     public boolean isElementDisplayed(By by) {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(by)).isDisplayed();
        } catch (Exception e) {
            return false;// TODO: handle exception
        }
    }
}