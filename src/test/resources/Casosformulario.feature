Feature: Automatizacion sobre formulario Web
    

    Scenario Outline: El usuario ingresa al formulario, escribe sus datos validos, da clic boton Enviar el formulario se envia exitosamente
        Given El usuario navega a "http://64.227.54.255/Softesting/Frontend/Caso1.html"
        When Ingresa su nombre "<Nombre>"
        And Ingresa su email "<Email>"
        And Ingresa su barrio "<Barrio>"
        And Ingresa un asunto "<Asunto>"
        And Ingresa un mensaje "<Mensaje>"
        When El usuario da clic en boton Enviar, el formulario se envia exitosamente
        

        Examples:
            | Nombre    | Email               | Barrio    | Asunto        | Mensaje       |
            | Diana     |dimedina44@gmail.com | La trini  |prueba1        |prueba 1       |
    
    
    Scenario: El usuario intenta enviar el formulario sin ingresar informacion
        Given El usuario navega a "http://64.227.54.255/Softesting/Frontend/Caso1.html"
        When Al cliclear en boton enviar se muestra alerta de error
        

        
    
    
        
        
    