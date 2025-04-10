package com;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.utils.BasicTest;
import com.utils.Utils;

public class HoverTest extends BasicTest {


    @Test()
    public void hoverTest() throws Exception {
        // Launch website
        String url = "https://bantheme.xyz/hathanhauto/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        
        // Utils.hardWait(); // cho 3s

        // WebElement menu1 = driver.findElement(By.xpath("//li[@id='menu-item-347']"));
        // action.moveToElement(menu1).build().perform();

        // Utils.hardWait(); // cho 3s

        // WebElement menu2 = driver.findElement(By.xpath("//li[@id='menu-item-465']"));
        // action.moveToElement(menu2).build().perform();
        // Utils.hardWait(); // cho 3s


        // Multiple elements

        
        // String locator = "//section[@id=\"eweb_new_product-2\"]//div[@class=\"item-product\"]";

        // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));

        // List<WebElement> elements = driver.findElements(By.xpath(locator));

        // for (WebElement element : elements) {
        //     // action.moveToElement(element).build().perform();
        //     // Utils.hardWait(); // cho 3s
        //     String text = element.getText();
        //     System.out.println(text);
        // }


        String menu_parent = "Hệ thống gầm";
        String menu_children = "Bơm nâng gầm";


        // TODO:
        hoverOverElement(menu_parent);
        //.....
       
        String actual_breadCrumd = "";

        Assert.assertTrue(actual_breadCrumd.contains(menu_parent));
        Assert.assertTrue(actual_breadCrumd.contains(menu_children));


    }

    // dynamic locator
    public void hoverOverElement(String menu) {
        String locator = "//a[contains(text(),'" + menu + "')]";
        // .....
    }
    

}
