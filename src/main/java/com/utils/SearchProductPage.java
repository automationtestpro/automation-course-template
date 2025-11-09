package com.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchProductPage extends BasicTest {

    @FindBy(xpath = "(//input[@id='s'])[1]")
    private WebElement searchInput;

    @FindBy(xpath = "//button[contains(text(),'Thêm')]")
    private WebElement addToCartButton;

    @FindBy(xpath = "//div[contains(@class,'woocommerce-message')]")
    private WebElement addMessage;

    private By dropdownOriginLocator = By.id("pa_xuat-xu");

    public SearchProductPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }
     
    //Tìm kiếm sản phẩm bằng keyword
    public SearchProductPage searchProduct(String keyWord) {
        waitForElementVisible(searchInput).sendKeys(keyWord + Keys.ENTER);
        return this;
    }

    //Chọn kết quả đầu tiên
    public SearchProductPage openFirstProduct() {
        By firstProductLocator = By.xpath("(//div[@class='item-product'])[1]");
        waitForElementClickable(firstProductLocator).click();
        return this;
    }

   // Chọn option 
    public SearchProductPage selectOptionByIndex(int index) {
        WebElement dropdown = waitForElementRefreshed(dropdownOriginLocator);
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//select[@id='pa_xuat-xu']/option"), 1));
        
        Select select = new Select(dropdown);
        select.selectByIndex(index);
        waitForElementClickable(addToCartButton);
        return this;
    }
    // Thêm sản phẩm vào giỏ
    public void addProductToCart() {
        waitForElementClickable(addToCartButton).click();
        waitForElementVisible(addMessage);
        System.out.println("Thêm sản phẩm thành công");
    }
}
