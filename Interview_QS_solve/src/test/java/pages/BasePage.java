package pages;

import io.qameta.allure.Allure;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.ByteArrayInputStream;
import java.time.Duration;
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

    public void hoverOnElement(By locator){
        Actions action = new Actions(getBrowser());
        action.clickAndHold(getElement(locator)).build().perform();
    }

 public void loadWebUrl( String url){
        getBrowser().get(url);


 }

 public  String elementText(By locator){
     return  getElement(locator).getText();

 }



        public List<WebElement> getElements(By by) {
            return getBrowser().findElements(by);  // This returns a list of elements matching the 'by' locator.
        }


        public void waitForPageLoad() {
            WebDriverWait wait = new WebDriverWait(getBrowser(), Duration.ofSeconds(10));

            // Wait for the document ready state to be "complete"
            wait.until(webDriver -> ((JavascriptExecutor) webDriver)
                    .executeScript("return document.readyState").equals("complete"));

            // Wait for any active AJAX requests to complete
            wait.until(webDriver -> (Boolean) ((JavascriptExecutor) webDriver)
                    .executeScript("return jQuery.active == 0"));
        }



    }
