package com.metacube.training;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * A app config class use to create objects as per requirement
 * @author Deekshika Sharma
 *
 */
@Configuration
public class AppConfig {

	@Bean
	public TextEditor textEditor(SpellChecker spellChecker) {
		return new TextEditor(spellChecker);
	}

	@Bean
	public SpellChecker spellChecker() {
		SpellChecker spellChecker = new SpellChecker();
		spellChecker.setStatus("Off");
		return spellChecker;
	}
}
