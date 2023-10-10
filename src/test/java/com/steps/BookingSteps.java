package com.steps;

import baseTest.BookingHomePage;
import com.utils.BasicTest;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


public class BookingSteps extends BasicTest {
    BookingHomePage bookingHomePage;

    @Given("the user is on the homepage")
    public void the_user_is_on_the_homepage() {
        WebDriverManager.chromedriver().setup();
       driver = new ChromeDriver();
       driver.manage().window().maximize();
       String url ="https://www.ivivu.com/";
       driver.get(url);
    }
    @When("the user clicks the plus button for booking rooms {int} times")
    public void the_user_clicks_the_plus_button_for_booking_rooms_times(Integer times) {
       BookingHomePage bookingHomePage = new BookingHomePage(driver);
       bookingHomePage.clickDropdown();
       bookingHomePage.clickRoomMultiTimes(times);
    }
    @When("clicks the plus button for booking rooms {int} more times")
    public void clicks_the_plus_button_for_booking_rooms_more_times(Integer moreTimes) {
        BookingHomePage bookingHomePage = new BookingHomePage(driver);
        bookingHomePage.clickRoomMultiTimes(moreTimes);
    }
    @When("clicks the plus button for adult persons {int} times")
    public void clicks_the_plus_button_for_adult_persons_times(Integer times) {
        BookingHomePage bookingHomePage = new BookingHomePage(driver);
        bookingHomePage.clickAdultMultiTimes(times);
    }
    @When("clicks the plus button for adult persons {int} more times")
    public void clicks_the_plus_button_for_adult_persons_more_times(Integer moreTimes) {
        BookingHomePage bookingHomePage = new BookingHomePage(driver);
        bookingHomePage.clickAdultMultiTimes(moreTimes);
    }

    @When("clicks the plus button for children {int} times")
    public void clicks_the_plus_button_for_children_times(Integer time) {
        BookingHomePage bookingHomePage = new BookingHomePage(driver);
        bookingHomePage.clickChildrenMultiTimes(time);
    }
    @When("clicks the plus button for children {int} more times")
    public void clicks_the_plus_button_for_children_more_times(Integer moreTimes) {
        BookingHomePage bookingHomePage = new BookingHomePage(driver);
        bookingHomePage.clickChildrenMultiTimes(moreTimes);
    }
    @Then("the maximum number of booking rooms should be {int}")
    public void the_maximum_number_of_booking_rooms_should_be(Integer maxBookingRoom) {
        BookingHomePage bookingHomePage = new BookingHomePage(driver);
        Assert.assertEquals(bookingHomePage.getRoomQuantity(),Integer.toString(maxBookingRoom));
    }
    @Then("the maximum number of adult persons should be {int}")
    public void the_maximum_number_of_adult_persons_should_be(Integer maxAdultPerson) {
        BookingHomePage bookingHomePage = new BookingHomePage(driver);
        Assert.assertEquals(bookingHomePage.getAdultQuantity(),Integer.toString(maxAdultPerson));
    }
    @Then("the maximum number of child rooms should be {int}")
    public void the_maximum_number_of_child_rooms_should_be(Integer maxChildren) {
        BookingHomePage bookingHomePage = new BookingHomePage(driver);
        Assert.assertEquals(bookingHomePage.getChildrenQuantity(),Integer.toString(maxChildren));
    }
}
