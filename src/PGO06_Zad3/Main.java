package PGO06_Zad3;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final DecimalFormat df = new DecimalFormat("0.0");
    public static void main(String[] args) {
        List<Function> functions = new ArrayList<>();
        functions.add(new LinearFunction(2,4));
        functions.add(new SquareFunction(2,0,-2.5));
        functions.add(new AbsoluteLinearFunction(2,4));
        List<Fun> funList = new ArrayList<>(functions);
        System.out.println("Original functions");
        funList.forEach(f ->
                System.out.println(df.format(Fun.minimum(f,-4,0,0.1))));
        functions.forEach(f -> f.increaseCoefficientsBy(1.2));
        System.out.println("Functions increased by 1.2");
        funList.forEach(f ->
                System.out.println(df.format(Fun.minimum(f,-4,0,0.1))));
        functions.forEach(f -> f.decreaseCoefficientsBy(1.2));
        System.out.println("Functions decreased by 1.2");
        funList.forEach(f ->
                System.out.println(df.format(Fun.minimum(f,-4,0,0.1))));



        // możemy utworzyć klasę anonimową. Oznacza to, że tworzymy instancję interfejsu,
        // ale dysponujemy nim tylko w miejscu gdzie powstał - jeśli nie ma sensu reużywać go
        // (bo na przykład jest bardzo specyficzny) to możemy dokonać tego w locie.
        // Tak naprawdę jest tu tworzona klasa (ale anonimowa), tyle, że nigdzie nie
        // używamy `implements`
        var dziwnaFunkcja = new Fun() {
            @Override
            public double f(double x) {
                return x + 3 - Math.sqrt(x);
            }
        };

        // musimy jedynie zaimplementować metody interfejsu. Następnie możemy odwoływać się
        // do klasy anonimowej, tak samo jak by była to utrwalona instancja.
        System.out.println("Dzina funkcja");
        System.out.println(dziwnaFunkcja.f(10));


    }
}