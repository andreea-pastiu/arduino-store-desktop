package sample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Cart
{
    private static HashMap<Product, Integer> cartItems = new HashMap<>();

    public static HashMap<Product, Integer> getCartItems()
    {
        return cartItems;
    }

    public static void AddProduct(Product product)
    {
        cartItems.put(product, 1);
    }
}
