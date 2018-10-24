package postfixEvalution;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Deekshika Sharma This class will have test cases related to postfix
 *         evaluation
 */
public class PostfixEvaluationTest {

	PostfixEvaluation postfix;

	/**
	 * This method will have positive test cases
	 */
	@Test
	public void postFixExpression() {
		postfix = new PostfixEvaluation("2 3 1 * +");
		assertEquals(5, postfix.evaluatePostFixExpression());

		postfix = new PostfixEvaluation("2 3 6 * + 22 -");
		assertEquals(2, postfix.evaluatePostFixExpression());

		postfix = new PostfixEvaluation("2 3 5 * + 2 -");
		assertEquals(-15, postfix.evaluatePostFixExpression());
	}

	/**
	 * This method will have negative test cases
	 */
	@Test(expected = AssertionError.class)
	public void postFixExpressionError() {
		postfix = new PostfixEvaluation("2 3 5 * 2 - \\"); // give error for
															// invalid operation
		assertEquals(-11, postfix.evaluatePostFixExpression());

		postfix = new PostfixEvaluation(""); // give error when expression is
												// not found
		assertEquals(-11, postfix.evaluatePostFixExpression());

		postfix = new PostfixEvaluation("2 3"); // give error when no operator
												// will find or expression
												// length is 2
		assertEquals(-11, postfix.evaluatePostFixExpression());
	}
}
