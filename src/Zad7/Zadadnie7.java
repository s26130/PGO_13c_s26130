package Zad7;

import java.util.Scanner;

public class Zadadnie7 {

    static final char CHAR = '*';

    public static void main(String[] args) {

        int n = 0;

        do {
            System.out.print("Give a number: ");
            n = readUserNumber();
        } while (! isValid(n));

        printPicture(n);

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
        printBar(size);

        // rows
        for (int row = 0; row < size; row++)
        {
            // cols
            for (int col = 0; col < size; col++){
                if (col == 0) {
                    System.out.print(CHAR);
                }

                if (col > 0 && col < size -1) {
                    if (row == col) {
                        System.out.print(CHAR);
                    } else {
                        System.out.print(' ');
                    }
                }

                if (col == size -1) {
                    System.out.println(CHAR);
                }
            }
        }

         printBar(size);
    }

    static void printBar(int size) {
        for (int i = 0; i < size; i++) {
            System.out.print(CHAR);
        }
        System.out.println();
    }
}
