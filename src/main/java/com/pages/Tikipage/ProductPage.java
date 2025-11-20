package com.pages.Tikipage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions; 
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.pages.BasePage;


public class ProductPage extends BasePage{
    public ProductPage(WebDriver givenDriver) {
        super(givenDriver);
    }


public By phoneItem = By.xpath("//button[text()='Thêm vào giỏ']");
public By loginPhone = By.xpath("//input[@placeholder='Số điện thoại']");
public By BtnContinue = By.xpath("//button[text()='Tiếp Tục']");
public By passPhone = By.xpath("//input[@placeholder='Mật khẩu']");
public By BtnLogin = By.xpath("//button[text()='Đăng Nhập']");
public By PlusBtn = By.xpath("//img[@alt='add-icon']");
public By cartItem = By.xpath("//a[text()='Xem giỏ hàng và thanh toán']");

// steps click additem
public ProductPage addItemCart() {
        wait.until(ExpectedConditions.elementToBeClickable(phoneItem)).click();
        return this;
    }  
public ProductPage fillphone(String string) {
        wait.until(ExpectedConditions.elementToBeClickable(loginPhone)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginPhone)).sendKeys(string);
        return this;
    }   
public ProductPage clickContinue() {
        wait.until(ExpectedConditions.elementToBeClickable(BtnContinue)).click();
        return this;
    }
public ProductPage fillpass(String string) {
        wait.until(ExpectedConditions.elementToBeClickable(passPhone)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(passPhone)).sendKeys(string);
        return this;
}
public ProductPage clickLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(BtnLogin)).click();
        return this;
    }
public ProductPage clickCart() {
       // wait.until(ExpectedConditions.visibilityOfElementLocated(cartItem)).click();
        wait.until(ExpectedConditions.elementToBeClickable(cartItem)).click();
        return this;
    }

}
