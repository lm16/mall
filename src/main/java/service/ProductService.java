package service;

import domain.Product;

import java.util.List;

public interface ProductService {

    List<Product> getList();
    Product getBean(String name);
    void update(Product product);
    void create(Product product);
    void delete(String name);
}
