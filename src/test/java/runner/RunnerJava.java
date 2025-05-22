package runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import pages.PaginaBase;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources", 
    glue = "steps", 
    plugin = { "pretty", "html:target/cucumber-reports" })

public class RunnerJava{
    @AfterClass
    public static void cleanDriver(){
        PaginaBase.cerrarNavegador();
    }
}
