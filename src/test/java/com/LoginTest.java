package com;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pages.LoginPage;
import com.utils.BasicTest;
import com.utils.Utils;

public class LoginTest extends BasicTest {


    @Test()
    public void loginTest() throws Exception {

        WebDriver driver = threadLocalDriver.get();

        // Launch website
        String url = "https://the-internet.herokuapp.com/login";
        driver.get(url);
        Utils.hardWait();

        // Enter username and password
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("tomsmith");
        loginPage.enterPassword("SuperSecretPassword!");
        Utils.hardWait();
        // Click on login button
        loginPage.clickLoginButton();
        Utils.hardWait();
        // Verify successful login
        String message = loginPage.getSuccessMessage();
        Assert.assertTrue(message.contains("You logged into a secure area!"), "Login failed!");

        // Wait for the logout button to be visible
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='button secondary radius']")));
        // Click on logout button
        WebElement logoutButton = driver.findElement(By.xpath("//a[@class='button secondary radius']"));
        logoutButton.click();
        Utils.hardWait();
        // Verify successful logout
        String logoutMessage = loginPage.getLogoutMessage();
        Assert.assertTrue(logoutMessage.contains("You logged out of the secure area!"), "Logout failed!");
        // Verify that the login button is displayed again
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        Assert.assertTrue(loginButton.isDisplayed(), "Login button is not displayed after logout!");
        // Verify that the username and password fields are displayed again
        WebElement usernameField = driver.findElement(By.id("username"));
        Assert.assertTrue(usernameField.isDisplayed(), "Username field is not displayed after logout!");
        WebElement passwordField = driver.findElement(By.id("password"));
        Assert.assertTrue(passwordField.isDisplayed(), "Password field is not displayed after logout!");
        // Verify that the success message is not displayed
        List<WebElement> successMessage = driver.findElements(By.xpath("//div[@id='flash']"));
        Assert.assertTrue(successMessage.isEmpty(), "Success message is displayed after logout!");
        // Verify that the logout button is not displayed
        List<WebElement> logoutButtonList = driver.findElements(By.xpath("//a[@class='button secondary radius']"));
        Assert.assertTrue(logoutButtonList.isEmpty(), "Logout button is displayed after logout!");
        // Verify that the error message is not displayed
        List<WebElement> errorMessage = driver.findElements(By.xpath("//div[@id='flash']"));
        Assert.assertTrue(errorMessage.isEmpty(), "Error message is displayed after logout!");
        // Verify that the login page is displayed again
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("login"), "Login page is not displayed after logout!");
        // Verify that the page title is correct
        


        
























        
    }

}
