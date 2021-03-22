package com.Competition;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Competition {
    private ArrayList<Runner> runners = new ArrayList<>();
    private Random random = new Random();

    public Competition(String startFile,String endFile){
        this.loadStartList(startFile);
        this.loadResults(endFile);

//        this.createTempFinalFile();
    }

    private void loadStartList(String startFile){
        String thisLine = null;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(startFile)));
            while ((thisLine = br.readLine()) != null) {
                runners.add(new Runner(thisLine));
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    private void loadResults(String endFile){
        String thisLine = null;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(endFile)));
            while ((thisLine = br.readLine()) != null) {
                String[] dataArray = thisLine.split("[\\s]([ ]{0,})[\\s]");
                for(Runner runner : runners){
                    if(runner.getPersonalNumber() == Integer.parseInt(dataArray[0])){
                        runner.setEndTime(dataArray[2]);
                        break;
                    }
                }

            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    private void createTempFinalFile(){
        String formatStr = "%-5s %-30s %-15s %n";
        StringBuilder output = new StringBuilder();

        for (Runner runner : runners){
            int min = (30 + random.nextInt(30));
            int sec = (random.nextInt(60));
            int mil =  (random.nextInt(60));
            String finalTime = "10:"+ String.format("%02d", min) + ":" + String.format("%02d", sec) + ":" + String.format("%02d", mil);
            output.append(String.format(formatStr,runner.getPersonalNumber(),runner.getFirstName()+ " " + runner.getLastName(),finalTime));
        }

        try {
            File file = new File(Main.endFilePath);
            FileWriter fileWriter = new FileWriter(file, false);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(output.toString());
            bufferedWriter.close();
        } catch (Exception e) {
        }
    }

    public void sortByTime(){
        Collections.sort(runners);
    }

    public void listResults(){
        String formatStr = "%-5s %-5s %-30s %-5s %-15s %-15s %-15s";
        System.out.println(String.format(formatStr,"Poz.","Č.","Jméno přijmení","Obor","Klub","Čas startu","Čas doběhu"));
        System.out.println("----------------------------------------------------------------------------------------------");
        int i = 1;
        for(Runner runner : this.runners){
            System.out.println(String.format(formatStr,i,runner.getPersonalNumber(),runner.getFirstName()+ " " + runner.getLastName(),runner.getField(),runner.getClub(),runner.getStartTime(),runner.getEndTime()));
            i++;
        }
    }
}
