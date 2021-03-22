package com.CMD;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CMD {
    private Path path;
    public CMD(String path){
        this.setPath(Paths.get(path));
    }

    public void dir(){
        this.dir("");
    }

    public void dirO(String fileName){
        this.dir("-o " + fileName);
    }

    public void dirE(String fileName){
        this.dir("-e " + fileName);
    }

    public void dirS(String fileName){
        this.dir("-s " + fileName);
    }

    public void cd(String param){
        boolean error = false;
        if(!param.contains("..")) {
            error = setPath(Paths.get(this.path.toString() + "\\" + param));
        } else {
            String regexp = "([^\\\\]+$)";
            String tmp = this.path.toString().replaceAll(regexp,"");
            String newUrl = tmp.substring(0,tmp.length() - 1);
            error = setPath(Paths.get(newUrl));
        }
        if(error){
            System.out.println("Bad address");
        }
    }

    private void dir(String param){
        this.executeProcess("(dir " + param + ")");
    }

    public void createFolder(String folderName){
        this.executeProcess("(mkdir " + folderName + ")");
    }

    public void renameFiles(String oldName,String newName){
        this.executeProcess("(rename " + oldName + " " + newName + " )");
    }

    public void help(){
        this.executeProcess("(help)");
    }

    private void executeProcess(String param){
        try {
            ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "cd " + this.path.toString() + " && " + param);
            builder.redirectErrorStream(true);
            Process p = builder.start();
            BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while (true) {
                line = r.readLine();
                if (line == null) {
                    break;
                }
                System.out.println(line);
            }
        } catch (IOException e){
            System.out.println(e.toString());
        }
    }

    public boolean setPath(Path path){
        if (Files.exists(path)) {
            this.path = path;
            return true;
        }
        return false;
    }

    public void recursiveScan(File location){
        recursiveScan(location,"-");
    }


    public void recursiveScan(File location,String level){
        File[] pathNames = location.listFiles();
        assert pathNames != null;
        for (File pathname : pathNames) {
            if(pathname.isDirectory()){
                recursiveScan(new File(pathname.getParent() + File.separator + pathname.getName()),level + "-");
            }
            System.out.println(level + " " + pathname.getName());
        }
    }
}