package com.dessert.sys.service;

import java.util.List;

import com.dessert.sys.orders.entity.Product;


public interface ProductService {

	List<Product> list();

    void save(Product product);
}
