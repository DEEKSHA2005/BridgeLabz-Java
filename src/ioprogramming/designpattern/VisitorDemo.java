package ioprogramming.designpattern;
/*
 Visitor Pattern
 Separate algorithm from object structure
*/

interface ProductItem {
    int accept(PriceVisitor visitor);
}

class NovelBook implements ProductItem {

    int price;

    NovelBook(int price) {
        this.price = price;
    }

    public int accept(PriceVisitor visitor) {
        return visitor.visit(this);
    }
}

class Gadget implements ProductItem {

    int price;

    Gadget(int price) {
        this.price = price;
    }

    public int accept(PriceVisitor visitor) {
        return visitor.visit(this);
    }
}

interface PriceVisitor {

    int visit(NovelBook book);
    int visit(Gadget gadget);
}

class ShoppingCartVisitor implements PriceVisitor {

    public int visit(NovelBook book) {
        return book.price;
    }

    public int visit(Gadget gadget) {
        return gadget.price;
    }
}

public class VisitorDemo {

    public static void main(String[] args) {

        ProductItem item1 = new NovelBook(500);
        ProductItem item2 = new Gadget(1500);

        PriceVisitor visitor = new ShoppingCartVisitor();

        System.out.println("Total price: " +
                (item1.accept(visitor) + item2.accept(visitor)));
    }
}