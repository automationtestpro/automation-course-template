package com;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.utils.BasicTest;
import com.utils.Utils;

public class Bai21_BreadcrumbTest extends BasicTest {

    @Test()
    public void hoverTest() throws Exception {
        // Launch website
        String url = "https://bantheme.xyz/hathanhauto/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);

        Utils.hardWait();
        String menu1 = "menu-item-347";
        hoverElement(menu1);

        Utils.hardWait();
        String menu2 = "menu-item-465";
        // WebElement menu2 = driver.findElement(By.xpath("//li[@id='menu-item-465']"));
        // action.moveToElement(menu2).build().perform();
        hoverElement(menu2);

        Utils.hardWait();
        String menu3 = "menu-item-470";
        // WebElement menu3 = driver.findElement(By.xpath("//li[@id='menu-item-470']"));
        // action.click(menu3).build().perform();
        hoverElement(menu3);
        String message1 = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//nav[@class='woocommerce-breadcrumb']")))
                .getText();

        // WebElement errorMessage =
        // driver.findElement(By.xpath("//ul[@class='woocommerce-error']"));
        Assert.assertTrue(message1.contains("Hệ thống truyền động, Khung gầm"));

        String locator = "//nav[@class='woocommerce-breadcrumb']";

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));

        List<WebElement> elements = driver.findElements(By.xpath(locator));

        for (WebElement element : elements) {
            // // action.moveToElement(element).build().perform();
            Utils.hardWait(); // cho 3s
            String text = element.getText();
            System.out.println(text);
        }
    }

    public void hoverElement(String menu) {
        String locator = "//li[@id='" + menu + "']";
        WebElement menu4 = driver.findElement(By.xpath(locator));
        action.click(menu4).build().perform();
    }
}