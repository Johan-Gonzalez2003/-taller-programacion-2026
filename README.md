# Taller de Programación 2026

## Object-Oriented Programming, SOLID Principles and Clean Code

This repository contains the practical work developed for the 2026 Programming Workshop at Universidad Manuela Beltrán. The project focuses on applying Object-Oriented Programming (OOP), SOLID principles, exception handling, interfaces, functional programming concepts, unit testing, and clean code practices using Java and Maven.

The project follows the standard Maven directory structure. The domain layer contains the main business entities and domain rules, while the application layer contains services and operations that coordinate the behavior of the system. The project also includes a test structure for validating the expected behavior of the application.

During the workshop, several Object-Oriented Programming concepts are demonstrated, including encapsulation, abstraction, inheritance, and polymorphism. Classes such as `Libro` and `Usuario` represent domain entities and provide examples of how these concepts can be applied in a practical software project.

The project also applies SOLID principles to improve maintainability and separation of responsibilities. A God Class example is analyzed and refactored according to the Single Responsibility Principle (SRP). Repository abstractions are introduced to demonstrate the Dependency Inversion Principle (DIP), allowing application services to depend on abstractions instead of concrete implementations.

A custom domain exception hierarchy is implemented using `AppException`, `DomainException`, `EntityNotFoundException`, `ValidationException`, and `BusinessRuleException`. This structure provides a clear way to represent different types of application and domain errors.

The project also includes a functional interface for domain validation, lambda expressions, method references, and unit tests using JUnit 5 and AssertJ. These tests help verify the behavior of domain validations, exception hierarchies, and object-oriented functionality.

Git and GitHub are used for version control and collaboration. GitHub Copilot is also used as a programming assistant during development. Its suggestions are reviewed critically rather than being accepted automatically, allowing the developer to evaluate code quality, maintainability, and compliance with the project's design principles.

## Technologies

* Java 17
* Maven
* JUnit 5
* AssertJ
* SLF4J
* Git
* GitHub
* GitHub Copilot
* Visual Studio Code

## Project Structure

```text
src/
├── main/
│   └── java/
│       └── com/
│           └── umb/
│               └── taller/
│                   ├── application/
│                   ├── domain/
│                   │   └── exception/
│                   └── infrastructure/
└── test/
    └── java/
        └── com/
            └── umb/
                └── taller/
```

## Testing

The project uses Maven to compile the source code and execute the automated tests.

```bash
mvn clean test
```

All tests must pass before changes are committed and pushed to the repository.

## Version Control

The project follows Conventional Commits to maintain clear and meaningful commit history.

Example:

```text
feat: implement validation repositories and exceptions
```

