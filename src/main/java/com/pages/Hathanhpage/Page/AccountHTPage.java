package com.pages.Hathanhpage.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.pages.BasePage;

public class AccountHTPage extends BasePage {

        public AccountHTPage(WebDriver givenDriver) {
            super(givenDriver);

        }

    public By searchInput = By.xpath("(//input[@name='s'])[1]");
    public By searchResult = By.xpath("(//a[contains(text(),'Bơm nước xe ')])[1]");

    public AccountHTPage search(String string) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchInput)).sendKeys(string);
        return this;
    }
    public AccountHTPage clickSearchResult() {
        wait.until(ExpectedConditions.elementToBeClickable(searchResult)).click();
        return this;
    }   
    }
