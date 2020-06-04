package vn.edu.ntu.nguyenthanhhuynh_59131001.nguyenthanhhuynh_59131001_cartnavigation.Controller;

import java.util.List;

import vn.edu.ntu.nguyenthanhhuynh_59131001.nguyenthanhhuynh_59131001_cartnavigation.Model.Product;

public interface ICartController{
    public List<Product> getAllProducts();
    public boolean addToCart(Product p);
    public List<Product> getShoppingCart();
    void clearShoppingCart();
}
