package com;

import org.testng.Assert;
import org.testng.annotations.Test;

//import static org.junit.jupiter.api.Assertions.fail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement; // Import this
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.pages.Tikipage.CartPage;
import com.pages.Tikipage.CollectPage;
import com.pages.Tikipage.Homepage;
import com.pages.Tikipage.ProductPage;
import com.utils.BasicTest;
import com.utils.Utils;

public class Bai26_OrderProductTest extends BasicTest {
    @Test()
    public void orderProductTest() throws Exception {
        Homepage homepage = new Homepage(driver);
        CollectPage collectpage = new CollectPage(driver);
        ProductPage productpage = new ProductPage(driver);
        CartPage cartpage = new CartPage(driver);
        
        // Launch website
        homepage.open(homepage.url);
        Utils.hardWait(1000);
        Utils.takeScreenshot(driver, "img1");
       // check banner
        boolean isBannerDisplayed = isElementDisplayedQuickly( By.id("VIP_BUNDLE"), 5);        
        Utils.takeScreenshot(driver, "img2");

        if (isBannerDisplayed) {
            System.out.println("Banner found, closing it...");
            By closeButtonLocator = By.xpath("//img[@alt='close-icon']");
            waitElementClickable(closeButtonLocator).click();
        }
        else {
            System.out.println("Banner not found, continuing...");
        }
        
        // click item menu
        homepage.clickCategory();
        Utils.takeScreenshot(driver, "img3");

        // click Item đầu tiên
        collectpage.clickMenu();
        Utils.takeScreenshot(driver, "img4");

        Utils.hardWait(2000);

        collectpage.clickItem();
        Utils.takeScreenshot(driver, "img5");
        Utils.hardWait(3000);

        // // add Item cart
         //productpage.addItemCart();
       
        // // By Accountlogin = By.xpath("//div[@class='sc-7d80e456-25 gVBJYa']");
        // // waitElementClickable(Accountlogin).click();
        // productpage.fillphone("0357422081");
        // productpage.clickContinue();
        // productpage.fillpass("D@ng291199");
        // productpage.clickLogin();
//         Utils.hardWait(2000);
//         productpage.clickCart();
        

        // cartpage.clickBorder();
        // Utils.hardWait(2000);
        // cartpage.clickPlus();
        // Utils.hardWait(500);
        // plus Item ->False sticky
        // take screen shot
        cartpage.addItemCart();
        Utils.takeScreenshot(driver, "img6");
        Utils.hardWait(2000);
        
        String unitPriceStr = cartpage.getUnitPrice();
        Utils.hardWait(2000);
        String totalPriceStr = cartpage.getTotalPrice();
        String quantityStr = cartpage.Quantity();

        double unitPrice = parsePrice(unitPriceStr);
        double totalPrice = parsePrice(totalPriceStr);
        int quantity = Integer.parseInt(quantityStr.trim()); // Hoặc dùng Double nếu cần

        double expectedTotal = unitPrice * quantity ;
        System.out.println("Giá trị tạm tính"+ expectedTotal);
        System.out.println("Giá trị tổng tiền"+ totalPrice);
        System.out.println("Số lượng"+ quantity);
        Assert.assertEquals(totalPrice, expectedTotal,5.0, "Tổng giá tiền không khớp sau khi tăng số lượng.");
        
   }
private double parsePrice(String priceString) {
    if (priceString == null || priceString.trim().isEmpty()) {
        return 0.0;
    }

    String cleanedString = priceString.replaceAll("[^0-9]", ""); 
    
    try {
        return Double.parseDouble(cleanedString);
    } catch (NumberFormatException e) {
        System.err.println("Lỗi phân tích giá: " + priceString);
        return 0.0; 
    }
 }
}