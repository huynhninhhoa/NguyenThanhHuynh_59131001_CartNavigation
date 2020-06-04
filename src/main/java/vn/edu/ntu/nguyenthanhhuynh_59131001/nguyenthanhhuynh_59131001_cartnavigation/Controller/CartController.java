package vn.edu.ntu.nguyenthanhhuynh_59131001.nguyenthanhhuynh_59131001_cartnavigation.Controller;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

import vn.edu.ntu.nguyenthanhhuynh_59131001.nguyenthanhhuynh_59131001_cartnavigation.Model.Product;

public class CartController extends Application implements ICartController{

    List<Product> listProducts = new ArrayList<>();
    List<Product> shoppingCart = new ArrayList<>();

    public CartController(){
        listProducts.add(new Product("Khoai Lang", 25000, "Đây là Khoai lang"));
        listProducts.add(new Product("Khoai Tây", 35000, "Đây là Khoai tây"));
        listProducts.add(new Product("Khoai Mì", 15000, "Đây là Khoai mì"));
        listProducts.add(new Product("Mít", 30000, "Đây là Mít"));
        listProducts.add(new Product("Nho", 40000, "Đây là Nho"));
        listProducts.add(new Product("Ổi", 15000, "Đây là Ổi"));
        listProducts.add(new Product("Măng cụt", 50000, "Đây là Măng cụt"));
        listProducts.add(new Product("Chôm chôm", 12000, "Đây là Chôm chôm"));
        listProducts.add(new Product("Sầu riêng", 80000, "Đây là Sầu riêng"));
    }

    @Override
    public List<Product> getAllProducts() {
        return listProducts;
    }

    @Override
    public boolean addToCart(Product product) {
        if(this.shoppingCart.contains(product))
            return false;
        this.shoppingCart.add(product);
        return true;
    }

    @Override
    public List<Product> getShoppingCart() {
        return this.shoppingCart;
    }

    @Override
    public void clearShoppingCart() {
        shoppingCart.clear();
    }
}
