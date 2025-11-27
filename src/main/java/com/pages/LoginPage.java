    package com.pages;

    import org.openqa.selenium.By;
    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.WebElement;
    import org.openqa.selenium.support.FindBy;
    import org.openqa.selenium.support.ui.ExpectedConditions;
    import org.testng.Assert;

    public class LoginPage extends BasePage{

        public LoginPage(WebDriver givenDriver) {
            super(givenDriver);

        }
        // public By regEmailBy = By.xpath("//input[@id='reg_email']"); 
        // public By regPassBy = By.xpath("//input[@id='reg_password']");
        // public By butResBy = By.xpath("//button[@name='register']");
        // public By ErrorMessage = By.xpath("//ul[@class='woocommerce-error']");

        // Res
        @FindBy(xpath = "//input[@id='reg_email']")
        public WebElement regEmailBy;
        @FindBy(xpath = "//input[@id='reg_password']")
        public WebElement regPassBy;
        @FindBy(xpath = "//button[@name='register']")
        public WebElement butResBy;
        @FindBy(xpath = "//ul[@class='woocommerce-error']")
        public WebElement ErrorMessage;
        //login
        @FindBy(xpath = "//a[@title='Giỏ hàng của bạn']/b")
        public WebElement cartQuantityElement; 
        @FindBy(xpath = "//input[@id='username']")
        public WebElement usernameInp;
        @FindBy(xpath = "//input[@id='password']")
        public WebElement passwordInp;
        @FindBy(xpath = "//button[text()='Đăng nhập']")
        public WebElement loginBtn;
        // @FindBy(xpath = "//button[text()='Đăng nhập']")
        // public WebElement loginLocator;
        // @FindBy(xpath = "//button[text()='Đăng nhập']")
        // public WebElement loginLocator;
        public By loginLocator = By.xpath("//button[text()='Đăng nhập']");
        public String url ="https://bantheme.xyz/hathanhauto/tai-khoan/";
        public LoginPage open(String url) {
            driver.get(url);
            return this;
        }

         public LoginPage fillRegemail(String string) {
            wait.until(ExpectedConditions.visibilityOf(regEmailBy));
                regEmailBy.sendKeys(string);
                return this;
         }
         public LoginPage fillRegpass(String string) {
            wait.until(ExpectedConditions.visibilityOf(regPassBy));
            regPassBy.sendKeys(string);
            return this;
        }
        public LoginPage clickRegister() {
            wait.until(ExpectedConditions.elementToBeClickable(butResBy));
            butResBy.click();
            return this;
        }   
        public String getErrorMessage(){
            return wait.until(ExpectedConditions.visibilityOf(ErrorMessage)).getText(); //wait.until(ExpectedConditions.visibilityOfElementLocated(ErrorMessage)).getText();
        }
        
        //Login
        public LoginPage fillUsername(String string) {
            wait.until(ExpectedConditions.visibilityOf(usernameInp));
            usernameInp.sendKeys(string);
            return this;    
        }
        public LoginPage fillPassword(String string) {
            wait.until(ExpectedConditions.visibilityOf(passwordInp));
            passwordInp.sendKeys(string);
            return this;    
        }
        public LoginPage clickLogin() {
            wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
            loginBtn.click();
            return this;    
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
            // WebElement cartQuantityElement = driver.findElement(By.xpath(""));
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
    public boolean isElementDisplayed(By by) {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(by)).isDisplayed();
        } catch (Exception e) {
            return false;// TODO: handle exception
        }

    
    }
    }

    


