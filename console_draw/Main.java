package com.emgineer.ConsoleDraw;

import java.io.IOException;
import java.util.Scanner;

public class Main{
    private static DrawText drawTextMachine = new DrawText();
    private static DrawImage drawImageMachine = new DrawImage();
    private static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        boolean cont = true;
        while(cont) {
            System.out.println("Vyber operaci {obrazek => namaluje obrazek}, {text => vykresli text} jako ASCII art");
            String input = scan.nextLine();
            cls();
            switch (input){
                case "text":
                    System.out.println("Zadej text k vypsani");
                    String text = scan.nextLine();
                    drawTextMachine.createTextImage(text);
                    break;
                case "obrazek":
                    System.out.println("Zadej cestu k obrazku");
                    String path = scan.nextLine();
                    drawImageMachine.createImage(path);
                    break;
                default:
                    if (input.equals("exit")){
                        cont = false;
                    }
                    break;
            }
        }
    }

    public static void cls()
    {
        try
        {
            new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
        }
        catch(final Exception e)
        {
            System.out.print(e);
        }

    }

}
