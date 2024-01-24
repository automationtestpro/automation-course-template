package com;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.utils.BasicTest;
import com.utils.Utils;

public class Bai19 extends BasicTest {

    /**
     * @param uname
     * @param pword
     * @throws Exception
     */
    @Test(dataProvider = "testdata")
    public void bai19(String uname, String pword) throws Exception {
        // Launch website
        String url = "https://icehrm-open.gamonoid.com/login.php";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);

        // Input user name & password
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys(uname);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(pword);

        WebElement loginBtn = driver.findElement(By.xpath("//button[normalize-space()='Log in']"));
        loginBtn.click();
        
        Utils.hardWait(3000);

    }

    @DataProvider(name = "testdata")
    public Object[][] userdata() {
        return new Object[][] {
                { "admin", "admin" },
                { "manager", "demouserpwd" },
                { "user1", "demouserpwd" },
                { "user2", "demouserpwd" }
        };
    }

}
