package baseTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BookingHomePage extends AbstractTest {

    private By optionsDropdown = By.xpath("//div[@class='col-xs-12 v_field']");
    private By roomPlusButton = By.xpath("//div[@class='quantity ng-binding' and text()=\"1\"]/following::button[2]");
    private By adultPersonPlusButton = By.xpath("//div[@class='quantity ng-binding' and text()=\"2\"]/following::button[2]");
    private By roomQuantity = By.xpath("//div[@class='quantity ng-binding' and text()=\"1\"]");
    private By adultPersonQuantity = By.xpath("//div[@class='quantity ng-binding' and text()=\"2\"]");



    public BookingHomePage(WebDriver driver) {
        super(driver);
    }

    public void clickDropdown() {
            clickElement(optionsDropdown);
    }

    public void clickRoomMultiTimes(int n)
    {
        clickButtonMultipleTimes(roomPlusButton,n);
    }

    public void clickAdultMultiTimes(int n)
    {
        clickButtonMultipleTimes(adultPersonPlusButton,n);
    }

    public String getRoomQuantity() {
        return getElementValidationMessage(roomQuantity);
    }
    public String getAdultQuantity() {
        return getElementValidationMessage(adultPersonQuantity);
    }
}
