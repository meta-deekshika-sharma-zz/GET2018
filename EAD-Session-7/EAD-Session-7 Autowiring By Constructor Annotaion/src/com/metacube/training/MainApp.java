package com.metacube.training;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Main class for using autowiring by constructor annotation
 * @author Deekshika Sharma
 *
 */
public class MainApp {

	public static void main(String[] arg) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		TextEditor textEditor = (TextEditor) context.getBean("textEditor");
		textEditor.checkSpelling();
	}
}
