package io.springacademy.todomvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/todos")
class TodoController {
	private TodoItemRepository todoRepository;

	@Autowired
	TodoController(TodoItemRepository todoRepository) {
		this.todoRepository = todoRepository;
	}

	@RequestMapping(method = RequestMethod.GET)
	public Collection<TodoItem> todos() {
		return todoRepository.findAll();
	}

	@RequestMapping(method = RequestMethod.DELETE)
	public Collection<TodoItem> deleteCompleted() {
		todoRepository.remove(TodoItem::isCompleted);
		return todoRepository.findAll();
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<TodoItem> insert(@RequestBody TodoItem todoItem) {
		TodoItem savedTodoItem = todoRepository.insert(todoItem);
		return new ResponseEntity<>(savedTodoItem, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{todoId}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Long todoId) {
		todoRepository.delete(todoId);
	}

	@RequestMapping(value = "/{todoId}", method = RequestMethod.PUT)
	public void put(@PathVariable Long todoId, @RequestBody TodoItem item) {
		TodoItem todoItem = todoRepository.findOne(todoId);
		todoItem.merge(item);

		todoRepository.update(todoItem);
	}
}
