package com.metacube.training;

/**
 * A text editor class will have spell checker object
 * @author Deekshika Sharma
 *
 */
public class TextEditor {

	private SpellChecker spellChecker;
	
	public TextEditor(SpellChecker spellChecker) {
		this.spellChecker = spellChecker;
	}

	public SpellChecker getSpellChecker() {
		return spellChecker;
	}

	public void checkSpelling() {
		System.out.println(spellChecker.getStatus() + " Spell Checker");
	}
}