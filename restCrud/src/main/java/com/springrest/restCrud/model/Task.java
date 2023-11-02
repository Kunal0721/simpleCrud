package com.springrest.restCrud.model;

public class Task {
	
	private long id;
	private String title;
	private boolean completed;
	public Task(long id, String title, boolean completed) {
		super();
		this.id = id;
		this.title = title;
		this.completed = completed;
	}
	public Task() {
		super();
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
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
	@Override
	public String toString() {
		return "Task [id=" + id + ", title=" + title + ", completed=" + completed + "]";
	}
	
	
}
