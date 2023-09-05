# Trabajo Práctico de Persistencia en JPA con Spring Boot

Este proyecto es parte del trabajo práctico de la Unidad 1 del curso y se centra en la persistencia de datos en una aplicación Spring Boot utilizando JPA (Java Persistence API) para mapear clases Java a tablas de base de datos. Además, exploraremos las relaciones entre las clases en el contexto de Hibernate y Spring Boot.

## Objetivo

El objetivo principal de este proyecto es que los estudiantes adquieran un profundo conocimiento sobre cómo utilizar las anotaciones JPA en el contexto de Spring Boot para mapear entidades Java a tablas de una base de datos relacional. También, se espera que los estudiantes comprendan las diferentes formas de establecer relaciones entre las clases en Hibernate en una aplicación Spring Boot.

## Requisitos Técnicos

- **Spring Boot**: Utilizaremos Spring Boot como el marco de desarrollo para nuestra aplicación.
- **Gradle**: Utilizaremos Gradle como nuestro sistema de gestión de dependencias.
- **Base de datos H2 embebida**: Configuraremos una base de datos H2 embebida para facilitar el desarrollo y las pruebas locales.
- **Configuración de Conexión**: Configuraremos la conexión a la base de datos en el archivo de configuración de Spring Boot (`application.properties` o `application.yml`).

## Estructura del Proyecto
```
├── src/
│ ├── main/
│ │ ├── java/
│ │ │ ├── com/
│ │ │ │ ├── example/
│ │ │ │ │ ├── tpbd/
│ │ │ │ │ │ ├── Entidades/
│ │ │ │ │ │ ├── Repositorios/
│ │ │ │ │ │ └── TpbdApp.java
│ │ ├── resources/
│ │ └── application.properties
├── build.gradle
├── README.md
```

## Instrucciones

1. Clona este repositorio.

```
git clone https://github.com/tuusuario/tuproyecto.git
```

1. Abre el proyecto en tu IDE favorito.

2. Configura la conexión a la base de datos en el archivo de configuración de Spring Boot (application.properties o application.yml) según tus necesidades.

3. Desarrolla las clases de entidad de Spring Boot correspondientes al modelo proporcionado, aplicando las anotaciones JPA necesarias para mapearlas a las tablas de la base de datos.

4. Implementa la lógica de negocio y los servicios relacionados con las clases de entidad.

5. Ejecuta la aplicación y prueba las operaciones CRUD y las relaciones entre entidades.
