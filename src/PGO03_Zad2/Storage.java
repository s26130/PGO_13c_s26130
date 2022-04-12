package PGO03_Zad2;

import java.util.Set;

class Storage {
    int deliveryTime;
    Set<Product> products;

    public Storage(int deliveryTime, Set<Product> products) {
        this.deliveryTime = deliveryTime;
        this.products = products;
    }
}
