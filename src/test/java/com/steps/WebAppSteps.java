package com.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.pages.LoginPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WebAppSteps {
    WebDriver driver;

    @Given("I am on the login page") 
    public void i_am_on_the_login_page() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        // Launch website
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

    @When("I enter username {string}")
    public void i_enter_username(String username) {
        // Enter email
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail(username);
        // driver.findElement(By.xpath("//input[@id='username']")).sendKeys(username);
    }

    @And("I enter password {string}")
    public void i_enter_password(String password) {
        // Enter password
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterPassword(password);
        // driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
    }

    @And("I click on login button")
    public void i_click_on_login_button() {
        // Click on Login button
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLoginButton();
        // driver.findElement(By.xpath("//button[@name='login']")).click();
    }

    @Then("I should be logged in")
    public void i_should_see_the_error_message() {
        // Verify login
        Assert.assertEquals(driver.findElement(By.xpath("//ul[@class='woocommerce-error']")).getText(), "");
    }
}
