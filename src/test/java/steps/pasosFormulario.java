package steps;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.*;
import pages.Formulario;


public class pasosFormulario {
    
    private Formulario caso = new Formulario();

    @Given("El usuario navega a {string}")
    public void navegaraFormularioWeb(String url){
        caso.navegaraFormulario();
    }

    @When("Ingresa su nombre {string}")
    public void elUsuarioIngresaSuNombre(String datosnombre) {
        caso.ingresarNombre(datosnombre);
    }
    @And("Ingresa su email {string}")
    public void elUsuarioIngresaSuEmail(String datosemail) {
        caso.ingresarEmail(datosemail);  
    }
    @And("Ingresa su barrio {string}")
    public void elUsuarioIngresaSuBarrio(String datosebarrio) {
        caso.ingresarBarrio(datosebarrio);  
    }
    @And("Ingresa un asunto {string}")
    public void elUsuarioIngresaSuAsunto(String datosasunto) {
        caso.ingresarAsunto(datosasunto);  
    }
    @And("Ingresa un mensaje {string}")
    public void elUsuarioIngresaUnMensaje(String datosmensaje) {
        caso.ingresarMensaje(datosmensaje);  
    }
    @When("El usuario da clic en boton Enviar, el formulario se envia exitosamente")
    public void elUsuarioEnviaFormulario() {
        caso.clickEnviar();  
    }
    @When("Al cliclear en boton enviar se muestra alerta de error")
    public void elUsuarioClickEnviarSinInformacion() {
        caso.clickEnviar();  
}
}





