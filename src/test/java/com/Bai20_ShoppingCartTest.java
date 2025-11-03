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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.utils.BasicTest;
import com.utils.Utils;




public class Bai20_ShoppingCartTest extends BasicTest {

        // Dữ liệu đăng nhập

        @DataProvider(name="LoginDataFeed")
        public Object[][] LoginDataFeed() {
        return new Object[][]{
            {"huadongxuan852@gmail.com", "xuanice123", "merc", "Bơm nước xe Mercedes"}           };
        }

    @Test(dataProvider = "LoginDataFeed")

    
    public void shoppingCartTest(String userName, String passWord, String keyWord, String expectedProductName) throws Exception {
        loginAccount(userName, passWord);
        searchAndOpenProduct(keyWord, expectedProductName);
        storeBadgeBeforeAdd(expectedProductName);
        addProductToCart(expectedProductName);
        verifyProductInCart(expectedProductName);
        deleteProductFromCart();
    
    }
        
        private int countBefore;

        private void loginAccount(String userName, String passWord){
            // Mở trang đăng nhập
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);

        //  login
        waitElementVisible("//input[@id='username']").sendKeys(userName);
        waitElementVisible("//input[@id='password']").sendKeys(passWord);
        waitElementClickable("//button[@name='login']").click();
        waitElementVisible("//p[contains(text(), 'Xin chào')]");
        System.out.println("Đăng nhập thành công");
    }
        
        private void searchAndOpenProduct(String keyWord, String expectedProductName){

        //Tìm kiếm sản phẩm
        waitElementVisible("(//input[@id='s'])[1]").sendKeys(keyWord + Keys.ENTER);

        //Chọn kết quả đầu tiên (Bơm nước xe)
        waitElementClickable("//a[contains(text(),'" + expectedProductName + "')][1]").click();
        WebElement dropdown =  waitElementClickable("//*[@id='pa_xuat-xu']");
        Select select = new Select(dropdown);
        select.selectByIndex(1);

    }

        private void storeBadgeBeforeAdd(String expectedProductName){

        //Badge trước khi thêm
        WebElement badgeBeforeAdd = waitElementVisible("//div[@class='d-table-cell link-cart']/a/b");
        String badgeTextBefore = badgeBeforeAdd.getText().trim();
         if (badgeTextBefore.isEmpty()) {
            countBefore = 0;
        } else {
        countBefore = Integer.parseInt(badgeTextBefore);
    
    }

} 
        
        private void addProductToCart(String expectedProductName){
        //Thêm sản phẩm vào giỏ hàng
        waitElementClickable("//button[contains(text(),'Thêm')]").click();
        waitElementVisible("//td[@class='product-name']/a");

    }

        private void verifyProductInCart(String expectedProductName){

        //Kiểm tra badge tăng sau khi thêm
        WebElement badgeAfterAdd = waitElementVisible("//div[@class='d-table-cell link-cart']/a/b");
        int countAfter = Integer.parseInt(badgeAfterAdd.getText());
        int badgeAdd = 1;
        Assert.assertEquals(countAfter, countBefore + badgeAdd, "Badge giỏ hàng tăng không đúng!");

        //Kiểm tra mở giỏ hàng sau khi thêm sản phẩm
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("/gio-hang/"), "Không mở trang giỏ hàng sau khi thêm!");

        //Kiểm tra sản phẩm trong giỏ hàng
        WebElement productName = waitElementVisible("//td[@class='product-name']/a");
        Assert.assertTrue(productName.getText().contains(expectedProductName), "Tên sản phẩm không đúng!");

        // Lấy giá sản phẩm
        WebElement priceProduct = waitElementVisible(By.xpath("//td[@class='product-price']//bdi"));
        String priceText = priceProduct.getText().replaceAll("[^\\d]", ""); 
        int price = Integer.parseInt(priceText);
        Assert.assertTrue(price > 0, "Giá tiền hiển thị sai!");

        //Kiểm tra số lượng
        WebElement qtyInCart  = waitElementVisible(By.xpath("//input[contains(@class,'qty')]"));
        int qty = Integer.parseInt(qtyInCart .getAttribute("value"));
        Assert.assertTrue(qty > 0, "Số lượng không đúng!");

        // Lấy subtotal và verify tổng
        WebElement subTotalProduct = waitElementVisible(By.xpath("//td[@class='product-subtotal']//bdi"));
        String subtotalText = subTotalProduct.getText().replaceAll("[^\\d]", "");
        int subtotal = Integer.parseInt(subtotalText);
        Assert.assertEquals(subtotal, price * qty, "Tổng giá không đúng!");
    }

         private void deleteProductFromCart(){

        //kiểm tra noti trc khi xóa
        WebElement badgeBeforeDelete = waitElementVisible("//div[@class='d-table-cell link-cart']/a/b");
        int countBeforeDelete = Integer.parseInt(badgeBeforeDelete.getText());

        //Kiểm tra nút xóa và bấm xóa
        WebElement deleteBtn = waitElementClickable(By.cssSelector("a.remove"));
        Assert.assertTrue(deleteBtn.isEnabled());
        deleteBtn.click();

        //kiểm tra khi xóa sp thành công
        WebElement deleteProduct = waitElementVisible("//div[@class='woocommerce-message']");
        Assert.assertTrue(deleteProduct.isDisplayed());
        

        //kiểm tra giỏ hàng trống
        if (countBeforeDelete == 1) {
        waitElementVisible(By.xpath("//p[contains(@class,'cart-empty')]"));
       
        System.out.println("Không có sản phẩm nào trong giỏ hàng.");
        }  else {
        // Nếu giỏ hàng còn sản phẩm, kiểm tra badge giảm 1
        WebElement badgeAfterDelete = waitElementVisible("//div[@class='d-table-cell link-cart']/a/b");
        int countAfterDeleted = Integer.parseInt(badgeAfterDelete.getText());
        Assert.assertEquals(countBeforeDelete - 1, countAfterDeleted, "Số lượng badge giỏ hàng giảm không đúng");
    }
}

    /*public boolean isElementDisplayed(WebElement element){

        try {
            return element.isDisplayed();
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
        
    }*/

}
