package bean;

import java.util.Date;

public class Order {
	int orderID;
	String customerName;
	double money;
	Date orderDate;
	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public boolean isOrderState() {
		return orderState;
	}
	public void setOrderState(boolean orderState) {
		this.orderState = orderState;
	}
	boolean orderState;
}
