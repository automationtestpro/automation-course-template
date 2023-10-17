package com.pages;

import javax.swing.text.html.parser.Element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    public WebDriver driver;

    protected BasePage(WebDriver givenDriver){
        this.driver = givenDriver;
        PageFactory.initElements(this.driver, this);
    }

    public WebElement findElement(By by) {
        System.out.println("here3");
        return driver.findElement(by);
    }

}
