package com.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class CartPage extends BasicTest { 

    @FindBy(xpath = "//div[contains(@class,'link-cart')]/a/b")
    private WebElement badgeCartCount; 

    @FindBy(xpath = "//p[contains(@class,'cart-empty')]")
    private WebElement emptyCartMessage; 

    private int badgeBeforeAdd = 0;

    // Constructor 
    public CartPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this); 
    }

    // --- Utility Methods ---
    /**
     * Lấy số lượng sản phẩm hiển thị trên badge giỏ hàng
     * Nếu không tìm thấy badge, trả về 0
     */
    private int getBadgeCount() {
        try {
            WebElement badge = waitForElementVisible(badgeCartCount); 
            String text = badge.getText().trim();
            return text.isEmpty() ? 0 : Integer.parseInt(text);
        } catch (Exception e) {
            return 0; 
        }
    }

    //Chờ badge đạt số lượng mong muốn 
    private void waitForExpectedBadgeCount(int expectedCount) {
        WebDriverWait localWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        localWait.until(d -> getBadgeCount() == expectedCount);
    }

    //  Logic Giỏ Hàng 

    // Lưu số lượng badge trước khi thêm sản phẩm
    public CartPage storeBadgeBeforeAdd() {
        badgeBeforeAdd = getBadgeCount(); 
        System.out.println("Badge trước khi thêm: " + badgeBeforeAdd);
        return this;
    }

    //Verify sản phẩm đã thêm có trong giỏ hàng

    public CartPage verifyProductInCart(String expectedProductName) {
        driver.get("https://bantheme.xyz/hathanhauto/gio-hang/");

        By productElementLocator = By.cssSelector("td.product-name a");
        WebElement productElement = waitForElementVisible(productElementLocator);

        String actualName = productElement.getText().trim();
        System.out.println("Tên sản phẩm trong giỏ: " + actualName);

        Assert.assertTrue(actualName.toLowerCase().contains(expectedProductName.toLowerCase()));

        // Verify badge đã tăng sau khi thêm
        verifyBadgeAfterAdd();
        return this;
    }

    //Xác minh badge giỏ hàng tăng 1
    public CartPage verifyBadgeAfterAdd() {
        int expectedCount = badgeBeforeAdd + 1;
        waitForExpectedBadgeCount(expectedCount);

        int badgeAfterAdd = getBadgeCount();
        System.out.println(" Badge sau khi thêm: " + badgeAfterAdd);
        Assert.assertEquals(badgeAfterAdd, expectedCount, " Badge giỏ hàng không tăng đúng!");
        return this;
    }

     //Xóa sản phẩm khỏi giỏ hàng
    public CartPage deleteProductFromCart() {
        int countBeforeDelete = getBadgeCount();

        // Lấy element nút xóa mới mỗi lần
        By deleteButtonLocator = By.cssSelector("a.remove");
        WebElement deleteButton = waitForElementClickable(deleteButtonLocator);
        deleteButton.click();

        // Chờ element bị xóa hoàn toàn
        wait.until(ExpectedConditions.invisibilityOf(deleteButton));

        // Veryfi badge sau khi xóa
        verifyBadgeAfterDelete(countBeforeDelete);
        System.out.println("Đã xóa sản phẩm khỏi giỏ hàng.");
        return this;
    }

    //Verify badge giỏ hàng sau khi xóa sản phẩm
    public CartPage verifyBadgeAfterDelete(int countBeforeDelete) {
        int expectedCount = countBeforeDelete - 1;

        if (expectedCount <= 0) {
            // TH1: Giỏ hàng trống
            waitForElementVisible(emptyCartMessage);
            System.out.println(" Giỏ hàng hiện tại trống.");

        } else {
            // TH2: Giỏ hàng còn sản phẩm (badge giảm 1)
            waitForExpectedBadgeCount(expectedCount);
            int badgeAfterDelete = getBadgeCount();
            Assert.assertEquals(badgeAfterDelete, expectedCount, "Badge giỏ hàng không giảm đúng!");
            System.out.println("Badge sau khi xóa: " + badgeAfterDelete);
        }
        return this;
    }
}