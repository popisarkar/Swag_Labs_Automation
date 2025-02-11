package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortingProductsPage extends BasePage {
    public By sortDropdown = By.className("product_sort_container");
    public By productPriceLocator = By.className("inventory_item_price");
    public By productNameLocator = By.className("inventory_item_name");

    public List<Double> getProductPrices() {
        // Find all elements that represent product prices
        List<WebElement> priceElements = getElements(productPriceLocator);

        // Create a list to store the prices
        List<Double> productPrices = new ArrayList<>();

        // Loop through all price elements and convert them to Double
        for (WebElement priceElement : priceElements) {
            // Get the text from the element (price as a string)
            String priceText = priceElement.getText().replace("$", "").trim(); // Remove "$" if present and trim any whitespace

            try {
                // Convert the price string to a Double and add it to the list
                productPrices.add(Double.parseDouble(priceText));
            } catch (NumberFormatException e) {
                System.out.println("Error parsing price: " + priceText);
            }
        }

        // Return the list of product prices
        return productPrices;
    }

    public Map<String, Double> products;

    public SortingProductsPage() {
        ProductDataSet();  // Initialize the product data
    }

    // Method to get all product names
    public List<String> getProductNames() {
        // Find all elements that represent product names
        List<WebElement> nameElements = getElements(productNameLocator);

        // Create a list to store the product names
        List<String> productNames = new ArrayList<>();

        // Loop through all name elements and get the text
        for (WebElement nameElement : nameElements) {
            productNames.add(nameElement.getText());
        }

        // Return the list of product names
        return productNames;
    }

    public void ProductDataSet() {
        products = new HashMap<>();
        products.put("Test.allTheThings() T-Shirt (Red)", 15.99);
        products.put("Sauce Labs Onesie", 7.99);
        products.put("Sauce Labs Fleece Jacket", 49.99);
        products.put("Sauce Labs Bolt T-Shirt", 15.99);
        products.put("Sauce Labs Bike Light", 9.99);
        products.put("Sauce Labs Backpack", 29.99);
    }

    public Map<String, Double> getProducts() {
        return products;
    }

    public void sortProducts(String sortOption) {
        WebElement dropdownElement = getElement(sortDropdown);
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText(sortOption);
        // Ensures sorting is completed (could include an explicit wait if needed)
    }
}
