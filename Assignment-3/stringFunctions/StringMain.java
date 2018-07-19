package stringFunctions;

import java.nio.channels.IllegalSelectorException;
import java.util.Scanner;

/**
 * this class will contain the various option which will be choosen by user
 * @author User15
 *
 */

public class StringMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringFunctions stringFunctions = new StringFunctions();
		Scanner sc = new Scanner(System.in);
		
		/**
		 * this while loop will true in each condition and used to provide menu for the users
		 * user will select option and perform the operations
		 */
		try {
		while (true)
		{
	     	System.out.println("MENU");
			System.out.println("1. Compare two strings are equal or not");
			System.out.println("2. Reverse of a strings");
			System.out.println("3. Change the case of character");
			System.out.println("4. Longest word in string");
			System.out.println("Enter your choice:");
			
			int choice = sc.nextInt();
			/**
			 * this switch case displays are options based on menus
			 * each time it will take input as strings 
			 */
			
			switch (choice)
			{
			   case 1: 
				   System.out.println("Enter the first string :");
				   String firstString = sc.next();
				   System.out.println("Enter the second string :");
				   String secondString = sc.next();
				   System.out.println("The two strings are : " + stringFunctions.compareStrings(firstString, secondString) );
			       break;
			   case 2:
				   System.out.println("Enter the string :");
			       String reverseString = sc.next();
			       System.out.println("Reverse String : " + stringFunctions.reverseString(reverseString));
		           break;
			   case 3:
		           System.out.println("Enter the String :");
		           String changeString = sc.next();
		           System.out.println("Area of Squre : " + stringFunctions.changeCaseOfString(changeString));
	               break;
			   case 4:
				   System.out.println("Enter the string :");
				   String string = sc.next();
				   string += sc.nextLine();
	               String[] largestWord = string.split("\\s+");
	               System.out.println("Largest word in string : " + stringFunctions.largestWordString(largestWord));
                   break;
			   default : throw new NumberFormatException();
			}
					
		}
	  } catch (Exception e)
	  {
		  System.out.println("Please input the valid value.!!");
	  }
		
	}

}
