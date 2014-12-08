package io.springacademy.todomvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@SpringBootApplication
@ControllerAdvice
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

	@ExceptionHandler(TodoItemNotFoundException.class)
	ResponseEntity<Void> handleTodoItemNotFound() {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
