package PGO03_Zad2;

import java.util.Collections;
import java.util.Set;

class Storage {
    int deliveryTime;
    Set<Product> products;

    public Storage(int deliveryTime) {
        this.deliveryTime = deliveryTime;
        this.products = Collections.emptySet();
    }

    void addProduct(Product product) {
        this.products.add(product);
    }
}
