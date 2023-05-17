package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="todo")
public class Todo {

	@Id
	@Column(name ="id")
	private int todoId;
	
	@Column(name="todo_name")
	private String todoName;
	
	@Column(name="is_completed")
	private boolean isCompleted;

	public Todo(int todoId, String todoName, boolean isCompleted) {
		super();
		this.todoId = todoId;
		this.todoName = todoName;
		this.isCompleted = isCompleted;
	}

	public Todo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getTodoId() {
		return todoId;
	}

	public void setTodoId(int todoId) {
		this.todoId = todoId;
	}

	public String getTodoName() {
		return todoName;
	}

	public void setTodoName(String todoName) {
		this.todoName = todoName;
	}

	public boolean isCompleted() {
		return isCompleted;
	}

	public void setCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}

	@Override
	public String toString() {
		return "Todo [todoId=" + todoId + ", todoName=" + todoName + ", isCompleted=" + isCompleted + "]";
	}
	
	
}
