package PageObject.Site;


import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class PublicationPage extends BasePage{

    public PublicationPage(WebDriver driver) {
        super(driver);
    }

    public String getArticleTitle(){
        return driver.findElement(By.className("entry-title")).getText();
    }


}
