package servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.DbUtil;

@WebServlet("/delectOrderServlet")
public class DelectOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int goodsID = Integer.valueOf(request.getParameter("goodsID"));
		String customerName = (String)request.getSession().getAttribute("customerName");
		
		String sql = "DELETE FROM tb_order WHERE goodsID = '" + goodsID + "' AND customerName = '" + customerName + "'";
		int result = 0;
		result = DbUtil.executeUpdate(sql);
		DbUtil.close();
		
		response.sendRedirect("showOrderServlet");
		
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
}
