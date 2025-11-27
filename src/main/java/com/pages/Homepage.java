package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

// add library
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Homepage extends BasePage {

    //public WebDriver driver;

    public Homepage(WebDriver givenDriver) {
        super(givenDriver);
    }

    //By username = By.xpath("//input[@id='username']");
    
    public By address = By.xpath("//*[@placeholder='Bạn muốn đi đâu?']");
    public By checkin = By.xpath("(//div[@class='sb-dropdown__result-item ng-star-inserted'])[1]");
    public By date = By.xpath("(//*[@type='button'])[1]");
    
    // Xóa 2 biến locator cũ vì chúng ta sẽ tạo động
    // public By fistdate = By.xpath("//div[@id='2025-11-12']");
    // public By seconddate = By.xpath("//div[@id='2025-11-15']");
    
    public By searchBy = By.xpath("(//span[contains(text(),'Tìm')])[1]");

    public void fillAddress(String string) {
       //findElement(address).sendKeys(string, Keys.ENTER);
       wait.until(ExpectedConditions.visibilityOfElementLocated(address)).sendKeys(string);
    }
    public void clickCheckin() { 
        wait.until(ExpectedConditions.elementToBeClickable(checkin)).click();
        //findElement(checkin).click();
    }
    public void clickDate() { 
        //findElement(date).click();
        wait.until(ExpectedConditions.elementToBeClickable(date)).click();
    }
    
    /**
     * Phương thức này sẽ click vào ngày sau hôm nay 1 tuần (7 ngày)
     */
    public void clickDatefirst() { 
        // Lấy ngày hiện tại + 7 ngày
        LocalDate oneWeekFromNow = LocalDate.now().plusDays(7);
        // Click vào ngày đó trên lịch
        clickDateOnCalendar(oneWeekFromNow);
    }
    
    /**
     * Phương thức này sẽ click vào ngày sau hôm nay 10 ngày (tức là 3 ngày sau ngày check-in)
     */
    public void clickDatesecond() { 
        // Lấy ngày hiện tại + 10 ngày (7 ngày + 3 ngày)
        LocalDate tenDaysFromNow = LocalDate.now().plusDays(10);
        // Click vào ngày đó trên lịch
        clickDateOnCalendar(tenDaysFromNow);
    }

    /**
     * Phương thức helper (hỗ trợ) để click vào một ngày bất kỳ trên lịch
     * @param date: Ngày (LocalDate) cần click
     */
    private void clickDateOnCalendar(LocalDate date) {
        // Định dạng ngày thành chuỗi "YYYY-MM-DD" (giống như id của element)
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String dateString = date.format(formatter);
        
        // Tạo ra locator XPath động
        // Ví dụ: //div[@id='2025-11-03']
        String xpathLocator = "//div[@id='" + dateString + "']";
        By dateLocator = By.xpath(xpathLocator);
        
        System.out.println("Đang click vào ngày: " + dateString);
        
        // Đợi và click
        try {
            wait.until(ExpectedConditions.elementToBeClickable(dateLocator)).click();
        } catch (Exception e) {
            System.out.println("Không tìm thấy ngày: " + dateString + ". Lỗi: " + e.getMessage());
            // Lưu ý: Nếu ngày bạn chọn nằm ở tháng sau, 
            // có thể bạn cần thêm logic để click nút "Next month" rồi tìm lại.
        }
    }

    public void search() {
        // TODO Auto-generated method stub
        // findElement(searchBy).click(); // Bỏ dòng này vì dòng dưới đã wait
        wait.until(ExpectedConditions.elementToBeClickable(searchBy)).click(); 
    }
    
}