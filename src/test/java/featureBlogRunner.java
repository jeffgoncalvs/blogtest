import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/Functionalities/blog.feature"
        ,glue="StepDefinition"
        ,plugin = { "pretty", "html:build/cucumber-reports"}
        ,monochrome = true
)
public class featureBlogRunner {

    @BeforeClass
    public static void setupClass() {
        System.out.println("Before All");
    }

    @AfterClass
    public static void teardownClass() {
        System.out.println("After All");
    }
}
