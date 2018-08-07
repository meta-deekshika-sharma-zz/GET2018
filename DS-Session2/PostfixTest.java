package infixToPostfix;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Deekshika Sharma This class will have the method for infix to postfix
 *         conversion
 */
public class PostfixTest {

	InfixToPostfixConversion postfix;

	/**
	 * This method will validate positive test cases
	 */
	@Test
	public void infixToPostfixTest() {
		postfix = new InfixToPostfixConversion("2 + 3");
		assertEquals("23+", postfix.infixToPostfixConversion());

		postfix = new InfixToPostfixConversion("* b");
		assertEquals("* b", postfix.infixToPostfixConversion());

		postfix = new InfixToPostfixConversion("a * b");
		assertEquals("ab*", postfix.infixToPostfixConversion());

		postfix = new InfixToPostfixConversion("a + ( b * c )");
		assertEquals("abc*+", postfix.infixToPostfixConversion());

		postfix = new InfixToPostfixConversion("a * ( b + c ) * d");
		assertEquals("abc+*d*", postfix.infixToPostfixConversion());

		postfix = new InfixToPostfixConversion(
				"( 300 + 23 ) * ( 43 - 21 ) / ( 84 + 7 )");
		assertEquals("30023+4321-*847+/", postfix.infixToPostfixConversion());
	}

	/**
	 * This method will validate negative test cases
	 */
	@Test(expected = AssertionError.class)
	public void infixToPostfixErrorTest() {
		postfix = new InfixToPostfixConversion("2 + 3");
		assertEquals("2+3", postfix.infixToPostfixConversion());

		postfix = new InfixToPostfixConversion("a * b []"); // give error when
															// expression is
															// invalid
		assertEquals("ab*", postfix.infixToPostfixConversion());
	}
}
