package com.pruebas.springapp.repository;

import java.util.List;

import com.pruebas.springapp.domain.Product;

public interface ProductDao {

    public List<Product> getProductList();

    public void saveProduct(Product prod);

}