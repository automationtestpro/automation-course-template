package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
    
    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }
        
    // public By regEmailBy = By.xpath("//input[@id='reg_email']"); 
    // public By regPassBy = By.xpath("//input[@id='reg_password']");
    // public By butResBy = By.xpath("//button[@name='register']");
    // public By errormessageBy = By.xpath("//ul[@class='woocommerce-error']");


    @FindBy(xpath = "//input[@id='reg_email']")
    public WebElement regEmailInp;

    @FindBy(xpath = "//input[@id='reg_password']")
    public WebElement regPassInp;

    @FindBy(xpath = "//button[@name='register']")
    public WebElement butRes;

    @FindBy(xpath = "//ul[@class='woocommerce-error']")
    public WebElement errormessage;

    // public void fillRegEmail(String string) {

    //     wait.until(ExpectedConditions.visibilityOfElementLocated(regEmailBy)).sendKeys(string);
    // }

    // public void fillRegPass(String string) {

    //     wait.until(ExpectedConditions.visibilityOfElementLocated(regPassBy)).sendKeys(string);
    // }

    // public void clickRegisterButton() {

    //     wait.until(ExpectedConditions.elementToBeClickable(butResBy)).click();
    // }


    // public String getErrorMessage() {
    //     return wait.until(ExpectedConditions.visibilityOfElementLocated(errormessageBy)).getText();
    // }

    public LoginPage fillRegEmail(String string) {
        By byRegEmail = By.xpath("//input[@id='reg_email']");
        WebElement regEmailInp = wait.until(ExpectedConditions.visibilityOfElementLocated(byRegEmail));
        regEmailInp.sendKeys(string);

        return this;
    }

    public LoginPage fillRegPass(String string) {

        regPassInp.sendKeys(string);

        return this;
    }

    public void clickRegisterButton() {

        butRes.click();
    }

    public String getErrorMessage() {
        return errormessage.getText();
    }

}
