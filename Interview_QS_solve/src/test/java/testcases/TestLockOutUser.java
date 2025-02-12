package testcases;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utilities.DriverSetUp;

public class TestLockOutUser extends DriverSetUp {

    LogInPage logInPage= new LogInPage();
    LockOutUserPage lockOutUserPage= new LockOutUserPage();

    @Test(description = "Ensure that a locked-out user cannot log in.")
    public void testLockOutUser() {
        getBrowser().get(logInPage.logInPageURl);
        logInPage.writeOnElement(logInPage.emailInputBox,"locked_out_user");
        logInPage.writeOnElement(logInPage.passwordInputBox,"secret_sauce");
        logInPage.clickOnElement(logInPage.logInButton);
        Assert.assertTrue(lockOutUserPage.getElement(lockOutUserPage.lockoutuser).isDisplayed());
        Assert.assertEquals(lockOutUserPage.elementText(lockOutUserPage.lockoutuser), "Epic sadface: Sorry, this user has been locked out.");
    }
}
