package com.dessert.sys.dao;

import java.util.List;

import com.dessert.sys.orders.entity.Product;


public interface ProductDao {
	List<Product> list();

    void save(Product product);
}
