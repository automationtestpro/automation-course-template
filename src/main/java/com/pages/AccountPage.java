package com.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

    public class AccountPage extends BasePage {

        public AccountPage(WebDriver givenDriver) {
            super(givenDriver);

        }
    // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@name='s'])[1]"))).sendKeys("merc");
    @FindBy(xpath = "(//input[@name='s'])[1]")
    public WebElement searchInput;
    //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[contains(text(),'Bơm nước xe ')])[1]"))).click();
    @FindBy(xpath = "(//a[contains(text(),'Bơm nước xe ')])[1]")
    public WebElement searchResult;
    public AccountPage search(String string) {
        wait.until(ExpectedConditions.visibilityOf(searchInput));
        searchInput.sendKeys(string);
        return this;
    }
    public AccountPage clickSearchResult() {
        wait.until(ExpectedConditions.elementToBeClickable(searchResult)).click();
        return this;
    }   
    }
