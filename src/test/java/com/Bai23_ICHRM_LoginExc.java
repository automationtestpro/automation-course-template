package com;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement; 
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.utils.BasicTest;
import com.pages.Hathanhpage.Page.LoginHTPage;
import com.pages.Hathanhpage.Page.AccountHTPage;
import com.pages.Hathanhpage.Page.CartHTPage;
import com.pages.Hathanhpage.Page.ProductHTPage;
//---------------------------------------------------------
import com.utils.Utils;

// --- Đã ĐỔI TÊN class ---
public class Bai23_ICHRM_LoginExc extends BasicTest {
    public int expectedQuantity = 0;


    @Test()
    public void shoppingCartTest() throws Exception {
        LoginHTPage loginPage = new LoginHTPage(driver);
        AccountHTPage accountPage = new AccountHTPage(driver); 
        ProductHTPage productPage = new ProductHTPage(driver);
        CartHTPage cartPage = new CartHTPage(driver);
        //------------------------------------------------

        // Launch website
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        loginPage.open(url);

        // Login
        loginPage.fillEmail("mdangdn29@gmail.com") 
                 .fillPass("D@ng291199")
                 .clickLogin();

        // check login success
        boolean isLoginDisplay = loginPage.isElementDisplayed(loginPage.loginLocator);
        Assert.assertFalse(isLoginDisplay);

        // check cart quantity view account 
        expectedQuantity = loginPage.getCurrentCartQuantity();
        System.out.println("Số lượng giỏ hàng ban đầu: " + expectedQuantity);

        // Search for "merc"
        accountPage.search("merc");

        // option after search
        accountPage.clickSearchResult();

        // select option Orginal
        productPage.option_Element();

        // click option Orginal England
        productPage.result_Engl();

        // add to cart
        productPage.addToCart();
        expectedQuantity++;

        // check button add Item display
        boolean isaddToCartBthDisplay = productPage.isElementDisplayed(productPage.addToCartLocator);
        Assert.assertFalse(isaddToCartBthDisplay);

        // add item = plus
        cartPage.plusItem();
        expectedQuantity++;
        System.out.println("Số lượng giỏ hàng sau khi thêm sản phẩm: " + expectedQuantity);

        // update cart after plus item
        cartPage.updateCart();

        // CHỜ cho nút đó trở lại trạng thái VÔ HIỆU HÓA (disable).
        cartPage.isUpdateCartDisabled();

        // check view item in cart
        String addnewitemText = cartPage.getNameItemcart();
        System.out.println("Message item: " + addnewitemText);
        Assert.assertTrue(addnewitemText.contains("Bơm nước xe Mercedes SLK200, SLK300, GLK200, E260, C350-2742000207 - England"));

        // Get unit price
        String unitPriceBaseText = cartPage.getUnitPriceBaseText();
        double unitPrice = cartPage.parsePrice(unitPriceBaseText);
        System.out.println("Giá đơn vị sản phẩm: " + unitPrice);

        // Get temporary price
        String tempPriceText = cartPage.getTempPriceText();
        double actualTempPrice = cartPage.parsePrice(tempPriceText); 
        System.out.println("Giá Tạm tính Thực tế: " + actualTempPrice);
        
        // Tính Giá dự kiến (Giá đơn vị * Số lượng dự kiến)
        double expectedTotalPrice = unitPrice * expectedQuantity;
        
        // ASSERT GIÁ TIỀN
        Assert.assertEquals(expectedTotalPrice, actualTempPrice, 0.001,
            "Lỗi: Giá Tạm tính không khớp. Dự kiến: " + expectedTotalPrice + ", Thực tế: " + actualTempPrice);
        
            // print out expected and actual temp price
        System.out.println("Giá Tạm tính Dự kiến: " + expectedTotalPrice); 
        System.out.println("Giá Tạm tính Thực tế: " + actualTempPrice);
        
        // hỏi
        // Biến expectedQuantity chỉ tồn tại trong file test
        String expectedText = String.valueOf(expectedQuantity);
        
        // Gọi hàm kiểm tra an toàn
        boolean isQuantityCorrect = cartPage.isCartQuantityTextCorrect(expectedText);
        
        // Bây giờ bạn có thể Assert một cách an toàn
        Assert.assertTrue(isQuantityCorrect, "Lỗi: Số lượng giỏ hàng trên web không khớp với dự kiến.");

        // (Sau đó bạn vẫn có thể lấy số lượng thực tế để so sánh lần nữa nếu muốn)
        int actualQuantity = cartPage.getCurrentCartQuantity();
        Assert.assertEquals(expectedQuantity, actualQuantity, 
            "Lỗi: Số lượng giỏ hàng không khớp sau khi thêm sản phẩm. " + 
            "Dự kiến: " + expectedQuantity + ", Thực tế: " + actualQuantity);
        
        //print out expected and actual cart quantity
        System.out.println("Số lượng giỏ hàng Dự kiến: " + expectedQuantity);
        
    }
    
}