package com.metacube.training;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * A app config class use to create objects as per requirement
 * @author Deekshika Sharma
 *
 */
@Configuration
public class AppConfig {

	@Bean
	@Scope("singleton")
	public Person person() {
		Person person = new Person();
		person.setId(2);
		person.setName("Deekshika");

		return person;
	}
}
