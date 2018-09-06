package com.metacube.training;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Main class for using autowiring by constructor
 * @author Deekshika Sharma
 *
 */
public class MainApp {

	public static void main(String[] arg) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		CollectionInjection collectionInjectionList = (CollectionInjection) context.getBean("getAllUserList");
		collectionInjectionList.getUserList();
		
		CollectionInjection collectionInjectionSet = (CollectionInjection) context.getBean("getAllUserSet");
		collectionInjectionSet.getUserSet();
		
		CollectionInjection collectionInjectionMap = (CollectionInjection) context.getBean("getAllUserMap");
		collectionInjectionMap.getUserMap();
	}
}
