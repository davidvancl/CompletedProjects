package com.Calendar;


public abstract class CalendarCustom {
    private static final String[] days = {"po","út","st","čt","pá","so","ne"};
    private static final String[] months = {"Leden","Únor","Březen","Duben","Květen","Červen","Červenec","Srpen","Září","Říjen","Listopad","Prosinec"};
    private static final int[] numbersMonths = {31,28,31,30,31,30,31,31,30,31,30,31};

    public static int getNumberMonth(String month){
        for(int i = 0;i< CalendarCustom.months.length;i++){
            if(month.equals(CalendarCustom.months[i])){
                return i + 1;
            }
        }
        return 0;
    }

    public static String getTextMonth(int month){
        if(month > CalendarCustom.months.length || month <= 0){
            return "Neplatný výstup.";
        } else {
            return CalendarCustom.months[month - 1];
        }
    }

    public static void printCalendar(int month,int year){
        StringBuilder resultCalendar = new StringBuilder();
        for (int i = 0;i < CalendarCustom.days.length;i++){
            if(i == (CalendarCustom.days.length - 1)){
                resultCalendar.append(CalendarCustom.days[i]).append("\n");
            } else {
                resultCalendar.append(CalendarCustom.days[i]).append(" ");
            }
        }

        int m;
        if(month == 1){
            m = 13;
        } else if (month == 2){
            m = 14;
        } else {
            m = month;
        }

        int K = year % 100;
        if(month == 1 || month == 2){
            K--;
        }

        int J = year / 100;

        int h = ( 1 + ((13 * (m + 1)/5) + K + (K / 4) + (J / 4) - (2 * J))) % 7;
        int d = ((h + 5) % 7) + 1;

        int c  = 1 - (d - 1);
        for (int i = 0;i < 6;i++){
                for (int j = 0; j < CalendarCustom.days.length; j++) {
                    if(c <= CalendarCustom.numbersMonths[month - 1]) {
                        if(c < 1) {
                            resultCalendar.append(" ").append(" ").append(" ");
                        } else {
                            if (c < 10) {
                                resultCalendar.append("0").append(c).append(" ");
                            } else {
                                resultCalendar.append(c).append(" ");
                            }
                        }
                        c++;
                    }
                }
                resultCalendar.append("\n");
        }
        System.out.println(resultCalendar);
    }
}
