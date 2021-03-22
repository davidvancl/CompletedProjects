package com.Hurricane;

public class HurricaneModel implements Comparable<HurricaneModel>{
    private String name;
    private String month;
    private String SSScale;
    private String warning;
    private int year;
    private int pressure;
    private int speed;
    private double speedInKM;

    public HurricaneModel(String dataLine){
        this.prepareData(dataLine);
    }

    private void prepareData(String dataLine){
        String[] tmpArray = dataLine.split("\\s");
        if(tmpArray.length >= 4) {
            this.year = Integer.parseInt(tmpArray[0]);
            this.month = tmpArray[1];
            this.pressure = Integer.parseInt(tmpArray[2]);
            this.speed = Integer.parseInt(tmpArray[3]);
            this.name = tmpArray[4];
        }
        this.speedInKM = this.speed * 1.852;
        this.checkSSScale();
    }

    private void checkSSScale(){
        if(this.speedInKM >= 252){
            this.SSScale = "Category 5";
            this.warning = "Many buildings destroyed, major roads cut off.";
        } else if(this.speedInKM >= 209){
            this.SSScale = "Category 4";
            this.warning = "Severe damage to well-built homes,trees blown over.";
        } else if(this.speedInKM >= 175){
            this.SSScale = "Category 3";
            this.warning = "Well-built homes suffer major damage.";
        } else if(this.speedInKM >= 154){
            this.SSScale = "Category 2";
            this.warning = "Extensive damage.";
        } else if(this.speedInKM >= 119){
            this.SSScale = "Category 1";
            this.warning = "Some damage and power cuts.";
        }
    }

    @Override
    public String toString() {
        return "HurricaneModel{" +"name='" + name + '\'' +", month='" + month + '\'' +
                ", year=" + year +
                ", pressure=" + pressure +
                ", speed=" + speed +
                ", speedInKM=" + String.format("%.2f", speedInKM) +
                ", category=" + SSScale +
                ", message=" + warning +
                '}';
    }

    public String getSSScale() {
        return SSScale;
    }

    public String getWarning() {
        return warning;
    }

    public double getSpeedInKM() {
        return speedInKM;
    }

    public String getName() {
        return name;
    }

    public String getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public int getPressure() {
        return pressure;
    }

    public int getSpeed() {
        return speed;
    }

    @Override
    public int compareTo(HurricaneModel o) {
        if(this.speed > o.speed){
            return -1;
        } else {
            return 1;
        }
    }
}
