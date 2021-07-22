package StepDefinition;

import ActionSteps.SearchSteps;
import Helper.DriverSetup;
import Helper.PropertyHelper;
import PageObject.Site.HomePage;
import PageObject.Site.PublicationPage;
import io.cucumber.java.After;
import io.cucumber.java.pt.*;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import javax.sound.midi.Soundbank;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;

@RunWith(Cucumber.class)
public class NavigationSteps {

    private WebDriver driver;
    private HomePage homePage;
    private String postTitle;
    private PublicationPage publicationPage;
    private String searchTerm= "teste";
    private SearchSteps searchSteps;
    private String bottomText="relacionado";

    @Dado("Que estou no blog")
    public void acessBlog(){
        initBorwser();
        String url = new PropertyHelper().getUrlBase("hyperflame");
        System.out.println("Acessei o blog da HypeFlame na URL:"+ url.toString());
        driver.get(url);
    }

    @Dado("estou na tela principal")
    public void acessLogin(){
         homePage = new HomePage(driver);
         postTitle = homePage.getTitlePost();
        System.out.println("Estou na tela inicial do blog");

    }
    @Quando("Clico no post")
    public void clickPost() {
        homePage.clickOnPublication();
        System.out.println("Cliquei na publicação");
    }

    @Entao("estou na tela do post")
    public void CheckPost() {
        publicationPage = new PublicationPage(driver);
        assertThat(postTitle,containsString(publicationPage.getArticleTitle()));
        System.out.println("Estou na tela do post");
    }

    public void initBorwser(){
        driver = new DriverSetup().getDriver();
    }

    @Quando("clico em pesquisar")
    public void clicoEmPesquisar() {
        searchSteps = new SearchSteps(driver);
        searchSteps.clickSearch();
        System.out.println("Cliquei no botão da pesquisa");
    }

    @E("Realizo uma pesquisa")
    public void realizoUmaPesquisa() {
        searchSteps = new SearchSteps(driver);
        searchSteps.searchForTerm(searchTerm);
        System.out.println("realizei uma pesquisa com o termo: " + searchTerm.toUpperCase());
    }

    @Então("estou na tela de resultado")
    public void estouNaTelaDeResultado() {
        WebElement tempElement = driver.findElement(By.className("page-header"));
        String tempText = tempElement.findElement(By.className("th-font-bolder")).getText();
        assertThat(searchTerm,containsString(tempText));
        System.out.println("estou na tela de resultado da pesquisa do termo: " + searchTerm.toUpperCase());
    }

    @E("faço scroll ate o final da pagina")
    public void navegoNaTela() {
        publicationPage = new PublicationPage(driver);
        publicationPage.scrollToElement(driver.findElement(By.id("jp-relatedposts")));
        String tempTxt = driver.findElement(By.id("jp-relatedposts")).findElement(By.className("jp-relatedposts-headline")).getText();
        assertThat(bottomText.toUpperCase(),containsString(tempTxt.toUpperCase()));
        System.out.println("Fiz scroll ate o final da tela");
    }

    @After
    public void closeBrowser(){
        if (driver != null) {
            driver.quit();
        }
    }
}
