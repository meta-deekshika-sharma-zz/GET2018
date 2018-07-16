package assignment1;

import java.util.Scanner;

public class ShoppingCartMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ShoppingCart cart = new ShoppingCart();
		Scanner sc = new Scanner(System.in);
		int choice;
		
		do
		{
			System.out.println("MENU");
			System.out.println("1. Add item to cart");
			System.out.println("2. Remove item from cart");
			System.out.println("3. Generate bill");
			System.out.println("4. Exit");
			System.out.println("Enter your choice:");
			choice = sc.nextInt();
			
			switch(choice)
			{
			case 1: System.out.println("Enter the name, price, quantity of the item");
					String name = sc.next();
					double price = sc.nextDouble();
					int quantity = sc.nextInt();
					cart.addItem(name, price, quantity);
					break;
					
			case 2: System.out.println("Enter the name of the item to be removed:");
					String name1 = sc.next();
					cart.removeItem(name1);
					break;
					
			case 3: cart.generateBill();
					break;
					
			case 4: break;
			
			default: System.out.println("Wrong input!! Try again!!");
			
			}
		}while(choice != 4);

	}

}
