package testcases;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckOutPage;
import pages.LogInPage;
import pages.ProductPage;
import utilities.DriverSetUp;

import java.time.Duration;

public class TestProductPage extends DriverSetUp {
    ProductPage productPage =new ProductPage();
    LogInPage logInPage= new LogInPage();
   CheckOutPage checkOutPage =new CheckOutPage();




    @Test(description = "Add To Card")
    public void testAddToCard(){
        logInPage.doLogIn("standard_user","secret_sauce");
        productPage.clickOnElement(productPage.addToCard1);
        productPage.clickOnElement(productPage.addToCard2);
        productPage.clickOnElement(productPage.shoppingCard);
    }

    @Test(description = "Verify cart badge count updates correctly when adding and removing items")
    public void testCartBadgeUpdate() {
        logInPage.doLogIn("standard_user", "secret_sauce");

        WebDriverWait wait = new WebDriverWait(getBrowser(), Duration.ofSeconds(10));

        // Add products to cart
        productPage.clickOnElement(productPage.addToCard1);
        productPage.clickOnElement(productPage.addToCard2);

        // Verify badge count after adding
        WebElement cartBadge = wait.until(ExpectedConditions.visibilityOfElementLocated(productPage.CartCount));
        int countAfterAdding = Integer.parseInt(cartBadge.getText().trim());
        Assert.assertEquals(countAfterAdding, 2, "Cart badge count incorrect after adding products!");

        // Remove one product
        productPage.clickOnElement(productPage.removeButton);

        // Verify badge count after removing
        WebElement updatedCartBadge = wait.until(ExpectedConditions.visibilityOfElementLocated(productPage.CartCount));
        int countAfterRemoving = Integer.parseInt(updatedCartBadge.getText().trim());
        Assert.assertEquals(countAfterRemoving, 1, "Cart badge count incorrect after removing a product!");
    }









//    @Test(description = "productPurchase")
//    public void purchaseProduct() throws InterruptedException {
//        logInPage.doLogIn("standard_user","secret_sauce");
//
//        productPage.clickOnElement(productPage.product1);
//
//        productPage.clickOnElement(productPage.shoppingCard);
//
//        checkOutPage.clickOnElement(checkOutPage.checkoutButton);
//
//        checkOutPage.writeOnElement(checkOutPage.firstName,"popy");
//        checkOutPage.writeOnElement(checkOutPage.lastName,"sarkar");
//        checkOutPage.writeOnElement(checkOutPage.postalCode,"1234");
//
//        checkOutPage.clickOnElement(checkOutPage.continueButton);
//
////      checkOutPage.clickOnElement(checkOutPage.finishButton);
//        checkOutPage.clickOnElement(checkOutPage.manu);
//
//        checkOutPage.clickOnElement(checkOutPage.logOut);
//
//    }
}
