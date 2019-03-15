package servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.DbUtil;

@WebServlet("/searchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SearchServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String goodsName = request.getParameter("goodssName");
		//System.out.println(goodsName);
		String sql;
		sql = " select * from tb_goods where goodsName LIKE '%" + goodsName + "%'";
		ResultSet rs = DbUtil.executeQuery(sql);
		int ID = 0;
		if(rs!=null) {
			try {
				while(rs.next()) {
				ID =  rs.getInt("goodsID");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if(ID==1001) {
				response.sendRedirect("details/food_1.html");
			}else if(ID==1002) {
				response.sendRedirect("details/food_2.html");
			}else if(ID==1003) {
				response.sendRedirect("details/food_3.html");
			}else if(ID==1004) {
				response.sendRedirect("details/food_4.html");
			}else if(ID==1005) {
				response.sendRedirect("details/food_5.html");
			}else if(ID==1006) {
				response.sendRedirect("details/food_6.html");
			}else if(ID==1007) {
				response.sendRedirect("details/food_7.html");
			}else if(ID==1008) {
				response.sendRedirect("details/food_8.html");
			}else if(ID==2001) {
				response.sendRedirect("details/book_1.html");
			}else if(ID==2002) {
				response.sendRedirect("details/book_2.html");
			}else if(ID==2003) {
				response.sendRedirect("details/book_3.html");
			}else if(ID==2004) {
				response.sendRedirect("details/book_4.html");
			}else if(ID==2005) {
				response.sendRedirect("details/book_5.html");
			}else if(ID==2006) {
				response.sendRedirect("details/book_6.html");
			}else if(ID==2007) {
				response.sendRedirect("details/book_7.html");
			}else if(ID==2008) {
				response.sendRedirect("details/bood_8.html");
			}else if(ID==3001) {
				response.sendRedirect("details/ahxt2.html");
			}else if(ID==3002) {
				response.sendRedirect("details/shwj.html");
			}else if(ID==3003) {
				response.sendRedirect("details/sgjz5.html");
			}else if(ID==3004) {
				response.sendRedirect("details/ckxt.html");
			}else if(ID==3005) {
				response.sendRedirect("details/gmly.html");
			}else if(ID==3006) {
				response.sendRedirect("details/kill.html");
			}else if(ID==3007) {
				response.sendRedirect("details/qszl.html");
			}else if(ID==3008) {
				response.sendRedirect("details/ne.html");
			}
			else {
//				request.getServletContext().setAttribute("flag", null);<input type="submit" value="搜索"/>
				response.sendRedirect("shop.jsp");
			}
		}
		else {
			response.sendRedirect("shop.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
