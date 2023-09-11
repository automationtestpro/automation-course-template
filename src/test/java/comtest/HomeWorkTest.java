package comtest;

import com.utils.BasicTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.utils.Utils.hardWait;

public class HomeWorkTest extends BasicTest {
    @Test()
    public void loginTestVivu() throws Exception {
        // Launch website
        String url = "https://www.ivivu.com/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        WebElement accountLogin = driver.findElement(By.xpath("(//div[@class='img-wrapper'])[1]"));
        accountLogin.click();
        WebElement loginBtn = driver.findElement(By.xpath("//li[@class='btn-login-wrap']//btn[text()='Đăng nhập']"));
        loginBtn.click();
        driver.findElement(By.xpath("//input[@name='EmailPhoneDN']")).sendKeys("minhvip4398@gmail.com");
        driver.findElement(By.xpath("//input[@name='PasswordDN']")).sendKeys("123456");
        driver.findElement(By.xpath("//button[@type='submit'][contains(text(),'Đăng nhập')]")).click();
        WebElement userNameAfterLogin = driver.findElement(By.xpath("//span[@class='username-header']"));
        webDriverWait.until(ExpectedConditions.visibilityOf(userNameAfterLogin));

        hardWait();
        Assert.assertEquals(userNameAfterLogin.getText(), "minhvip4398@gmailcom");
    }
}
