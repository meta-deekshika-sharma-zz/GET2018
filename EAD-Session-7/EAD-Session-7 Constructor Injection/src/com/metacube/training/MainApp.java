package com.metacube.training;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Main class for using constructor injection
 * @author Deekshika Sharma
 *
 */
public class MainApp {

	public static void main(String[] arg) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"beans.xml");
		TextEditor textEditor = (TextEditor) context.getBean("textEditor");
		textEditor.checkSpelling();
	}
}
