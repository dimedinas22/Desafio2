package steps;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.*;
import pages.PaginaBase;

public class Hooks extends PaginaBase{
    
    public Hooks(){
        super(driver);
    }
    // Este método se ejecuta después de cada escenario
    @After
    public void tearDown(Scenario escenario){
        // Si el escenario falló, toma una captura de pantalla
        if (escenario.isFailed()){
            escenario.log("El escenario fallo. Por favor revisar la imagen adjunta en este reporte");
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            // Adjuntamos la imagen al reporte del escenario
            escenario.attach(screenshot, "image/png", "Pantallazo del error");
        }
        
    }
    // Este método se ejecuta después de cada paso
    @AfterStep
    public void tomarCapturaCadaPaso(Scenario escenario) {
        // Tomamos una captura después de cada paso
        final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            escenario.attach(screenshot, "image/png", "Pantallazo del paso");
    }


}
