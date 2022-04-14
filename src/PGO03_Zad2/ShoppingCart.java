package PGO03_Zad2;

import java.util.List;



class ShoppingCart {
    private static int nextId = 1;
    int id;
    double totalPrice;
    int totalDeliveryTime;
    List<Product> products;

    public ShoppingCart(List<Product> products) {
        if (products == null) {
            throw new IllegalArgumentException("Lista produktów nie może byc nullem");
        }
        this.id = generateNextId();
        this.products = products;

        this.calculatePrice();
        this.calculateDeliveryTime();
    }

    void sell(){
        for (var product : this.products){
            product.sell();
        }
    }

    private static int generateNextId() {
        var currentId = nextId;
        nextId = nextId ++;
        return currentId;
    }

    private void calculatePrice() {
        double sum = 0;
        for (var product : this.products) {
            sum += product.price;
        }

        this.totalPrice = sum;
    }

    private void calculateDeliveryTime() {
        for (var product : this.products) {
            if (product.storage == null) {
                continue; // dostepny od reki
            }

            if (this.totalDeliveryTime < product.storage.deliveryTime) {
                this.totalDeliveryTime = product.storage.deliveryTime;
            }
        }
    }
}
