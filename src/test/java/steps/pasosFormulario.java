package steps;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Assertions;
import io.cucumber.java.en.*;
import pages.Formulario;



public class pasosFormulario {
    
    private Formulario caso = new Formulario();
    private String datosemail;

    @Given("El usuario navega a {string}")
    public void navegaraFormularioWeb(String url){
        caso.navegaraFormulario();
    }

    @When("Ingresa su nombre {string}")
    public void elUsuarioIngresaSuNombre(String datosnombre) {
        caso.ingresarNombre(datosnombre);
    }
    @When("Ingresa su email {string}")
    public void elUsuarioIngresaSuEmail(String datosemail) {
        this.datosemail = datosemail;  // guardar para luego
        caso.ingresarEmail(datosemail);
    }
    @Then("No deberia aparecer mensaje de error en el campo mail")
    public void noDeberiaAparecerErrorEmail(){
        caso.ingresarEmail(datosemail);  
        boolean visible = caso.errorVisibleEmail();
        boolean esValido = caso.validarEmailPersonalizado(datosemail);

    if (!esValido) {
        assertTrue(visible, "❌ El email es inválido pero no se mostró el error en el DOM.");
    } else {
        assertFalse("❌ El email es válido pero se mostró un error en el DOM.", visible);
    }  
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
    @When("El usuario hace clic en el botón enviar sin completar el formulario")
    public void elUsuarioClickEnviarSinInformacion() {
        caso.clickEnviar(); 
    }
    @Then("Deberia aparecer una alerta de error al enviar el formulario vacio")
    public void seMuestraUnaAlertaDeError() {
        boolean alertaMostrada = caso.hayAlertaPresente();
        Assertions.assertTrue(alertaMostrada, "❌ No se mostró la alerta al enviar el formulario vacío.");
    }
    

    @When("Ingresa nombre invalido {string}")
    public void ingresaNombreinvalido(String nombre) {
        caso.ingresarNombre(nombre);
    }
    @Then("Se muestra un mensaje de error indicando que el nombre es inválido")
    public void seMuestraUnMensajeDeErrorNombreInvalido() {
    Assertions.assertTrue(caso.estaVisibleMensajeErrorNombre(),"❌ El nombre es inválido, pero NO apareció mensaje de error."
    );
    }
}






