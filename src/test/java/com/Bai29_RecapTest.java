package com;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.utils.BasicTest;
import com.utils.Utils;
// import org.openqa.selenium.we;

public class Bai29_RecapTest extends BasicTest {

    @Test(dataProvider = "loginDataFeed")
    public void employeeManagementTest(String email, String password, String expectedMessage) throws Exception {
        // Mở trang đăng nhập
        String url = "https://icehrm-open.gamonoid.com/login.php";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);

        /*
         * Trang login
         */
        // Nhập email
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='username']"))).sendKeys(email);
        // Nhập password
        WebElement passwordInput = driver.findElement(By.xpath("//*[@id='password']"));
        passwordInput.sendKeys(password);
        // Click nút đăng nhập
        By loginBtnLocator = By.xpath("(//*[@type='button'])[1]");
        WebElement loginBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(loginBtnLocator));
        loginBtn.click();

        /*
         * Trang Dashboard
         * click vào Employee -> Employee
         */
        // check banner
        boolean isBannerDisplayed = isElementDisplayedQuickly(By.xpath("(//*[@class='modal-content'])[8]"), 5);
        // Utils.takeScreenshot(driver, "img2");

        if (isBannerDisplayed) {
            System.out.println("Banner found, closing it...");
            By closeButtonLocator = By.xpath("(//*[@class='close'])[8]");
            waitElementClickable(closeButtonLocator).click();
        } else {
            System.out.println("Banner not found, continuing...");
        }

        // click Employees
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[@class='treeview'])[1]"))).click();
        // click Employee con
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='admin_Employees']"))).click();

        /*
         * Trang Employee
         */
        // click Add a Employee
        Utils.hardWait(3000);
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("(//*[contains(text(),'Add a New Employee')])[1]"))).click();
        Utils.hardWait(3000);
        waitElementVisible(By.xpath("//*[@id='employee_id']")).click();

        /*
         * Trang Add Employee
         */

        // điền các thông tin bắt buộc Personal
        // điền Employee Number
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='employee_id']")))
                .sendKeys("18050644");
        // điền First Name
        WebElement firstNameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='first_name']")));
        firstNameInput.sendKeys("Nguyen");
        Utils.hardWait(3000);
        // điền Last Name
        WebElement lastNameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='last_name']")));
        lastNameInput.sendKeys("Dang");
        // click Nationality
        Utils.hardWait(5000);

        // 1. Tìm ô Input (Vẫn dùng XPath input chuẩn mà mình đã đưa ở trên)
        By inputLocator = By.xpath("(//span[@class='ant-select-selection-search'])[2]");
        WebElement inputElement = wait.until(ExpectedConditions.visibilityOfElementLocated(inputLocator));

        // 2. Dùng Action để mô phỏng: Click -> Gõ từ từ
        Actions action = new Actions(driver);

        action.click(inputElement) // Click để kích hoạt dropdown
                .pause(500) // Nghỉ 1 xíu
                .sendKeys("Vietnam") // Gõ chữ
                .pause(2000) // Chờ 2 giây cho API load (Thay cho Wait)
                .build()
                .perform(); // Thực hiện chuỗi hành động

        // 3. Sau đó mới chọn kết quả
        By optionLocator = By
                .xpath("//div[@class='ant-select-item-option-content'and text()='Vietnamese']");
        wait.until(ExpectedConditions.elementToBeClickable(optionLocator)).click();

        // click birthday
        // trỏ vào ô
        WebElement BirthdayLocator = waitElementVisible(By.xpath("(//input[@id='birthday'])"));
        BirthdayLocator.click();
        // trỏ vào năm 2025 (//button[@class='ant-picker-year-btn'])
        By yearSelectLocator = By.xpath("//button[@class='ant-picker-year-btn']");
        wait.until(ExpectedConditions.elementToBeClickable(yearSelectLocator)).click();
        // trở về năm 1999 click trở 3 lần
        // (//button[@class='ant-picker-header-super-prev-btn'])
        By yearPrevLocator = By.xpath("//button[@class='ant-picker-header-super-prev-btn']");
        WebElement yearPrevElement = wait.until(ExpectedConditions.visibilityOfElementLocated(yearPrevLocator));
        Actions dateAction = new Actions(driver);

        dateAction.click(yearPrevElement)
                .pause(500) // Nên pause giữa các lần click
                .click(yearPrevElement)
                .pause(500)
                .click(yearPrevElement)
                .build()
                .perform();
        // chọn o năm 1999 (//td[@title='1999'])
        By select1999Locator = By.xpath("//td[@title='1999']");
        wait.until(ExpectedConditions.elementToBeClickable(select1999Locator)).click();
        // chọn tháng (//td[@title='1999-01'])
        By selectJanLocator = By.xpath("//td[@title='1999-01']");
        wait.until(ExpectedConditions.elementToBeClickable(selectJanLocator)).click();
        // chọn ngày (//td[@title='1999-01-29'])
        By select29Locator = By.xpath("//td[@title='1999-01-29']");
        wait.until(ExpectedConditions.elementToBeClickable(select29Locator)).click();

        // click Gender ((//span[@class='ant-select-selection-search']))[3]//input
        By genderLocator = By.xpath("(//span[@class='ant-select-selection-search'])[3]");
        wait.until(ExpectedConditions.elementToBeClickable(genderLocator)).click();
        // chọn male //div[@class='ant-select-item-option-content'and text()='Male']
        By maleOptionLocator = By.xpath("//div[@class='ant-select-item-option-content'and text()='Male']");
        wait.until(ExpectedConditions.elementToBeClickable(maleOptionLocator)).click();
        // Marital Status (//span[@class='ant-select-selection-search'])[4]
        By maritalStatusLocator = By.xpath("(//span[@class='ant-select-selection-search'])[4]");
        wait.until(ExpectedConditions.elementToBeClickable(maritalStatusLocator)).click();
        // single //div[@class='ant-select-item-option-content'and text()='Single']
        By singleOptionLocator = By.xpath("//div[@class='ant-select-item-option-content'and text()='Single']");
        wait.until(ExpectedConditions.elementToBeClickable(singleOptionLocator)).click();
        Utils.hardWait(1000);

        /**
         * Click Step 3
         */
        By step3Locator = By.xpath("(//*[@class='ant-steps-item-title'])[3]");
        wait.until(ExpectedConditions.elementToBeClickable(step3Locator)).click();

        // click Employment Status
        By employmentStatusLocator = By.xpath("(//*[@class='ant-select-selection-search-input'])[7]");
        wait.until(ExpectedConditions.elementToBeClickable(employmentStatusLocator)).click();
        // chọn Full Time Contractdiv[@class='ant-select-item-option-content'and
        // text()='Full Time Contract']
        By fullTimeOptionLocator = By
                .xpath("//div[@class='ant-select-item-option-content'and text()='Full Time Contract']");
        wait.until(ExpectedConditions.elementToBeClickable(fullTimeOptionLocator)).click();
        Utils.hardWait(1000);

        // Department (//*[@class='ant-select-selection-search-input'])[8]
        By departMentLocator = By.xpath("(//*[@class='ant-select-selection-search-input'])[8]");
        wait.until(ExpectedConditions.elementToBeClickable(departMentLocator)).click();
        // chọn QA Team[@class='ant-select-item-option-content'and text()='QA Team']
        By QAoptionLocator = By.xpath("//div[@class='ant-select-item-option-content'and text()='QA Team']");
        wait.until(ExpectedConditions.elementToBeClickable(QAoptionLocator)).click();
        Utils.hardWait(500);
        // click Job Title (//*[@class='ant-select-selection-search-input'])[9]
        By jobTitleLocator = By.xpath("(//*[@class='ant-select-selection-search-input'])[9]");
        wait.until(ExpectedConditions.elementToBeClickable(jobTitleLocator)).click();
        // chọn Automation Engineerdiv[@class='ant-select-item-option-content'and
        // text()='Software Engineer']
        By autoEngineerLocator = By
                .xpath("//div[@class='ant-select-item-option-content'and text()='Software Engineer']");
        wait.until(ExpectedConditions.elementToBeClickable(autoEngineerLocator)).click();
        Utils.hardWait(500);

        // 1. Click mở lịch
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@class='ant-picker-input'])[2]"))).click();
        Utils.hardWait(1000); // Chờ popup hiện ra

        // 2. XPath CHÍNH XÁC chọn nút Today đang hiển thị
        // Giải thích: Tìm trong cái dropdown nào KHÔNG BỊ ẨN (not hidden), sau đó mới
        // tìm nút Today bên trong nó.
        By visibleTodayBtn = By.xpath(
                "//div[contains(@class, 'ant-picker-dropdown') and not(contains(@class, 'ant-picker-dropdown-hidden'))]//a[contains(@class, 'ant-picker-today-btn')]");

        // 3. Click
        wait.until(ExpectedConditions.visibilityOfElementLocated(visibleTodayBtn)).click();

        // time zone
        By TimeLocator = By.xpath("(//*[@class='ant-select-selection-search-input'])[11]");
        WebElement inputTimeElement = wait.until(ExpectedConditions.visibilityOfElementLocated(TimeLocator));

        // 2. Dùng Action để mô phỏng: Click -> Gõ từ từ
        Actions TimeAction = new Actions(driver);

        TimeAction.click(inputTimeElement) // Click để kích hoạt dropdown
                .pause(500) // Nghỉ 1 xíu
                .sendKeys("Ho_") // Gõ chữ
                .pause(2000) // Chờ 2 giây cho API load (Thay cho Wait)
                .build()
                .perform(); // Thực hiện chuỗi hành động

        // 3. Sau đó mới chọn kết quả
        By HoChiMinhLocator = By
                .xpath("//div[@class='ant-select-item-option-content'and text()='(GMT+07:00) Asia/Ho_Chi_Minh']");
        wait.until(ExpectedConditions.elementToBeClickable(HoChiMinhLocator)).click();
        
        /**
         * Click Step 4
         */
        By step4Locator = By.xpath("(//*[@class='ant-steps-item-title'])[4]");
        wait.until(ExpectedConditions.elementToBeClickable(step4Locator)).click();

        //Country (//*[@class='ant-select-selection-search-input'])[12]
        By countryLocator = By.xpath("(//*[@class='ant-select-selection-search-input'])[12]");
        WebElement countryElement = wait.until(ExpectedConditions.elementToBeClickable(countryLocator));
        // chọn Vietnam //div[@class='ant-select-item-option-content'and text()='Vietnam']
        
        // 2. Dùng Action để mô phỏng: Click -> Gõ từ từ
        Actions CountryAction = new Actions(driver);

        CountryAction.click(countryElement) // Click để kích hoạt dropdown
                .pause(500) // Nghỉ 1 xíu
                .sendKeys("Viet Nam") // Gõ chữ
                .pause(2000) // Chờ 2 giây cho API load (Thay cho Wait)
                .build()
                .perform(); // Thực hiện chuỗi hành động

        // 3. Sau đó mới chọn kết quả
        By VietnamLocator = By
                .xpath("//div[@class='ant-select-item-option-content'and text()='Viet Nam']");
        wait.until(ExpectedConditions.elementToBeClickable(VietnamLocator)).click();

        /**
         * Click Step 5
         */    
        By step5Locator = By.xpath("(//*[@class='ant-steps-item-title'])[5]");
        wait.until(ExpectedConditions.elementToBeClickable(step5Locator)).click();

        // click Save //button[@type='button']//span[text()='Save']
        By saveBtnLocator = By.xpath("//button[@type='button']//span[text()='Save']");
        wait.until(ExpectedConditions.elementToBeClickable(saveBtnLocator)).click();
        
        // search name //input[@placeholder='Search by Name']
        String fName = firstNameInput.getAttribute("value"); 
        String lName = lastNameInput.getAttribute("value");
        
        // Ghép chuỗi (Ví dụ: "Nguyen Dang")
        // trim() để cắt khoảng trắng thừa 2 đầu nếu có
        String fullName = (fName + " " + lName).trim(); 
        
        System.out.println("Tên cần tìm hover: " + fullName);

        // --- BƯỚC 2: TÌM KIẾM ---
        By searchByNameLocator = By.xpath("//input[@placeholder='Search by Name']");
        WebElement searchByNameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(searchByNameLocator));
        
        // Xóa dữ liệu cũ trong ô search trước khi gõ (Best practice)
        searchByNameElement.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
        
        // Gõ tên (Chỉ gõ Last Name "Dang" như bạn muốn, hoặc gõ cả Full Name đều được)
        // 1. Nhập tên
        searchByNameElement.sendKeys("Dang");
        Utils.hardWait(500);

        // 2. Tìm nút Search (kính lúp) bên cạnh và Click
        // Logic: Tìm nút button có chứa icon search (class 'anticon-search')
        By searchBtnLocator = By.xpath("//button[.//span[contains(@class, 'anticon-search')]]");

        wait.until(ExpectedConditions.elementToBeClickable(searchBtnLocator)).click();
        
        // Chờ kết quả search load xong
        Utils.hardWait(2000); 

        // --- BƯỚC 3: HOVER VÀO TÊN TÌM THẤY ---
        
        // Tạo XPath động: Chèn biến fullName vào trong chuỗi XPath
        // Mình dùng contains() cho an toàn, phòng trường hợp web hiển thị có thêm dấu cách
        By resultNameLocator = By.xpath("//*[@class='ant-list-item-meta-title' and contains(text(), '" + fullName + "')]");
        
        try {
            WebElement nameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(resultNameLocator));
            
            // Thực hiện hành động Hover
            Actions Nameaction = new Actions(driver);
            Nameaction.moveToElement(nameElement).perform();
            
            String actualNameOnWeb = nameElement.getText().trim();
            
            System.out.println("Tên tìm thấy trên web: " + actualNameOnWeb);

            Assert.assertEquals(actualNameOnWeb, fullName, "Sai tên nhân viên hiển thị!");
            
        } catch (Exception e) {
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
