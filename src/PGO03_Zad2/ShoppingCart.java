package PGO03_Zad2;

import java.util.List;



class ShoppingCart {
    private static int nextId = 1;
    int id;
    double totalPrice;
    int totalDeliveryTime;
    List<Product> products;


    void sell(){

    }

    public ShoppingCart() {
        this.id = generateNextId();
    }

    private static int generateNextId() {
        var currentId = nextId;
        nextId = nextId ++;
        return currentId;
    }
}
