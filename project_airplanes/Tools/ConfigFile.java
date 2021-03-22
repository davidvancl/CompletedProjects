package com.projectAirlines.Tools;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public abstract class ConfigFile {
    private static String pathConfig = ProjectPath.getConfigFilePath("cfg.txt");

    private static List<String> readConfigFile() throws IOException {
        List<String> fileLines = new ArrayList<String>();
        try (BufferedReader br = new BufferedReader(new FileReader(new File(pathConfig)))) {
            String line;
            while ((line = br.readLine()) != null) {
                fileLines.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return fileLines;
    }

    public static String loadData(String regExp) throws IOException {
        List<String> lines = readConfigFile();
        for (int i = 0; i < lines.size(); i++) {
            if(lines.get(i).contains(regExp)){
                String[] tmp = lines.get(i).split("=");
                return tmp[1];
            }
        }
        return null;
    }

    public static void saveConfig(String regExp,String value) throws IOException {
        List<String> lines = readConfigFile();
        for (int i = 0; i < lines.size(); i++) {
            if(lines.get(i).contains(regExp)){
                String[] tmp = lines.get(i).split("=");
                tmp[1] = value;
                String result = tmp[0] + "=" + tmp[1];
                lines.set(i,result);
            }
        }

        PrintWriter writer = new PrintWriter(pathConfig, StandardCharsets.UTF_8);
        for (int i = 0; i < lines.size(); i++) {
            writer.println(lines.get(i));
        }
        writer.close();
    }
}