# Todomvc in Spring Boot and AngularJS

Demo project demonstrating how to build simple REST API with Spring Boot. 

Frontend part is taken from https://github.com/tastejs/todomvc/tree/gh-pages/examples/angularjs

- based on Spring Boot 1.2.RC2
- AngularJS
- todo items are stored in in-memory repository based on simple `HashMap`, can be easily extended to save items to database

## Build

`mvn package`

## Run

`java -jar target/java -jar target/todomvc-0.0.1-SNAPSHOT.jar`

or run it through Spring Boot Maven plugin: `mvn spring-boot:run`
