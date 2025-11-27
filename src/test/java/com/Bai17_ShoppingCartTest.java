package com;

import org.testng.Assert;
import org.testng.annotations.Test;

//import static org.junit.jupiter.api.Assertions.fail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement; // Import this
import org.openqa.selenium.support.ui.ExpectedConditions;

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
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='username']"))).sendKeys("mdangdn29@gmail.com");

        // Input password
        WebElement passwordInp = driver.findElement(By.xpath("//*[@id='password']"));
        passwordInp.sendKeys("D@ng291199");

        // Click login button
        WebElement loginBtn = driver.findElement(By.xpath("//button[text()='Đăng nhập']"));
        loginBtn.click();

        // check login success
        // Add a small wait to ensure the element is not displayed anymore
        By loginLocator = By.xpath("//button[text()='Đăng nhập']");
        wait.until(ExpectedConditions.invisibilityOfElementLocated(loginLocator));
        boolean isLoginDisplay = isElementDisplayed(loginLocator);
        Assert.assertFalse(isLoginDisplay);

        expectedQuantity = getCurrentCartQuantity();
        System.out.println("Số lượng giỏ hàng ban đầu: " + expectedQuantity);
        
         
        // Search for "merc"
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@name='s'])[1]"))).sendKeys("merc");

        // option after search
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[contains(text(),'Bơm nước xe ')])[1]"))).click();
        //WebElement option1 = driver.findElement((By.xpath("(//a[contains(text(),'Bơm nước xe ')])[1]")));
        //option1.click();
        
        // select option Orginal
        WebElement option_Element = driver.findElement(By.xpath("//select[@id='pa_xuat-xu']"));
        option_Element.click();

        // click option Orginal England
        WebElement result_Engl = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='pa_xuat-xu']/option[2]")));
        result_Engl.click();

        // add to cart
        WebElement addToCartBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='single_add_to_cart_button button alt']")));
        addToCartBtn.click();
        //wait.until(ExpectedConditions.invisibilityOf(addToCartBtn));
        expectedQuantity++;

        By addToCartLocator = By.xpath("//button[@class='single_add_to_cart_button button alt']");
        wait.until(ExpectedConditions.invisibilityOfElementLocated(addToCartLocator));
       
        // check displayed add to cart button
        boolean isaddToCartBthDisplay = isElementDisplayed(addToCartLocator);
        Assert.assertFalse(isaddToCartBthDisplay);

        // add item = plus
        WebElement plusitem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='plus']")));
        plusitem.click();
        expectedQuantity++;
        System.out.println("Số lượng giỏ hàng sau khi thêm sản phẩm: " + expectedQuantity);

        // update cart after plus item
        //WebElement updateCartBtn = driver.findElement(By.xpath("//button[text()='Cập nhật giỏ hàng']"));
        By updateCartLocator = By.xpath("//button[text()='Cập nhật giỏ hàng']");
        WebElement updateCartBtn = driver.findElement(updateCartLocator);   

        updateCartBtn.click();
        // CHỜ cho nút đó trở lại trạng thái VÔ HIỆU HÓA (disable).
        // Đây là xác nhận rằng quá trình AJAX đã hoàn tất
        wait.until(ExpectedConditions.attributeToBe(updateCartLocator, "disabled", "true"));

        //wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//button[text()='Cập nhật giỏ hàng']")));
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
        WebElement tempPriceElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//td[@data-title='Tạm tính'])[1]")));
        String tempPriceText = tempPriceElement.getText();
        double actualTempPrice = parsePrice(tempPriceText); 
        System.out.println("Giá Tạm tính Thực tế: " + actualTempPrice);
       
        // Tính Giá dự kiến (Giá đơn vị * Số lượng dự kiến)
        double expectedTotalPrice = unitPrice * expectedQuantity;
       
        // ASSERT GIÁ TIỀN
        Assert.assertEquals(expectedTotalPrice, actualTempPrice, 0.001,
            "Lỗi: Giá Tạm tính không khớp. Dự kiến: " + expectedTotalPrice + ", Thực tế: " + actualTempPrice);
       
            // print out expected and actual temp price
        System.out.println("Giá Tạm tính Dự kiến: " + expectedTotalPrice); // Sẽ luôn in ra
        System.out.println("Giá Tạm tính Thực tế: " + actualTempPrice);
        
        // hỏi
        // Locator của giỏ hàng là: //a[@title='Giỏ hàng của bạn']/b
        By cartQuantityLocator = By.xpath("//a[@title='Giỏ hàng của bạn']/b");

        // Chờ cho nội dung văn bản của phần tử giỏ hàng khớp với số lượng dự kiến
        wait.until(ExpectedConditions.textToBePresentInElementLocated(cartQuantityLocator, String.valueOf(expectedQuantity)));

        // Get current cart quantity
        int actualQuantity = getCurrentCartQuantity();
        System.out.println("Số lượng giỏ hàng hiện tại: " + actualQuantity);

        // seems like expectedQuantity always +1 more than actualQuantity
        Assert.assertEquals(expectedQuantity, actualQuantity, 
            "Lỗi: Số lượng giỏ hàng không khớp sau khi thêm sản phẩm. " + 
            "Dự kiến: " + expectedQuantity + ", Thực tế: " + actualQuantity);
        //print out expected and actual cart quantity
        System.out.println("Số lượng giỏ hàng Dự kiến: " + expectedQuantity);
          
    }
   
    public boolean isElementDisplayed(By by) {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(by)).isDisplayed();
        } catch (Exception e) {
            return false;// TODO: handle exception
        }

    
    }
}