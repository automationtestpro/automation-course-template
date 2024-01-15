package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.utils.Utils;

public class HomePage extends BasePage {
    protected WebDriver driver;

    


    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//li[@id=\"UserLogin\"]")
    
    private WebElement tk;

    @FindBy(xpath = "//*[text() = 'Đăng nhập']")
    private WebElement dn;

    public HomePage openTk() {
        tk.click();
        Utils.hardWait();

        return this;
    }

    public HomePage openDn() {
        dn.click();
        Utils.hardWait();

        return this;
        
    }

}
