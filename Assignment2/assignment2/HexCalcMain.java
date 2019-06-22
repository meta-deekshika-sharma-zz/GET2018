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
		int decimalFirst = hex.decimalValue(hexValueFirst);
		int decimalSecond = hex.decimalValue(hexValueSecond);

		
		for (int i = 0; i < hexValueFirst.length(); i++)
		{
			if (hexValueFirst.charAt(i) >= 70)
			{
				System.out.println("Please input the valid data..");
				System.exit(0);
			}
		}
		
		for (int i = 0; i < hexValueSecond.length(); i++)
		{
			if (hexValueSecond.charAt(i) >= 70)
			{
				System.out.println("Please input the valid data..");
				System.exit(0);
			}
		}
		
		if(decimalFirst < 0 || decimalSecond < 0)
		{
		  throw new NumberFormatException();
		}
		
		 /**
		    * This is simply a menu driven program which will show the choices choosen by user
		    * Exception handling is used to remove exceptions 
		    */
		while (true)
		{
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
			 * It represt different options for users to choose
			 */
			switch (choice)
			{
			   case 1: int add = hex.addHexValue(decimalFirst, decimalSecond);
				   System.out.println("Addition" + hex.hexadecimalValue(add));
			       break;
			   case 2: int sub = hex.substractHexValue(decimalFirst, decimalSecond);
			   System.out.println("Subtraction" + hex.hexadecimalValue(sub));
		       break;
			   case 3: int mul = hex.mulHexValue(decimalFirst, decimalSecond);
			   System.out.println("Multiplication" + hex.hexadecimalValue(mul));
		       break;
			   case 4: int div = hex.divideHexValue(decimalFirst, decimalSecond);
			   System.out.println("Dividation" + hex.hexadecimalValue(div));
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
