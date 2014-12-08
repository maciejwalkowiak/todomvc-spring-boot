package io.springacademy.todomvc;

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
