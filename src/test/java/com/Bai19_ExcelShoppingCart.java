package com;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.utils.BasicTest;
import com.utils.ExcelUtils;
import com.utils.Utils;
// import org.openqa.selenium.we;


public class Bai19_ExcelShoppingCart extends BasicTest {
    //Bai19_ExcelShoppingCart
    //mvn clean test -Dtest=com.Bai19_ExcelShoppingCart
    public int expectedQuantity = 0;

    public double parsePrice(String priceText) {
        // Loại bỏ ký tự tiền tệ, dấu phẩy (,) và khoảng trắng
        String cleanedPrice = priceText.replace("₫", "").replace(".", "").replace(",", "").trim();
        return Double.parseDouble(cleanedPrice);
    }
    // dùng try catch tránh mới đầu đăng  nhập giỏ hàng =0 thẻ <b> có thể không có giá trị ví dụ là 0
    public int getCurrentCartQuantity() {
        try {
            // XPath: //a[@title='Giỏ hàng của bạn']/b để lấy thẻ <b> (chứa số lượng)
            WebElement cartQuantityElement = driver.findElement(By.xpath("//a[@title='Giỏ hàng của bạn']/b"));
            String cartQuantityText = cartQuantityElement.getText().trim();
            if (cartQuantityText.isEmpty()) {
                return 0;
            }
            return Integer.parseInt(cartQuantityText);
        } catch (Exception e) {
            // Nếu thẻ <b> không tồn tại hoặc lỗi khác (giả định giỏ hàng trống)
            return 0; 
        }
    }

    @Test(dataProvider = "excelData")
    public void loginTest(String Type, String Option , String Origin) throws Exception {
        // Mở trang đăng nhập
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);

        //Nhập email
        WebElement emailInput = driver.findElement(By.xpath("//*[@id='username']"));
        emailInput.sendKeys("mdangdn29@gmail.com");

        //Nhập password
         WebElement passwordInput = driver.findElement(By.xpath("//*[@id='password']"));
         passwordInput.sendKeys("D@ng291199");

         //Click nút đăng nhập
        WebElement loginBtn = driver.findElement(By.xpath("//button[text()='Đăng nhập']"));
        loginBtn.click();
        Utils.hardWait(2000);

        // Kiểm tra đăng nhập thành công
        boolean isLoginDisplay  = isElementDisplayed(loginBtn);
        Assert.assertFalse(isLoginDisplay);
        Utils.hardWait(1000);

        // kiểm tra message hiện ra 
        // By byElementlocator = By.xpath("//*[@class='alert alert-danger']");
        // String errorMessageText = getErrorMessage(byElementlocator);
        // System.out.println("Error Message: " + errorMessageText);
        // Assert.assertEquals(errorMessageText, expectedMessage); 

        expectedQuantity = getCurrentCartQuantity();
        System.out.println("Số lượng giỏ hàng ban đầu: " + expectedQuantity);

        // Click login button
        WebElement searchFieldLocator = driver.findElement(By.xpath("(//input[@name='s'])[1]"));
        searchFieldLocator.sendKeys(Type);
        Utils.hardWait(5000);

        WebElement option1 = driver.findElement(By.xpath(Option));
        option1.click();
        Utils.hardWait(3000);

        WebElement option_Element = driver.findElement(By.xpath("//select[@id='pa_xuat-xu']"));
        option_Element.click();
        Utils.hardWait(1000);
        //org.openqa.selenium.support.ui.Select dropdown = new org.openqa.selenium.support.ui.Select(option_Element);
        //dropdown.selectByVisibleText(Origin);
        WebElement result_Engl = driver.findElement(By.xpath(Origin));
        result_Engl.click();
        Utils.hardWait(1000);

        WebElement addToCartBtn = driver.findElement(By.xpath("//button[@class='single_add_to_cart_button button alt']"));
        addToCartBtn.click();
        Utils.hardWait(2000);
        expectedQuantity++;
        // check displayed add to cart button
        boolean isaddToCartBthDisplay = isElementDisplayed(addToCartBtn);
        Assert.assertFalse(isaddToCartBthDisplay);

        // add item = plus
        WebElement plusitem = driver.findElement(By.xpath("//button[@class='plus']"));
        plusitem.click();
        Utils.hardWait(2000);
        expectedQuantity++;

        // update cart after plus item
        WebElement updatecart = driver.findElement(By.xpath("//button[text()='Cập nhật giỏ hàng']"));
        updatecart.click();
        Utils.hardWait(3000);

        WebElement unitPriceBaseElement = driver.findElement(By.xpath("(//span[@class='woocommerce-Price-amount amount'])[1]"));
        String unitPriceBaseText = unitPriceBaseElement.getText();
        double unitPrice = parsePrice(unitPriceBaseText);
        System.out.println("Giá đơn vị sản phẩm: " + unitPrice);


        
    }
    @DataProvider(name = "loginDataFeed")
    public Object[][] testDataFeed(){
        return new Object[][] {
            // Test Case 1: Valid Login (Expected to succeed)
            {"admin", "admin", ""}, 
            // Test Case 2: Invalid Password (Expected to fail)
           // {"admin", "admin123", "Login failed"}
        };  
    }
    // @DataProvider(name = "shoppingData")
    // public Object[][] shoppingData() {
    //     return new Object[][] {
    //         {"merc", "(//a[contains(text(),'Bơm nước xe ')])[1]", "//select[@id='pa_xuat-xu']/option[2]" },
    //         //{"apple", "VietNam", "20000"}
    //     };
    // }
    @DataProvider(name = "excelData")
    public Object[][] getExcelData() {
    // 1. Chỉ định đường dẫn và tên file Excel
    String filePath = "C:\\Users\\nguye\\OneDrive\\Desktop\\automation\\Automation_selenium\\"; // Thay đổi đường dẫn thực tế
    String fileName = "shoppingcart.xlsx";       // Thay đổi tên file thực tế
    String sheetName = "Sheet1";       // Thay đổi tên sheet thực tế
    
    // 2. Tạo đối tượng ExcelUtils
    ExcelUtils excel = new ExcelUtils(filePath, fileName);
    
    // 3. Lấy dữ liệu
    return excel.getTestData(sheetName);
}
    // @DataProvider(name = "loginData2")
    // public Object[][] loginData2(){
    //     return new Object[][] {
    //         {"mdangdn29@gmail.com","D@ng291199" ,"error message"},
    //         {"","D@ng291199"},
    //         {"mdangdn29","123456"}
    //     };  
    // }

    public boolean isElementDisplayed(WebElement element){

        try {
            return element.isDisplayed();
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }

    }
        public String getErrorMessage(By byElementlocator){
        
            try {
                WebElement element = driver.findElement(byElementlocator);
                return element.getText();
            } catch (Exception e) {
                // TODO: handle exception
                return "";
            }

        }

}
