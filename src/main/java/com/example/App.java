package com.example;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.model.Todo;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Todo.class).buildSessionFactory();
		Session session = factory.openSession();
		session.getTransaction().begin();
		int choice;
		do {
			System.out.println("1. get todolist");
			System.out.println("2. create todo");
			System.out.println("3. get todo by id");
			System.out.println("enter your choice ");
			choice = scanner.nextInt();
			switch (choice) {
			case 1:
				Query query=session.createQuery("FROM Todo");
		        List<Todo> todoList= query.getResultList();
		        for(Todo s:todoList)
		        {
		        	System.out.println(s);
		        }
				break;
			case 2:
				System.out.println("enter todo name");
				String todoName = scanner.next();
				System.out.println("is completed");
				boolean isCompleted = scanner.nextBoolean();
				session.save(new Todo(new Random().nextInt(), todoName, isCompleted));
				System.out.println("todo created...");
				break;
			case 3:
				System.out.print("Enter Todo ID: ");

				int id = scanner.nextInt();

				Todo todo = session.find(Todo.class, id);

				if(todo==null)
				{
					System.out.println("no such id..");
				}else
				{
					System.out.println("Found: " + todo);
				}
				break;
			}
		} while (choice != 0);

	}
//		session.save(new Todo(105, "work on project1", false));
//		System.out.println("todo created...");
//		Query query=session.createQuery("FROM Todo");
//        List<Todo> todoList= query.getResultList();
//        for(Todo s:todoList)
//        {
//        	System.out.println(s);
//        }

	
}
