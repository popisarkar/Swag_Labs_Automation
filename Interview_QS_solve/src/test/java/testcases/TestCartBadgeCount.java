package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utilities.DriverSetUp;

public class TestCartBadgeCount extends DriverSetUp {

    ProductPage productPage =new ProductPage();
    LogInPage logInPage= new LogInPage();

    CartBadgeCountPage cartBadgeCountPage= new CartBadgeCountPage();


    @Test(description = "Verify cart badge count updates correctly")
    public void testCartBadgeCount() {
        // Step 1: Login
        logInPage.doLogIn("standard_user", "secret_sauce");

        // Step 2: Add product to cart
        productPage.clickOnElement(productPage.addToCard1);
        productPage.clickOnElement(productPage.addToCard2);


        int cartCountAfterAdding = Integer.parseInt(productPage.getElement(productPage.CartCount).getText().trim());
        Assert.assertEquals(cartCountAfterAdding, 2, "Cart badge count should be 2 after adding two products.");

        // Step 4: Remove one product
        productPage.clickOnElement(productPage.removeButton);

        // Step 5: Verify cart badge count is updated to 1
        int cartCountAfterRemoving = Integer.parseInt(productPage.getElement(productPage.CartCount).getText().trim());
        Assert.assertEquals(cartCountAfterRemoving, 1, "Cart badge count should decrease to 1 after removing a product.");


    }


}
