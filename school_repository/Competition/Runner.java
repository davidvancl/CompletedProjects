package com.Competition;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Runner implements Comparable<Runner> {
    public final static DateTimeFormatter startFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
    public final static DateTimeFormatter endFormatter = DateTimeFormatter.ofPattern("HH:mm:ss:SS");

    private int personalNumber;
    private String firstName;
    private String lastName;
    private String field;
    private String club;

    private LocalTime startTime;
    private LocalTime endTime;

    public Runner(String dataLine){
        this.cutData(dataLine);
    }

    private void cutData(String data){
        String[] dataArray = data.split("[\\s]([ ]{0,})[\\s]");
        this.personalNumber = Integer.parseInt(dataArray[0]);
        String[] tmp = dataArray[1].split(" ");
        this.lastName = tmp[0];
        this.firstName = tmp[1];
        this.field = dataArray[2];
        this.club = dataArray[3];
        this.startTime = LocalTime.parse(dataArray[4].replace(" ","").replace("\\.",""),Runner.startFormatter);
    }

    public void setEndTime(String endTime) {
        this.endTime = LocalTime.parse(endTime,Runner.endFormatter);
    }

    @Override
    public String toString() {
        return "Runner{" +
                "personalNumber=" + personalNumber +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", field='" + field + '\'' +
                ", club='" + club + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }

    public int getPersonalNumber() {
        return personalNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getField() {
        return field;
    }

    public String getClub() {
        return club;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    @Override
    public int compareTo(Runner o) {
        return this.endTime.compareTo(o.endTime);
    }
}
