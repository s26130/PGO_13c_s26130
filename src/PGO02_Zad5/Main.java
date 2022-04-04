package PGO02_Zad5;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Address domMickiewicza = new Address("Poland", "Nowogródek", "-", 19, 29);
        Person  mickiewicz = new Person("Adam","Mickiewicz", LocalDate.of(1798, 12, 24), domMickiewicza);

        Person osobaZUlicy = new Person("Jan", "Kowalski", LocalDate.of(2000, 12, 23), null);


        Book panTadeusz = new Book("Pan Tadeusz", Genre.Classic,  Lang.Polish, LocalDate.of(1834,6,28));
        Book dziady2 = new Book("Dziady II", Genre.Classic,  Lang.Polish, LocalDate.of(1823,6,28));
        Book dziady4 = new Book("Dziady IV", Genre.Classic,  Lang.Polish, LocalDate.of(1823,6,28));
        Book dziady3 = new Book("Dziady III", Genre.Classic,  Lang.Polish, LocalDate.of(1832,6,28));
        Book dziady1 = new Book("Dziady I", Genre.Classic,  Lang.Polish, LocalDate.of(1860,6,28));

        mickiewicz.publishBook(panTadeusz);

        try {
            mickiewicz.publishBook(null);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        panTadeusz.borrowBook(osobaZUlicy);
    }

}
