package testcases;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckOutPage;
import pages.LogInPage;
import pages.ProductPage;
import utilities.DriverSetUp;

public class TestCheckOutPage extends DriverSetUp {

    ProductPage productPage =new ProductPage();
    LogInPage logInPage= new LogInPage();
    CheckOutPage checkOutPage =new CheckOutPage();

    @Test(description = "Automate the full checkout process")
    public void testCheckOut() {
        logInPage.doLogIn("standard_user", "secret_sauce");
        productPage.clickOnElement(productPage.addToCard1);
        productPage.clickOnElement(productPage.shoppingCard);
        checkOutPage.clickOnElement(checkOutPage.checkoutButton);
        checkOutPage.writeOnElement(checkOutPage.firstName,"John");
        checkOutPage.writeOnElement(checkOutPage.lastName,"Due");
        checkOutPage.writeOnElement(checkOutPage.postalCode,"12345");
        checkOutPage.clickOnElement(checkOutPage.continueButton);
        Assert.assertEquals(checkOutPage.elementText(checkOutPage.verify_product),"Sauce Labs Backpack");
        checkOutPage.clickOnElement(checkOutPage.finishButton);
        Assert.assertEquals(checkOutPage.elementText(checkOutPage.thankyoumsg),"Thank you for your order!");
    }
}
