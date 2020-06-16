package main.java.com.ebookstore.service.impl;

import main.java.com.ebookstore.dao.ProductDao;
import main.java.com.ebookstore.model.Product;
import main.java.com.ebookstore.service.CartService;
import main.java.com.ebookstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService
{
    @Autowired
    private ProductDao productDao;

    @Autowired
    private CartService cartService;

    public Product getProductById (int productId) {
        return productDao.getProductById(productId);
    }

    public List<Product> getProductList () {
        return productDao.getProductList();
    }

    public void addProduct(Product product) {
        productDao.addProduct(product);
    }

    public void editProduct(Product product) {
        productDao.editProduct(product);
    }

    public void deleteProduct(Product product) {
        productDao.deleteProduct(product);
    }


}
