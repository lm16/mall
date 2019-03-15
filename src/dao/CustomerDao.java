package dao;

import bean.Customer;

public interface CustomerDao {

    String validate(Customer customer);
    String register(Customer customer);
}
