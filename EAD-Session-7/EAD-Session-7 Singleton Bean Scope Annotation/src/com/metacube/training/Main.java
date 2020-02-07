package com.metacube.training;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * This main class will apply the singleton bean scope for objects
 * @author Deekshika Sharma
 *
 */
public class Main {

	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(
				AppConfig.class);
		Person person = (Person) context.getBean("person");

		System.out.println(person.getName()); // result: Deekshika

		Person person2 = (Person) context.getBean("person");
		System.out.println(person2.getName()); // result: Deekshika

		person2.setName("Arpita");
		System.out.println(person2.getName()); // result: Arpita
		System.out.println(person.getName()); // result: Arpita
	}

}
