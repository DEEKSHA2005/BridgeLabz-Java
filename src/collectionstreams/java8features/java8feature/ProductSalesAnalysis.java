package javacollectionsstream.java8features.java8feature;

import java.util.*;
import java.util.stream.Collectors;

public class ProductSalesAnalysis {

    public static void main(String[] args) {

        List<Sale> sales = List.of(
                new Sale(101, 15, 100),
                new Sale(102, 5, 200),
                new Sale(103, 25, 50),
                new Sale(104, 12, 300),
                new Sale(105, 30, 80),
                new Sale(106, 8, 150)
        );

        List<ProductSales> topProducts =
                sales.stream()

                        // 1️⃣ Filter
                        .filter(s -> s.getQuantity() > 10)

                        // 2️⃣ Transform
                        .map(s -> new ProductSales(
                                s.getProductId(),
                                s.getQuantity() * s.getPrice()
                        ))

                        // 3️⃣ Sort
                        .sorted(Comparator.comparingDouble(
                                ProductSales::getTotalRevenue).reversed())

                        // 4️⃣ Top 5
                        .limit(5)

                        .collect(Collectors.toList());

        topProducts.forEach(System.out::println);
    }
}
class Sale {
    private int productId;
    private int quantity;
    private double price;

    public Sale(int productId, int quantity, double price) {
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }
}
class ProductSales {
    private int productId;
    private double totalRevenue;

    public ProductSales(int productId, double totalRevenue) {
        this.productId = productId;
        this.totalRevenue = totalRevenue;
    }

    public double getTotalRevenue() {
        return totalRevenue;
    }

    @Override
    public String toString() {
        return "ProductId=" + productId + ", Revenue=" + totalRevenue;
    }
}
