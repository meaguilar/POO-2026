# 🏃‍♂️ Gestión de Atletas

## 📌 Descripción del Proyecto

Este ejercicio tiene como objetivo la creación de una clase en Java que represente a un atleta, permitiendo gestionar y mostrar información básica relacionada con su rendimiento físico.

El propósito principal es practicar y reforzar:

- Sintaxis básica de Java
- Creación de clases y objetos
- Definición de atributos y métodos
- Uso de constructores
- Control de flujo (`if`, `switch`, `do-while`)

---

## 🎯 Funcionalidades del Proyecto

El sistema permitirá:

- Ingresar datos del atleta desde consola:
    - Nombre
    - Edad
    - Deporte
    - Horas de entrenamiento semanal
    - Peso (kg)
    - Altura (m)

- Calcular:
    - Promedio de horas de entrenamiento
    - Índice de Masa Corporal (IMC)
    - Clasificación del IMC
    - Clasificación del rendimiento

- Mostrar la información del atleta en consola

- Registrar múltiples atletas haciendo uso de datos quemados

---

## 🧮 Lógica de Negocio

### 📊 Cálculo del IMC

---

### ⚖️ Clasificación del IMC

| Rango IMC        | Clasificación   |
|------------------|---------------|
| IMC < 18.5       | Bajo peso     |
| 18.5 ≤ IMC < 25  | Peso normal   |
| 25 ≤ IMC < 30    | Sobrepeso     |
| IMC ≥ 30         | Obesidad      |

---

### 🏋️ Clasificación del Rendimiento

| Horas promedio semanales | Clasificación        |
|--------------------------|---------------------|
| < 5                      | Poco entrenamiento  |
| 5 – 9                    | Nivel intermedio    |
| 10 – 14                  | Buen nivel          |
| ≥ 15                     | Alto rendimiento    |

---

## 🧱 Diseño del Sistema

### 📌 Clase: `Atleta`

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

---

## 🧩 Diagrama de Clases

Se debe crear utilizando:

**draw.io**

El diagrama debe incluir:

- Clase `Atleta`
- Atributos
- Métodos

---

## 💻 Implementación en Java (Gradle)

### Requisitos:

- Proyecto con Gradle
- Clase `Atleta`
- Clase `Main` para ejecución

---

