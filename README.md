# Taller POO - Sistema de Biblioteca

## Descripción

Este proyecto corresponde a un taller de Programación Orientada a Objetos (POO) desarrollado utilizando Java y Maven.

El dominio seleccionado es un sistema de biblioteca, en el cual se modelan libros, usuarios, préstamos y la biblioteca. El proyecto utiliza GitHub Copilot como herramienta de asistencia para la generación de código, realizando una evaluación crítica de las sugerencias obtenidas y documentando las modificaciones necesarias.

## Tecnologías utilizadas

- Java 17
- Maven
- JUnit 5
- Git
- GitHub Copilot
- Visual Studio Code

## Estructura del proyecto

El proyecto utiliza la estructura estándar de Maven:

```text
Taller-Poo/
├── pom.xml
├── .gitignore
├── README.md
└── src/
    ├── main/
    │   └── java/
    │       └── com/
    │           └── umb/
    │               └── taller/
    │                   └── domain/
    │                       ├── Biblioteca.java
    │                       ├── Bibliotecario.java
    │                       ├── Estudiante.java
    │                       ├── Libro.java
    │                       ├── Prestamo.java
    │                       └── Usuario.java
    │
    └── test/
        └── java/
            └── com/
                └── umb/
                    └── taller/
                        └── domain/
                            ├── LibroTest.java
                            └── UsuarioPolimorfismoTest.java