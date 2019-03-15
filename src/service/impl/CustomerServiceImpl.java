package service.impl;

import dao.CustomerDao;

import dao.impl.CustomerDaoImpl;
import bean.Customer;
import service.CustomerService;

public class CustomerServiceImpl implements CustomerService {

    private CustomerDao customerDao = new CustomerDaoImpl();

    @Override
    public String validate(Customer customer) {
        return customerDao.validate(customer);
    }

    @Override
    public String register(Customer customer) {
        return customerDao.register(customer);
    }
}
