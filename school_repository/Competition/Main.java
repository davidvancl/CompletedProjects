package com.Competition;

public class Main {
    public static String startFilePath = "C:\\Users\\vancl\\Downloads\\startList.txt";
    public static String endFilePath = "C:\\Users\\vancl\\Downloads\\endList.txt";

    public static void main(String[] args) {
        Competition competition = new Competition(Main.startFilePath,Main.endFilePath);
        competition.sortByTime();
        competition.listResults();
    }
}
