package com;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.utils.BasicTest;
import com.utils.ExcelUtils;

public class Bai23_ICHRM_LoginExcel extends BasicTest {

    // Khai báo đường dẫn file Excel cố định để dùng chung
    String EXCEL_PATH = "C:\\Users\\nguye\\OneDrive\\Desktop\\automation\\Automation_selenium\\";
    String EXCEL_FILE_NAME = "Login.xlsx"; // Tên file của bạn
    String EXCEL_SHEET_NAME = "Sheet1";

    ExcelUtils excelUtils;

    // Cột trong Excel (Tính từ 0)
    final int COL_ACTUAL_RESULT = 4; // Cột E
    final int COL_TEST_REPORT = 5;   // Cột F

    @BeforeClass
    public void setupExcel() {
        // Khởi tạo ExcelUtils một lần
        excelUtils = new ExcelUtils(EXCEL_PATH, EXCEL_FILE_NAME);
    }

    @Test(dataProvider = "excelData")
public void loginTest(String tcID, String username, String password, String expectedMessage, String actualPlaceholder, String statusPlaceholder) throws Exception {
    System.out.println("---------------------------------------");
    System.out.println("Dang chay Test Case ID: " + tcID);

    // 1. Mở trang và nhập liệu
    driver.get("https://www.saucedemo.com/");
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='user-name']"))).clear();
    driver.findElement(By.xpath("//*[@id='user-name']")).sendKeys(username);
    driver.findElement(By.xpath("//*[@id='password']")).clear();
    driver.findElement(By.xpath("//*[@id='password']")).sendKeys(password);
    driver.findElement(By.xpath("//input[@id='login-button']")).click();

    // 2. Xử lý kết quả thực tế (Linh hoạt hơn)
    String actualMessage = "";
    boolean loginSuccess = false;

    try {
        // Chờ tối đa 10s cho Dashboard HOẶC thông báo lỗi xuất hiện
        // Nếu Dashboard xuất hiện trước -> Đăng nhập thành công
        // Nếu thông báo lỗi xuất hiện trước -> Đăng nhập thất bại
        
        // Locator cho Dashboard (Cần chính xác, bạn hãy kiểm tra lại trên web thật)
        By dashboardLoc = By.xpath("//span[contains(text(),'Products')]"); 
        // Locator cho thông báo lỗi
        By errorLoc = By.xpath("//*[@class='error-message-container error']");

        // Dùng try-catch lồng nhau để kiểm tra từng điều kiện mà không bị chết chương trình
        try {
             // Ưu tiên kiểm tra lỗi trước vì nó thường hiện nhanh hơn nếu có
             if (driver.findElements(errorLoc).size() > 0 && driver.findElement(errorLoc).isDisplayed()) {
                 actualMessage = driver.findElement(errorLoc).getText().trim();
                 loginSuccess = false;
             } else {
                 // Nếu không có lỗi thì chờ Dashboard
                 wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardLoc));
                 actualMessage = "Login thành công (Vào được Dashboard)";
                 loginSuccess = true;
            }
        } catch (Exception e) {
            // Nếu chờ Dashboard cũng timeout nốt -> Có thể web lag hoặc locator sai
             actualMessage = "Lỗi: Không xác định được trạng thái đăng nhập (Timeout).";
        }

    } catch (Exception e) {
        actualMessage = "Lỗi ngoại lệ: " + e.getMessage();
    }

    System.out.println("=> Actual: " + actualMessage);

    // 3. Ghi kết quả vào Excel
    excelUtils.setCellData(actualMessage, 0, tcID, COL_ACTUAL_RESULT);

    // 4. So sánh và ghi PASS/FAIL
    try {
        if (expectedMessage.isEmpty()) {
            // Mong đợi thành công
            Assert.assertTrue(loginSuccess, "Mong đợi Login thành công nhưng thực tế lại thất bại!");
        } else {
            // Mong đợi thất bại -> So sánh nội dung lỗi
            Assert.assertEquals(actualMessage, expectedMessage, "Thông báo lỗi không khớp!");
        }
        excelUtils.setCellData("PASS", 0, tcID, COL_TEST_REPORT);
        System.out.println("=> Trạng thái: PASS");
    } catch (AssertionError e) {
        excelUtils.setCellData("FAIL", 0, tcID, COL_TEST_REPORT);
        System.out.println("=> Trạng thái: FAIL");
        throw e; // Vẫn ném lỗi để TestNG báo đỏ
    }
}

    @DataProvider(name = "excelData")
    public Object[][] getExcelData() {
        // Sử dụng lại excelUtils đã khởi tạo
        return excelUtils.getTestData(EXCEL_SHEET_NAME);
    }
}