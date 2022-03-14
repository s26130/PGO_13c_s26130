package Zad6;

import java.util.Arrays;
import java.util.Random;

public class Zadanie6 {

    public static void main(String[] args) {
        int[] tablicaTestowa = generateArray(15);

        System.out.println("New array:");
        printArray(tablicaTestowa);

        int[] sortedArray = sortArray(tablicaTestowa);
        System.out.println("");
        System.out.println("Sorted array:");
        printArray(sortedArray);
    }

    static int[] sortArray(int[] arr) {
        Arrays.sort(arr);

        return arr;
    }

    static int[] generateArray(int itemsNumber) {
        int[] arr = new int[itemsNumber];

        for(int i = 0; i < itemsNumber; i++ ) {
            arr[i] = generateNumber(100, 1000);
        }

        return arr;
    }

    static int generateNumber(int min, int max) {
        Random random = new Random();

        int value = random.nextInt(min, max + 1);

        return value;
    }

    static void printArray(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);

            if (i != arr.length - 1) {
                System.out.print(", ");
            }
        }
    }
}
