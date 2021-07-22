package PageObject.Site;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage {


    public HomePage(WebDriver driver) {
        super(driver);
    }


    public void clickOnPublication(){
        driver.findElement(By.className("entry-title")).click();
    }

    public String getTitlePost(){
        return driver.findElement(By.className("entry-title")).getText();
    }

}
