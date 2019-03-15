package factory;

//import henu.daoimpl.UserDaoimpl;
import dao.IAddressDao;

//import henu.dao.IUserDao;
import dao.impl.AddressDaoimpl;
//import henu.dao.impl.OrderDaoImpl;

public class DaoFactory {
//	public static IUserDao getUserDaoInstance() {
//		return new UserDaoimpl();
//	}
//
	/*
	 * ��ַ��
	 */
	public static IAddressDao getAddressDaoInstance() {
		return new AddressDaoimpl();
	}
	/*
	 * ������
	 */
//	public static OrderDaoImpl getInstance() {
//		return new OrderDaoImpl();
//	}
	
	
	
}
