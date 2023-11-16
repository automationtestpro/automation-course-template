package com;

// import java.time.Duration;
// import java.util.concurrent.TimeUnit;
import java.io.File;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


import com.utils.BasicTest;
import com.utils.ExcelUtils;
import com.utils.Utils;

public class Bai19 extends BasicTest {

    public static final String Path_TestData = System.getProperty("user.dir") + File.separator + "src\\test\\resources\\suites\\testdata\\";
    public static final String File_TestData = "TestData.xlsx";
    @Test()
    public void loginTest() throws Exception {
        // Launch website
        String tcID = "UTS_User_02";

        ExcelUtils excelUtils = new ExcelUtils(Path_TestData, File_TestData);



        String url = "https://icehrm-open.gamonoid.com/login.php?logout=1";
        driver.get(url);
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Assert.assertEquals(driver.getCurrentUrl(), url);

        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement loginbutton = driver.findElement(By.xpath("//button[contains(text(),'Log in')]"));

        String usernameExcel = excelUtils.getData(0, 2, 2);
        String passwordExcel = excelUtils.getData(0, 2, 3);
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
