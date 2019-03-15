package servlet;

import java.io.IOException;

import java.sql.ResultSet;
import java.sql.SQLException;
//import java.text.DecimalFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.DbUtil;

@WebServlet("/showOrderServlet")
public class ShowOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ShowOrderServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String customerName = (String)request.getSession().getAttribute("customerName");
		String sql = "select * from tb_order where customerName = '" + customerName + "'";
		ResultSet rs = DbUtil.executeQuery(sql);
		System.out.println("asdf");
		StringBuffer sb = new StringBuffer();
		String goodsName = "error";
		//�޸� 0104 12:07
		int number = 1;
		float sellPrice = 0;
		float priceCount = 0;
		int goodsCount = 0;
		String goodsType = "";
		try {
			while(rs.next()) {
				int goodsID = rs.getInt("goodsID");
				number = rs.getInt("number");
				System.out.println("goodsID:"+goodsID);
				System.out.println("number:"+number);
				String gsql = "SELECT * FROM tb_goods WHERE goodsID = '"+ goodsID +"'";
				ResultSet grs = DbUtil.executeQuery(gsql);
				if(grs.next()) {
					goodsName = grs.getString("goodsName");
					sellPrice = grs.getFloat("sellPrice");
					goodsType = grs.getString("goodsType");
				}

				priceCount += (number *sellPrice);
				goodsCount += number;

				System.out.println("goodsName:"+goodsName);
				System.out.println("sellPrice:"+sellPrice);
				sb.append("<tr><td>");
				sb.append("<input type=\"checkbox\" class=\"qx\"/></td>");
				sb.append("<td class=\"shopcart-img-list\">");
				sb.append("<div class=\"shopcart-img\">");
				sb.append("<img src=\"img/");
				sb.append(goodsType);
				sb.append("/");
				sb.append(goodsID);
				sb.append(".jpg\"></div></td><td>");
				sb.append(goodsName);
				sb.append("</td><td>￥");
				sb.append(sellPrice);
				sb.append("</td><td><input type=\"text\" disabled name=\"number\" class=\"number\" value=\"");
				sb.append(number);
				sb.append("\"></td>");
				//ͨ����goodsID��ֵ��ɾ�����ﳵ�ϵ���Ʒ
				sb.append("<td><a href=\"delectOrderServlet?goodsID="+goodsID+"\">删除</a>");
				sb.append("</td></tr>");
				System.out.println("V");
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}

//		DecimalFormat df = new DecimalFormat("##.##");
		float  pcount   =  (float)(Math.round(priceCount*100))/100;
//		String pcount = df.format(priceCount);

		DbUtil.close();
		request.getServletContext().setAttribute("sb", sb);
		request.getSession().setAttribute("gcount", goodsCount);
		request.getSession().setAttribute("pcount", pcount);
		response.sendRedirect("gouwuche.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
