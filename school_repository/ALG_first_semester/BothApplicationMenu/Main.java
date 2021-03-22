package com.bothApplicationMenu;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        boolean repeat = true;
        while (repeat) {
            switch (getAction()) {
                case 1:
                    new MagicanSquare();
                    break;
                case 2:
                    new CombinatoricSelections();
                    break;
                default:
                    repeat = false;
                    break;
            }
            if(!repeat){
                break;
            }
        }
    }

    private static int getAction(){
        System.out.println("1. Magický čtverec \n" +
                "2. Kombinatorické výběry");
        return scanner.nextInt();
    }
}
