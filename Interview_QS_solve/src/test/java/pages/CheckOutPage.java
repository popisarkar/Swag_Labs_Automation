package pages;

import org.openqa.selenium.By;

public class CheckOutPage extends BasePage{

    public By checkoutButton = By.id("checkout");
    public By firstName = By.xpath("//input[@id='first-name']");
    public By lastName = By.xpath("//input[@id='last-name']");
    public By postalCode  = By.xpath("//input[@id='postal-code']");
    public By continueButton = By.xpath("//input[@id='continue']");


    public By verify_product= By.cssSelector(".inventory_item_name");
    public By finishButton = By.xpath("//button[@id='finish']");
    public By thankyoumsg =By.className("complete-header");


}
