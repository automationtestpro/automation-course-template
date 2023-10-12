package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    By byEmail = By.xpath("//*[@id=\"username\"]");
    By byPassword = By.xpath("//input[@id='password']");
    By byLoginBtn = By.xpath("//*[@id='customer_login']/div[1]/form/p[3]/button");
    
    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
        //TODO Auto-generated constructor stub
    }
    
    public void enterEmail(String emailString) {
        System.out.println("here1");
        WebElement email = findElement(byEmail);
        System.out.println("here2");
        email.sendKeys(emailString);
    }

    public void enterPass(String passString) {
        WebElement pass = findElement(byPassword);
        pass.sendKeys(passString);
    }

    public void clickLogin() {
        WebElement loginBtn = findElement(byLoginBtn);
        loginBtn.click();
    }
    
    
}
