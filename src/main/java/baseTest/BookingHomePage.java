package baseTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BookingHomePage extends AbstractTest {

    private By optionsDropdown = By.xpath("//div[@class='col-xs-12 v_field']");
    private By roomPlusButton = By.xpath("(//div[@class=\"col-xs-6 no-padding text-right\"]//div[1]//button[2])[1]");
    private By adultPersonPlusButton = By.xpath("(//div[@class=\"col-xs-6 no-padding text-right\"]//div[1]//button[2])[2]");
    private By childrenPlusButton = By.xpath("(//div[@class=\"col-xs-6 no-padding text-right\"]//div[1]//button[2])[3]");
    private By roomQuantity = By.xpath("(//div[@class='quantity ng-binding'])[1]");
    private By adultPersonQuantity = By.xpath("(//div[@class='quantity ng-binding'])[2]");
    private By childrenQuantity = By.xpath("(//div[@class='quantity ng-binding'])[3]");



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
    public void clickChildrenMultiTimes(int n)
    {
        clickButtonMultipleTimes(childrenPlusButton,n);
    }

    public String getRoomQuantity() {
        return getElementValidationMessage(roomQuantity);
    }
    public String getAdultQuantity() {
        return getElementValidationMessage(adultPersonQuantity);
    }
    public String getChildrenQuantity() {
        return getElementValidationMessage(childrenQuantity);
    }
}
