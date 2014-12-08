package io.springacademy.todomvc;

import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Predicate;

@Repository
class InMemoryTodoItemRepository implements TodoItemRepository {
	private AtomicLong counter = new AtomicLong(0);
	private Map<Long, TodoItem> map = new ConcurrentHashMap<>();

	@Override
	public Collection<TodoItem> findAll() {
		return map.values();
	}

	@Override
	public TodoItem insert(TodoItem todoItem) {
		Long id = counter.incrementAndGet();
		todoItem.setId(id);
		map.put(id, todoItem);

		return todoItem;
	}

	@Override
	public void delete(Long todoId) {
		checkIfExists(todoId);
		map.remove(todoId);
	}

	@Override
	public void update(TodoItem todoItem) {
		checkIfExists(todoItem.getId());
		map.put(todoItem.getId(), todoItem);
	}

	@Override
	public TodoItem findOne(Long todoId) {
		checkIfExists(todoId);
		return map.get(todoId);
	}

	@Override
	public void remove(Predicate<TodoItem> predicate) {
		map.forEach((k,v) -> {
			if (predicate.test(v)) {
				map.remove(k);
			}
		});
	}

	private void checkIfExists(Long todoItemId) {
		if (!map.containsKey(todoItemId)) {
			throw new TodoItemNotFoundException(todoItemId);
		}
	}
}