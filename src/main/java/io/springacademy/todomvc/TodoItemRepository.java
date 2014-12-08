package io.springacademy.todomvc;

import java.util.Collection;
import java.util.function.Predicate;

interface TodoItemRepository {
	Collection<TodoItem> findAll();

	TodoItem insert(TodoItem todoItem);

	void delete(Long todoId);

	void update(TodoItem todoItem);

	TodoItem findOne(Long todoId);

	void remove(Predicate<TodoItem> predicate);
}
