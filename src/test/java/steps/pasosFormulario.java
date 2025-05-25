package steps;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Assertions;


import io.cucumber.java.en.*;
import pages.Formulario;



public class pasosFormulario {
    
    private Formulario caso = new Formulario();
    private String lblBarrio = "";
    private String lblMensaje = "";  
    
    // GIVEN
    // Navega a la URL del formulario especificada para iniciar la prueba
    @Given("El usuario navega a {string}")
    public void navegaraFormularioWeb(String url){
        caso.navegaraFormulario();
    }
    
    // WHEN
    // Ingresa el nombre del usuario en el campo correspondiente del formulario
    @When("Ingresa su nombre {string}")
    public void elUsuarioIngresaSuNombre(String datosnombre) {
        caso.ingresarNombre(datosnombre);
    }
    // Clic en el botón de enviar del formulario cuando todos los campos han sido completados
    @When("El usuario da clic en boton enviar")
    public void elUsuarioClickEnviarInformacion() {
        caso.clickEnviar(); 
    }
    // Ingresa un email inválido para probar la validación del campo de correo
    @When("Ingresa su email invalido {string}")
    public void elUsuarioIngresaSuEmail(String datosemail) {
        caso.ingresarEmail(datosemail);
    }
    // Intenta enviar el formulario sin llenar ningún campo
    @When("El usuario hace clic en el botón enviar sin completar el formulario")
    public void elUsuarioClickEnviarSinInformacion() {
        caso.clickEnviar(); 
    }
    
    // AND
    // Ingresa un email válido en el campo correspondiente del formulario
    @And("Ingresa su email {string}")
    public void elUsuarioIngresaSuEmailValido(String datosemail) {
        caso.ingresarEmail(datosemail);
    }
    // Ingresa el nombre del barrio en el formulario
    @And("Ingresa su barrio {string}")
    public void elUsuarioIngresaSuBarrio(String datosebarrio) {
        caso.ingresarBarrio(datosebarrio);  
    }
    // Ingresa un asunto relacionado al mensaje
    @And("Ingresa un asunto {string}")
    public void elUsuarioIngresaSuAsunto(String datosasunto) {
        caso.ingresarAsunto(datosasunto);  
    }
    // Escribe un mensaje en el campo correspondiente del formulario
    @And("Ingresa un mensaje {string}")
    public void elUsuarioIngresaUnMensaje(String datosmensaje) {
        caso.ingresarMensaje(datosmensaje);  
    }
    // Captura el texto del título del campo "Barrio" para verificar su ortografía
    @And("Visualiza el titulo Barrio")
    public void obtenerTextoBarrio() {
        lblBarrio = caso.verificarTituloBarrio(); // devuelve el texto de ese label
    }
    // Captura el texto del título del campo "Mensaje" para verificar su ortografía
    @And("Visualiza el titulo Mensaje")
    public void obtenerTextoMensaje() {
        lblMensaje = caso.verificarTituloMensaje(); // devuelve el texto de ese label
    }
    
    // THEN
    // Verifica que no se haya mostrado ninguna alerta tras enviar un formulario correctamente completado
    @Then("El formulario se envia exitosamente")
    public void enviodatos(){
        boolean alertaMostrada = caso.hayAlertaPresente();
        Assertions.assertFalse(alertaMostrada, "❌ Se mostró una alerta, el formulario no se envio exitosamente.");
    }
    // Verifica que se haya mostrado un mensaje de error por un email inválido
    @Then("Deberia aparecer mensaje de error en el campo mail")
    public void DeberiaAparecerErrorEmail(){ 
        boolean visible = caso.errorVisibleEmail();
        assertTrue(visible, "❌ El email es inválido pero no se mostró el error en el DOM.");  
    }
    // Verifica que se haya mostrado una alerta al intentar enviar un formulario vacío
    @Then("Deberia aparecer una alerta de error al enviar el formulario vacio")
    public void seMuestraUnaAlertaDeError() {
        boolean alertaMostrada = caso.hayAlertaPresente();
        Assertions.assertTrue(alertaMostrada, "❌ No se mostró la alerta al enviar el formulario vacío.");
    }
    // Verifica que se haya mostrado el mensaje de error correspondiente al nombre inválido
    @Then("Se muestra un mensaje de error indicando que el nombre es inválido")
    public void seMuestraUnMensajeDeErrorNombreInvalido() {
        Assertions.assertTrue(caso.estaVisibleMensajeErrorNombre(),"❌ El nombre es inválido, pero NO apareció mensaje de error."
    );
    }
    // Verifica que ambos campos "Barrio" y "Asunto" muestran un mensaje de error 
    @Then("Se debe mostrar un mensaje de error en los campos barrio y asunto")
    public void seMuestraUnaAlertaDeErrorBarrioAsunto() {
        boolean errorBarrioVisible = caso.estaVisibleMensajeErrorBarrio();
        boolean errorAsuntoVisible = caso.estaVisibleMensajeErrorAsunto();    
        assertAll("Validar errores en campos barrio y asunto",
            () -> assertTrue(errorBarrioVisible, "❌ No se mostró mensaje de error en el campo barrio."),
            () -> assertTrue(errorAsuntoVisible, "❌ No se mostró mensaje de error en el campo asunto.")
        );
    }
    // Verifica que los títulos de los campos "Barrio" y "Mensaje" están bien escritos
    @Then("Los titulos de Barrio y Mensaje estan bien escritos")
    public void ortografia() {
        assertAll("Validar ortografía de los títulos",
            () ->assertEquals("Barrio", lblBarrio, "Error en el título Barrio, no esta bien escrito"),
            () -> assertEquals("Mensaje", lblMensaje, "Error en el título Mensaje, no está bien escrito")
        );
    }
}







