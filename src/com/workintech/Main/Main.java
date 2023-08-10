package com.workintech.Main;

import java.sql.SQLOutput;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {


        System.out.println("===========STACK====================");

        System.out.println(checkForPalindrome("abccba"));
        System.out.println(checkForPalindrome("Was it a car or a cat I saw ?"));
        System.out.println(checkForPalindrome("I did, did I?"));
        System.out.println(checkForPalindrome("hello"));
        System.out.println(checkForPalindrome("Don't node"));

        System.out.println("===========STACK & QUEUE===========");

        System.out.println(checkForPalindrome2("abccba"));
        System.out.println(checkForPalindrome2("Was it a car or a cat I saw ?"));
        System.out.println(checkForPalindrome2("I did, did I?"));
        System.out.println(checkForPalindrome2("hello"));
        System.out.println(checkForPalindrome2("Don't node"));

        System.out.println("===========DECIMAL TO BINARY===========");

        int decimalNumber = 13;
        String binaryNumber = convertToBinary(decimalNumber);
        System.out.println("Decimal: " + decimalNumber + " -> Binary: " + binaryNumber);
    }



    public static boolean checkForPalindrome(String text) {
        String processedText = text.toLowerCase(Locale.ENGLISH).replaceAll("[^a-zA-Z0-9]", ""); // Sadece harf ve rakamları al, büyük harfleri küçük harfe çevir

        Stack<Character> stack = new Stack<>();
        int halfLength = processedText.length() / 2;

        for (int i = 0; i < halfLength; i++) {
            stack.push(processedText.charAt(i));
        }

        int startIndex = halfLength;
        if (processedText.length() % 2 == 1) {
            startIndex++;
        }

        for (int i = startIndex; i < processedText.length(); i++) {
            if (stack.isEmpty() || stack.pop() != processedText.charAt(i)) {
                return false;
            }
        }


        return stack.isEmpty();
    }

    public static boolean checkForPalindrome2(String text) {
        String processedText = text.toLowerCase(Locale.ENGLISH).replaceAll("[^a-zA-Z0-9]", ""); // Sadece harf ve rakamları al, büyük harfleri küçük harfe çevir

        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();

        for (char c : processedText.toCharArray()) {
            stack.push(c);
            queue.offer(c);
        }

        while (!stack.isEmpty()) {
            if (!stack.pop().equals(queue.poll())) {
                return false;
            }
        }

        return true;
    }

    public static String convertToBinary(int decimal) {
        Stack<Integer> stack = new Stack<>();

        while (decimal > 0) {
            int remainder = decimal % 2;
            stack.push(remainder);
            decimal /= 2;
        }

        StringBuilder binaryBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            binaryBuilder.append(stack.pop());
        }

        return binaryBuilder.toString();
    }
}
