package com;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.utils.BasicTest;
import com.utils.ExcelUtils;
import com.utils.Utils;

public class Bai16_LoginTestDDT extends BasicTest {


    ExcelUtils excelUtils = new ExcelUtils("src/test/resources/testdata/excel/", "TestData.xlsx");

    @Test(dataProvider = "loginTestData")
    public void loginTestSuccess(String email, String password, String expectedMessage, String tcid) throws Exception {
        // Launch website and navigate to https://bantheme.xyz/hathanhauto/tai-khoan/
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);

        // Declare locator
        WebElement loginEmailFieldLocator = driver.findElement(By.id("username"));
        WebElement loginPasswordFieldLocator = driver.findElement(By.id("password"));
        WebElement loginButtonLocator = driver.findElement(By.cssSelector("button[name='login']"));

        // Enter email address into email field
        loginEmailFieldLocator.sendKeys(email);
        // Enter password into password field
        loginPasswordFieldLocator.sendKeys(password);
        // Click login button
        loginButtonLocator.click();
        Utils.hardWait(3000);
        
        String errorMessage = getErrorMess();

        excelUtils.setCellData(errorMessage, 0, tcid, 4);

        if (errorMessage.equals(expectedMessage)){
            excelUtils.setCellData("PASS", 0, tcid, 5);
        } else {
            excelUtils.setCellData("FAIL", 0, tcid, 5);
        }

        Assert.assertTrue(errorMessage.contains(expectedMessage));

    }

    @DataProvider(name = "loginTestData")
    public Object[][] testData() {


        // Object[][] data = {
        //         {"ntthanhngan.2001@gmail.com", "Thanhngan@123456", ""},
        //         {"", "Thanhngan@123456", "Yêu cầu tên tài khoản"},
        //         {"ntthanhngan.2001@gmail.com", "", "Mục nhập mật khẩu trống"},
        //         {"ntthanhngan.2001", "", "Invalid email address."}
        // };

        

        
        int rowCount = excelUtils.getRowCount(0);

        Object[][] data = new Object[rowCount-1][4];

        for (int i = 1; i < rowCount; i++) {
            String email = excelUtils.getData(0, i, 1);
            String password = excelUtils.getData(0, i, 2);
            String expectedMessage = excelUtils.getData(0, i, 3);
            String testCaseId = excelUtils.getData(0, i, 0);
            System.out.println("Email: " + email + ", Password: " + password + ", Expected Message: " + expectedMessage);
            data[i-1][0] = email;
            data[i-1][1] = password;
            data[i-1][2] = expectedMessage; 
            data[i-1][3] = testCaseId;
        }


        
        return data;
    }


    public String getErrorMess(){
        try {
            // Get the error message
            WebElement errorMessageLocator = driver.findElement(By.cssSelector("ul[role=\"alert\"] li"));
            String errorMessage = errorMessageLocator.getText();
            return errorMessage;
        } catch (Exception e) {
            return "";
        }
    }

    

}