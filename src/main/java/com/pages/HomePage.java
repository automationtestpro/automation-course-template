package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    public HomePage(WebDriver givenDriver) {
        // Constructor for HomePage
        super(givenDriver);
    }

    public boolean isItemInCart(String s) {
        // TODO Auto-generated method stub
        try {
            waitElementVisible(By.xpath("//div[contains(text(),'" + s + "')]"));
            return true;
        } catch (Exception e) {
            return false;
        }
        
    }

    public void addItemToCart(String s) {
        // TODO Auto-generated method stub
        clickElement(By.xpath("//div[contains(text(),'" + s + "')]/../../..//button"));
    }

    public void clickCartIcon() {
        // TODO Auto-generated method stub
        clickElement(By.xpath("//div[@id='shopping_cart_container']"));
    }

    // Define locators for elements on the home page
    // For example:
    // By searchBox = By.id("search");
    // By featuredProducts = By.className("featured-products");

    // Add methods to interact with elements on the home page
    // For example:
    // public void searchForProduct(String productName) {
    //     findElement(searchBox).sendKeys(productName);
    //     findElement(searchBox).submit();
    // }
    
}
