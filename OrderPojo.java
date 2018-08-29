package storeFront;

import java.sql.Date;

/**
 * @author Deekshika Sharma
 * This pojo have Orders properties for orders table in store front
 */
public class OrderPojo {

	private int id;
	private Date placedDate;
	private double totalAmount;
	
	public OrderPojo(int id, Date placedDate, double totalAmount) {
		this.id = id;
		this.placedDate = placedDate;
		this.totalAmount = totalAmount;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getPlacedDate() {
		return placedDate;
	}
	public void setPlacedDate(Date placedDate) {
		this.placedDate = placedDate;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
}
