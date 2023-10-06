package com;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.utils.BasicTest;
import com.utils.Utils;

public class LoginTest extends BasicTest {


    @Test()
    public void loginTest() throws Exception {

        
        Utils.hardWait();
        
        //Open https://bantheme.xyz/hathanhauto/tai-khoan/ in new tab
        Utils.newTab(driver);
        Utils.hardWait();

        driver.get("https://bantheme.xyz/hathanhauto/tai-khoan/");
        Utils.hardWait();

    }


}
