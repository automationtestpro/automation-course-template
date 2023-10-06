package com;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Bool;
import com.github.javafaker.Faker;
import com.utils.BasicTest;
import com.utils.ExcelUtils;
import com.utils.Utils;

public class ExcelDataDemo extends BasicTest {

    public static final String Path_TestData = System.getProperty("user.dir")+ File.separator + "src/test/resources/testdata/";
    public static final String File_TestData = "TestData.xlsx";
    public Faker faker;

    @Test()
    public void tc01() throws Exception {
        
        String tcID = "TC_01";
        ExcelUtils excelUtils = new ExcelUtils(Path_TestData, File_TestData);
        int testRow = excelUtils.getRowByTCID(0, tcID);

        // Launch website admin 
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);

        //Enter username, password and submit

        String userName = excelUtils.getData(0, testRow, 1);
        String password = excelUtils.getData(0, testRow, 2);


        WebElement emailInp = driver.findElement(By.xpath("//*[@id='username']"));
        emailInp.sendKeys(userName);

        WebElement passwordInp = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        passwordInp.sendKeys(password);


        WebElement loginBtn = driver.findElement(By.xpath("//*[@id=\"customer_login\"]/div[1]/form/p[3]/button"));
        loginBtn.click();

        Utils.hardWait(5000);

        //Assert.assertTrue(loginBtn.isDisplayed());
        //Boolean isDisplayed = loginBtn.isDisplayed();

        //Assert.assertTrue(isDisplayed);

        excelUtils.setCellData("Passed", 0, tcID, 3);
    }

}
