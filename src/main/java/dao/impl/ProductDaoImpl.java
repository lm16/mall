package dao.impl;

import config.C3P0Config;
import dao.ProductDao;
import domain.Product;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {

    private QueryRunner qr = new QueryRunner(C3P0Config.getDataSource());

    @Override
    public List<Product> getList() {
        List<Product> list = new ArrayList<>();
        String sql = "select * from product";
        try{
            list = qr.query(sql, new BeanListHandler<>(Product.class));
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Product getBean(String name) {
        Product product = null;
        String sql = "select * from product where name = ?";
        try {
            product = qr.query(sql, new BeanHandler<>(Product.class), name);
        }catch (Exception e){
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public void update(Product product) {
        String sql = "update product set name=?, type=?, price=?, restNum=? createDate=? where name=?";
        try{
            qr.update(sql, product.getName(), product.getType(), product.getPrice(), product.getRestNum(), product.getCreateDate(), product.getName());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void create(Product product) {
        String sql = "insert into product(name, type, price, restNum, createDate) values (?, ?, ?, ?, ?)";
        try{
            qr.update(sql, product.getName(), product.getType(), product.getPrice(), product.getRestNum(), product.getCreateDate());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String name) {
        String sql = "delete from product where name=?";
        try{
            qr.update(sql, name);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
