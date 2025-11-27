package com;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.pages.ICEPage.LoginPage;
import com.pages.ICEPage.DashboardPage;
import com.pages.ICEPage.EmployeePage;
import com.pages.ICEPage.AddEmployeePage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.utils.BasicTest;
import com.utils.Utils;
// import org.openqa.selenium.we;

public class Bai29_RecapTest extends BasicTest {

    @Test(dataProvider = "loginDataFeed")
    public void employeeManagementTest(String email, String password, String expectedMessage) throws Exception {
        // Mở trang đăng nhập -> dùng Page Objects
        String url = "https://icehrm-open.gamonoid.com/login.php";
        LoginPage loginPage = new LoginPage(driver, wait);
        DashboardPage dashboard = new DashboardPage(driver, wait);
        EmployeePage employeePage = new EmployeePage(driver, wait);
        AddEmployeePage addEmployee = new AddEmployeePage(driver, wait);

        loginPage.open(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        loginPage.login(email, password);

        // Dashboard: close banner if present and navigate to Employees
        dashboard.closeBannerIfPresent();

        Utils.takeScreenshot(driver, "img1");
        Utils.hardWait(1000);
        dashboard.goToEmployees();


        // Employee: click "Add a New Employee"
        Utils.hardWait(3000);
        employeePage.clickAddNewEmployee();
        Utils.hardWait(3000);
        /**
         * Click Step 1
         */
        // Add Employee: fill basic required fields
        addEmployee.setEmployeeId("18050648");
        addEmployee.setFirstAndLastName("Nguyen", "Dang");
        Utils.hardWait(5000);

        addEmployee.setNationality("Vietnam", "Vietnamese");
        addEmployee.selectBirthday1999Jan29();
        addEmployee.setGender("Male");
        addEmployee.setMaritalStatus("Single");
        addEmployee.goToStep(3);
        addEmployee.setEmploymentDetails("Full Time Contract", "QA Team", "Software Engineer");
        addEmployee.setStartDateToday();
        addEmployee.setTimeZone("Ho_", "(GMT+07:00) Asia/Ho_Chi_Minh");
        addEmployee.goToStep(4);
        addEmployee.setCountry("Viet Nam", "Viet Nam");
        addEmployee.goToStep(5);
        addEmployee.clickSave();
        
        // search name using DashboardPage helper
        String fName = addEmployee.getFirstNameValue();
        String lName = addEmployee.getLastNameValue();
        String fullName = (fName + " " + lName).trim();
        System.out.println("Tên cần tìm hover: " + fullName);

        dashboard.searchByName("Dang");
        Utils.hardWait(2000);

        String actualNameOnWeb = dashboard.getResultName(fullName);
        if (actualNameOnWeb != null) {
            Assert.assertEquals(actualNameOnWeb, fullName, "Sai tên nhân viên hiển thị!");
        } else {
            System.out.println("Lỗi: Không tìm thấy nhân viên tên '" + fullName + "' trong danh sách kết quả!");
        }

    }

    @DataProvider(name = "loginDataFeed")
    public Object[][] testDataFeed() {
        return new Object[][] {
                // Test Case 1: Valid Login (Expected to succeed)
                { "admin", "admin", "" },

        };
    }

    public boolean isElementDisplayed(By by) {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(by)).isDisplayed();
        } catch (Exception e) {
            return false;// TODO: handle exception
        }
    }

    public String getErrorMessage(By byElementlocator) {

        try {
            WebElement element = driver.findElement(byElementlocator);
            return element.getText();
        } catch (Exception e) {
            // TODO: handle exception
            return "";
        }

    }

}
