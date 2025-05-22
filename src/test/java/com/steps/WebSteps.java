package com.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.pages.LoginPage;

import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WebSteps {
    WebDriver driver;
    WebDriverWait wait;

    @Given("^I am on the login page")
    public void i_am_on_the_login_page() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        // Maximize the browser
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 15);
        // Code to navigate to the login page
        
        System.out.println("Navigating to the login page...");
        // Example: driver.get("http://example.com/login");
        driver.get("https://bantheme.xyz/hathanhauto/tai-khoan/");
    }


    @When("I enter email {string}")
    public void i_enter_username(String username) {
        // Code to enter the username
        System.out.println("Entering username: " + username);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername(username);

        // driver.findElement(By.xpath("//input[@id='username']")).sendKeys(username);
        // Example: driver.findElement(By.id("username")).sendKeys(username);
    }


    @And("I enter password {string}")
    public void i_enter_password(String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterPassword(password);
        // driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
        // Example: driver.findElement(By.id("username")).sendKeys(username);
    }

    @And("^I click on the login button")
    public void i_click_on_the_login_button() {
        // Code to click the login button
        System.out.println("Clicking the login button...");
        // driver.findElement(By.xpath("//button[@name='login']")).click();
        // Example: driver.findElement(By.id("loginButton")).click();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLoginButton();
    }


    @Then("^I should be redirected to the dashboard")
    public void i_should_be_redirected_to_the_dashboard() {
        // Code to verify that the user is redirected to the dashboard
        System.out.println("Verifying redirection to the dashboard...");
        // Example: Assert.assertEquals(driver.getCurrentUrl(), "http://example.com/dashboard");
        String expectedUrl = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl);

        driver.quit();
    }

}
