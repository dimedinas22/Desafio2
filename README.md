## Desafío 1: Replica Escenario De Prueba Con Selenium Y Cucumber

### 🧪 Descripción del Proyecto
Este proyecto automatiza la validación de un formulario web ubicado en http:/Softesting/Frontend/Caso1.html, utilizando Selenium WebDriver, Cucumber y Gradle. El objetivo es verificar el comportamiento del formulario, asegurando que los campos obligatorios, los formatos y las respuestas del sistema funcionen correctamente. Las pruebas están escritas en lenguaje Gherkin bajo el enfoque BDD y ejecutadas con Cucumber.

A continuación, se describen los escenarios de prueba automatizados:

### @Formulario1
**Escenario:** El usuario ingresa datos válidos y envía el formulario exitosamente.  
**Precondiciones:**
- El usuario accede al formulario desde un navegador compatible.
- El formulario está completamente cargado.

**Datos de ejemplo:**  
- Nombre: Diana Medina  
- Email: dimedina44@gmail.com  
- Barrio: La trini  
- Asunto: prueba1  
- Mensaje: Prueba1  

**Resultado esperado:** Se muestra una alerta o mensaje de éxito indicando que el formulario fue enviado correctamente.

---

### @Formulario2
**Escenario:** Validación de ingreso de emails inválidos.  
**Precondiciones:**
- El campo de email se encuentra visible y habilitado.
- El usuario accede correctamente al formulario.

**Emails inválidos probados:**  
- dimedina44.gmail.com  
- dimedina44gmail.com  
- d$r@gmail.com  

**Resultado esperado:** El campo muestra un mensaje de error por formato inválido de email.

---

### @Formulario3
**Escenario:** El usuario intenta enviar el formulario sin completar ningún campo.  
**Precondiciones:**
- Todos los campos del formulario están vacíos.
- El botón "Enviar" está habilitado.

**Resultado esperado:** Se genera una alerta o mensaje de error indicando que no se puede enviar el formulario.

---

### @Formulario4
**Escenario:** 
Se valida nombre invalido contiene menos de 4 letras o caracteres especiales.  
**Precondiciones:**
- El campo "Nombre" está visible y permite la escritura.

**Valores inválidos:**  
- DI  
- Di$na  

**Resultado esperado:** Se muestra un mensaje de error indicando que el nombre ingresado no es válido.

---

### @Formulario5
**Escenario:** Los campos "Barrio" y "Asunto" contienen datos inválidos.  
**Precondiciones:**
- El usuario ha dejado los demás campos vacíos o con datos válidos.
- Los campos "Barrio" y "Asunto" aceptan entrada de texto.

**Datos de ejemplo inválidos:**  
- Barrio: Lat, Asunto: Ok!  
- Barrio: Cl#, Asunto: Ok  

**Resultado esperado:** Se muestran mensajes de error específicos para cada campo inválido.

---

### @Formulario6
**Escenario:** Verificación ortográfica de los títulos "Barrio" y "Mensaje".  
**Precondiciones:**
- El formulario está completamente cargado.
- Los títulos o labels son visibles en pantalla.

**Resultado esperado:** Los títulos están escritos correctamente como "Barrio" y "Mensaje", sin errores ortográficos.



## 🧰 Herramientas y Versiones Usadas

### ☕ Java Development Kit (JDK) : Version 21 

Este proyecto está desarrollado utilizando Java Development Kit (JDK) versión 21, por lo que es necesario tener esta versión instalada para compilar y ejecutar el código correctamente.

### 🔧 ¿Qué es el JDK?
El JDK (Java Development Kit) es un conjunto de herramientas proporcionado por Oracle (u otros distribuidores) que permite desarrollar, compilar y ejecutar aplicaciones Java. Incluye el JRE (Java Runtime Environment), el compilador javac, y herramientas como javadoc, jar, etc.

 🛠️ Instalación del JDK 21

Opción 1: Descargar desde el sitio oficial de Oracle
Visita: https://www.oracle.com/java/technologies/javase/jdk21-archive-downloads.html
Descarga el instalador correspondiente a tu sistema operativo (Windows, macOS, Linux).
Sigue los pasos de instalación.

✅ Verificar instalación
Después de instalar, abre una terminal y ejecuta: java -version

## 📦 Manejador de Dependencias

Este proyecto utiliza Gradle Version 8.12 para la gestión de dependencias y la automatización de tareas.


🔧 Instalación de Gradle
Ve al sitio oficial de descargas de Gradle: https://gradle.org/releases/
Descarga la versión binaria más reciente (o compatible con tu proyecto).
Descomprime el archivo ZIP en una ubicación de tu preferencia.
Agrega la ruta del directorio bin de Gradle a la variable de entorno PATH.

✅ Verificar instalación
Después de la instalación, abre una terminal o CMD y ejecuta: gradle --version

### Extensiones de VS code
Para este proyecto se utilizaron alguna extensiones de VS Code que ayudan a la escritura, organización y ejecución de pruebas automatizadas, especialmente para trabajar con Java, Gradle y Cucumber. Las extensiones que vamos a descargar son:

Extension Pack for Java  
Gradle for Java  
Gradle Language Support  
Cucumber  
Snippets and Syntax Highlight for Gherkin (Cucumber)  

###  Dependencias

Para este proyecto desarrollado en Java con Gradle, se agregaron varias dependencias en el archivo build.gradle, las cuales fueron obtenidas desde el repositorio https://mvnrepository.com/repos/central
 
Selenium Java: Version 4.32.0   
Cucumber JVM (Java): Version 7.22.0
Cucumber JVM (JUnit 4): Version	7.22.0          
TestNG: Version	7.10.2  
WebDriverManager (Bonigarcia): Version 6.0.1

### 🌐 Navegador Utilizado para las Pruebas Automatizadas
Este proyecto utiliza Google Chrome como navegador principal para la ejecución de pruebas automatizadas con Selenium WebDriver.

✅ Requisitos para usar Google Chrome
Tener Google Chrome instalado en el sistema (se recomienda la última versión estable).
Asegurarse de que la versión del navegador sea compatible con el ChromeDriver utilizado por WebDriverManager.


### ⚙️ Instalación

1.Clona el repositorio:
git clone https://github.com/dimedinas22/CarritoComprasAmazon.git
cd CarritoComprasAmazon  
2.Asegúrate de tener el WebDriver correspondiente a tu navegador en el sistema y que su ruta esté configurada en las variables de entorno.



### 🚀 Ejecución de Pruebas

Para ejecutar las pruebas automatizadas, utiliza el siguiente comando en la terminal: gradle test

### 📊 Visualización de reportes

Los resultados se suben automáticamente a Cucumber Reports, permitiendo revisar los escenarios desde cualquier dispositivo con acceso web.
Para generar y publicar reportes en Cucumber, se utiliza una variable de entorno llamada CUCUMBER_PUBLISH_TOKEN. Este token es proporcionado por la plataforma de Cucumber Reports, y permite que los resultados de tus pruebas se suban y se visualicen en línea.

#### Pasos para generar el reporte:

1. Primero, debes registrarte o iniciar sesión en https://reports.cucumber.io/ para obtener tu token personal.
2. Una vez que tengas el token, debes configurarlo como una variable de entorno en tu sistema. Esto se puede hacer ejecutando el siguiente comando en la terminal : export CUCUMBER_PUBLISH_TOKEN=some-secret-token (reemplazar el some-secret-token por el token que les dio Cucumber)


### 📁 Estructura del Proyecto
```text
Desafio2Formulario/
│
├── build/                       # Carpeta generada automáticamente por Gradle al compilar
├── gradle/                      # Configuraciones internas de Gradle
├── target/                      # Puede contener salidas de compilación (similar a build/)
├── .gitignore                   # Archivos/carpetas que Git debe ignorar
├── build.gradle                 # Script principal de construcción (build) del proyecto
├── gradlew                     # Wrapper para ejecutar Gradle sin necesidad de instalarlo
├── gradlew.bat                  # Wrapper para entornos Windows
├── cucumber.properties          # Propiedades de configuración para Cucumber
│
├── src/
│   └── test/                    # 📌 Zona de pruebas (test) — Detalle a continuación
│       ├── java/
│       │   ├── pages/           # 🧩 Página de objetos - patrón Page Object Model (POM)
│       │   │   ├── Elemento.java         # Clase auxiliar para manejo de elementos web
│       │   │   ├── Formulario.java       # Interacciones con el formulario (llenado, validación, envío)
│       │   │   └── PaginaBase.java       # Clase base compartida (ej. WebDriver, métodos comunes)
│       │   │
│       │   ├── runner/          # 🚀 Ejecutores de prueba (Cucumber + JUnit/TestNG)
│       │   │   └── RunnerJava.java       # Clase que configura los features y step definitions
│       │   │
│       │   ├── steps/           # 🧪 Definiciones de pasos de Cucumber (Step Definitions)
│       │       ├── Hooks.java             # Métodos @Before y @After (config inicial y limpieza)
│       │       └── pasosFormulario.java   # Implementación Java de los pasos del archivo `.feature`
│       │
│       └── resources/          # 📄 Archivos de recursos de prueba
│           ├── Casosformulario.feature    # Escenarios escritos en Gherkin (Given, When, Then)
│           └── cucumber.properties         # Configuración personalizada para Cucumber (idioma, tags, etc.)
│
└── index.html                  # Archivo HTML que representa el formulario web a probar
