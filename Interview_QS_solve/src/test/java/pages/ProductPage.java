package pages;

import org.openqa.selenium.By;

public class ProductPage extends BasePage{
    public String productPageURl ="https://www.saucedemo.com/inventory.html";

    public By product1 = By.xpath("//div[normalize-space()='Sauce Labs Backpack']");
    public By product2 = By.xpath("//div[normalize-space()='Sauce Labs Bolt T-Shirt']");




    // public By product1 = By.xpath("//div[normalize-space()='Sauce Labs Backpack']");
    //public By product2 = By.xpath("//div[normalize-space()='Sauce Labs Bolt T-Shirt']");
    public By addToCard1= By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']");
    public By addToCard2= By.xpath("//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']");


    public By CartCount=  By.className("shopping_cart_badge");
    public By removeButton= By.xpath("//button[@id='remove-sauce-labs-bolt-t-shirt']");
    public By shoppingCard = By.xpath("//a[@class='shopping_cart_link']");
    public By productTittle = By.xpath("//div[@class='inventory_details_name large_size']");

    public void addToCardProduct(By locator){
    clickOnElement(addToCard1);

    }
}
