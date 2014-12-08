package io.springacademy.todomvc;

class TodoItem {
	private Long id;
	private String title;
	private boolean completed;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	public void merge(TodoItem item) {
		setTitle(item.getTitle());
		setCompleted(item.isCompleted());
	}
}
