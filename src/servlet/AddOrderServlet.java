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

import bean.Order;
import util.DbUtil;

@WebServlet("/addOrderServlet")
public class AddOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AddOrderServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
//		Order goods = new Order();
		/*
		 * ģ��ͻ���¼���
		 */
		String customerName = (String) request.getSession().getAttribute("customerName");
//		goods.setCustomerName(customerName);

		//���蹺������Ϊ1
		int number = 1;
		
		int goodsID = Integer.valueOf(request.getParameter("goodsID"));
//		String goodsName ="a";
//		float sellPrice = 1.2f;
//		StringBuffer sb = new StringBuffer();
		//���޸�
		String sql = "SELECT * FROM tb_order WHERE goodsID = '" + goodsID + "' AND customerName = '" + customerName + "'";
		ResultSet rs = DbUtil.executeQuery(sql);
		int sresult = 0;
		try {
			if(rs != null){
				while(rs.next()) {
					sresult ++;
					number = rs.getInt("number");
					number ++;
					
				}
			}
			if(sresult == 0) {
				String osql = "insert into tb_order(customerName,number,goodsID) values(?,?,?)";
				PreparedStatement ps = DbUtil.executePrepareStatement(osql);
				int result = 0;
				ps.setString(1, customerName);
				ps.setInt(2, number);
				ps.setInt(3, goodsID);
				result = ps.executeUpdate();
				if(result > 0) {
					
				}
			} else {
				String osql = "update tb_order set number = ? where goodsID = ? and customerName = ?";
				PreparedStatement ps = DbUtil.executePrepareStatement(osql);
				int result = 0;
				ps.setInt(1, number);
				ps.setInt(2, goodsID);
				ps.setString(3, customerName);
				result = ps.executeUpdate();
				if(result>0) {
					System.out.println("Add order Success!");
				}
			}
			
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
		
		
		
		//���޸�
//		
//		String osql = "insert into tb_order(customerName,number,goodsID) values(?,?,?)";
//		PreparedStatement ps = DbUtil.executePrepareStatement(osql);
//		int result = 0;
//		try {
//			ps.setString(1, customerName);
//			ps.setInt(2, number);
//			ps.setInt(3, goodsID);
//			result = ps.executeUpdate();
//			if(result > 0) {
//				System.out.println(goodsID);
////				String sql = "SELECT * FROM tb_order";
////				ResultSet ors = DbUtil.executeQuery(sql);
////				while(ors.next()) {
////					String gsql = "SELECT * FROM tb_goods WHERE goodsID = '"+ goodsID +"'";
////					ResultSet grs = DbUtil.executeQuery(gsql);
////					goodsName = grs.getString("goodsName");
////					sellPrice = grs.getFloat("sellPrice");
////					sb.append("<tr><td>");
////					sb.append("<input type=\"checkbox\" class=\"qx\"/></td>");
////					sb.append("<td class=\"shopcart-img-list\">");
////					sb.append("<div class=\"shopcart-img\">");
////					sb.append("<img src=\"img/food/");
////					sb.append(goodsID);
////					sb.append(".jpg\"></div></td><td>");
////					sb.append(goodsName);
////					sb.append("</td><td>��");
////					sb.append(sellPrice);
////					sb.append("</td><td><input type=\"text\" name=\"number\" class=\"number\" value=\"1\"></td>");
////					//ͨ����goodsID��ֵ��ɾ�����ﳵ�ϵ���Ʒ
////					sb.append("<td><a href=\"delectOrderServlet?goodsID="+goodsID+"\">ɾ��</a>");
////					sb.append("</td></tr>");
////				}
//			}
//			
//			/*
//			 * �޸�
//			 */
//			
//			
////			request.getSession().setAttribute("sb", sb);
//			
//			
//		}catch(SQLException e) {
//			e.printStackTrace();
//		}
//		DbUtil.close();
//
//		request.getSession().setAttribute("goodsName", goodsName);
//		request.getSession().setAttribute("sellPrice", sellPrice);
		response.sendRedirect("shop.jsp");

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
