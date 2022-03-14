package Zad7;

import java.util.Scanner;

public class Zadadnie7 {

    /*
    Odczytaj liczbę od użytkownika i zapisz ją w zmiennej o nazwie n.
N powinno być co najmniej 5 i liczbą nieparzystą. Jeśli użytkownik wprowadzi błędnie,
poproś, aby spróbował ponownie, aż warunek zostanie spełniony.
Wydrukuj rysunek używając znaku * o rozmiarze n. Na przykład, jeśli n wynosi 5:
*****
** *
* * *
* **
*****
     */
    public static void main(String[] args) {
        System.out.print("Give a number: ");
        int n = readUserNumber();

        System.out.println("\n\nYou gave: " + n);

        boolean isValid = isValid(n);
        System.out.println("Is your number valid: " + isValid);
    }

    static int readUserNumber() {
        Scanner sc= new Scanner(System.in);
        int number = sc.nextInt();
        return number;
    }

    static boolean isValid(int number) {
        if(number < 5) {
            return false;
        }
        if(number % 2 == 1){
            return true;
        } else {
            return false;
        }
    }

    static void printPicture(int size) {

    }
}
