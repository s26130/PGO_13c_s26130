package PGO03_Zad2;

public class Main {

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

    }
}
