package com.projectAirlines.Tools;

public abstract class ProjectPath {
    public static String getProjectPath(){
        return System.getProperty("user.dir") + "\\";
    }

    public static String getGraphicPath(String file){
        return getProjectPath() + "Graphic\\" + file;
    }

    public static String getAirplanesPath(String file){
        return getProjectPath() + "Graphic\\Airplanes\\" + file;
    }

    public static String getIconsPath(String file){
        return getProjectPath() + "Graphic\\Icons\\" + file;
    }

    public static String getConfigFilePath(String file){
        return getProjectPath() + "Config\\" + file;
    }

    public static String getMusicPath(String file){
        return getProjectPath() + "Music\\" + file;
    }
}
