package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utilities.DriverSetUp;

public class TestLockOutUser extends DriverSetUp {

    ProductPage productPage =new ProductPage();
    LogInPage logInPage= new LogInPage();
    CheckOutPage checkOutPage =new CheckOutPage();
    LogOutPage logOutPage= new LogOutPage();
    LockOutUserPage lockOutUserPage= new LockOutUserPage();

    @Test
    public void testLockOutUser() {
        getBrowser().get(logInPage.logInPageURl);
        logInPage.writeOnElement(logInPage.emailInputBox,"locked_out_user");
        logInPage.writeOnElement(logInPage.passwordInputBox,"secret_sauce");
        logInPage.clickOnElement(logInPage.logInButton);
        Assert.assertTrue(lockOutUserPage.getElement(lockOutUserPage.lockoutuser).isDisplayed());
        Assert.assertEquals(lockOutUserPage.elementText(lockOutUserPage.lockoutuser), "Epic sadface: Sorry, this user has been locked out.");



    }


}
