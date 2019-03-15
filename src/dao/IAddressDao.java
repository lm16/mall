package dao;

import bean.UserAddress;

public interface IAddressDao {
	
	/*
	 * ������ַ
	 * @param
	 * @return �ɹ�����1
	 */
	public int add(UserAddress user);
	
	public boolean chang();
	
	public boolean delect();
}
