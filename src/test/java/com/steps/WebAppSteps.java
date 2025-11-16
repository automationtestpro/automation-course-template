package com.steps;

import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import com.mongodb.util.Util;
import com.utils.Constants;
import com.utils.Utils;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WebAppSteps {
    WebDriver driver;


    @Given("User is on the login page")
    public void userIsOnLoginPage() {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        
        // 🚀 THÊM CÁC TÙY CHỌN ẨN DANH ĐỂ VƯỢT QUA CAPTCHA
        // options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
        // options.setExperimentalOption("useAutomationExtension", false);
        
        //headless mode
        if (Constants.headless){
            options.addArguments("--headless");
            options.addArguments("--window-size=1920,1080");
        }
        // options
        driver = new ChromeDriver(options);

        driver.get("https://bantheme.xyz/hathanhauto/tai-khoan/");
        Utils.hardWait(2000);
    }

    @When("User enters valid username {string}")
    public void User_enters_valid_username( String email) {
        // Write code here that turns the phrase above into concrete actions
        // Input username
        WebElement emailInp = driver.findElement(By.xpath("//*[@id='username']"));
        emailInp.sendKeys(email);
    }

    @When("User enters valid password {string}")
    public void User_enters_valid_password(String password) {
        WebElement passwordInp = driver.findElement(By.xpath("//*[@id='password']"));
        passwordInp.sendKeys(password);
    }

    @Then("User should be redirected to the dashboard page")
    public void User_should_be_redirected_to_the_dashboard_page() {

        String expectedMessage = "Địa chỉ email này chưa được đăng ký.";

        // Write code here that turns the phrase above into concrete actions
        By byElementLocator = By.xpath("//ul[@class='woocommerce-error']");
        String errorMessageText = getErrorMessage(byElementLocator);
        System.out.println("Error Message: " + errorMessageText);

        // Assert.assertTrue(errorMessageText.contains(expectedMessage));
        Assert.assertEquals(errorMessageText, expectedMessage);

        driver.quit();
    }

    @When("User clicks the login button")
    public void User_clicks_the_login_button() {
        // Write code here that turns the phrase above into concrete actions
        WebElement loginBtn = driver.findElement(By.xpath("//button[text()='Đăng nhập']"));
        loginBtn.click();
        Utils.hardWait(2000);
    }

    @Then("verify expectedMessage is displayed {string}")
    public void verify_expectedMessage_is_displayed(String s) {
        // Write code here that turns the phrase above into concrete actions

        String expectedMessage = s;

        // Write code here that turns the phrase above into concrete actions
        By byElementLocator = By.xpath("//ul[@class='woocommerce-error']");
        String errorMessageText = getErrorMessage(byElementLocator);
        System.out.println("Error Message: " + errorMessageText);

        Assert.assertEquals(errorMessageText, expectedMessage);

        
    }

    public boolean isElementDisplayed(WebElement element){
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            return false;// TODO: handle exception
        }
    }


    public String getErrorMessage(By byElementLocator){
        try {
            WebElement element = driver.findElement(byElementLocator);
            return element.getText();
        } catch (Exception e) {
            return "";
        }
    }

}
