package PGO03_Zad2;

class Product {
    String name;
    ProductType productType;
    double price;
    int quantity;
    Storage storage;

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

    boolean isAvailable() {
        return quantity > 0;
    }

    // TODO:
    void sell() {
        System.out.println("not implemented yet");
    }

    // TODO:

    void increaseQuantity(int quantity) {
        System.out.println("not implemented yet");
    }

}
