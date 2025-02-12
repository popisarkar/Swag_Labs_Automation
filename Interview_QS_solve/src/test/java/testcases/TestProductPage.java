package testcases;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LogInPage;
import pages.ProductPage;
import utilities.DriverSetUp;
import java.time.Duration;
import java.util.List;

public class TestProductPage extends DriverSetUp {
    ProductPage productPage =new ProductPage();
    LogInPage logInPage= new LogInPage();

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
        productPage.clickOnElement(productPage.addToCard2);
        //Add and remove items two times.
        WebElement cartBadge = wait.until(ExpectedConditions.visibilityOfElementLocated(productPage.CartCount));
        int countAfterAdding = Integer.parseInt(cartBadge.getText().trim());
        Assert.assertEquals(countAfterAdding, 1, "Cart badge count incorrect after adding products");
        productPage.clickOnElement(productPage.removeButton);
        List<WebElement> cartBadgeElements = getBrowser().findElements(productPage.CartCount);
        Assert.assertTrue(cartBadgeElements.isEmpty(), "Cart badge is still visible after removing the  item!");
    }
    }




