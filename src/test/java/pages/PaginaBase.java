package pages;

import java.time.Duration;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;


    public class PaginaBase {

    protected static WebDriver driver;
    static WebDriverWait wait;

    
    static {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize(); // Maximiza la pantalla 
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    public PaginaBase(WebDriver driver) { 
        PaginaBase.driver = driver;
    }

    // Metodo para navegar a una pagina por su URL
    public void navegarA(String url){
        driver.get(url);
    }

    // Metodo para cerrar el navegador
    public static void cerrarNavegador(){
        driver.close();
    }
    
    // Método para encontrar un elemento web usando un objeto 'Element' con tipo y localizador
    // Espera explícita a que el elemento esté presente en el DOM antes de devolverlo
    public WebElement Find(Elemento elemento) {
    By by;
    switch (elemento.type.toLowerCase()) {
        case "id": by = By.id(elemento.locator); break;
        case "name": by = By.name(elemento.locator); break;
        case "css": by = By.cssSelector(elemento.locator); break;
        case "xpath": by = By.xpath(elemento.locator); break;
        default: throw new IllegalArgumentException("Tipo de localizador no válido: " + elemento.type);
        }
    return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }
    

    // Método para escribir texto en un campo de entrada (input)
    // Primero limpia el campo y luego envía las teclas
    public void escribir(Elemento elemento, String dato){
        Find(elemento).clear();
        Find(elemento).sendKeys(dato);
    }
    // Método para hacer clic en un elemento encontrado con el método Find
    public void clickElemento(Elemento elemento) {
        Find(elemento).click();
    }
    public boolean estaVisible(Elemento elemento) {
        try {
            return Find(elemento).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean validarEmailPersonalizado(String email) {
        if (email == null) return false;
        if (email.length() <= 4) return false;
        String regex = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$";
        return email.matches(regex);
    }
    
}
    

    


