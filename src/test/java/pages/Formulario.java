package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;




public class Formulario extends PaginaBase {

    // ingresar nombre en campo nombre
    private Elemento nombre = new Elemento("name", "nombre"); 
    // ingresar email en campo email
    private Elemento email = new Elemento ("css","input[name='email']"); 
    // ingresar barrio en campo barrio
    private Elemento barrio = new Elemento ("name","barrio"); 
    // ingresar asunto en campo asunto
    private Elemento asunto = new Elemento ("css","input[name='asunto']"); 
    // ingresar mensaje en campo mensaje
    private Elemento mensaje = new Elemento ("xpath","//textarea[@name='Mensaje']"); 
    // Boton para enviar formulario
    private Elemento botonEnviar = new Elemento ("xpath","//button[@type='submit']");
    // Mensaje que aparece si el email es inválido
    private Elemento mensajeErrorEmail = new Elemento ("xpath","//p[@class='formulario__input-error formulario__input-error-activo']");
    
    //Constructor
    public Formulario() {
        super(driver);
    }

    // Navega a la pagina principal de formulario Caso 1
    public void navegaraFormulario() {
        navegarA("http://64.227.54.255/Softesting/Frontend/Caso1.html");
    }


    // Metodo para Escribir dato nombre 
    public void ingresarNombre(String datosnombre){
        escribir(nombre,datosnombre);
        
    }
    // Escribe dato email
    public void ingresarEmail(String datosemail){
        escribir(email,datosemail); 

    boolean errorVisible = estaVisible(mensajeErrorEmail);
    boolean esValidoLocal = validarEmailPersonalizado(datosemail);

    if (esValidoLocal && errorVisible) {
        throw new RuntimeException("❌ El email '" + datosemail + "' es válido, pero el DOM muestra un error.");
    } else if (!esValidoLocal && !errorVisible) {
        throw new RuntimeException("❌ El email '" + datosemail + "' es inválido, pero el DOM NO muestra error.");
    } else {
        System.out.println("✅ El email '" + datosemail + "' fue procesado correctamente por el DOM.");
    }
    }
    
    // Escribe dato barrio
    public void ingresarBarrio(String datosbarrio){
        escribir(barrio,datosbarrio);   
    }
    // Escribe dato Asunto
    public void ingresarAsunto(String datosasunto){
        escribir(asunto,datosasunto);   
    }
    // Escribe dato mensaje
    public void ingresarMensaje(String datosmensaje){
        escribir(mensaje,datosmensaje);   

    }
     // Hace clic en el boton Enviar
    public boolean clickEnviar(){
        try {
        clickElemento(botonEnviar);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        Alert alerta = wait.until(ExpectedConditions.alertIsPresent());

        // Si llega aquí, es porque hay una alerta
        System.out.println("Se detectó una alerta: " + alerta.getText());
        alerta.accept(); // o .dismiss() si lo prefieres
        return true;

    } catch (TimeoutException e) {
        // No se mostró alerta: formulario enviado correctamente
        throw new AssertionError("Error: No se mostró la alerta al intentar enviar el formulario vacío.");
    }
}

}

    




