package util;
import java.sql.*;

public class DbUtil {
		/**
		 *�����������ݿ����Ϣ���������ݿ�URL���û���������
		*/
		private static final String URL = "jdbc:mysql://localhost:3306/shop?useUnicode=true&characterEncoding=UTF-8";
		private static final String USER = "root";
		private static final String PASSWORD = "";
		
		/**
		 * ����JDBC��ض���
		 */
		protected static Statement s = null;
		protected static ResultSet rs = null;
		protected static Connection conn = null;
		
		/**
		 * �������ݿ�
		 * @return conn
		 */
	    public static synchronized Connection getConnection() {
	    	try {
	    		Class.forName("com.mysql.jdbc.Driver");
	    		conn = DriverManager.getConnection(URL, USER, PASSWORD);
	    	}catch (Exception e) {
				e.printStackTrace();
			}
	    	return conn;
	    }
	    
	    /**
	      *  ִ�� INSERT��UPDATE��DELECE���
	     * @param sql SQL ��䣬�ַ�������
	     * @return ִ�н����int����
	     */
	    public static int executeUpdate(String sql) {
	    	int result = 0;
	    	try {
	    		s = getConnection().createStatement();
	    		result = s.executeUpdate(sql);
	    	}catch (Exception e) {
	    		e.printStackTrace();
			}
	    	if(result>0) {
	    		System.out.println("�����ɹ�");
	    	}
	    	return result;
	    }
	    
	    /**
	     * ִ��SELECT���
	     * @param sql SQL��䣬�ַ�������
	     * @return ResultSet�����
	     */
	    public static ResultSet executeQuery(String sql) {
	    	try {
	    		s = getConnection().createStatement();
	    		rs = s.executeQuery(sql);
	    	}catch (Exception e) {
	    		e.printStackTrace();
	    	}
	    	return rs;
	    }
	    
	    /**
	     * ִ�ж�̬SQL���
	     * @param sql ���в����Ķ�̬SQL���
	     * @return ����PreparedStatement����
	     */
	    public static PreparedStatement executePrepareStatement(String sql) {
			PreparedStatement ps = null;
			try {
				ps = getConnection().prepareStatement(sql);
			}catch (Exception e) {
				e.printStackTrace();
			}
			
			return ps;
		}
	    
	    /**
	     * ����ع�
	     */
	    public static void rollback() {
			try {
				getConnection().rollback();
			}catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	    
	    /**
	     * �ر����ݿ����Ӷ���
	     */
	    public static void close() {
	    	try {
	    		if(rs!=null) {
	    			rs.close();
	    		}
	    		if(s!=null) {
	    			s.close();
	    		}
	    		if(conn!=null) {
	    			conn.close();
	    		}
	    	}catch (Exception e) {
	    		e.printStackTrace();
			}
	    }
}
