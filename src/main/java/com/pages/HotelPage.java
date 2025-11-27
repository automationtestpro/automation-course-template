    package com.pages;

    import org.checkerframework.checker.units.qual.s;
    import org.openqa.selenium.By;
    import org.openqa.selenium.WebDriver;

    import com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Basic;
    import com.utils.BasicTest;

    import org.openqa.selenium.support.ui.ExpectedConditions;
    
    import org.openqa.selenium.JavascriptExecutor;
    import org.openqa.selenium.WebElement;

    public class HotelPage extends BasePage {

        public HotelPage(WebDriver givenDriver) {
            super(givenDriver);
        }

        //public By continueBy = By.xpath("(//a[@class='pdv__box ng-star-inserted'])[1]");// khách sạn
        public By orderBy = By.xpath("//button[contains(text(),'Đặt ngay')]");// đặt ngay
        public By requestPlace = By.xpath("(//span[contains(text(),'Yêu cầu đặt')])[1]");// đặt ngay
        ////public By requestPlace = By.xpath("(//button[@class='flex-center pdv__next-btn'])"(//button[contains(text(),' Yêu cầu đặt ')])[1]");//request place
        public By fullName = By.xpath("//input[@name='fullName']"); 
        public By phoneNumber = By.xpath("//input[@name='phoneNumber']");
        public By email = By.xpath("//input[@name='email']");

        public By titleBy = By.xpath("//span[contains(text(),'Yêu cầu đặt Combo')]");
        //By password = By.xpath("//input[@id='password']");
        //By loginBtn = By.xpath("//button[text()='Login']");     
    
        public void orderBy() {
            //findElement(continueBy).click();  
            wait.until(ExpectedConditions.elementToBeClickable(orderBy)).click();
        }

        public void requestPlace() { 
            //wait until element is visible
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(requestPlace));
            // Scroll to the element
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", element);
            // Click on the element
            wait.until(ExpectedConditions.visibilityOfElementLocated(requestPlace)).click();
           
        }
        //fill full name
        public void fullname(String string) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(fullName)).sendKeys(string);

        }
        // fill phone number
        public void phoneNumber(String string) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(phoneNumber)).sendKeys(string);
        }

        public void email(String string) {
            // TODO Auto-generated method stub
            // findElement(email).sendKeys(string);
            wait.until(ExpectedConditions.visibilityOfElementLocated(email)).sendKeys(string);
        }

        public String title() {
            // TODO Auto-generated method stub
            return wait.until(ExpectedConditions.visibilityOfElementLocated(titleBy)).getText();
        }
      
    }
