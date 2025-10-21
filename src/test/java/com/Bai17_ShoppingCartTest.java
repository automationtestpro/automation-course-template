package com;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import com.utils.BasicTest;
import com.utils.Utils;




public class Bai17_ShoppingCartTest extends BasicTest {


    @Test()
    public void shoppingCartTest() throws Exception {
        // Mở trang đăng nhập
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);

        // Đăng nhập hợp lệ
        WebElement emailInput = driver.findElement(By.xpath("//input[@id='username']"));
        emailInput.sendKeys("huadongxuan852@gmail.com");

        WebElement passwordInput  = driver.findElement(By.xpath("//input[@id='password']"));
        passwordInput.sendKeys("xuanice123");

        WebElement loginBtn = driver.findElement(By.xpath("//button[@name='login']"));
        loginBtn.click();
        Utils.hardWait(3000);

        // Kiểm đăng nhập thành công (nút login biến mất)
        boolean isLoginDisplay = isElementDisplayed(loginBtn);
        Assert.assertFalse(isLoginDisplay);
        Utils.hardWait(3000);

        //Tìm kiếm sản phẩm
        WebElement searchInput = driver.findElement(By.xpath("(//input[@id='s'])[1]"));
        searchInput.sendKeys("merc" + Keys.ENTER);
        Utils.hardWait(2000);

        //Chọn kết quả đầu tiên (Bơm nước xe)
        WebElement firstResult = driver.findElement(By.xpath("//a[contains(text(),'Bơm nước xe')][1]"));
        firstResult.click();
        Utils.hardWait(2000);

        // Lấy dropdown
        WebElement dropdown = driver.findElement(By.id("pa_xuat-xu"));
        dropdown.click();
        Utils.hardWait(500); 
        //Chọn option
        WebElement optionSelect= driver.findElement(By.xpath("//*[@id='pa_xuat-xu']/option[2]"));
        optionSelect.click();
        Utils.hardWait(500);

        //Badge trước khi thêm
        WebElement badgeBeforeAdd = driver.findElement(By.xpath("//div[@class='d-table-cell link-cart']/a/b"));
        int countBefore = Integer.parseInt(badgeBeforeAdd.getText());
        Utils.hardWait(1000);

        //Thêm sản phẩm vào giỏ hàng
        WebElement addBtn = driver.findElement(By.xpath("//button[contains(text(),'Thêm')]"));
        addBtn.click();
        Utils.hardWait(2000);

        //Kiểm tra badge tăng sau khi thêm
        WebElement badgeAfterAdd = driver.findElement(By.xpath("//div[@class='d-table-cell link-cart']/a/b"));
        int countAfter = Integer.parseInt(badgeAfterAdd.getText());
        int badgeAdd = 1;
        Assert.assertEquals(countAfter,  countBefore + badgeAdd, "Badge giỏ hàng tăng không đúng!");
        Utils.hardWait(2000);

        //Kiểm tra mở giỏ hàng sau khi thêm sản phẩm
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("/gio-hang/"), "Không mở trang giỏ hàng sau khi thêm!");

        //Kiểm tra sản phẩm trong giỏ hàng
        WebElement productName = driver.findElement(By.xpath("//td[@class='product-name']/a"));
        Assert.assertTrue(productName.getText().contains("Bơm nước xe Mercedes"), "Tên sản phẩm không đúng!");


        // Lấy giá sản phẩm
        WebElement priceProduct = driver.findElement(By.xpath("//td[@class='product-price']//bdi"));
        String priceText = priceProduct.getText().replaceAll("[^\\d]", ""); 
        int price = Integer.parseInt(priceText);
        Assert.assertTrue(price > 0, "Giá tiền hiển thị sai!");

        //Kiểm tra số lượng
        WebElement qtyInCart  = driver.findElement(By.xpath("//input[contains(@class,'qty')]"));
        int qty = Integer.parseInt(qtyInCart .getAttribute("value"));
        Assert.assertTrue(qty > 0, "Số lượng không đúng!");

        // Lấy subtotal và verify tổng
        WebElement subTotalProduct = driver.findElement(By.xpath("//td[@class='product-subtotal']//bdi"));
        String subtotalText = subTotalProduct.getText().replaceAll("[^\\d]", "");
        int subtotal = Integer.parseInt(subtotalText);
        Assert.assertEquals(subtotal, price * qty, "Tổng giá không đúng!");

        //kiểm tra noti trc khi xóa
        WebElement badgeBeforeDelete = driver.findElement(By.xpath("//div[@class='d-table-cell link-cart']/a/b"));
        int countBeforeDelete = Integer.parseInt(badgeBeforeDelete.getText());
        Utils.hardWait(1000);


        //Kiểm tra nút xóa và bấm xóa
        WebElement deleteBtn = driver.findElement(By.cssSelector("a.remove"));
        Assert.assertTrue(deleteBtn.isEnabled());
        deleteBtn.click();
        Utils.hardWait(1000);


        //kiểm tra khi xóa sp thành công

        WebElement deleteProduct = driver.findElement(By.xpath("//div[@class='woocommerce-message']"));
        Assert.assertTrue(deleteProduct.isDisplayed());
        Utils.hardWait(5000);

        //Kiểm tra noti sau khi xóa sản phẩm
        WebElement badgeAfterDelete = driver.findElement(By.xpath("//div[@class='d-table-cell link-cart']/a/b"));
        int countAfterDeleted = Integer.parseInt(badgeAfterDelete.getText());
        Assert.assertEquals(countBeforeDelete - 1, countAfterDeleted);
        Utils.hardWait(2000);

    }

   
    public boolean isElementDisplayed(WebElement element){

        try {
            return element.isDisplayed();
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
        
    }

}
