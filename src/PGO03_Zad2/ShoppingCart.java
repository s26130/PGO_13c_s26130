package PGO03_Zad2;

import java.util.ArrayList;
import java.util.List;

class ShoppingCart {
    private static int nextId = 1;
    private int id;
    private double totalPrice;
    private int totalDeliveryTime;
    private List<Product> products;

     ShoppingCart() {
        this.id = generateNextId();
        this.products = new ArrayList<>();/**/
    }

    void sell(){
        for (var product : this.products){
            product.sell();
        }
        System.out.println("Koszyk został sprzedany: " + this);
    }

    void addProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Produkt nie może być nullem");
        }

        if (!product.isAvailable()) {
            System.out.println("Produkt " + product.getName() + " nie jest dostępny");
            return;
        }

        this.products.add(product);
        this.calculatePrice();
        this.calculateDeliveryTime();
    }

    private static int generateNextId() {
        var currentId = nextId;
        nextId = nextId ++;
        return currentId;
    }

    private void calculatePrice() {
        double sum = 0;
        for (var product : this.products) {
            sum += product.getPrice();
        }

        this.totalPrice = sum;
    }

    private void calculateDeliveryTime() {
        for (var product : this.products) {
            if (product.getStorage() == null) {
                continue; // dostepny od reki
            }

            if (this.totalDeliveryTime < product.getStorage().getDeliveryTime()) {
                this.totalDeliveryTime = product.getStorage().getDeliveryTime();
            }
        }
    }

     double getTotalPrice() {
        return totalPrice;
    }

   List<Product> getProducts() {
        return products;
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "id=" + id +
                ", totalPrice=" + totalPrice +
                ", totalDeliveryTime=" + totalDeliveryTime +
                ", products=" + products +
                '}';
    }
}
