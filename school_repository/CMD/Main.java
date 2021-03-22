package com.CMD;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        CMD cmd = new CMD(System.getProperty("user.dir"));
//        cmd.cd("..");
//        cmd.cd("DiscordBots");
//        cmd.dir();
//        cmd.createFolder("TEST");
//        cmd.help();
        cmd.recursiveScan(new File(System.getProperty("user.dir")));
    }
}
