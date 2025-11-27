package com.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

    public class ProductPage extends BasePage {

        public ProductPage(WebDriver givenDriver) {
            super(givenDriver);

        }
    // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@name='s'])[1]"))).sendKeys("merc");
    @FindBy(xpath = "//select[@id='pa_xuat-xu']")
    public WebElement option_Element;
    //WebElement result_Engl = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='pa_xuat-xu']/option[2]")));
    
    @FindBy(xpath = "//select[@id='pa_xuat-xu']/option[2]")
    public WebElement result_Engl;

    //WebElement addToCartBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='single_add_to_cart_button button alt']")));
    @FindBy(xpath = "//button[@class='single_add_to_cart_button button alt']")
    public WebElement addToCartBtn;

    public By addToCartLocator = By.xpath("//button[@class='single_add_to_cart_button button alt']");
        

    public ProductPage option_Element() {
        wait.until(ExpectedConditions.visibilityOf(option_Element));
        option_Element.click();;
        return this;
    }
    public ProductPage result_Engl() {
        wait.until(ExpectedConditions.elementToBeClickable(result_Engl)).click();
        return this;
    }   
    public ProductPage addToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn)).click();
        return this;
    }
    public boolean isElementDisplayed(By by) {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(by)).isDisplayed();
        } catch (Exception e) {
            return false;// TODO: handle exception
        }

    
    }   
    }
