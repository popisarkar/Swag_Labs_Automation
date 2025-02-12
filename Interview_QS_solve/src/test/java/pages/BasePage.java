package pages;
import org.openqa.selenium.*;
import java.util.List;
import static utilities.DriverSetUp.getBrowser;

    public class BasePage {

       public WebElement getElement(By locator){
         return getBrowser().findElement(locator);
    }

    public void clickOnElement(By locator){
           getElement(locator).click();
    }

    public void writeOnElement(By locator,String text){
        getElement(locator).sendKeys(text);
    }

 public void loadWebUrl( String url){
        getBrowser().get(url);

 }

 public  String elementText(By locator){
     return  getElement(locator).getText();

 }

        public List<WebElement> getElements(By by) {
            return getBrowser().findElements(by);
        }




    }
