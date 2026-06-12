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

