package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import bean.UserAddress;
import factory.DaoFactory;
import util.DbUtil;

/**
 * Servlet implementation class AddressServlet
 */
@WebServlet("/addressServlet")
public class AddressServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int result;
		String customerName = (String)req.getSession().getAttribute("customerName");
		UserAddress user = new UserAddress();
		req.setCharacterEncoding("utf-8");
		
		//int p = req.getParameter("province");
		String a[] = {"北京","湖北","湖南","河北","河南","上海","广东","浙江","天津","重庆"};
		
		
		user.setConsigneeName((String)req.getParameter("username"));
		user.setConsigneePhone((String)req.getParameter("tel"));
		
		
		user.setConsigneeCity((String)req.getParameter("city"));
		user.setConsigneeCity(a[Integer.parseInt(req.getParameter("province"))]+user.getConsigneeCity());
		
		System.out.println("province+city:"+req.getParameter("province")+req.getParameter("city"));
		
		
		user.setConsigneeAddress((String)req.getParameter("address"));
		user.setConsigneePostcode((String)req.getParameter("postcode"));
		System.out.println((String)req.getParameter("username"));
		
		result = DaoFactory.getAddressDaoInstance().add(user);
		if(result > 0) {
			System.out.println("success L_35");
		}else {
			System.out.println("false L_37");
		}
		//
		String sql = "DELETE FROM tb_order WHERE customerName = '" + customerName + "'";
		int sresult = 0;
		sresult = DbUtil.executeUpdate(sql);
		DbUtil.close();
		
		if(sresult > 0) {
			System.out.println("Clean Order Success!");
		}
		
		//
		float priceCount = (float) req.getSession().getAttribute("pcount");
		
		resp.sendRedirect("success.jsp");
		
	}

	
	
}
