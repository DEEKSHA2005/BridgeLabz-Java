package collectionstreams.collections;

import java.util.*;

public class ShoppingCartSystem {

    public static void main(String[] args) {

        Map<String, Integer> priceMap = new HashMap<>();
        priceMap.put("Laptop", 50000);
        priceMap.put("Phone", 30000);
        priceMap.put("Headphones", 2000);


        Map<String, Integer> cart = new LinkedHashMap<>();
        cart.put("Phone", priceMap.get("Phone"));
        cart.put("Laptop", priceMap.get("Laptop"));
        cart.put("Headphones", priceMap.get("Headphones"));

        System.out.println("Cart (Insertion Order): " + cart);


        TreeMap<String, Integer> sortedCart = new TreeMap<>(cart);
        System.out.println("Cart (Sorted): " + sortedCart);
    }
}

