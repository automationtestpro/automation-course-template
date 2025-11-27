package com.pages.Hathanhpage.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.pages.BasePage;
import com.pages.LoginPage;
public class LoginHTPage extends BasePage{
    
        public LoginHTPage (WebDriver givenDriver) {
            super(givenDriver);

        }
        // Register
        public By regEmailBy = By.xpath("//input[@id='reg_email']"); 
        public By regPassBy = By.xpath("//input[@id='reg_password']");
        public By butResBy = By.xpath("//button[@name='register']");
        public By ErrorMessage = By.xpath("//ul[@class='woocommerce-error']");

        // Login
        public By cartQuantityElement = By.xpath("//a[@title='Giỏ hàng của bạn']/b");
        public By usernameInp = By.xpath("//input[@id='username']");
        public By passwordInp = By.xpath("//input[@id='password']");
        public By loginBtn = By.xpath("//button[text()='Đăng nhập']");
        public By loginLocator = By.xpath("//button[text()='Đăng nhập']");

        public String url ="https://bantheme.xyz/hathanhauto/tai-khoan/";
        public LoginHTPage open(String url) {
            driver.get(url);
            return this;
        }
        
         public LoginHTPage fillEmail(String string) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(usernameInp)).sendKeys(string);
            return this;
         }
         
         public LoginHTPage fillPass(String string) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInp)).sendKeys(string);
            return this;
        }
        public LoginHTPage clickLogin() {
            wait.until(ExpectedConditions.elementToBeClickable(loginBtn)).click();
            return this;
        }
        public String getErrorMessage(){
            return wait.until(ExpectedConditions.visibilityOfElementLocated(ErrorMessage)).getText(); //wait.until(ExpectedConditions.visibilityOfElementLocated(ErrorMessage)).getText();
        }
        
        
        
    public double parsePrice(String priceText) {
        // Loại bỏ ký tự tiền tệ, dấu phẩy (,) và khoảng trắng
        String cleanedPrice = priceText.replace("₫", "").replace(".", "").replace(",", "").trim();
        return Double.parseDouble(cleanedPrice);
    }
    // dùng try catch tránh mới đầu đăng  nhập giỏ hàng =0 thẻ <b> có thể không có giá trị ví dụ là 0
   
    public int getCurrentCartQuantity() {
        try {
            // XPath: //a[@title='Giỏ hàng của bạn']/b để lấy thẻ <b> (chứa số lượng)
            WebElement cartElement = wait.until(ExpectedConditions.visibilityOfElementLocated(cartQuantityElement));
            String cartQuantityText = cartElement.getText().trim();
            if (cartQuantityText.isEmpty()) {
                return 0;
            }
            return Integer.parseInt(cartQuantityText);
        } catch (Exception e) {
            // Nếu thẻ <b> không tồn tại hoặc lỗi khác (giả định giỏ hàng trống)
            return 0; 
        }
    }
    public boolean isElementDisplayed(By by) {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(by)).isDisplayed();
        } catch (Exception e) {
            return false;// TODO: handle exception
        }

    
    }
    }

    


