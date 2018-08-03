package infixToPostfix;

import java.util.Stack;

/**
 * @author Deekshika Sharma This class will have the method to convert an infix
 *         expression into prefix operation
 */
public class InfixToPostfixConversion {

	private String[] expressionArray;
	Stack<String> stringStack;

	/**
	 * This constructor will initializes the infix expression
	 * 
	 * @param expression
	 */
	public InfixToPostfixConversion(String expression) {
		if (expression == null)
			throw new AssertionError("Infix expression is missing!!!");
		this.expressionArray = expression.split(" ");
		this.stringStack = new Stack<String>();
	}

	/**
	 * This method will convert the infix expression into postfix expression
	 * 
	 * @return the postfix expression in form of string
	 */
	public String infixToPostfixConversion() {
		
		if(expressionArray.length == 2)
			return (expressionArray[0] + " " + expressionArray[1]);
			
		String postfixExpression = new String();

		String expression;
		for (int i = 0; i < expressionArray.length; i++) {

			expression = expressionArray[i];

			if (PostfixUtility.isDigitOrAlphabet(expression)) // check
																// expression
																// have digit or
																// alphabet and
																// add into
																// string
				postfixExpression = postfixExpression.concat(expression);

			else if ("(".equals(expression))
				stringStack.push(expression); // if left parenthesis occur push
												// it into stack
			else if (")".equals(expression)) { // if right parenthesis occur
												// then check further
				while (!stringStack.isEmpty()
						&& !("(".equals(stringStack.peek())))
					// pop stack till left parenthesis occur {
					postfixExpression = postfixExpression.concat(stringStack
							.pop());

				if (!stringStack.isEmpty() && "(".equals(stringStack.peek())) {
					stringStack.pop();
				} else {
					throw new AssertionError("Invalid expression");
				}
			} else {
				while (!stringStack.isEmpty()
						&& (PostfixUtility.getPrecedence(expression) <= PostfixUtility
								.getPrecedence(stringStack.peek())))
					postfixExpression = postfixExpression.concat(stringStack
							.pop());
				stringStack.push(expression);
			}
		}

		while (!stringStack.isEmpty())
			// last pop all operator from stack
			postfixExpression = postfixExpression.concat(stringStack.pop());

		return postfixExpression.toString();
	}
}
