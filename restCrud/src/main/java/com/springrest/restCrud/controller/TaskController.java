package com.springrest.restCrud.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.restCrud.model.Task;

@RestController
public class TaskController {

	private List<Task> tasks = new ArrayList<>();
	private long nextid = 1;

	@GetMapping("/tasks")
	public List<Task> getallTask() {
		return tasks;
	}

	@GetMapping("/tasks/{id}")
	public Task getTaskById(@PathVariable Long id) {
		for (Task task : tasks) {
			if (task.getId() == id)
				return task;
		}

		return null;
	}

	@PostMapping("/tasks")
	public Task createTask(@RequestBody Task task) {
		task.setId(nextid++);
		tasks.add(task);
		return task;
	}

	@PutMapping("/tasks/{id}")
	public Task updateTask(@PathVariable Long id, @RequestBody Task updatedTask) {
		for (Task task : tasks) {
			if (task.getId() == id) {
				task.setTitle(updatedTask.getTitle());
				task.setCompleted(updatedTask.isCompleted());
				return task;
			}
		}
		return null;
	}

	@DeleteMapping("/tasks/{id}")
	public void deleteTask(@PathVariable Long id) {
		tasks.removeIf(task -> task.getId()==id);
	}

}