package servlet;

import java.io.IOException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.DbUtil;

@WebServlet("/buyOrderServlet")
public class BuyOrderServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int goodsID = Integer.valueOf(req.getParameter("goodsID"));
		float Price = 1.2f;
		String sql = "SELECT * FROM tb_goods WHERE goodsID='"+ goodsID +"'";
		ResultSet rs = DbUtil.executeQuery(sql);
		int result = 0;
		try {
			if(rs.next()) {
				Price = rs.getFloat("sellPrice");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		req.getSession().setAttribute("pcount", Price);
		resp.sendRedirect("shopCart.jsp");
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}
