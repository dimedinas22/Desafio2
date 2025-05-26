## Desafío 2: Automatización de Pruebas - Formulario Web

### 🧪 Descripción del Proyecto
Este proyecto automatiza la validación de un formulario web ubicado en http:/Softesting/Frontend/Caso1.html, utilizando Selenium WebDriver, Cucumber y Gradle. El objetivo es verificar el comportamiento del formulario, asegurando que los campos obligatorios, los formatos y las respuestas del sistema funcionen correctamente. Las pruebas están escritas en lenguaje Gherkin bajo el enfoque BDD y ejecutadas con Cucumber.

A continuación, se describen los escenarios de prueba automatizados:

### ✅ Caso 1: Envío exitoso del formulario con datos válidos
- **Nombre del caso:** Envío exitoso del formulario  
- **Objetivo:** Validar que el formulario se envíe correctamente cuando todos los campos se completan con datos válidos.  
- **Datos de prueba:**
  - Nombre: Diana Medina  
  - Email: dimedina44@gmail.com  
  - Barrio: La trini  
  - Asunto: prueba1  
  - Mensaje: Prueba1  
- **Pasos:**
  1. Navegar a la URL del formulario.
  2. Ingresar los datos válidos en todos los campos.
  3. Hacer clic en el botón "Enviar".
- **Resultado esperado:** El formulario se envía correctamente y se muestra un mensaje de confirmación.

---

### ❌ Caso 2: Validación de email con formato inválido
- **Nombre del caso:** Error al ingresar email inválido  
- **Objetivo:** Verificar que se muestre un mensaje de error cuando se ingresa un email en formato incorrecto.  
- **Datos de prueba:**
  - dimedina44.gmail.com  
  - dimedina44gmail.com  
  - d$r@gmail.com  
- **Pasos:**
  1. Navegar a la URL del formulario.
  2. Ingresar uno de los emails inválidos en el campo correspondiente.
- **Resultado esperado:** Se muestra un mensaje de error en el campo email que impide el envío del formulario.

---

### ⚠️ Caso 3: Envío del formulario sin completar campos
- **Nombre del caso:** Formulario vacío  
- **Objetivo:** Validar que no se permita enviar el formulario si ningún campo ha sido completado.  
- **Datos de prueba:** Todos los campos vacíos.  
- **Pasos:**
  1. Navegar a la URL del formulario.
  2. Hacer clic directamente en el botón "Enviar" sin completar ningún campo.
- **Resultado esperado:** Se muestra una alerta o mensaje de error indicando no se puede enviar el formulario.

---

### 🚫 Caso 4: Validación de nombre inválido (menos de 4 caracteres o caracteres especiales)
- **Nombre del caso:** Nombre inválido  
- **Objetivo:** Verificar que el sistema muestre un mensaje de error cuando se ingresa un nombre muy corto o con caracteres no permitidos.  
- **Datos de prueba:**
  - DI  
  - Di$na  
- **Pasos:**
  1. Navegar al formulario.
  2. Ingresar un nombre inválido en el campo correspondiente.
- **Resultado esperado:** Se muestra un mensaje de error indicando que el nombre no es válido.

---

### 🚫 Caso 5: Validación de campos Barrio y Asunto con menos de 4 caracteres
- **Nombre del caso:** Campos Barrio y Asunto inválidos  
- **Objetivo:** Verificar que el formulario muestre mensajes de error cuando los campos “Barrio” y “Asunto” contienen menos de 4 caracteres válidos.  
- **Datos de prueba:**
  - Barrio: Lat / Asunto: Ok!  
  - Barrio: Cl# / Asunto: Ok  
- **Pasos:**
  1. Navegar al formulario.
  2. Ingresar los valores inválidos en los campos Barrio y Asunto.
- **Resultado esperado:** Se muestra un mensaje de error específico en ambos campos.

---

### 🔍 Caso 6: Verificación de ortografía de los títulos "Barrio" y "Mensaje"
- **Nombre del caso:** Validación de ortografía de títulos  
- **Objetivo:** Confirmar que los títulos de los campos “Barrio” y “Mensaje” estén correctamente escritos, sin errores ortográficos.  
- **Datos de prueba:** No aplica (validación visual).  
- **Pasos:**
  1. Navegar al formulario web.
  2. Verificar que el título del campo “Barrio” esté correctamente escrito.
  3. Verificar que el título del campo “Mensaje” esté correctamente escrito.
- **Resultado esperado:** Los títulos deben aparecer como “Barrio” y “Mensaje”, correctamente escritos y sin errores ortográficos.

### 🤖 Principales características que hacen óptima esta solución

#### Cobertura funcional completa:
Se validan rutas positivas (datos válidos) y negativas (errores comunes), abarcando diferentes combinaciones de entrada y comportamiento esperado.
#### Uso de Gherkin (BDD):
El lenguaje natural mejora la comprensión entre testers, desarrolladores y partes interesadas no técnicas, facilitando el trabajo colaborativo.
#### Escenarios reutilizables y parametrizados:
Gracias a Scenario Outline, es posible reutilizar un mismo flujo con múltiples datos de prueba sin duplicar código.
#### Detección efectiva de errores de validación:
Se prueban restricciones como longitud mínima, caracteres inválidos, campos vacíos, emails mal escritos, etc.
#### Orientación al usuario final:
La lógica de prueba simula el comportamiento real de un usuario interactuando con el formulario.


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

☑️ Verificar instalación
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
