package com.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.config.Constants;
import com.pages.LoginPage;
import com.utils.Utils;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginSteps {
    WebDriver driver;

    @Given("I am on the login page")
    public void user_is_on_the_login_page() {
        String browser = "chrome";


        // headless mode
        ChromeOptions options = new ChromeOptions();
        // options.addArguments("--headless");
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1920,1080");

        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(options);
        } else if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else {
            throw new IllegalArgumentException("Browser not supported: " + browser);
        }

        // Maximize the browser
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // wait = new WebDriverWait(driver, 15);

        // actions = new Actions(driver);
        String url = Constants.HOMEPAGE_SAUCELAB_URL;
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open(url);
    }


    @When("I enter valid credentials")
    public void user_enters_credentials() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterEmail("standard_user")
                 .enterPassword("secret_sauce")
                 .clickLoginButton();
    }

    @When("I enter username {string} and password {string}")
    public void user_enters_credentials_2(String username, String password) {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterEmail(username)
                 .enterPassword(password)
                 .clickLoginButton();
    }

    

    @Then("I should be redirected to the dashboard")
    public void user_is_redirected_to_home_page() {
        LoginPage loginPage = new LoginPage(driver);
        Utils.hardWait(5000);
        // Assert.assertTrue(loginPage.isErrorMessageDisplayed().contains("You logged into a secure area!"), "Error message does not match.");
        driver.quit();
    }

    @Then("I should see {string}")
    public void I_should_see(String expectedMessage) {
        Utils.hardWait(2000);
        LoginPage loginPage = new LoginPage(driver);
        String actualMessage = loginPage.getErrorMessage();
        Assert.assertTrue(actualMessage.contains(expectedMessage), "The expected message does not match the actual message.");
        driver.quit();
    }


}
