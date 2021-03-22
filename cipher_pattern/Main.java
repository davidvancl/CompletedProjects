package com.cipherPattern;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static String abdString = "QWERTYUIOPASDFGHJKLZXCVBNM ";
    private static char[] abd = abdString.toCharArray();

    public static void main(String[] args) {
        int todo = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < todo; i++) {
            String message = scanner.nextLine();
            String key = scanner.nextLine();

            boolean isPossible = false;
            for (int j = 1; j < abdString.length(); j++) {
                String encrypted = encryptedMessage(message,j);
                if(encrypted.contains(key)){
                    isPossible = true;
                    break;
                }
            }
            System.out.println(isPossible ? "Vyskyt vzorku je mozny" : "Vyskyt vzorku neni mozny");
        }
    }

    private static String encryptedMessage(String message, int k){
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            int newIndex = abdString.indexOf(message.charAt(i)) - k;
            if(newIndex < 0){
                newIndex = abdString.length() + newIndex;
            }
            builder.append(abdString.charAt(newIndex));
        }
        return builder.toString();
    }
}