Spring Deep Dive Repository
Welcome to the Spring Deep Dive repository! This project is dedicated to exploring and mastering core Spring technologies, including Spring Core, Spring MVC, Spring Data, and Spring Testing. It serves as both a reference and a practical guide to understanding and implementing these frameworks in modern Java applications.

Table of Contents
Introduction
Technologies Covered
Spring Core
Spring MVC
Spring Data
Spring Testing
Project Structure
Setup & Installation
Running the Application
Testing
Resources
Contributing
Introduction
This repository aims to provide a comprehensive dive into the Spring ecosystem. It is divided into multiple modules, each focusing on a different aspect of Spring, from the core fundamentals to advanced testing practices.

Each section contains examples, tutorials, and best practices, along with code samples to help you gain a thorough understanding of the subject matter.

Technologies Covered
1. Spring Core
Focuses on the foundation of Spring, including:

Inversion of Control (IoC) and Dependency Injection (DI)
Bean lifecycle and scopes
Application context and configuration
2. Spring MVC
A web framework built on top of the Spring Framework, covering:

Request handling with controllers
Model-View-Controller architecture
RESTful web services development
3. Spring Data
Simplifies the data access layer with:

JPA repositories
CRUD operations
Query derivation and custom query creation
4. Spring Testing
Best practices and tools for testing Spring applications, including:

Unit testing with JUnit and Mockito
Integration testing with Spring's test framework
Test-driven development (TDD)
Project Structure
spring/
├── spring-core/ # Contains examples and code for Spring Core concepts
├── spring-mvc/ # Contains Spring MVC and web layer examples
├── spring-data/ # Data access and persistence layer examples
├── spring-testing/ # Unit and integration testing examples
└── README.md # This README file

Setup & Installation
To get started, clone this repository:
git clone https://github.com/mehmedmaljoki/spring.git

Prerequisites
Ensure you have the following installed:

Java 11+
Maven or Gradle(will use Maven)
An IDE like IntelliJ IDEA or Eclipse (with Spring Boot support)
Installing Dependencies
To install dependencies, run: mvn clean install
