package com.metacube.training;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * This main class will apply the singleton bean scope for objects
 * @author Deekshika Sharma
 *
 */
public class Main {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"bean.xml");
		Person person = (Person) context.getBean("person");
		person.setId(3);
		person.setName("Deekshika"); // result: Deekshika

		System.out.println(person.getName());

		Person person2 = (Person) context.getBean("person");
		System.out.println(person2.getName()); // result: Deekshika
		person2.setId(2);
		person2.setName("Arpita");

		System.out.println(person2.getName()); // result: Arpita
		System.out.println(person.getName()); // result: Arpita
	}

}
