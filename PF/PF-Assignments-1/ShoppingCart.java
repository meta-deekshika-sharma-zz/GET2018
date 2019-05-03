package assignment1;

import java.util.ArrayList;
import java.util.List;

class Item
{
	private String name;
	private double price;
	private int quantity;
	
	public Item(String name,double price, int quantity)
	{
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double total()
	{
		return price*quantity;
	}
	
	public void showItem()
	{
		System.out.println(name+"\t\t\t"+price+"\t\t"+quantity+"\t\t"+total());
	}
}


public class ShoppingCart {

	List<Item> items = new ArrayList<Item>();
	
	public void addItem(String name, double price, int quantity)
	{
		int update = 0;
		for(Item i : items)
		{
			if(i.getName().equals(name))
			{
				update = 1;
				int q = i.getQuantity();
				i.setQuantity(quantity + q);
				break;
			}
		}
		if(update == 0)
		{
		Item item = new Item(name, price, quantity);
		items.add(item);
		}
	}
	
	public void removeItem(String name)
	{
		for(Item i:items)
		{
			if(name.equals(i.getName()))
			{
				items.remove(i);
				break;
			}
		}
	}
	
	public void generateBill()
	{
		double sum=0;
		System.out.println("name\t\t\tprice\t\tquantity\t\ttotal");
		for(Item i:items)
		{
			i.showItem();
			sum += i.total();
		}
		System.out.println();
		System.out.println("Grand Total:  " + sum);
	}
}
