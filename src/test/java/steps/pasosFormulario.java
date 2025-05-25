package steps;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.*;
import pages.Formulario;



public class pasosFormulario {
    
    private Formulario caso = new Formulario();
    private String datosemail;
    private String lblBarrio = "";
    private String lblMensaje = "";  

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
    @Then("Deberia aparecer mensaje de error en el campo mail")
    public void DeberiaAparecerErrorEmail(){
        caso.ingresarEmail(datosemail);  
        boolean visible = caso.errorVisibleEmail();
        assertTrue(visible, "❌ El email es inválido pero no se mostró el error en el DOM.");  
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
    @Then("Se debe mostrar un mensaje de error en los campos barrio y asunto")
    public void seMuestraUnaAlertaDeErrorBarrioAsunto() {
        boolean errorBarrioVisible = caso.estaVisibleMensajeErrorBarrio();
        boolean errorAsuntoVisible = caso.estaVisibleMensajeErrorAsunto();
        
        assertAll("Validar errores en campos barrio y asunto",
        () -> assertTrue(errorBarrioVisible, "❌ No se mostró mensaje de error en el campo barrio."),
        () -> assertTrue(errorAsuntoVisible, "❌ No se mostró mensaje de error en el campo asunto.")
    );
    }
    @And("Visualiza el titulo Barrio")
    public void obtenerTextoBarrio() {
        lblBarrio = caso.verificarTituloBarrio(); // devuelve el texto de ese label
    }
    @And("Visualiza el titulo Mensaje")
    public void obtenerTextoMensaje() {
        lblMensaje = caso.verificarTituloMensaje(); // devuelve el texto de ese label
    }
    @Then("Los titulos de Barrio y Mensaje estan bien escritos")
    public void ortografia() {
        assertAll("Validar ortografía de los títulos",
            () ->assertEquals("Barrio", lblBarrio, "Error en el título Barrio, no esta bien escrito"),
            () -> assertEquals("Mensaje", lblMensaje, "Error en el título Mensaje, no está bien escrito")
        );
    }

    

}







