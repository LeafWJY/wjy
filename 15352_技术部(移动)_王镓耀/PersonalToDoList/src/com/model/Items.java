package com.model;

public class Items {
	public String getTodo_item_id() {
		return todo_item_id;
	}
	public void setTodo_item_id(String todo_item_id) {
		this.todo_item_id = todo_item_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getTodo_item_title() {
		return todo_item_title;
	}
	public void setTodo_item_title(String todo_item_title) {
		this.todo_item_title = todo_item_title;
	}
	public String getTodo_item_content() {
		return todo_item_content;
	}
	public void setTodo_item_content(String todo_item_content) {
		this.todo_item_content = todo_item_content;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getCreation_date() {
		return creation_date;
	}
	public void setCreation_date(String creation_date) {
		this.creation_date = creation_date;
	}
	public String getLast_update_date() {
		return last_update_date;
	}
	public void setLast_update_date(String last_update_date) {
		this.last_update_date = last_update_date;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	private String todo_item_id;
	private String user_id;
	
	private String todo_item_title;
	
	private String  todo_item_content;
	private String  priority;
	private String  creation_date;
	private String last_update_date;
	private String comments;

}
