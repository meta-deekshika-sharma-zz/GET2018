package com.metacube.training;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * This main class will get the object from bean factory and executes different type of collections
 * @author Deekshika Sharma
 *
 */
public class MainApp {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"beans.xml");
		CollectionInjection colleactionInjection = (CollectionInjection) context
				.getBean("collectionInjection");

		colleactionInjection.getUserList();
		colleactionInjection.getUserSet();
		colleactionInjection.getUserMap();

	}

}
