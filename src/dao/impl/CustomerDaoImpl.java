package dao.impl;

import util.C3P0Config;

import dao.CustomerDao;
import bean.Customer;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

public class CustomerDaoImpl implements CustomerDao {

    private QueryRunner qr = new QueryRunner(C3P0Config.getDataSource());

    public String validate(Customer customer) {
        Customer bean = null;
        String sql = "select * from tb_customer where customerName=? and customerPass=?";

        try{
            bean = qr.query(sql, new BeanHandler<>(Customer.class), customer.getCustomerName(), customer.getCustomerPass());
        }catch (Exception e){
            e.printStackTrace();
        }

        if(bean == null) {
            return "failed";
        } else{
            return "success";
        }
    }

    @Override
    public String register(Customer customer) {
        String sql = "insert into tb_customer(customerName, customerPass, customerEmail, customerPhone) values(?, ?, ?, ?)";
        int flag=0;

        try{
            flag = qr.update(sql, customer.getCustomerName(), customer.getCustomerPass(), customer.getCustomerEmail(), customer.getCustomerPhone());
            System.out.println(flag);
        }catch (Exception e){
            e.printStackTrace();
        }

        if(flag == 0)
            return "failed";
        else
            return "success";
    }
}
