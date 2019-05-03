package shoppingcart;

import java.util.Scanner;

public class ShoppingMain {

	public static void main(String[] args) {
		
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
			case 1: System.out.println("Enter the product name, price, quantity of the item");
					String name = sc.next();
					double price = sc.nextDouble();
					int quantity = sc.nextInt();
					cart.addItem(name, price, quantity);
					break;
					
			case 2: System.out.println("Enter the product name of the item to be removed:");
					String pname = sc.nextLine();
					cart.removeItem(pname);
					break;
					
			case 3: System.out.println("Do you have a promo code?(y/n)");
					char response = sc.next().charAt(0);
					String promoCode = "";
					if(response == 'y')
					{
						System.out.println("Enter the promo code");
						promoCode = sc.next();
					}
					cart.generateBill(promoCode);
					break;
					
			case 4: break;
			
			default: System.out.println("Wrong input!! Try again!!");
			
			}
		}while(choice != 4);

	}

}
