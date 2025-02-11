package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.LogInPage;
import pages.ProductPage;
import pages.SortingProductsPage;
import utilities.DriverSetUp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestSortingProductsPage extends DriverSetUp {

    LogInPage logInPage = new LogInPage();
    SortingProductsPage dataset = new SortingProductsPage();

    @Test
    public void testProductSortingByPriceLowToHigh() {
        logInPage.doLogIn("standard_user", "secret_sauce");
        dataset.sortProducts("Price (low to high)");  // Call sortProducts from SortingProductsPage object

        List<Double> actualPrices = dataset.getProductPrices();
        List<Double> expectedPrices = new ArrayList<>(dataset.getProducts().values());
        expectedPrices.sort(Double::compareTo);

        Assert.assertEquals(actualPrices, expectedPrices, "Products are not sorted correctly by price (Low to High)");
    }



    @Test
    public void testProductSortingByPriceHighToLow() {
        logInPage.doLogIn("standard_user", "secret_sauce");
        // Sort the products by Price (High to Low)
        dataset.sortProducts("Price (high to low)");

        // Get the actual product prices after sorting
        List<Double> actualPrices = dataset.getProductPrices();

        // Expected prices are already in the dataset and sorted high to low
        List<Double> expectedPrices = new ArrayList<>(dataset.getProducts().values());
        expectedPrices.sort((a, b) -> Double.compare(b, a));  // Sort descending for High to Low

        // Assert that the actual prices match the expected prices
        Assert.assertEquals(actualPrices, expectedPrices, "Products are not sorted correctly by price (High to Low)");
    }

    @Test
    public void testProductSortingByNameAToZ() {
        // Sort the products by Name (A to Z)

        logInPage.doLogIn("standard_user", "secret_sauce");
        dataset.sortProducts("Name (A to Z)");

        // Get the actual product names after sorting
        List<String> actualNames = dataset.getProductNames();

        // Expected names are already in the dataset and sorted A to Z
        List<String> expectedNames = new ArrayList<>(dataset.getProducts().keySet());
        Collections.sort(expectedNames);  // Sort alphabetically for A to Z

        // Assert that the actual names match the expected names
        Assert.assertEquals(actualNames, expectedNames, "Products are not sorted correctly by name (A to Z)");
    }

    @Test
    public void testProductSortingByNameZToA() {
        logInPage.doLogIn("standard_user", "secret_sauce");
        // Sort the products by Name (Z to A)
        dataset.sortProducts("Name (Z to A)");

        // Get the actual product names after sorting
        List<String> actualNames = dataset.getProductNames();

        // Expected names are already in the dataset and sorted Z to A
        List<String> expectedNames = new ArrayList<>(dataset.getProducts().keySet());
        Collections.sort(expectedNames, Collections.reverseOrder());  // Sort in reverse order for Z to A

        // Assert that the actual names match the expected names

        Assert.assertEquals(actualNames, expectedNames, "Products are not sorted correctly by name (Z to A)");
    }





}
