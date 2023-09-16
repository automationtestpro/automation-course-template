package comtest;

import com.base.HomePage;
import com.base.LoginPage;
import com.utils.BasicTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.utils.Utils.hardWait;

public class HomeWorkTest extends BasicTest {
    LoginPage loginPage;

    @Test()
    public void loginTestVivu() throws Exception {

        String url = "https://www.ivivu.com/";
        loginPage = new LoginPage(driver);
        loginPage.openUrl(url);
        loginPage.clickAccount();
        loginPage.clickLoginBtn();
        loginPage.inputEmail("minhvip4398@gmail.com");
        loginPage.clickDangNhapBtn();
        String expectedErrorMessage = loginPage.getErrorMessage();
        Assert.assertEquals("Please fill out this field.", expectedErrorMessage);
        loginPage.inputPassword("123456");
        HomePage homePage = loginPage.clickDangNhapBtn();

        hardWait();
        Assert.assertEquals(homePage.getUserNameText(), "minhvip4398@gmailcom");

    }
    @Test
    public void testGoogle() {
        System.out.println("Minh Vo");
    }

}