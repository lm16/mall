package dao;

import java.util.List;

import bean.Order;

public interface IOrderDao {
	
	//��ӹ��ﳵ
	public int save(Order goods);
	
	//ɾ�����ﳵ
	public int delete(String goodsname);
	
	//public int update(String username, Order user);
	
	//�鿴���ﳵ
	public List<Order> findAll();

	//public String findByUsername(String key,String value);

	public String searchResult();
}
