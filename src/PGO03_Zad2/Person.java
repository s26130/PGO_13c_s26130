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
                ", historyShoppingCarts=" + historyShoppingCarts +
                '}';
    }

    // TODO:
    void makeOrder(){
        System.out.println("not implemented yet");
    }
   void buyByCard(){
       System.out.println("not implemented yet");
   }
   void buyInCash(){
       System.out.println("not implemented yet");
   }
}
