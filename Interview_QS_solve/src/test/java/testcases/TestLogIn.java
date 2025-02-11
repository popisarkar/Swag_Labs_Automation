package testcases;


import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LogInPage;
import pages.ProductPage;
import utilities.DataSet;
import utilities.DriverSetUp;

public class TestLogIn extends DriverSetUp {

    LogInPage logInPage= new LogInPage();
    ProductPage productPage= new ProductPage();

    @Test(description = "Test With valid login")
    public void login_Valid_Credential(){

     getBrowser().get(logInPage.logInPageURl);
     logInPage.writeOnElement(logInPage.emailInputBox,"standard_user");
     logInPage.writeOnElement(logInPage.passwordInputBox,"secret_sauce");
     logInPage.clickOnElement(logInPage.logInButton);
     Assert.assertEquals(getBrowser().getCurrentUrl(),productPage.productPageURl);
    }


    @Test(description = "Test With Invalid login")
     public void login_Invalid_Credential(){
        getBrowser().get(logInPage.logInPageURl);
        logInPage.writeOnElement(logInPage.emailInputBox,"standard" );
        logInPage.writeOnElement(logInPage.passwordInputBox, "secret_sauce");
        logInPage.clickOnElement(logInPage.logInButton);
        Assert.assertTrue(logInPage.getElement(logInPage.errorMsg).isDisplayed());
        Assert.assertEquals(logInPage.elementText(logInPage.errorMsg), "Epic sadface: Username and password do not match any user in this service");
    }










    @Test(dataProvider = "invalidUsr",dataProviderClass = DataSet.class)
    public void ErrorTestLogCredentials(String email, String password,String errorMsg) {

        getBrowser().get(logInPage.logInPageURl);
        logInPage.writeOnElement(logInPage.emailInputBox, email);
        logInPage.writeOnElement(logInPage.passwordInputBox, password);
        logInPage.clickOnElement(logInPage.logInButton);
        Assert.assertTrue(logInPage.getElement(logInPage.errorMsg).isDisplayed());
        Assert.assertEquals(logInPage.elementText(logInPage.errorMsg), errorMsg);

    }
}
