package com.pages.ICEPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    private By username = By.xpath("//*[@id='username']");
    private By password = By.xpath("//*[@id='password']");
    private By loginButton = By.xpath("(//*[@type='button'])[1]");

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void open(String url) {
        driver.get(url);
    }

    public void login(String user, String pass) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(username)).sendKeys(user);
        WebElement pw = driver.findElement(password);
        pw.sendKeys(pass);
        WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        btn.click();
    }
}
