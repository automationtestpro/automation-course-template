package com;

import org.testng.Assert;
import org.testng.annotations.Test;

//import static org.junit.jupiter.api.Assertions.fail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement; // Import this
import com.utils.BasicTest;
import com.utils.Utils;

public class Bai17_ShoppingCartTest extends BasicTest {
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
    @Test()
    public void shoppingCartTest() throws Exception {
        // Launch website
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);

        // Input username
        WebElement emailInp = driver.findElement(By.xpath("//*[@id='username']"));
        emailInp.sendKeys("mdangdn29@gmail.com");

        // Input password
        WebElement passwordInp = driver.findElement(By.xpath("//*[@id='password']"));
        passwordInp.sendKeys("D@ng291199");

        // Click login button
        WebElement loginBtn = driver.findElement(By.xpath("//button[text()='Đăng nhập']"));
        loginBtn.click();

        // Add a small wait to ensure the element is not displayed anymore
        Utils.hardWait(2000);
        boolean isLoginDisplay = isElementDisplayed(loginBtn);
        Assert.assertFalse(isLoginDisplay);

        expectedQuantity = getCurrentCartQuantity();
        System.out.println("Số lượng giỏ hàng ban đầu: " + expectedQuantity);
        
         
        // Click login button
        WebElement searchFieldLocator = driver.findElement(By.xpath("(//input[@name='s'])[1]"));
        searchFieldLocator.sendKeys("merc");
        Utils.hardWait(5000);

        WebElement option1 = driver.findElement(By.xpath("(//a[contains(text(),'Bơm nước xe ')])[1]"));
        option1.click();
        Utils.hardWait(3000);

        //WebElement result1 = driver.findElement(By.xpath("(//img[@class='attachment-woocommerce_thumbnail size-woocommerce_thumbnail'])[1]"));
        //result1.click();
        //Utils.hardWait(3000);

        WebElement option_Element = driver.findElement(By.xpath("//select[@id='pa_xuat-xu']"));
        option_Element.click();
        Utils.hardWait(1000);

        WebElement result_Engl = driver.findElement(By.xpath("//select[@id='pa_xuat-xu']/option[2]"));
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
       
        // check view item in cart
        WebElement addnewitem = driver.findElement(By.xpath("//a[contains(text(),'Bơm nước xe Mercedes SLK200, SLK300, GLK200, E260, C350-2742000207 - England')]"));
        String addnewitemText = addnewitem.getText();
        System.out.println("Message item: " + addnewitemText);
        Assert.assertTrue(addnewitemText.contains("Bơm nước xe Mercedes SLK200, SLK300, GLK200, E260, C350-2742000207 - England"));

        // Get unit price
        WebElement unitPriceBaseElement = driver.findElement(By.xpath("(//span[@class='woocommerce-Price-amount amount'])[1]"));
        String unitPriceBaseText = unitPriceBaseElement.getText();
        double unitPrice = parsePrice(unitPriceBaseText);
        System.out.println("Giá đơn vị sản phẩm: " + unitPrice);

        // Get temporary price
       WebElement tempPriceElement = driver.findElement(By.xpath("//td[@data-title='Tạm tính']/span[@class='woocommerce-Price-amount amount']"));
        String tempPriceText = tempPriceElement.getText();
        double actualTempPrice = parsePrice(tempPriceText); 
        
        // Tính Giá dự kiến (Giá đơn vị * Số lượng dự kiến)
        double expectedTotalPrice = unitPrice * expectedQuantity;
        // ASSERT GIÁ TIỀN
        Assert.assertEquals(expectedTotalPrice, actualTempPrice, 0.001,
            "Lỗi: Giá Tạm tính không khớp. Dự kiến: " + expectedTotalPrice + ", Thực tế: " + actualTempPrice);
        // print out expected and actual temp price
        System.out.println("Giá Tạm tính Dự kiến: " + expectedTotalPrice); // Sẽ luôn in ra
        System.out.println("Giá Tạm tính Thực tế: " + actualTempPrice);
        // Get current cart quantity
        int actualQuantity = getCurrentCartQuantity();
        System.out.println("Số lượng giỏ hàng hiện tại: " + actualQuantity);

        // seems like expectedQuantity always +1 more than actualQuantity
        Assert.assertEquals(expectedQuantity, actualQuantity, 
            "Lỗi: Số lượng giỏ hàng không khớp sau khi thêm sản phẩm. " + 
            "Dự kiến: " + expectedQuantity + ", Thực tế: " + actualQuantity);
        //print out expected and actual cart quantity
        System.out.println("Số lượng giỏ hàng Dự kiến: " + expectedQuantity);
        //System.out.println("Số lượng giỏ hàng Thực tế: " + actualQuantity); 
       
        //check login fail (//img[@class='attachment-woocommerce_thumbnail size-woocommerce_thumbnail'])[1]
        //WebElement errorMessage = driver.findElement(By.xpath("//ul[@class='woocommerce-error']"));
        //String errorMessageText = errorMessage.getText();
        //System.out.println("Error Message: " + errorMessageText);
        //Assert.assertTrue(errorMessageText.contains("Mật khẩu bạn nhập cho địa chỉ email mdangdn29@gmail.com không đúng"));   
    }
   
    //@Test()
    public void loginTestFailed() throws Exception {
        // Launch website
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);

        // Input username
        WebElement emailInp = driver.findElement(By.xpath("//*[@id='username']"));
        emailInp.sendKeys("mdangdn29@gmail.com");

        // Input password
        WebElement passwordInp = driver.findElement(By.xpath("//*[@id='password']"));
        passwordInp.sendKeys("");

        // Click login button
        WebElement loginBtn = driver.findElement(By.xpath("//button[text()='Đăng nhập']"));
        loginBtn.click();

        // Add a small wait to ensure the element is not displayed anymore
        //Utils.hardWait(2000);
        //boolean isLoginDisplay = isElementDisplayed(loginBtn);
        //Assert.assertFalse(isLoginDisplay);
    

        Utils.hardWait(5000);

        //check login fail
        WebElement errorMessage = driver.findElement(By.xpath("//ul[@class='woocommerce-error']"));
        String errorMessageText = errorMessage.getText();
        System.out.println("Error Message: " + errorMessageText);
        Assert.assertTrue(errorMessageText.contains("Mục nhập mật khẩu trống."));   
    }

    public boolean isElementDisplayed(WebElement element){
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            return false;// TODO: handle exception
        }
    }
}