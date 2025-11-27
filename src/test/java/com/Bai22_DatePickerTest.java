package com;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

//import static org.junit.jupiter.api.Assertions.fail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement; // Import this
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.pages.Homepage;
import com.pages.HotelPage;
import com.pages.HotelListPage;
import com.utils.BasicTest;
import com.utils.Utils;

public class Bai22_DatePickerTest extends BasicTest {
    
    // 1. Chỉ KHAI BÁO, không khởi tạo
    HotelPage hotelPage;
    Homepage homepage;
    HotelListPage hotelListPage;

 
    @Test()
    public void datePickerTest() throws Exception {
        hotelPage = new HotelPage(driver);
        homepage = new Homepage(driver);
        hotelListPage = new HotelListPage(driver);
        // Launch website
        String url = "https://www.ivivu.com/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);

        homepage.fillAddress("Phú Quốc");
        homepage.clickCheckin();
        homepage.clickDate();
        homepage.clickDatefirst();
        homepage.clickDatesecond();
        homepage.search();
        //
        /// click book
        hotelListPage.continueBy();
    
        // click order
        hotelPage.orderBy();
        
        // request place
        hotelPage.requestPlace();   
        //wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("(//button[@class='flex-center pdv__next-btn'])[1]")));
        
         // fill booking
        hotelPage.fullname("Nguyen Dang");
        hotelPage.phoneNumber("0357422081");
        hotelPage.email("mdangdn29@gmail.com");
        
        String textHeader ="Yêu cầu đặt Combo";
        System.out.println(hotelPage.title());
        Assert.assertEquals(hotelPage.title(), textHeader);
    }
   

     public boolean isElementDisplayed(By by) {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(by)).isDisplayed();
        } catch (Exception e) {
            return false;// TODO: handle exception
        }
    }
}