package com.company;

import java.lang.reflect.Array;
import java.util.*;

public class MaxMin {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("How many numbers do you want to enter?");
        int numbers = scanner.nextInt();
        int[] tab = new int[numbers];
        for (int i = 0; i < numbers; i++) {
            System.out.println("Enter next number:");
            tab[i] = scanner.nextInt();
        }
        int min = tab[0];
        int max = tab[0];
        for (int j : tab) {
            if (j < min) {
                min = j;
            }
            if (j > max) {
                max = j;
            }
        }
        System.out.println("Minimum is: " + min);
        System.out.println("Maximum is: " + max);
    }
}
