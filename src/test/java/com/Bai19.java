package com;

// import java.time.Duration;
// import java.util.concurrent.TimeUnit;
import java.io.File;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import com.utils.BasicTest;
import com.utils.ExcelUtils;
import com.utils.Utils;

public class Bai19 extends BasicTest {

    public static final String Path_TestData = System.getProperty("user.dir") + File.separator + "src\\test\\resources\\suites\\testdata\\";
    public static final String File_TestData = "TestData.xlsx";

    @DataProvider(name = "loginDataProvider")
    public static Object [][] loginDataProvider(){
        return new Object[][] {
            {"UTS_User_01",0, 2, 2, 3},
            {"UTS_User_02",0, 3, 2, 3},
            {"UTS_User_03",0, 4, 2, 3},
            {"UTS_User_04",0, 5, 2, 3},
        };
    }

    @Test(dataProvider = "loginDataProvider")
    public void loginTest(String tcID, int sheetIndex,int rowNum, int usernameCol, int passwordCol) throws Exception {
        // Launch website
        //String tcID = "UTS_User_02";

        ExcelUtils excelUtils = new ExcelUtils(Path_TestData, File_TestData);



        String url = "https://icehrm-open.gamonoid.com/login.php?logout=1";
        driver.get(url);
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Assert.assertEquals(driver.getCurrentUrl(), url);

        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement loginbutton = driver.findElement(By.xpath("//button[contains(text(),'Log in')]"));

        String usernameExcel = excelUtils.getData(0, rowNum, usernameCol);
        String passwordExcel = excelUtils.getData(0,rowNum, passwordCol);
        username.sendKeys(usernameExcel);
        password.sendKeys((passwordExcel));
        loginbutton.click();

        Utils.hardWait();
        boolean entryHeader = driver.findElement(By.xpath("//span[normalize-space()='Admin']")).isDisplayed();
        if (entryHeader==true) {
            excelUtils.setCellData("Pass", 0, tcID, 6);
        }

    }


}
