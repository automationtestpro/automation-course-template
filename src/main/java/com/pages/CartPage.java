package com.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

    public class CartPage extends BasePage {

        public CartPage(WebDriver givenDriver) {
            super(givenDriver);

        }
    //WebElement plusitem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='plus']")));
    @FindBy(xpath = "//button[@class='plus']")
    public WebElement plusItem;
    
    //By updateCartLocator = By.xpath("//button[text()='Cập nhật giỏ hàng']");
    //WebElement updateCartBtn = driver.findElement(updateCartLocator);   

    @FindBy(xpath = "//button[text()='Cập nhật giỏ hàng']")
    public WebElement updateCart;

     @FindBy(xpath = "//a[@title='Giỏ hàng của bạn']/b")
    public WebElement cartQuantityElement; 
    //WebElement unitPriceBaseElement = driver.findElement(By.xpath("(//span[@class='woocommerce-Price-amount amount'])[1]"));
       // String unitPriceBaseText = unitPriceBaseElement.getText();
    @FindBy(xpath = "(//span[@class='woocommerce-Price-amount amount'])[1]")
    public WebElement unitPriceBase;
    
    @FindBy(xpath = "(//td[@data-title='Tạm tính'])[1]")
    public WebElement tempPriceElement;
        
    @FindBy(xpath = "//a[contains(text(),'Bơm nước xe Mercedes SLK200, SLK300, GLK200, E260, C350-2742000207 - England')]")
    public WebElement nameItem;
    
    public By updateCartButtonLocator = By.xpath("//button[text()='Cập nhật giỏ hàng']");
    public int expectedQuantity = 0;
    
    public CartPage plusItem() {
        wait.until(ExpectedConditions.visibilityOf(plusItem));
        plusItem.click();;
        
        return this;
    }

    public CartPage updateCart() {
        wait.until(ExpectedConditions.elementToBeClickable(updateCart)).click();
        return this;
    }   
    public String getUnitPriceBaseText() {
    return wait.until(ExpectedConditions.visibilityOf(unitPriceBase)).getText();
    }
    public String getTempPriceText() {
    return wait.until(ExpectedConditions.visibilityOf(tempPriceElement)).getText();
    }
    public String getNameItemcart() {
    return wait.until(ExpectedConditions.visibilityOf(nameItem)).getText();
    }
    
    // Hàm kiểm tra an toàn xem nút 'update' đã bị vô hiệu hóa chưa
    public boolean isUpdateCartDisabled() {
    try {
        // Dùng biến 'By' mà bạn đã tạo
        wait.until(ExpectedConditions.attributeToBe(updateCartButtonLocator, "disabled", "true"));
        // Nếu wait thành công, trả về true
        return true; 
    } catch (Exception e) {
        // Nếu wait thất bại (TimeoutException), bắt lỗi và trả về false
        return false;
    }
}
    
    
    public boolean isCartQuantityTextCorrect(String expectedText) {
    try {
        // Dùng wait để chờ text khớp
        // (Hàm textToBePresentInElement của bạn là đúng khi dùng với WebElement)
        wait.until(ExpectedConditions.textToBePresentInElement(cartQuantityElement, expectedText));
        
        // Nếu wait thành công, trả về true
        return true; 
    } catch (Exception e) {
        // Nếu wait thất bại (văng ra TimeoutException),
        // bắt lỗi đó và trả về false
        return false;
    }
}





    public boolean isElementDisplayed(By by) {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(by)).isDisplayed();
        } catch (Exception e) {
            return false;// TODO: handle exception
        }
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
    }
