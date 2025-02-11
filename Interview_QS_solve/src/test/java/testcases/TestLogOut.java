package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckOutPage;
import pages.LogInPage;
import pages.LogOutPage;
import pages.ProductPage;
import utilities.DriverSetUp;

public class TestLogOut extends DriverSetUp {


    ProductPage productPage =new ProductPage();
    LogInPage logInPage= new LogInPage();
    CheckOutPage checkOutPage =new CheckOutPage();
    LogOutPage logOutPage= new LogOutPage();



    @Test
    public void TestLogOut() {

        logInPage.doLogIn("standard_user", "secret_sauce");
        logOutPage.clickOnElement(logOutPage.manu);
        logOutPage.clickOnElement(logOutPage.logOut);
        Assert.assertEquals(getBrowser().getCurrentUrl(),logInPage.logInPageURl);
    }




}
