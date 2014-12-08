package io.springacademy.todomvc;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
class TodoItemNotFoundException extends RuntimeException {
	private final Long id;

	TodoItemNotFoundException(Long id) {
		super("TodoItem [id=" + id + "] not found");
		this.id = id;
	}

	public Long getId() {
		return id;
	}
}
