package com.steps;

import baseTest.BookingHomePage;
import com.utils.BasicTest;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;


public class BookingSteps extends BasicTest {
    BookingHomePage bookingHomePage;

    @Given("the user is on the homepage")
    public void givenUserIsOnHomepage() {
        String url = "https://www.ivivu.com/";
        bookingHomePage = new BookingHomePage(driver);
        bookingHomePage.openUrl(url);
    }

    @When("the user clicks the plus button for booking rooms {int} times")
    public void whenUserClicksPlusButtonForBookingRooms(int times) {
        bookingHomePage = new BookingHomePage(driver);
        bookingHomePage.clickDropdown();
        bookingHomePage.clickRoomMultiTimes(times);
    }

    @When("clicks the plus button for booking rooms {int} more times")
    public void whenUserClicksPlusButtonForBookingRoomsMoreTimes(int moreTimes) {
        bookingHomePage = new BookingHomePage(driver);
        bookingHomePage.clickRoomMultiTimes(moreTimes);
    }

    @Then("the maximum number of booking rooms should be {int}")
    public void thenMaxBookingRoomsShouldBe(int maxRooms) {
        bookingHomePage = new BookingHomePage(driver);
        Assert.assertEquals(bookingHomePage.getRoomQuantity(),Integer.toString(maxRooms));
    }

    @When("the user clicks the plus button for adult persons {int} times")
    public void whenUserClicksPlusButtonForAdultPersons(int times) {
        bookingHomePage = new BookingHomePage(driver);
        bookingHomePage.clickAdultMultiTimes(times);
    }

    @When("clicks the plus button for adult persons {int} more times")
    public void whenUserClicksPlusButtonForAdultPersonsMoreTimes(int moreTimes) {
        bookingHomePage = new BookingHomePage(driver);
        bookingHomePage.clickAdultMultiTimes(moreTimes);
    }

    @Then("the maximum number of adult persons should be {int}")
    public void thenMaxAdultPersonsShouldBe(int maxPersons) {
        bookingHomePage = new BookingHomePage(driver);
        Assert.assertEquals(bookingHomePage.getAdultQuantity(),Integer.toString(maxPersons));
    }

//    @When("the user clicks the plus button for children {int} times")
//    public void whenUserClicksPlusButtonForChildren(int times) {
//        // Implement the behavior for this step
//    }
//
//    @When("clicks the plus button for children {int} more times")
//    public void whenUserClicksPlusButtonForChildrenMoreTimes(int moreTimes) {
//        // Implement the behavior for this step
//    }
//
//    @Then("the maximum number of child rooms should be {int}")
//    public void thenMaxChildRoomsShouldBe(int maxRooms) {
//        // Implement the behavior for this step
//    }
}
