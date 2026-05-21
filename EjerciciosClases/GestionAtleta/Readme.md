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

## 📌 Parte V
Se aplica el patrón de diseño **Strategy**, ampliando el diagrama de clases de la siguiente manera:

- Se agrega la clase `GestorReporte`, la cual tiene una relación de **dependencia** con `Entrenador`.
- Se incorpora la clase `Reporte`, que se asocia con `GestorReporte`.
- Se define la interfaz `EstrategiaVisualizacion`, encargada de delegar el comportamiento del patrón Strategy.
- Se implementan dos estrategias concretas:
  - `VisualizacionCompleta`
  - `VisualizacionSimple`
Este diseño permite cambiar dinámicamente la forma en que se visualizan los reportes, promoviendo flexibilidad y reutilización del código.
 
## 📌 Parte VI
Se implementan tareas con la interfaz Runnable para ser ejecutadas por hilos. En el diagrama de clases se agregan:

- La clase EvaluacionEntrenamiento, relacionada con Entrenador, Atleta, Reporte y GestorReporte.
- La clase EntrenamientoAtleta, relacionada con Atleta.
Esto permite simular el entrenamiento y evaluación simultánea de varios atletas por diferentes entrenadores. Además, se aplica sincronización para asegurar la integridad de los reportes compartidos.

## 📌 Parte VII
Se implementa la interfaz gráfica utilizando JavaFX, incorporando ventanas, controles y componentes visuales que permiten la interacción del usuario con el sistema de manera intuitiva y dinámica.

## 📌 Parte VIII
Se implementa la persistencia en base de datos utilizando JDBC y el patrón DAO, por lo que el diagrama de clases se modifica nuevamente incorporando:

- Clases e interfaces encargadas de separar la lógica de acceso a datos de la lógica de negocio, asociadas a las clases correspondientes.
El uso de JDBC y el patrón DAO brinda mayor flexibilidad y mantenibilidad, ya que permite cambiar el tipo de persistencia o el motor de base de datos sin afectar la lógica de negocio existente.



