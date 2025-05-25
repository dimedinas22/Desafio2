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
    // Mensaje que aparece si el barrio es inválido
    private Elemento mensajeErrorBarrio = new Elemento ("css","div[id='grupo__barrio'] p[class='formulario__input-error formulario__input-error-activo']");
    // Mensaje que aparece si el asunto es inválido
    private Elemento mensajeErrorAsunto = new Elemento ("css","div[id='grupo__asunto'] p[class='formulario__input-error formulario__input-error-activo']");
    // Titulo de el campo Barrio en el formulario
    private Elemento tituloBarrio = new Elemento ("xpath","//label[contains(text(),'Varrio')]");
    // Titulo de el campo Asunto en el formulario
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
    //Verifica si el mensaje de error del nombre es visible.
    public boolean estaVisibleMensajeErrorNombre() {
        return estaVisible(mensajeErrorNombre);
    }
    //Verifica si el mensaje de error del asunto es visible.
    public boolean estaVisibleMensajeErrorAsunto() {
        return estaVisible(mensajeErrorAsunto);
    }
    //Verifica si el mensaje de error del barrio es visible.
    public boolean estaVisibleMensajeErrorBarrio() {
        return estaVisible(mensajeErrorBarrio);
    }

    //Verifica si el mensaje de error del email es visible.
    public boolean errorVisibleEmail() {
    return estaVisible(mensajeErrorEmail);
    }
    //Devuelve si una alerta fue mostrada después de enviar el formulario.
    public boolean hayAlertaPresente() {
        return alertaVisible;
    }
    //Obtiene el texto visible del titulo barrio en el formulario
    public String verificarTituloBarrio(){
        return obtenerTexto(tituloBarrio);   
    }
    //Obtiene el texto visible del titulo mensaje en el formulario
    public String verificarTituloMensaje(){
        return obtenerTexto(tituloMensaje);   
    }

}





    


    




