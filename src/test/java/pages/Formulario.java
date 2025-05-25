package pages;


import org.openqa.selenium.Alert;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;



/**
 * Clase que representa la página del formulario web.
 * Hereda de PaginaBase, donde están definidos métodos reutilizables para interactuar con el navegador.
 */
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
    private Elemento mensajeErrorEmail = new Elemento ("xpath","//b[normalize-space()='no debe incluir caracteres especiales']");
    // Mensaje que aparece si el nonbre es inválido
    private Elemento mensajeErrorNombre = new Elemento ("xpath","//p[contains(text(),'El nombre debe ser mayor a 4 letras y no debe incl')]");
    private Elemento mensajeErrorbarrio = new Elemento ("css","div[id='grupo__barrio'] p[class='formulario__input-error formulario__input-error-activo']");
    private Elemento mensajeErrorasunto = new Elemento ("css","div[id='grupo__asunto'] p[class='formulario__input-error formulario__input-error-activo']");
    private Elemento tituloBarrio = new Elemento ("xpath","//label[contains(text(),'Varrio')]");
    private Elemento tituloMensaje = new Elemento ("xpath","//label[contains(text(),'Mensage:')]");
    
    //Indica si apareció una alerta al enviar el formulario
    private boolean alertaVisible = false;

    // Constructor que llama al constructor de la clase base
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
     // Hace clic en el boton Enviar y maneja la alerta que aparece.
    public boolean clickEnviar(){
        try {
            clickElemento(botonEnviar);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
            Alert alerta = wait.until(ExpectedConditions.alertIsPresent());
            alertaVisible = true;  // guardamos estado de alerta detectada
            alerta.accept();       // cerramos alerta
            return true;
        } catch (TimeoutException e) {
            alertaVisible = false;
            return false;
        }
    }
    // Métodos para verificar si los mensajes de error son visibles
    public boolean estaVisibleMensajeErrorNombre() {
        return estaVisible(mensajeErrorNombre);
    }
    public boolean estaVisibleMensajeErrorAsunto() {
        return estaVisible(mensajeErrorasunto);
    }
    public boolean estaVisibleMensajeErrorBarrio() {
        return estaVisible(mensajeErrorbarrio);
    }

    
    //Verifica si el mensaje de error del email es visible.
    public boolean errorVisibleEmail() {
    return estaVisible(mensajeErrorEmail);
    }
    //Devuelve si una alerta fue mostrada después de enviar el formulario.
    public boolean hayAlertaPresente() {
        return alertaVisible;
    }
    public String verificarTituloBarrio(){
        return obtenerTexto(tituloBarrio);   
    }
    public String verificarTituloMensaje(){
        return obtenerTexto(tituloMensaje);   
    }

}





    


    




