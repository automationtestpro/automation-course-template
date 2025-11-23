package com.pages.ICEPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;

public class DashboardPage extends BasePage {

    private By bannerLocator = By.xpath("(//*[@class='modal-content'])[8]");
    private By bannerClose = By.xpath("(//*[@class='close'])[8]");
    private By employeesMenu = By.xpath("(//li[@class='treeview'])[1]");
    private By employeesChild = By.xpath("//*[@id='admin_Employees']");
    private By searchByNameLocator = By.xpath("//input[@placeholder='Search by Name']");
    private By searchBtnLocator = By.xpath("//button[.//span[contains(@class, 'anticon-search')]]");

    public DashboardPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void closeBannerIfPresent() {
        try {
            if (wait.until(ExpectedConditions.visibilityOfElementLocated(bannerLocator)).isDisplayed()) {
                wait.until(ExpectedConditions.elementToBeClickable(bannerClose)).click();
            }
        } catch (Exception ignored) {
        }
    }

    public void goToEmployees() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(employeesMenu)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(employeesChild)).click();
    }

    public void searchByName(String name) {
        WebElement searchByNameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(searchByNameLocator));
        searchByNameElement.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
        searchByNameElement.sendKeys(name);
        wait.until(ExpectedConditions.elementToBeClickable(searchBtnLocator)).click();
    }

    public String getResultName(String fullName) {
        By resultNameLocator = By.xpath("//*[@class='ant-list-item-meta-title' and contains(text(), '" + fullName + "')]");
        try {
            WebElement nameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(resultNameLocator));
            return nameElement.getText().trim();
        } catch (Exception e) {
            return null;
        }
    }
}
