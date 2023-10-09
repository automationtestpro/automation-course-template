package baseTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends AbstractTest {

    private By submitButton = By.xpath("//button[@name='register']");
    private By errorText = By.xpath("//ul[@role='alert']//li");
    private By emailInput = By.id("reg_email");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void clickRegister() {
        clickElement(submitButton);
    }

    public void inputEmail(String email) {
        sendKeyToElement(emailInput, email);
    }


    public String getErrorMessage() {
     return getElementValidationMessage(errorText);
    }

}
