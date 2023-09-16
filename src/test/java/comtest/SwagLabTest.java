package comtest;

import com.swaglab.HomePage;
import com.swaglab.LoginPage;
import com.utils.BasicTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SwagLabTest extends BasicTest {
    LoginPage loginPage;

    @Test
    public void loginSuccess() {
        String url = "https://www.saucedemo.com/";
        loginPage = new LoginPage(driver);
        loginPage.openUrl(url);
        HomePage homePage = loginPage.loginToSwagLab("standard_user", "secret_sauce");
        Assert.assertEquals(homePage.getProductsText(), "Products");

    }
}
