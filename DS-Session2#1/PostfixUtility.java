package infixToPostfix;

/**
 * @author Deekshika Sharma This class will have utility function for infix to
 *         postfix expression conversion
 */
public class PostfixUtility {

	/**
	 * This method will validate the string is digit or alphabet
	 * 
	 * @param value
	 * @return
	 */
	public static boolean isDigitOrAlphabet(String string) {
		if (isDigit(string) | isAlphabet(string))
			return true;
		else
			return false;
	}

	/**
	 * Check whether string is digit or not
	 * 
	 * @param value
	 * @return
	 */
	public static boolean isDigit(String string) {
		for (int i = 0; i < string.length(); i++) {
			if (!(string.charAt(i) >= '0' && string.charAt(i) <= '9'))
				return false;
		}
		return true;
	}

	/**
	 * Check whether string is alphabet or not
	 * 
	 * @param string
	 * @return
	 */
	public static boolean isAlphabet(String string) {
		String stringInUpperCase = string.toUpperCase();
		for (int i = 0; i < stringInUpperCase.length(); i++) {
			if (!(stringInUpperCase.charAt(i) >= 'A' && stringInUpperCase
					.charAt(i) <= 'Z'))
				return false;
		}
		return true;
	}

	/**
	 * This method will define the precedence of operators
	 * 
	 * @param operator
	 * @return
	 */
	public static int getPrecedence(String operator) {
		if ("||".equals(operator)) {
			return 1;
		} else if ("&&".equals(operator)) {
			return 2;
		} else if ("!=".equals(operator) || "==".equals(operator)) {
			return 3;
		} else if (">=".equals(operator) || "<=".equals(operator)
				|| "<".equals(operator) || ">".equals(operator)) {
			return 4;
		} else if ("+".equals(operator) || "-".equals(operator)) {
			return 5;
		} else if ("*".equals(operator) || "%".equals(operator)
				|| "/".equals(operator)) {
			return 6;
		} else
			return -1;
	}
}
