package assignment2;

import java.util.Scanner;


/**
 * This is the main class for the hexadecimal calculator which contains a menu for taking various choices regarding hexa operation
 * @author User15
 * Exception are handled via try-catch
 */
public class HexCalcMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			
		HexCalc hex = new HexCalc();
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter first hexadecimal value :");
		String hexValueFirst = sc.nextLine().toUpperCase();
		System.out.println("Please enter second hexadecimal value :");
		String hexValueSecond = sc.nextLine().toUpperCase();
		
		 /**
		    * This is simply a menu driven program which will show the choices choosen by user
		    * Exception handling is used to remove exceptions 
		    */
		while (true)
		{
			if(!(hex.isNumberValid(hexValueFirst)) || !(hex.isNumberValid(hexValueSecond)))
			{
				System.out.println("Input is not valid..");
				System.exit(0);
			}
		    System.out.println("MENU");
			System.out.println("1. Addition");
			System.out.println("2. Subtraction");
			System.out.println("3. Multiplication");
			System.out.println("4. Division");
			System.out.println("5. String1 == String2");
			System.out.println("6. String1 > String2");
			System.out.println("7. String1 < String2");
			System.out.println("Enter your choice:");
			
			int choice = sc.nextInt();
			
			/**
			 * It represent different options for users to choose
			 */
			switch (choice)
			{
			   case 1:
				   System.out.println("Addition" + hex.addHexValue(hexValueFirst, hexValueSecond));
			       break;
			   case 2: 
			       System.out.println("Subtraction" + hex.substractHexValue(hexValueFirst, hexValueSecond));
		           break;
			   case 3: 
			   System.out.println("Multiplication" + hex.mulHexValue(hexValueFirst, hexValueSecond));
		       break;
			   case 4:
			   System.out.println("Dividation" + hex.divideHexValue(hexValueFirst, hexValueSecond));
		       break;
			   case 5: boolean equal = hex.equals(hexValueFirst, hexValueSecond);
			   System.out.println(equal);
			   break;
			   case 6: boolean greater = hex.greaterThen(hexValueFirst, hexValueSecond);
			       System.out.println(greater);
			   break;
			   case 7: boolean less = hex.lessThen(hexValueFirst, hexValueSecond);
			       System.out.println(less);
			   break;
			   default:System.exit(0); 
			}		
		}
	  } catch (Exception e)
		{
		    System.out.println("Please choose correct options....");
		}
	}
	
}
