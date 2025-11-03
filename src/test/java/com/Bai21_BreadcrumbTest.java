package com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.openqa.selenium.interactions.Actions;

import com.utils.BasicTest;
import com.utils.Utils;

public class Bai21_BreadcrumbTest extends BasicTest  {

    @Test()
    public void breadcrumbTest(){
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);

        // Hover "Hệ thống truyền động, Khung gầm"
        WebElement menuItem = waitElementClickable("//li[@id='menu-item-347']");
        actions.moveToElement(menuItem).perform();

        // Hover "Hệ thống phanh"
        WebElement menuItem1 = waitElementClickable("//li[@id='menu-item-465']");
        actions.moveToElement(menuItem1).perform();

       // Click "Phanh tay ô tô"
        waitElementClickable("//li[@id='menu-item-468']").click();

        // Kiểm tra đường dẫn
        WebElement breadcrumb = waitElementVisible("//nav[@class='woocommerce-breadcrumb']");
        String breadcrumbText = breadcrumb.getText();
        System.out.println("Đường dẫn hiện tại: " + breadcrumbText);

        //// Kiểm tra đường dẫn có chứa text Phanh tay ô tô
        String expectedText = "Phanh tay ô tô";
        Assert.assertTrue(breadcrumbText.contains(expectedText), "Đường không chứa text: " + expectedText);
        System.out.println("Đường dẫn hiển thị đúng: " + breadcrumbText);

        // Kiểm tra tiêu đề trang
        String pageTitle = driver.getTitle();
        System.out.println("Tiêu đề trang: " + pageTitle);
        Assert.assertTrue(pageTitle.contains("Phanh tay ô tô"));

    }

}