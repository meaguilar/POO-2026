# 🏃‍♂️ Gestión de Atletas - Parte II

## 📌 Descripción del Proyecto

Este ejercicio tiene como objetivo la creación de clases abstractas e interfaces, aplicando los principios de **herencia** y **polimorfismo**, permitiendo gestionar y mostrar información de atletas de diferentes disciplinas.

El propósito principal es que los estudiantes continúen el proyecto de Gestión de Atletas, incorporando:

- Clases abstractas
- Interfaces
- Relaciones entre clases
- Reutilización de código mediante herencia

---

## 🎯 Objetivos de Aprendizaje

- Aplicar herencia y polimorfismo
- Crear e implementar interfaces
- Definir clases abstractas
- Sobrescribir métodos
- Utilizar `super` y `this`
- Extender funcionalidades del proyecto anterior

---

## 🔄 Modificaciones al Proyecto

### 📊 Actualizar el Diagrama de Clases

- Utilizar **draw.io**
- Incluir:
  - Clase abstracta `Atleta`
  - Interfaz `Imprimible`
  - Clase(s) hija(s) (ejemplo: `AtletaNatacion`)

---

## 🧩 Diseño del Sistema

### 📌 Interfaz: `Imprimible`

Define el comportamiento para mostrar información.

#### Método:

- `imprimir() : void`

---

### 📌 Clase Abstracta: `Atleta`

#### Atributos:

- nombre : String
- edad : int
- deporte : String
- horasEntrenamiento : double
- peso : double
- altura : double

#### Métodos:

- calcularIMC() : double
- clasificarIMC() : String
- clasificarRendimiento() : String
- mostrarInformacion() : void
- **entrenar() : void (abstracto)**

#### Implementa:

- Interfaz `Imprimible`

---

### 📌 Clase Hija (Ejemplo): `AtletaNatacion`

#### Atributos adicionales:

- estilo : String
- mejorTiempo : double

#### Métodos:

- Implementación de `entrenar()`
- Sobrescritura de métodos necesarios
- Uso de `super` para acceder a la clase padre
- Uso de `this` para atributos propios

---

## 💻 Implementación en Java (Gradle)

### Requisitos:

- Proyecto con Gradle
- Codificación del diagrama de clases
- Uso de herencia e interfaces
- Creación de objetos mediante constructores

---

## 🔄 Flujo del Programa

El programa debe:

1. Mostrar un menú con opciones:
  - Registrar atleta
  - Mostrar atletas
  - Salir

2. Permitir ingresar diferentes tipos de atletas

3. Mostrar información en consola

4. Repetir el proceso usando un ciclo:
