@Formulario
Feature: Automatizacion sobre formulario Web
    
    
    @Formulario1
    Scenario Outline: El usuario ingresa al formulario, escribe sus datos validos, da clic boton Enviar el formulario se envia exitosamente
        Given El usuario navega a "http://64.227.54.255/Softesting/Frontend/Caso1.html"
        When Ingresa su nombre "<Nombre>"
        And Ingresa su email "<Email>"
        And Ingresa su barrio "<Barrio>"
        And Ingresa un asunto "<Asunto>"
        And Ingresa un mensaje "<Mensaje>"
        When El usuario da clic en boton enviar
        Then El formulario se envia exitosamente
        

        Examples:
            | Nombre          | Email               | Barrio    | Asunto        | Mensaje       | 
            | Diana Medina    |dimedina44@gmail.com | La trini  |prueba1        | Prueba1       |

    @Formulario2
    Scenario Outline: Validacion de ingreso email invalido
        Given El usuario navega a "http://64.227.54.255/Softesting/Frontend/Caso1.html"
        When Ingresa su email invalido "<Email>"
        Then Deberia aparecer mensaje de error en el campo mail
        

        Examples:
            | Email               | 
            |dimedina44.gmail.com | 
            |dimedina44gmail.com  | 
            |d$r@gmail.com        |
    
    @Formulario3
    Scenario: El usuario intenta enviar el formulario sin ingresar informacion, se valida mensaje de error
        Given El usuario navega a "http://64.227.54.255/Softesting/Frontend/Caso1.html"
        When El usuario hace clic en el botón enviar sin completar el formulario
        Then Deberia aparecer una alerta de error al enviar el formulario vacio

    @Formulario4   
    Scenario Outline: El usuario ingresa nombre inválido con menos de 4 letras o nombre con caracter especial
        Given El usuario navega a "http://64.227.54.255/Softesting/Frontend/Caso1.html"
        When  Ingresa su nombre "<Nombre>"
        Then  Se muestra un mensaje de error indicando que el nombre es inválido

        Examples:
            | Nombre |
            | DI     | 
            | Di$na    |  

    @Formulario5    
    Scenario Outline: El usuario ingresa datos invalidos menores a 4 letras en el campo barrio y asunto
        Given El usuario navega a "http://64.227.54.255/Softesting/Frontend/Caso1.html"
        And Ingresa su barrio "<Barrio>"
        And Ingresa un asunto "<Asunto>"
        Then Se debe mostrar un mensaje de error en los campos barrio y asunto

        Examples:
            | Barrio            | Asunto |
            |  Lat              |  Ok!   |      
            |  Cl#              |  Ok   |      
    
    @Formulario6   
    Scenario: Verificar ortografia de titulos Barrio y Mensaje
        Given El usuario navega a "http://64.227.54.255/Softesting/Frontend/Caso1.html"
        And Visualiza el titulo Barrio
        And Visualiza el titulo Mensaje
        Then Los titulos de Barrio y Mensaje estan bien escritos

    

        
    