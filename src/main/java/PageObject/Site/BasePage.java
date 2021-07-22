package PageObject.Site;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    protected final WebDriver driver;

    BasePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void reInit(){
        PageFactory.initElements(driver, this);
    }

    public void scrollToElement(WebElement element){
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        Actions actions = new Actions(driver);
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
        actions.moveToElement(element).perform();
    }
}
