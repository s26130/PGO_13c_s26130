package PGO03_Zad2;

 class Main {

    public static void main(String[] args) {
        var p1 = new Person("Jan", "Kowalski", 0.0, 10_000.0);
        var p2 = new Person("Ania", "Leśoń", 0.0, 10_000.0);
        var p3 = new Person("Piotr", "Sulowski", 1_230.50, 550.0);
        var p4 = new Person("Adam", "Andrzejowicz", 100_000.00, 0);
        var p5 = new Person("Andrzej", "Adamowicz", 52.0, 0);

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println(p4);
        System.out.println(p5);

        var storageA1 = new Storage(1);
        var storageCE54 = new Storage(30);


        var product1 = new Product("Cisowianka", ProductType.Consumable, 1.69, 1, null);
        var product2 = new Product("Kinder Bueno", ProductType.Consumable, 3.21, 1000, storageA1);
        var product3 = new Product("Bilet do kina", ProductType.Entertainment, 34, 1000, null);
        var product4 = new Product("Sokowirówka", ProductType.Electronic, 167, 500, storageCE54);

        validatePerson();
        validateProduct();


        System.out.println("\n TEST \n");
        p1.buyByCard();
        p1.buyInCash();

        p1.makeOrder();
        var cart = p1.getCurrentShoppingCart();
        cart.addProduct(product1);
        cart.addProduct(product1);
        cart.addProduct(product1);

        product1.increaseQuantity(5);

        cart.addProduct(product1);
        cart.addProduct(product2);
        cart.addProduct(product3);
        cart.addProduct(product4);

        p1.buyInCash(); // brakuje pieniędzy
        p1.buyByCard(); // ok


    }

    private static void validateProduct() {
        try {
            new Product("", ProductType.Consumable, 1.69, 1000, null);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            new Product("Cisowianka", null, 1.69, 1000, null);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            new Product("Cisowianka", ProductType.Consumable, -1.69, 1000, null);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            new Product("Cisowianka", ProductType.Consumable, 1.69, -1000, null);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }

    private static void validatePerson() {
        try {
            new Person("     ", "Kowalski", 0.0, 10_000.0);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            new Person("Jan", "   ", 0.0, 10_000.0);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            new Person("Jan", "Kowalski", -50.0, 10_000.0);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            new Person("Jan", "Kowalski", 50.0, -10_000.0);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }








}
