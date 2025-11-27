package com.pages.ICEPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EmployeePage extends BasePage {

    private By addNewEmployeeButton = By.xpath("(//*[contains(text(),'Add a New Employee')])[1]");
    private By employeeIdField = By.xpath("//*[@id='employee_id']");

    public EmployeePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void clickAddNewEmployee() {
        wait.until(ExpectedConditions.elementToBeClickable(addNewEmployeeButton)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(employeeIdField)).click();
    }
}
