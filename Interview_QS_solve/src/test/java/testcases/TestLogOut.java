package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LogInPage;
import pages.LogOutPage;
import utilities.DriverSetUp;

public class TestLogOut extends DriverSetUp {
    LogInPage logInPage= new LogInPage();
    LogOutPage logOutPage= new LogOutPage();

    @Test(description = "Verify that the logout process works correctly")
    public void testLogOut() {
        logInPage.doLogIn("standard_user", "secret_sauce");
        logOutPage.clickOnElement(logOutPage.manu);
        logOutPage.clickOnElement(logOutPage.logOut);
        Assert.assertEquals(getBrowser().getCurrentUrl(),logInPage.logInPageURl);
    }
}
