package service;

import bean.Customer;

public interface CustomerService {

    String validate(Customer customer);
    String register(Customer customer);

}
