package PGO03_Zad2;

class Product {
    private String name;
    private ProductType productType;
    private double price;
    private int quantity;
    private Storage storage;
    private boolean isAvailable;

    Product(String name, ProductType productType, double price, int quantity, Storage storage) {
        if (Utils.isNullorEmpty(name)){
            throw new IllegalArgumentException("Nazwa produktu nie może być pusta albo nullem");
        }
        if (productType == null) {
            throw new IllegalArgumentException("Produkt type nie może byc nullem");
        }
        if (price < 0) {
            throw new IllegalArgumentException("Cena nie może być ujemne");
        }
        if (quantity < 0){
            throw new IllegalArgumentException("Ilość nie moża być ujemna");
        }

        this.name = name;
        this.productType = productType;
        this.price = price;
        this.quantity = quantity;
        this.storage = storage;
        this.calculateAvailability();

        if (storage != null) {
            this.storage.addProduct(this);
        }
    }

    void sell() {
        if (quantity > 0) {
            quantity --;
            this.calculateAvailability();
        } else {
            System.out.println("Produkt " + this.name + " nie jest dostępny");
            return;
        }
    }

    void increaseQuantity(int quantity) {
        if (quantity < 0 ) {
            throw new IllegalArgumentException("Nie można dodać ujemnej liczby produktów!");
        }

        this.quantity += quantity;
        this.calculateAvailability();
        System.out.println("Dostawa. W magazynie znajduje się teraz " + this.quantity + " sztuk " + this.name);
    }

    boolean isAvailable() {
        return isAvailable;
    }

    String getName() {
        return name;
    }

    double getPrice() {
        return price;
    }

    Storage getStorage() {
        return storage;
    }

    private void calculateAvailability(){
        isAvailable = this.quantity > 0;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", productType=" + productType +
                ", price=" + price +
                ", quantity=" + quantity +
                ", storage=" + storage +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
