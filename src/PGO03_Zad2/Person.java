package PGO03_Zad2;

import java.util.HashSet;
import java.util.Set;

class Person {

    private String name;
    private String surname;
    private double moneyInCash;
    private double moneyOnCard;
    private ShoppingCart currentShoppingCart;
    private Set<ShoppingCart> historyShoppingCarts;

    ShoppingCart getCurrentShoppingCart() {
        return currentShoppingCart;
    }

    Person(String name, String surname, double moneyInCash, double moneyOnCard) {
        if (Utils.isNullorEmpty(name)) {
            throw new IllegalArgumentException("Imię nie może być nullem ani puste");
        }
        if (Utils.isNullorEmpty(surname)) {
            throw new IllegalArgumentException("Nazwisko nie może byc nullem ani puste");
        }
        if (moneyInCash < 0){
            throw new IllegalArgumentException("Pieniądze nie mogą być ujemne");
        }
        if (moneyOnCard < 0){
            throw new IllegalArgumentException("Pieniądze nie mogą być ujemne");
        }

        this.name = name;
        this.surname = surname;
        this.moneyInCash = moneyInCash;
        this.moneyOnCard = moneyOnCard;
        this.historyShoppingCarts = new HashSet<>();
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", moneyInCash=" + moneyInCash +
                ", moneyOnCard=" + moneyOnCard +
                ", currentShoppingCart=" + currentShoppingCart +
                '}';
    }

    void makeOrder() {
        if (this.currentShoppingCart != null) {
            System.out.println("Masz już aktywny koszyk. Dokończ zakupy płacąc kartą lub gotówką");
            return;
        }
        this.currentShoppingCart = new ShoppingCart();
    }

    void buyByCard() {
        if (this.currentShoppingCart == null || this.currentShoppingCart.getProducts().isEmpty()) {
            System.out.println("Nie masz nic w koszyku. Zacznij zakupy uruchamiając metodę 'makeOrder'");
            return;
        }

        if (this.moneyOnCard >= this.currentShoppingCart.getTotalPrice()) {
            this.moneyOnCard = this.moneyOnCard - this.currentShoppingCart.getTotalPrice();

            this.currentShoppingCart.sell();

            this.historyShoppingCarts.add(this.currentShoppingCart);
            this.currentShoppingCart = null;
            System.out.println("Udało się zapłacić kartą");
        } else {
            System.out.println("Nie masz wystarczającej ilości pieniędzy na karcie. Spróbuj zapłacić gotówką");
        }
    }

    void buyInCash() {
        if (this.currentShoppingCart == null || this.currentShoppingCart.getProducts().isEmpty()) {
            System.out.println("Nie masz nic w koszyku. Zacznij zakupy uruchamiając metodę 'makeOrder'");
            return;
        }

        if (this.moneyInCash >= this.currentShoppingCart.getTotalPrice()) {
            this.moneyInCash = this.moneyInCash - this.currentShoppingCart.getTotalPrice();

            this.currentShoppingCart.sell();

            this.historyShoppingCarts.add(this.currentShoppingCart);
            this.currentShoppingCart = null;
            System.out.println("Udało się zapłacić gotówką");
        } else {
            System.out.println("Nie masz wystarczającej ilości gotówki. Spróbuj zapłacić kartą");
        }
    }
}