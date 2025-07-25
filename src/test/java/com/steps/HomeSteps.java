package com.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

import com.config.Constants;
import com.mongodb.util.Util;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.utils.Utils;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class HomeSteps {
    WebDriver driver;

    @Given("I am on the hover page")
    public void user_is_on_the_hover_page() {
        // Initialize the WebDriver and navigate to the hover page
        // This is a placeholder; actual implementation will depend on your setup
    }

    @When("I hover over the element")
    public void user_hovers_over_the_element() {
        // Implement the hover action using Actions class
        // This is a placeholder; actual implementation will depend on your setup
        // Example:
        // Actions actions = new Actions(driver);
        // WebElement element = driver.findElement(By.id("hoverElementId"));
        // actions.moveToElement(element).perform();
    }

    @Then("I should see the tooltip appear")
    public void user_sees_the_tooltip() {
        // Verify that the tooltip is displayed
        // This is a placeholder; actual implementation will depend on your setup
        // Example:
        // WebElement tooltip = driver.findElement(By.id("tooltipId"));
        // Assert.assertTrue(tooltip.isDisplayed(), "Tooltip is not displayed");        
    }

    @Given("I am on the homepage")
    public void I_am_on_the_homepage() {
        // Write code here that turns the phrase above into concrete actions
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

    @When("I log in with username and password")
    public void I_log_in_with_username_and_password() {
        // Write code here that turns the phrase above into concrete actions
        String username = "standard_user";
        String password = "secret_sauce";
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);
        Utils.hardWait(5000);
    }

    @When("I add item {string} to the cart")
    public void I_add_item_to_the_cart(String s) {
        // Write code here that turns the phrase above into concrete actions
        HomePage homePage = new HomePage(driver);
        homePage.addItemToCart(s);
        Utils.hardWait(5000);
        
    }

    @Then("I should see {string} in the cart")
    public void I_should_see_in_the_cart(String s) {
        // Write code here that turns the phrase above into concrete actions
        HomePage homePage = new HomePage(driver);
        homePage.clickCartIcon();
        homePage.waitElementVisible(By.xpath("//*[contains(text(),'Your Cart')]"));
        boolean isItemInCart = homePage.isItemInCart(s);
        Assert.assertTrue(isItemInCart, "Item '" + s + "' is not in the cart");
        Utils.hardWait(5000);
        driver.quit();
    }
 
    
}