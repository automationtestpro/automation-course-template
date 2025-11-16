package com;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import javax.swing.Action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement; // Import this
import com.utils.BasicTest;
import com.utils.Utils;

public class Bai21_Demotest extends BasicTest {

    // @Test()
    public void registerTest() throws Exception {
        // Launch website
        String url = "https://bantheme.xyz/hathanhauto/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);

        WebElement demoElement = driver.findElement(By.id("menu-item-347"));

        action.moveToElement(demoElement).perform();

        Utils.hardWait(5000);


        // Multiple elements
        List<WebElement> demoList = driver.findElements(By.cssSelector("#eweb_new_product-2 .item-product"));

        System.out.println("Number of elements: " + demoList.size());


        for (WebElement ele : demoList) {
            System.out.println("Element name: " + ele.getText());
        }

    }

}