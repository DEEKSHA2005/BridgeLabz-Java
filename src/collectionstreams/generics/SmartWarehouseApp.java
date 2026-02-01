package collectionstreams.generics;

import java.util.ArrayList;
import java.util.List;


abstract class WarehouseItem {
    private String name;

    public WarehouseItem(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    public abstract void displayInfo();
}


class Electronics extends WarehouseItem {

    public Electronics(String name) {
        super(name);
    }

    @Override
    public void displayInfo() {
        System.out.println("Electronics Item: " + getName());
    }
}

class Groceries extends WarehouseItem {

    public Groceries(String name) {
        super(name);
    }

    @Override
    public void displayInfo() {
        System.out.println("Grocery Item: " + getName());
    }
}

class Furniture extends WarehouseItem {

    public Furniture(String name) {
        super(name);
    }

    @Override
    public void displayInfo() {
        System.out.println("Furniture Item: " + getName());
    }
}


class Storage<T extends WarehouseItem> {

    private List<T> items = new ArrayList<>();


    public void addItem(T item) {
        items.add(item);
    }


    public List<T> getItems() {
        return items;
    }
}


class WarehouseUtil {

    public static void displayItems(List<? extends WarehouseItem> items) {
        for (WarehouseItem item : items) {
            item.displayInfo();
        }
    }
}


public class SmartWarehouseApp {

    public static void main(String[] args) {


        Storage<Electronics> electronicsStorage = new Storage<>();
        electronicsStorage.addItem(new Electronics("Laptop"));
        electronicsStorage.addItem(new Electronics("Mobile"));


        Storage<Groceries> groceriesStorage = new Storage<>();
        groceriesStorage.addItem(new Groceries("Rice"));
        groceriesStorage.addItem(new Groceries("Milk"));


        Storage<Furniture> furnitureStorage = new Storage<>();
        furnitureStorage.addItem(new Furniture("Chair"));
        furnitureStorage.addItem(new Furniture("Table"));


        System.out.println("---- Electronics ----");
        WarehouseUtil.displayItems(electronicsStorage.getItems());

        System.out.println("\n---- Groceries ----");
        WarehouseUtil.displayItems(groceriesStorage.getItems());

        System.out.println("\n---- Furniture ----");
        WarehouseUtil.displayItems(furnitureStorage.getItems());
    }
}
