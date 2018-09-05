package uniqueCharacter;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Deekshika Sharma
 * This class will have the positive and negative test cases
 */
public class UniqurCharactersTest {

	UniqueCharacter uniqueCharacter = new UniqueCharacter();
	
	/**
	 * This test case is positive test case related to unique character 
	 */
	@Test
	public void uniqueCharacterTest() {
		
		assertEquals(3, uniqueCharacter.uniqueCharacterSerach("abcabcab"));
		assertEquals(3, uniqueCharacter.uniqueCharacterSerach("abcabcab")); // return from map if similar string is to be found
		assertEquals(5, uniqueCharacter.uniqueCharacterSerach("xzdrf"));
		assertEquals(5, uniqueCharacter.uniqueCharacterSerach("ytghf"));
		assertNotEquals(5, uniqueCharacter.uniqueCharacterSerach("fdsfsdfsd"));
		assertEquals(4, uniqueCharacter.uniqueCharacterSerach("hello"));
		assertEquals(4, uniqueCharacter.uniqueCharacterSerach("hello   hello"));
	}
	
	@Test(expected = AssertionError.class)
	public void uniqueCharacterErrorTest() {
		
		assertEquals(3, uniqueCharacter.uniqueCharacterSerach("")); // give error when string is empty
		assertEquals(5, uniqueCharacter.uniqueCharacterSerach("123iivdss")); // give error when string have numeric values
		assertEquals(5, uniqueCharacter.uniqueCharacterSerach("@#$%^!HDD(SFgh)")); // give error if special characters are present
	}
}
