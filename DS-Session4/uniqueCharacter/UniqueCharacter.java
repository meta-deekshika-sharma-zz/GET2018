package uniqueCharacter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Deekshika Sharma 
 * This class will find the unique characters in a string
 */
public class UniqueCharacter {

	private Map<String, Integer> stringMap; // a map is created to store string
											// with its
											// no. of unique characters
	private String uniqueCharacterString;
	private boolean isFound;
	private int uniquecharacters;

	public UniqueCharacter() {
		stringMap = new HashMap<String, Integer>();
	}

	public int uniqueCharacterSerach(String stringOfLetters) {
		// if string length is '0' or string does not have only letters then
		// throw an error
		String newString = stringOfLetters.replaceAll("\\s+","").trim();
		
		if (newString.length() == 0)
			throw new AssertionError("No string is present");
		else if (!newString.chars().allMatch(Character::isLetter))
			throw new AssertionError("String does not have only letters");

		uniquecharacters = 0;
		uniqueCharacterString = "";
		isFound = false;

		uniquecharacters = searchInCache(newString);
		if (uniquecharacters > 0) {
			isFound = true;
		}

		if (!isFound) {
			// if string is not present in map then its unique characters is
			// calculated
			for (int i = 0; i < newString.length(); i++) {
				String stringInstance = "" + newString.charAt(i);
				if (!uniqueCharacterString.contains(stringInstance)) {
					uniqueCharacterString += stringInstance;
					uniquecharacters++;
				}
			}
			stringMap.put(newString, uniquecharacters); // put this new
																// string into
																// map
		}

		return uniquecharacters;
	}

	private int searchInCache(String stringOfLetters) {

		// the string is searched in the map, if find then directly return the
		// no. of unique characters
		int uniquecharacters = 0;
		for (String string : stringMap.keySet()) {
			if (stringOfLetters.equals(string)) {
				isFound = true;
				uniquecharacters = stringMap.get(string);
				break;
			}
		}
		return uniquecharacters;
	}
}
