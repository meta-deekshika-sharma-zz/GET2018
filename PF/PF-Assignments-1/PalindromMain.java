package assignment1;

import java.util.Scanner;

public class PalindromMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PalindromClass palindrom = new PalindromClass();
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter a string:");
		String string = sc.nextLine();
		boolean ans = palindrom.checkPalindrom(string);
		if(ans == true)
			System.out.println("String is palindrom");
		else
			System.out.println("String is not palindrom");
	}

}
