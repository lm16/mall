//package henu.servlet;
//
//import java.io.IOException;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import henu.bean.Customer;
//import henu.factory.DaoFactory;
//
//
//public class RegistServlet extends HttpServlet {
//
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		doPost(req, resp);
//	}
//
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		Customer user = new Customer();
//		user.setCustomerName((String)req.getAttribute("username"));
//		user.setCustomerPass((String)req.getAttribute("password"));
//		user.setCustomerEmail((String)req.getAttribute("email"));
//		user.setCustomerPhone((String)req.getAttribute("tel"));
//		
//		DaoFactory.getUserDaoInstance().regist(user);
//		
//		
//	}
//	
//	
//}
