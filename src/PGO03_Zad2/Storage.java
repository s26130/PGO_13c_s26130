package PGO03_Zad2;

import java.util.HashSet;
import java.util.Set;

class Storage {
    private int deliveryTime;
    private Set<Product> products;

    Storage(int deliveryTime) {
        if (deliveryTime  < 0) {
            throw new IllegalArgumentException("Czas tak nie działa");
        }

        this.deliveryTime = deliveryTime;
        this.products = new HashSet<>();
    }

    void addProduct(Product product) {
        this.products.add(product);
    }

    int getDeliveryTime() {
        return deliveryTime;
    }

    @Override
    public String toString() {
        return "Storage{" +
                "deliveryTime=" + deliveryTime +
                '}';
    }
}
