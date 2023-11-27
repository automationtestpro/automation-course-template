package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class HomePage extends BasePage {

    @FindBy(xpath = "//*[contains(text(),'Đăng ký tại đây.')]")
    private WebElement loginBtn2;


    By byLoginBtn = By.xpath("//*[contains(text(),'Đăng ký tại đây.')]");

    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public void open(){
        String url = "https://bantheme.xyz/hathanhauto/";
        driver.get(url);
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

    public void hover(WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
    }

    public void login() {
        // WebElement loginBtn = driver.findElement(By.xpath("//*[contains(text(),'Đăng ký tại đây.')]"));
        // loginBtn.click();
        //loginBtn2.click();

        findElement(byLoginBtn).click();
    }

}
