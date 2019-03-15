package dao.impl;

import java.sql.PreparedStatement;

import java.sql.SQLException;

import bean.UserAddress;
import dao.IAddressDao;
import util.DbUtil;

public class AddressDaoimpl implements IAddressDao {

	@Override
	public int add(UserAddress user) {
		System.out.println(user.toString());
		String sql = "INSERT INTO tb_address(consigneeName,consigneePhone,consigneeCity,consigneeAddress,consigneePostcode) VALUES(?,?,?,?,?)";
		
		PreparedStatement ps = DbUtil.executePrepareStatement(sql);
		int result = -1;
		try {
			ps.setString(1, user.getConsigneeName());
			ps.setString(2, user.getConsigneePhone());
			ps.setString(3, user.getConsigneeCity());
			ps.setString(4, user.getConsigneeAddress());
			ps.setString(5, user.getConsigneePostcode());
		
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DbUtil.close();
		return result;
	}

	

	@Override
	public boolean chang() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delect() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
