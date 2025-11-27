package com.pages.ICEPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.Keys;
import com.utils.Utils;
import java.util.concurrent.ThreadLocalRandom;

public class AddEmployeePage extends BasePage {

    private By employeeId = By.xpath("//*[@id='employee_id']");
    private By firstName = By.xpath("//*[@id='first_name']");
    private By lastName = By.xpath("//*[@id='last_name']");
    private By saveButton = By.xpath("//button[@type='button']//span[text()='Save']");
    // Consolidated locators for Steps 1-5
    private By nationalityInput = By.xpath("(//span[@class='ant-select-selection-search'])[2]");
    private String nationalityOptionXpath = "//div[@class='ant-select-item-option-content'and text()='%s']";
    private By birthdayInput = By.xpath("(//input[@id='birthday'])");
    private By yearSelectLocator = By.xpath("//button[@class='ant-picker-year-btn']");
    private By yearPrevLocator = By.xpath("//button[@class='ant-picker-header-super-prev-btn']");
    private By select1999Locator = By.xpath("//td[@title='1999']");
    private By selectJanLocator = By.xpath("//td[@title='1999-01']");
    private By select29Locator = By.xpath("//td[@title='1999-01-29']");
    private By genderLocator = By.xpath("(//span[@class='ant-select-selection-search'])[3]");
    private By maritalStatusLocator = By.xpath("(//span[@class='ant-select-selection-search'])[4]");
    private String stepLocatorTemplate = "(//*[@class='ant-steps-item-title'])[%d]";
    private By employmentStatusLocator = By.xpath("(//*[@class='ant-select-selection-search-input'])[7]");
    private By departmentLocator = By.xpath("(//*[@class='ant-select-selection-search-input'])[8]");
    private By jobTitleLocator = By.xpath("(//*[@class='ant-select-selection-search-input'])[9]");
    private By startDatePicker = By.xpath("(//*[@class='ant-picker-input'])[2]");
    private By visibleTodayBtn = By.xpath("//div[contains(@class, 'ant-picker-dropdown') and not(contains(@class, 'ant-picker-dropdown-hidden'))]//a[contains(@class, 'ant-picker-today-btn')]");
    private By timeZoneInput = By.xpath("(//*[@class='ant-select-selection-search-input'])[11]");
    private By countryInput = By.xpath("(//*[@class='ant-select-selection-search-input'])[12]");
    private String optionXpathTemplate = "//div[@class='ant-select-item-option-content'and text()='%s']";

    public AddEmployeePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    // random
    // 1. Hàm sinh số ngẫu nhiên (Giữ nguyên logic để dùng nội bộ)
    private String generateRandomNumber(int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int randomDigit = ThreadLocalRandom.current().nextInt(0, 10);
            sb.append(randomDigit);
        }
        return sb.toString();
    }

    /**
     * Hàm này tự động tạo ID gồm 8 CHỮ SỐ, điền vào ô và trả về giá trị ID đó.
     * Không cần truyền tham số nữa.
     * @return String ID (8 số) vừa tạo
     */
    public String setRandomEmployeeId() {
        // Cố định độ dài là 8 số tại đây
        String randomId = generateRandomNumber(8); 
        
        setEmployeeId(randomId); // Gọi hàm điền vào UI
        return randomId;         // Trả về để verify
    }

    // 2. Hàm setEmployeeId cũ (Giữ nguyên để thực hiện hành động nhập)
    public void setEmployeeId(String id) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(employeeId));
        element.clear(); 
        element.sendKeys(id);
    }

    public void setFirstAndLastName(String fName, String lName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstName)).sendKeys(fName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(lastName)).sendKeys(lName);
    }

    public String getFirstNameValue() {
        return driver.findElement(firstName).getAttribute("value");
    }

    public String getLastNameValue() {
        return driver.findElement(lastName).getAttribute("value");
    }

    public void clickSave() {
        wait.until(ExpectedConditions.elementToBeClickable(saveButton)).click();
    }

    public void setNationality(String text, String optionText) {
        WebElement inputElement = wait.until(ExpectedConditions.visibilityOfElementLocated(nationalityInput));
        Actions action = new Actions(driver);
        action.click(inputElement).pause(500).sendKeys(text).pause(2000).build().perform();
        By optionLocator = By.xpath(String.format(nationalityOptionXpath, optionText));
        wait.until(ExpectedConditions.elementToBeClickable(optionLocator)).click();
    }

    public void selectBirthday1999Jan29() {
        WebElement birthday = wait.until(ExpectedConditions.elementToBeClickable(birthdayInput));
        birthday.click();
        wait.until(ExpectedConditions.elementToBeClickable(yearSelectLocator)).click();
        WebElement yearPrevElement = wait.until(ExpectedConditions.visibilityOfElementLocated(yearPrevLocator));
        Actions dateAction = new Actions(driver);
        dateAction.click(yearPrevElement).pause(500).click(yearPrevElement).pause(500).click(yearPrevElement).build().perform();
        wait.until(ExpectedConditions.elementToBeClickable(select1999Locator)).click();
        wait.until(ExpectedConditions.elementToBeClickable(selectJanLocator)).click();
        wait.until(ExpectedConditions.elementToBeClickable(select29Locator)).click();
    }

    public void setGender(String genderText) {
        wait.until(ExpectedConditions.elementToBeClickable(genderLocator)).click();
        By option = By.xpath(String.format(optionXpathTemplate, genderText));
        wait.until(ExpectedConditions.elementToBeClickable(option)).click();
    }

    public void setMaritalStatus(String statusText) {
        wait.until(ExpectedConditions.elementToBeClickable(maritalStatusLocator)).click();
        By option = By.xpath(String.format(optionXpathTemplate, statusText));
        wait.until(ExpectedConditions.elementToBeClickable(option)).click();
    }

    public void goToStep(int stepNumber) {
        By stepLocator = By.xpath(String.format(stepLocatorTemplate, stepNumber));
        wait.until(ExpectedConditions.elementToBeClickable(stepLocator)).click();
    }

    public void setEmploymentDetails(String employmentStatus, String department, String jobTitle) {
        // Employment Status
        wait.until(ExpectedConditions.elementToBeClickable(employmentStatusLocator)).click();
        By empOption = By.xpath(String.format(optionXpathTemplate, employmentStatus));
        wait.until(ExpectedConditions.elementToBeClickable(empOption)).click();
        Utils.hardWait(1000);

        // Department
        wait.until(ExpectedConditions.elementToBeClickable(departmentLocator)).click();
        By deptOption = By.xpath(String.format(optionXpathTemplate, department));
        wait.until(ExpectedConditions.elementToBeClickable(deptOption)).click();
        Utils.hardWait(500);

        // Job Title
        wait.until(ExpectedConditions.elementToBeClickable(this.jobTitleLocator)).click();
        By jobOption = By.xpath(String.format(optionXpathTemplate, jobTitle));
        wait.until(ExpectedConditions.elementToBeClickable(jobOption)).click();
        Utils.hardWait(500);
    }

    public void setStartDateToday() {
        wait.until(ExpectedConditions.elementToBeClickable(startDatePicker)).click();
        Utils.hardWait(1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(visibleTodayBtn)).click();
    }

    public void setTimeZone(String partialText, String optionText) {
        WebElement inputTimeElement = wait.until(ExpectedConditions.visibilityOfElementLocated(timeZoneInput));
        Actions TimeAction = new Actions(driver);
        TimeAction.click(inputTimeElement).pause(500).sendKeys(partialText).pause(2000).build().perform();
        By option = By.xpath(String.format(optionXpathTemplate, optionText));
        wait.until(ExpectedConditions.elementToBeClickable(option)).click();
    }

    public void setCountry(String partialText, String optionText) {
        WebElement countryElement = wait.until(ExpectedConditions.elementToBeClickable(countryInput));
        Actions CountryAction = new Actions(driver);
        CountryAction.click(countryElement).pause(500).sendKeys(partialText).pause(2000).build().perform();
        By option = By.xpath(String.format(optionXpathTemplate, optionText));
        wait.until(ExpectedConditions.elementToBeClickable(option)).click();
    }
}

