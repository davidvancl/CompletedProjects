package com.Bank;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Person extends Client {

    public Person(String name){
        this.name = name;
    }

    public String getInfo(){
        Pattern pattern = Pattern.compile("(ová|ova){1}$");
        Matcher matcher = pattern.matcher(this.name);
        if(matcher.find()){
            return "paní " + this.name;
        } else {
            return "pan " + this.name;
        }
    }
}
