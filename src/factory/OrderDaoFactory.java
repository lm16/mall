package factory;

import dao.impl.OrderDaoImpl;

public class OrderDaoFactory {
	public static OrderDaoImpl getInstance() {
		return new OrderDaoImpl();
	}
}
