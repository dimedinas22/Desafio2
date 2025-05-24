package runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import pages.PaginaBase;

// Indicamos que esta clase ejecuta pruebas con Cucumber
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources", 
    glue = "steps", 
    plugin = { "pretty", "html:target/cucumber-reports" })

// Clase que se encarga de ejecutar los tests
public class RunnerJava{
    // Este método se ejecuta una vez al final de todos los escenarios
    @AfterClass
    public static void cleanDriver(){
        PaginaBase.cerrarNavegador();
    }
}
