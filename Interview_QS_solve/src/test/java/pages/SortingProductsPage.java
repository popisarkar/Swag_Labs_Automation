package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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

        List<WebElement> priceElements = getElements(productPriceLocator);
        List<Double> productPrices = new ArrayList<>();
        for (WebElement priceElement : priceElements) {
            String priceText = priceElement.getText().replace("$", "").trim();

            try {
                productPrices.add(Double.parseDouble(priceText));
            } catch (NumberFormatException e) {
                System.out.println("Error parsing price: " + priceText);
            }
        }
        return productPrices;
    }


    public Map<String, Double> products;
    public SortingProductsPage() {
        ProductDataSet();
    }

    public List<String> getProductNames() {

        List<WebElement> nameElements = getElements(productNameLocator);
        List<String> productNames = new ArrayList<>();
        for (WebElement nameElement : nameElements) {
            productNames.add(nameElement.getText());
        }
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
    }
}
