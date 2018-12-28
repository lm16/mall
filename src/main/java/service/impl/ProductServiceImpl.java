package service.impl;

import dao.ProductDao;
import dao.impl.ProductDaoImpl;
import domain.Product;
import service.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {

    private ProductDao productDao = new ProductDaoImpl();

    @Override
    public List<Product> getList() {
        return productDao.getList();
    }

    @Override
    public Product getBean(String name) {
        return productDao.getBean(name);
    }

    @Override
    public void update(Product product) {
        productDao.update(product);
    }

    @Override
    public void create(Product product) {
        productDao.create(product);
    }

    @Override
    public void delete(String name) {
        productDao.delete(name);
    }
}
