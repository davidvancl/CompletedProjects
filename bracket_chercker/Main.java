package com.brackets;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String result = loadInput();
        ArrayList<Character> bracketsArray = cutBracketsToArray(result);
        int index = 0;
        char[] tmpArray = new char[bracketsArray.size()];
        for (Character character : bracketsArray) {
            if (character == '{' || character == '[' || character == '(') {
                tmpArray[index] = character;
                index++;
            } else if (character == ')' && tmpArray[index - 1] == '(' ||
                    character == '}' && tmpArray[index - 1] == '{' ||
                    character == ']' && tmpArray[index - 1] == '[') {
                tmpArray[index - 1] = '\u0000';
                index--;
            }
        }
        System.out.println(compareArray(tmpArray) ? "1" : "0");
    }

    private static boolean compareArray(char[] array){
        for (char c : array) {
            if (c != '\u0000') {
                return false;
            }
        }
        return true;
    }

    private static ArrayList<Character> cutBracketsToArray(String input){
        ArrayList<Character> list = new ArrayList<Character>();
        for (int i = 0; i < input.length(); i++) {
            if(input.charAt(i) == '{' || input.charAt(i) == '}' ||
                    input.charAt(i) == '[' || input.charAt(i) == ']' ||
                    input.charAt(i) == '(' || input.charAt(i) == ')'){
                list.add(input.charAt(i));
            }
        }
        return list;
    }

    private static String loadInput() {
        StringBuilder builder = new StringBuilder();
        if (scanner.next().toLowerCase().equals("begin")) {
            String input;
            while (!(input = scanner.next().toLowerCase()).equals("end")) {
                if (input.contains("end")) {
                    builder.append(input.replace("end", ""));
                    break;
                } else {
                    builder.append(input);
                }
            }
        }
        return builder.toString();
    }
}