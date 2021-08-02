package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        String textToCheck1 = "O, ty z Katowic, Iwo? Tak, Zyto.";
        String textToCheck2 = "O, z Katowic, Iwo? Nie, Zyto.";
        boolean isTextPalindrome;
        int intToCheck1 = 12321;
        int intToCheck2 = 12343;


        List<Object> list = new ArrayList<Object>();
        list.add(textToCheck1);
        list.add(intToCheck1);
        list.add(textToCheck2);
        list.add(intToCheck2);

        for (Object el: list) {
            isTextPalindrome = isThisTextPalindrome(el.toString());
            if (isTextPalindrome) {
                System.out.println("This is " + isTextPalindrome + ". This \"" + el.toString() + "\" is a palindrome");
            } else {
                System.out.println("This is " + isTextPalindrome + ". This \"" + el.toString() + "\" is not a palindrome");
            }
        }
    }

    public static boolean isThisTextPalindrome(String someText){
        String reverseStr = "";
        boolean isTextPalindrome;
        String noComma =someText.replace(",", "");
        String noDot = noComma.replace(".", "");
        String noQuestion = noDot.replace("?", "");
        String noSpaces= noQuestion.replace(" ", "");
        int strLength = noSpaces.length();

        for (int i = (strLength - 1); i >=0; --i) {
            reverseStr = reverseStr + noSpaces.charAt(i);
        }

        if(noSpaces.toLowerCase().equals(reverseStr.toLowerCase())){
            isTextPalindrome = true;
        } else {
            isTextPalindrome = false;
        }
        return isTextPalindrome;
    }
}
