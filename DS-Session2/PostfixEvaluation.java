package postfixEvalution;

import stack.StackUsingLinkedList;

/**
 * @author Deekshika Sharma This class will have method for the evaluation for
 *         postfix expression It implements the stack interface
 */
public class PostfixEvaluation {

	private String[] postFixExpression;
	private stack.Stack stackInteger = new StackUsingLinkedList();// use linked
																	// list
																	// implementation
																	// of stack
																	// interface

	/**
	 * The constructor will initializes the string expression into string array
	 * split by whitespace
	 * 
	 * @param postFixExpression
	 */
	public PostfixEvaluation(String postFixExpression) {
		this.postFixExpression = postFixExpression.split(" ");
		stackInteger = new StackUsingLinkedList();
	}

	/**
	 * This method will return the evaluated expression
	 * 
	 * @return If the result is integer that means given expression is correct
	 *         otherwise not
	 */
	public int evaluatePostFixExpression() {
		
		if(postFixExpression.length == 0)
			throw new AssertionError("The expression is not found");
		else if(postFixExpression.length == 2)
			throw new AssertionError("The expression can not be evaluated");
		String expression;

		for (int i = 0; i < postFixExpression.length; i++) {
			expression = postFixExpression[i];

			try {
				if (Integer.parseInt(expression) >= 0)
					stackInteger.pushStack(Integer.parseInt(expression));
			} catch (Exception e) {
				int value1 = stackInteger.popStack();
				int value2 = stackInteger.popStack();
				int intermediateExpression;
				switch (expression) // calculate intermediate result
				{
				case "+":
					intermediateExpression = value1 + value2;
					break;
				case "-":
					intermediateExpression = value1 - value2;
					break;
				case "*":
					intermediateExpression = value1 * value2;
					break;
				case "/":
					intermediateExpression = value1 / value2;
					break;
				default:
					throw new AssertionError(
							"The given expression is not valid!!");
				}
				stackInteger.pushStack(intermediateExpression);
			}

		}
		int resultExpression = stackInteger.popStack();
		if (!stackInteger.isStackEmpty()) // throw error if stack is not empty
											// at last
			throw new AssertionError("The given expression is not complete!!");
		return resultExpression;
	}
}
