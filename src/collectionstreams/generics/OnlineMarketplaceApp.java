package collectionstreams.generics;

import java.util.ArrayList;
import java.util.List;


interface Category {
    String getCategoryName();
}


class BookCategory implements Category {
    @Override
    public String getCategoryName() {
        return "Books";
    }
}


class ClothingCategory implements Category {
    @Override
    public String getCategoryName() {
        return "Clothing";
    }
}

class GadgetCategory implements Category {
    @Override
    public String getCategoryName() {
        return "Gadgets";
    }
}


class Product<T extends Category> {

    private String name;
    private double price;
    private T category;

    public Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public T getCategory() {
        return category;
    }

    public void displayProduct() {
        System.out.println(
                "Product: " + name +
                        ", Category: " + category.getCategoryName() +
                        ", Price: ₹" + price
        );
    }
}


class DiscountUtil {

    public static <T extends Product<?>> void applyDiscount(T product, double percentage) {

        double discountAmount = product.getPrice() * (percentage / 100);
        double newPrice = product.getPrice() - discountAmount;

        product.setPrice(newPrice);
    }
}


public class OnlineMarketplaceApp {

    public static void main(String[] args) {


        Product<BookCategory> book =
                new Product<>("Java Programming", 500.0, new BookCategory());

        Product<ClothingCategory> shirt =
                new Product<>("T-Shirt", 800.0, new ClothingCategory());

        Product<GadgetCategory> phone =
                new Product<>("Smartphone", 25000.0, new GadgetCategory());


        List<Product<?>> catalog = new ArrayList<>();
        catalog.add(book);
        catalog.add(shirt);
        catalog.add(phone);

        System.out.println("---- Before Discount ----");
        for (Product<?> product : catalog) {
            product.displayProduct();
        }


        DiscountUtil.applyDiscount(book, 10);
        DiscountUtil.applyDiscount(shirt, 20);
        DiscountUtil.applyDiscount(phone, 5);

        System.out.println("\n---- After Discount ----");
        for (Product<?> product : catalog) {
            product.displayProduct();
        }
    }
}
