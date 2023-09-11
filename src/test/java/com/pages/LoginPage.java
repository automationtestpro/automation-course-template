package com.pages;

import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver givenDriver) {
        this.driver = givenDriver;
    }

    public void enterEmail(String email){

    }

    public void enterPassword(String email){

    }

    public void clickSubmit(){


        String username = "#username"; // locator

        String loginBtn = "button[name='login']";
        String pass = "#password";
    }
}
