package com;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.utils.BasicTest;
import com.utils.LoginPage;
import com.utils.SearchProductPage;
import com.utils.CartPage;

public class Bai23_PageFactoryShoppingCart extends BasicTest {

    @DataProvider(name = "LoginDataFeed")
    public Object[][] LoginDataFeed() {
        return new Object[][]{
            {"huadongxuan852@gmail.com", "xuanice123", "merc"}
        };
    }

    @Test(dataProvider = "LoginDataFeed")
    public void shoppingCartTest(String userName, String passWord, String keyWord) {
        // Login
        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.open()
                 .login(userName, passWord)
                 .verifyLoginSuccess();

        // Search sp và chọn sp
        SearchProductPage searchPage = new SearchProductPage(driver, wait);
        searchPage.searchProduct(keyWord)  
                  .openFirstProduct()     
                  .selectOptionByIndex(1); 

        // Xử lý giỏ hàng
        CartPage cartPage = new CartPage(driver, wait);
        cartPage.storeBadgeBeforeAdd();      
        searchPage.addProductToCart();       
        cartPage.verifyBadgeAfterAdd();
        cartPage.deleteProductFromCart(); 
        
    }
}