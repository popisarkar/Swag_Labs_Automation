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



    @Test(description = "Add To Card")
    public void testcheckout() {
        logInPage.doLogIn("standard_user", "secret_sauce");
        productPage.clickOnElement(productPage.addToCard1);
        productPage.clickOnElement(productPage.shoppingCard);
        checkOutPage.clickOnElement(checkOutPage.checkoutButton);
        checkOutPage.writeOnElement(checkOutPage.firstName,"popy");
      checkOutPage.writeOnElement(checkOutPage.lastName,"sarkar");
       checkOutPage.writeOnElement(checkOutPage.postalCode,"1234");

       checkOutPage.clickOnElement(checkOutPage.continueButton);
        Assert.assertEquals(checkOutPage.elementText(checkOutPage.verify_product),"Sauce Labs Backpack");
        checkOutPage.clickOnElement(checkOutPage.finishButton);
        Assert.assertEquals(checkOutPage.elementText(checkOutPage.thankyoumsg),"Thank you for your order!");





    }



}
