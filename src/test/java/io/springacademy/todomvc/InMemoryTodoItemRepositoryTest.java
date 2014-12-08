package io.springacademy.todomvc;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class InMemoryTodoItemRepositoryTest {
	private InMemoryTodoItemRepository repository = new InMemoryTodoItemRepository();

	@Test(expected = TodoItemNotFoundException.class)
	public void should_throw_exception_when_not_found() {
		repository.findOne(1l);
	}

	@Test
	public void should_return_item() {
		TodoItem saved = repository.insert(new TodoItem());

		assertNotNull(repository.findOne(saved.getId()));
	}
}