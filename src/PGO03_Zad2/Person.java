package PGO03_Zad2;

import java.util.Collections;
import java.util.Set;

class Person {

    String name;
    String surname;
    double moneyInCash;
    double moneyOnCard;
    ShoppingCart currentShoppingCart;
    Set<ShoppingCart> historyShoppingCarts;

    public Person(String name, String surname, double moneyInCash, double moneyOnCard) {
        this.name = name;
        this.surname = surname;
        this.moneyInCash = moneyInCash;
        this.moneyOnCard = moneyOnCard;
        this.historyShoppingCarts = Collections.emptySet();
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
        if (this.currentShoppingCart == null) {
            System.out.println("Nie masz nic w koszyku. Zacznij zakupy uruchamiając metodę 'makeOrder'");
            return;
        }

        if (this.moneyOnCard >= this.currentShoppingCart.totalPrice) {
            this.moneyOnCard = this.moneyOnCard - this.currentShoppingCart.totalPrice;
            this.historyShoppingCarts.add(this.currentShoppingCart);
            this.currentShoppingCart = null;
        } else {
            System.out.println("Nie masz wystarczającej ilości pieniędzy na karcie. Spróbuj zapłacić gotówką");
        }
    }

    void buyInCash() {
        if (this.currentShoppingCart == null) {
            System.out.println("Nie masz nic w koszyku. Zacznij zakupy uruchamiając metodę 'makeOrder'");
            return;
        }

        if (this.moneyInCash >= this.currentShoppingCart.totalPrice) {
            this.moneyInCash = this.moneyInCash - this.currentShoppingCart.totalPrice;
            this.historyShoppingCarts.add(this.currentShoppingCart);
            this.currentShoppingCart = null;
        } else {
            System.out.println("Nie masz wystarczającej ilości gotówki. Spróbuj zapłacić kartą");
        }

    }

}