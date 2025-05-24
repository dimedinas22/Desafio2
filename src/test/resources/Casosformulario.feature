Feature: Automatizacion sobre formulario Web
    

    Scenario Outline: Validacion de ingreso email valido
        Given El usuario navega a "http://64.227.54.255/Softesting/Frontend/Caso1.html"
        When Ingresa su email "<Email>"
        Then No deberia aparecer mensaje de error en el campo mail
        

        Examples:
            | Email               | 
            |dimedina44@gmail.com | 
            |dimedina44gmail.com  | 
            |d$r@gmail.com        |
    
    Scenario: El usuario intenta enviar el formulario sin ingresar informacion, se valida mensaje de error
        Given El usuario navega a "http://64.227.54.255/Softesting/Frontend/Caso1.html"
        When El usuario hace clic en el botón enviar sin completar el formulario
        Then Deberia aparecer una alerta de error al enviar el formulario vacio
        
    Scenario Outline: El usuario ingresa nombre inválido con menos de 4 letras o nombre con caracter especial
        Given El usuario navega a "http://64.227.54.255/Softesting/Frontend/Caso1.html"
        When Ingresa nombre invalido "<Nombre>"
        Then Se muestra un mensaje de error indicando que el nombre es inválido

        Examples:
            | Nombre |
            | DI     | 
            | Di$na    |  
        
    #Scenario Outline: El usuario ingresa datos validos y vacios a los campos barrio y asunto validadando mensajes de error
    #    Given El usuario navega a "http://64.227.54.255/Softesting/Frontend/Caso1.html"
    #    And Ingresa su barrio "<Barrio>"
    #    And Ingresa un asunto "<Asunto>"
    #    Then Se muestra un mensaje de error indicando que el nombre es inválido

    #    Examples:
    #        | Barrio           | Asunto |
    #        |  Cruz de Bonza   |        |
    #        |                  |        |
    
        
        
    