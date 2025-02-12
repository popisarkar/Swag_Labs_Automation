package testcases;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LogInPage;
import pages.SortingProductsPage;
import utilities.DriverSetUp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestSortingProductsPage extends DriverSetUp {
    LogInPage logInPage = new LogInPage();
    SortingProductsPage dataset = new SortingProductsPage();

    @Test(description = "Test Price low to high ")
    public void testProductSortingByPriceLowToHigh() {
        logInPage.doLogIn("standard_user", "secret_sauce");
        dataset.sortProducts("Price (low to high)");
        List<Double> actualPrices = dataset.getProductPrices();
        List<Double> expectedPrices = new ArrayList<>(dataset.getProducts().values());
        expectedPrices.sort(Double::compareTo);
        Assert.assertEquals(actualPrices, expectedPrices, "Products are not sorted correctly by price (Low to High)");
    }

    @Test(description = "Test Price high to low")
    public void testProductSortingByPriceHighToLow() {
        logInPage.doLogIn("standard_user", "secret_sauce");
        dataset.sortProducts("Price (high to low)");
        List<Double> actualPrices = dataset.getProductPrices();
        List<Double> expectedPrices = new ArrayList<>(dataset.getProducts().values());
        expectedPrices.sort((a, b) -> Double.compare(b, a));
        Assert.assertEquals(actualPrices, expectedPrices, "Products are not sorted correctly by price (High to Low)");
    }

    @Test(description = "Test Name A to Z")
    public void testProductSortingByNameAToZ() {
        logInPage.doLogIn("standard_user", "secret_sauce");
        dataset.sortProducts("Name (A to Z)");
        List<String> actualNames = dataset.getProductNames();
        List<String> expectedNames = new ArrayList<>(dataset.getProducts().keySet());
        Collections.sort(expectedNames);
        Assert.assertEquals(actualNames, expectedNames, "Products are not sorted correctly by name (A to Z)");
    }

    @Test(description = "Test Name Z to A")
    public void testProductSortingByNameZToA() {
        logInPage.doLogIn("standard_user", "secret_sauce");
        dataset.sortProducts("Name (Z to A)");
        List<String> actualNames = dataset.getProductNames();
        List<String> expectedNames = new ArrayList<>(dataset.getProducts().keySet());
        Collections.sort(expectedNames, Collections.reverseOrder());
        Assert.assertEquals(actualNames, expectedNames, "Products are not sorted correctly by name (Z to A)");
    }
}
