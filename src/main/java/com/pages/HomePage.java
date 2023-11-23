package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class HomePage extends BasePage{

    public HomePage(WebDriver givendriver) {
        super(givendriver);
        //TODO Auto-generated constructor stub
    }
    public void open(){
    String url = "https://www.ivivu.com/";
    driver.get(url);
    Assert.assertEquals(driver.getCurrentUrl(), url);
   }
    public void login(){
    WebElement account = driver.findElement(By.xpath("//a[@class='dropdown-toggle']//div[@class='img-wrapper']"));
    account.click();
    WebElement loginbutton = driver.findElement(By.cssSelector("ul[role='menu'] btn[type='button']"));
    loginbutton.click();

   } 
    public void verifyLogin(String user, String password){
    WebElement email = driver.findElement(By.xpath("//input[@name='EmailPhoneDN']"));
    email.sendKeys(user);
    WebElement pass = driver.findElement(By.xpath("//input[@name='PasswordDN']"));
    pass.sendKeys(password);
    WebElement loginbutton = driver.findElement(By.xpath("//button[@type='submit'][contains(text(),'Đăng nhập')]"));
    loginbutton.click();
   }
}



