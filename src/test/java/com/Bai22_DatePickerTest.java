package com;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.utils.BasicTest;
import com.utils.BookingPage;
import com.utils.BookingPopupPage;
import com.utils.HomePage;
import com.utils.HotelPage;


public class Bai22_DatePickerTest extends BasicTest{


    HomePage homePage;
   
    @Test() 
    public void datePickerTest(){
        HomePage homePage = new HomePage(driver);
        HotelPage hotelPage = new HotelPage(driver);
        BookingPage bookingPage = new BookingPage(driver);
        BookingPopupPage popup = new BookingPopupPage(driver);

        String url = "https://www.ivivu.com/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);

        //Homepage
        homePage.selectSuggestion("Phú Quốc");
        homePage.selectDate();
        homePage.Search();
        homePage.verifyHotelPage();

        //hotelPage
        hotelPage.selectHotel();
        
        //Booking Page và verify thông tin popup
        bookingPage.requestBooking();
        Assert.assertTrue(popup.isPopupDisplayed());
        Assert.assertTrue(popup.areFieldsDisplayed());
        System.out.println("Name: " + popup.getName());
        System.out.println("Phone: " + popup.getPhone());
        System.out.println("Email: " + popup.getEmail());
        System.out.println("Message: " + popup.getMessage());


    }


    
}
