package PGO03_Zad2;

class Product {
    String name;
    ProductType productType;
    double price;
    int quantity;
    Storage storage;
    boolean isAvailable;

    public Product(String name, ProductType productType, double price, int quantity, Storage storage) {
        this.name = name;
        this.productType = productType;
        this.price = price;
        this.quantity = quantity;
        this.storage = storage;

        if (storage != null) {
            this.storage.addProduct(this);
        }
    }

    void sell() {
        if (quantity > 0) {
            quantity --;
        } else {
            throw new RuntimeException("Product is not available");
        }
    }

    void increaseQuantity(int quantity) {
        if (quantity < 0 ) {
            throw new IllegalArgumentException("Nie można dodać ujemnej liczby produktów!");
        }

        this.quantity += quantity;
        System.out.println("W magazynie znajduje się " + this.quantity + " sztuk " + this.name);
    }
}
