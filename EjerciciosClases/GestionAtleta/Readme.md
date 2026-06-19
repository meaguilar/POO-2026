# 🏃‍♂️ Gestión de Atletas

## 📖 Descripción del Proyecto
Proyecto desarrollado en Java utilizando Gradle (DSL Groovy).  
La estructura del proyecto está diseñada para permitir la escalabilidad a medida que se avanzan los temas relacionados con Programación Orientada a Objetos (POO).

---

## 📌 Parte I 
Implementación del diagrama de clases en código, aplicando conceptos de POO:
- Encapsulamiento  
- Abstracción  

Se inicia con la clase `Atleta`.

---

## 📌 Parte II
Se expande el diagrama de clases incorporando:
- `Nadador` (clase concreta)  
- `Atleta` (clase abstracta)  
- `Imprimible` (interfaz)  

Se aplican los conceptos de:
- Herencia  
- Polimorfismo  

---

## 📌 Parte III
Se amplía el diagrama de clases aplicando diferentes tipos de relaciones:

- Se agrega el enum `Deporte`, asociado a `Atleta`.  
- Se incorpora la clase `Entrenador`, que implementa `Imprimible` y se asocia con `Atleta`.  
- Se agrega la interfaz `Pagable`, implementada por `Entrenador`.  
- Se crea la clase `Equipo`, con una relación de **agregación** con `Atleta`.  
- Se añade la clase `PlanEntrenamiento`, con:
  - Relación de **composición** con `Atleta`  
  - Relación de **dependencia** con `Entrenador`  

---

## 📌 Parte IV
Se implementa el uso de **colecciones** en el proyecto:
- Se modifican atributos de las clases existentes para utilizar estructuras como:
  - Listas (`List`)  
  - Mapas (`Map`)  

---

## 📌 Parte V
### 🧠 Patrón de diseño Strategy

Se implementa el patrón **Strategy** en el sistema de reportes.

Se crean estrategias de visualización:

- `ReporteSimple`
- `ReporteCompleto`

Esto permite:
- Cambiar dinámicamente el tipo de reporte
- Separar algoritmos de visualización

---

## 📌 Parte VI
### 🔄 Diagramas de secuencia, actividad y concurrencia

Se implementan diagramas de:

- Secuencia  
- Actividad  

con el objetivo de identificar y modelar procesos concurrentes y paralelos dentro del sistema.

---

### 🧵 Implementación de concurrencia (Hilos)

Se modifica el diagrama de clases incorporando las siguientes clases:

- `EntrenamientoTarea`  
- `EvaluacionTarea`  

Estas clases están diseñadas para la ejecución de procesos en paralelo mediante programación concurrente en Java.

---

### ⚙️ Implementación de hilos

Las clases `EntrenamientoTarea` y `EvaluacionTarea` implementan la interfaz:

```java
Runnable
```

## 📌 Parte VII
### 🎨 Diseño de interfaz gráfica (UX/UI + JavaFX)

Antes de la implementación de la interfaz en JavaFX, se realizó la fase de diseño y planificación utilizando la herramienta **Figma**, permitiendo definir la estructura visual del sistema mediante wireframes y mockups.

---

### 🧩 Diseño en Figma (UX/UI)

Se elaboró el diseño previo de las pantallas aplicando principios de diseño de interfaz de usuario:

- Creación de **wireframes** para la estructura general de las vistas  
- Desarrollo de **mockups** con mayor nivel de detalle visual  

---

### 📐 Sistema de diseño (8pt Grid)

Se aplicó una **plantilla basada en el sistema de 8pt grid**, lo que permitió:

- Alineación consistente de los elementos  
- Mejor proporción visual entre componentes  
- Proximidad adecuada entre secciones  
- Diseño más ordenado y escalable  

---

### 💻 Implementación en JavaFX

Posteriormente, el diseño fue implementado en JavaFX utilizando:

- JavaFX  
- Biblioteca de diseño **MaterialFX**

Se desarrolló:

- Archivos `.fxml` para las vistas  
- Archivos `.css` personalizados  
- Diseño basado en Material Design  

---

## 📌 Parte VIII
### 🗄️ Implementación de persistencia de datos (JDBC + Arquitectura DAO)

Se implementa la persistencia de datos del sistema mediante el uso de **JDBC (Java Database Connectivity)**, permitiendo la comunicación directa con la base de datos según el motor seleccionado (en este caso SQL Server).

---

### ⚙️ Conexión a base de datos

La conexión se realiza a través del **driver JDBC correspondiente al motor de base de datos**, asegurando compatibilidad y comunicación eficiente entre la aplicación Java y el sistema gestor de base de datos.

---

### 🧱 Patrón de diseño DAO (Data Access Object)

Se actualiza el diagrama de clases incorporando el patrón **DAO**, con el objetivo de:

- Separar la lógica de negocio del acceso a datos  
- Centralizar las operaciones CRUD (Create, Read, Update, Delete)  
- Mejorar la mantenibilidad del sistema  
- Facilitar la escalabilidad del proyecto  

Cada entidad del sistema puede contar con su respectiva clase DAO para manejar la persistencia.

---

### 🔒 Patrón de diseño Singleton

Se implementa el patrón **Singleton** en la clase de conexión a la base de datos, garantizando que:

- Solo exista **una única instancia de conexión activa**  
- Se optimicen los recursos del sistema  
- Se eviten múltiples conexiones innecesarias  
- Se centralice el acceso a la base de datos  

---

## 📌 Parte IX (JavaDoc)
### 📚 Documentación y empaquetado del sistema

Se implementan herramientas avanzadas de Java:

### 🧾 JavaDoc
Se genera documentación automática del proyecto utilizando JavaDoc desde Gradle:

- Documentación de clases y métodos  
- Generación de archivos HTML  
- Mejora en la mantenibilidad del código  

---
