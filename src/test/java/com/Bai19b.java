package com;

import com.utils.BasicTest;
import com.utils.ExcelUtils;
import com.utils.Utils;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class Bai19b extends BasicTest {

    @Test(dataProvider = "testdata")
    public void bai19(String uname, String pword) {
        // Launch website
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);

        // for loop
        driver.findElement(By.xpath("//input[@id='reg_email']")).sendKeys(uname);

        driver.findElement(By.xpath("//input[@id='reg_password']")).sendKeys(pword);

        Utils.hardWait(3000); // 5s

    }

    @DataProvider(name = "testdata")
    public Object[][] testdata() {
        Object[][] data = new Object[2][2];
        data[0][0] = "testtest@gmail.com";
        data[0][1] = "testtest";

        data[1][0] = "testtest2@gmail.com";
        data[1][1] = "testtest2";



        String Path_TestData = System.getProperty("user.dir")+ File.separator + "src/test/resources/testdata/";
        String File_TestData = "TestData.xlsx";

        //Call read file method of the class to read data
        String tcID = "UTS_User_01";
        ExcelUtils excelUtils = new ExcelUtils(Path_TestData, File_TestData);
        int testRow = excelUtils.getRowByTCID(0, tcID);

        String u = excelUtils.getData(0, testRow, 2);
        String p = excelUtils.getData(0, testRow, 3);



        return data;
    }
}