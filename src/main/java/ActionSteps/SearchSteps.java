package ActionSteps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchSteps {
    private WebDriver driver;

    public SearchSteps(WebDriver driverCurrent){
        driver = driverCurrent;
    }

    public void searchForTerm(String searchTerm){
        WebElement busca = driver.findElement(By.className("search-field"));
        busca.sendKeys(searchTerm);
        busca.submit();
    }
    public void clickSearch(){
        driver.findElement(By.id("header-search")).click();
    }

}
