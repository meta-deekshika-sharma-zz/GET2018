package com.metacube.training;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * A text editor class will have spell checker object
 * @author Deekshika Sharma
 *
 */
public class TextEditor {
    
	@Autowired
	private SpellChecker spellChecker;

	public SpellChecker getSpellChecker() {
		return spellChecker;
	}

	public void setSpellchecker(SpellChecker spellChecker) {
		this.spellChecker = spellChecker;
	}

	public void checkSpelling() {
		System.out.println(spellChecker.getStatus() + " Spell Checker");
	}
}