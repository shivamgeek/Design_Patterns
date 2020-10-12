package com.shivam.patterns;

import java.util.ArrayList;
import java.util.List;

/*
 * Composite Pattern
 * 
 * Composite pattern composes objects into tree structures to represent hierarchy. Tree not necessarily binary, but n-ary trees.
 * It lets clients treat individual objects and composition of objects uniformly.   
 */
public class CompositePattern {

	public static void main(String[] args) {
		TodoList t1 = new Todo("First");
		TodoList t2 = new Todo("Second");
		TodoList t3 = new Todo("Third");
		
		List<TodoList> al = new ArrayList<>();
		al.add(t1); al.add(t2); al.add(t3);
		
		TodoList project = new Project("MyList", al);
		String data = project.getData();
		System.out.println(data);
	}

}


interface TodoList {
	public String getData();
}

class Todo implements TodoList {
	String text;
	
	public Todo(String text) {
		this.text = text; 
	}
	
	public String getData() {
		return text;
	}
	
}

class Project implements TodoList {
	String title;
	List<TodoList> todos;
	
	public Project(String title, List<TodoList> todos) {
		this.todos = todos;
		this.title = title;
	}
	
	public String getData() {
		String data =  title;
		for(TodoList todo : todos) {
			data = data + todo.getData();
		}
		return data;
	}
}