package com.Hurricane;

public class Main {

    public static void main(String[] args) {
	    HurricaneMachine hurricaneMachine = new HurricaneMachine("C:\\Users\\vancl\\Downloads\\hurricanedata.txt"); //LOAD
	    hurricaneMachine.sortHurricanes(); //SORT - SPEED
//	    hurricaneMachine.listAll(); //LIST ALL
//        hurricaneMachine.listSpecific(1995,2001); //LIST SPECIFIC
        hurricaneMachine.listSpecific("Danielle");
    }
}
