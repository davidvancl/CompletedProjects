package com.Hurricane;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class HurricaneMachine {
    private ArrayList<HurricaneModel> hurricanes = new ArrayList<>();
    private String pathToFile = "";

    public HurricaneMachine(String path){
        this.setPath(path);
        this.loadData();
    }

    public void setPath(String pathToFile){
        this.pathToFile = pathToFile;
    }

    public void loadData(){
        try(BufferedReader br = new BufferedReader(new FileReader(new File(this.pathToFile)))) {
            for(String line; (line = br.readLine()) != null; ) {
                if(!line.trim().equals("")) {
                    hurricanes.add(new HurricaneModel(line));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sortHurricanes(){
        Collections.sort(this.hurricanes);
    }

    public void listAll(){
        for(HurricaneModel model : this.hurricanes){
            System.out.println(model.toString());
        }
    }

    public void listSpecific(int from,int to){
        for(HurricaneModel model : this.hurricanes){
            if(model.getYear() >= from && model.getYear() <= to) {
                System.out.println(model.toString());
            }
        }
    }

    public void listSpecific(String name){
        for(HurricaneModel model : this.hurricanes){
            if(model.getName().equals(name)) {
                System.out.println(model.toString());
            }
        }
    }
}
