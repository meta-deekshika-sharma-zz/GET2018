package storeFront;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		List<OrderPojo> orderList = SelectOrders.selectOrders(1);
		for(OrderPojo orderPojo: orderList)
		{
			System.out.println(orderPojo.getId() + " " + orderPojo.getPlacedDate() + " " + orderPojo.getTotalAmount());
		}
	}

}
