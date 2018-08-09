package dictionaryImplementation;

import static org.junit.Assert.*;

import org.junit.Test;

public class DictionaryTest {

	
	@Test
	public void test() {
		Dictionary dictionaryImplementation = new DictionaryImplementation("D:\\java\\Dictionary\\Trees.json");
		assertNotNull(dictionaryImplementation.addKeyValuePair("d", "dd"));
		assertNotNull(dictionaryImplementation.addKeyValuePair("b", "bb"));
		assertNotNull(dictionaryImplementation.addKeyValuePair("c", "cc"));
		assertNotNull(dictionaryImplementation.addKeyValuePair("a", "aa"));
		assertNotNull(dictionaryImplementation.addKeyValuePair("e", "ee"));
		
		assertNotNull(dictionaryImplementation.sortedList());
		
		assertEquals("bb", dictionaryImplementation.getValueForKey("b"));
		assertNotNull(dictionaryImplementation.deleteKeyValuePair("a"));
		
		assertNotNull(dictionaryImplementation.sortedList());
	}

}
