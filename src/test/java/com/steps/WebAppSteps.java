package com.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import com.pages.LoginPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class WebAppSteps {

    WebDriver driver;
    private String driverPath;

    @Given("browser is opened")
    public void browser_is_opened() {
        // Chromedriver path
        driverPath = "src/main/resources/WebDrivers/chromedriver";
        ChromeOptions options = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver(options);
        // Maximize the browser
        driver.manage().window().maximize();

        String url = "https://seniorautomationtest.com/";
        driver.get(url);
    }

    @When("enter email {string}")
    public void enter_email(String email) {
        // step
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail(email);
    }

    @And("enter password {string}")
    public void enter_pass(String pwd) {
        // step
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail(pwd);
    }

    @And("click submit")
    public void click_submit() {
        // step
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickSubmit();
    }

    @Then("verify login successfully")
    public void verify_login_success() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://seniorautomationtest.com/");
        driver.quit();
    }



}
