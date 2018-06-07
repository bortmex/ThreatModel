package ru.javaproject.threatmodel.util;

import javax.xml.soap.SAAJResult;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetLowMediumHigh {
    public static String get(Integer number, Integer[][] map,Integer[][] mapUser, Integer numverQuestion){
        if(number==1){
            if (mapUser[numverQuestion].length!=0){
                switch (map[numverQuestion][mapUser[numverQuestion][0]]) {
                    case 0: return "Низкий";
                    case 1: return "Средний";
                    case 2: return "Высокий";
                }
            }
        } return "";
    }

    public static Integer getNumber(String x1){
        if(x1.equals("Низкий")) return 0;
        if(x1.equals("Средний")) return 1;
        if(x1.equals("Высокий")) return 2;
        return -1;
    }

    public static String getActial(Integer x1){
        if(x1==0) return "неактуальный";
        if(x1==1) return "актуальный";
        return "";
    }

    public static String getMax(String[] x1){
        Integer[] arr = new Integer[x1.length];

        for (int i = 0; i < x1.length; i++) {
            if(x1[i].equals("Низкий")) arr[i] = 0;
            else if(x1[i].equals("Средний")) arr[i] = 1;
            else if(x1[i].equals("Высокий")) arr[i] = 2;
            else arr[i] = -1;
        }

        int maxi = Arrays.stream(arr).max(Integer::compareTo).get();
        if(maxi==0) return "Низкий";
        else if(maxi==1) return "Средний";
        else if(maxi==2) return "Высокий";
        return "Не определено";
    }

    public static String getId(Integer id){
        String jid = Integer.toString(id);
        switch (jid.length()){
            case 1: return "00" + jid;
            case 2: return "0" + jid;
        }return Integer.toString(id);
    }

    public static Double getSumNumberForAnketa(int numb, Integer[][] array){
        double sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if(array[i][j]==numb && i<10){
                    sum++;
                }
            }
        }
        return sum;
    }

    public static Double getSumNumberUserForAnketa(int numb, List<Integer> array){
        double sum = 0;
            for (Integer list: array) {
                if(list==numb) sum++;
            }
        return sum;
    }

    public static String getProcent(Integer[][] arrayAnswer, Integer[][] arrayAnswerUser){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < arrayAnswerUser[i].length; j++) {
                list.add(arrayAnswer[i][arrayAnswerUser[i][j]]);
            }
        }

        Double high = getSumNumberForAnketa(2, arrayAnswer);
        Double mid = getSumNumberForAnketa(1, arrayAnswer);
        Double low = getSumNumberForAnketa(0, arrayAnswer);
        Double highuser = getSumNumberUserForAnketa(2, list);
        Double miduser = getSumNumberUserForAnketa(1, list);
        Double lowuser = getSumNumberUserForAnketa(0, list);
        return "" + Math.round((highuser/high)*100) + "%" +
                " " + Math.round((miduser/mid)*100) + "%" +
                " " + Math.round((lowuser/low)*100) + "%" +
                " " + Math.round(((highuser+miduser)/(highuser+miduser+lowuser))*100) + "%";
    }

    public static Integer[][] getArrFromDao(Integer[][] arrAnsw, int number_of_columns, int size){
        Integer[][] array = new Integer[size][];
        for (int i = 0; i < array.length; i++) {
            array[i] = new Integer[arrAnsw[number_of_columns].length];
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = arrAnsw[i + number_of_columns][j];
            }
        }
        return array;
    }

    public static Integer[][] getArrFromDaoUser(Integer[][] arrAnsw, Integer[][] arrAnswUser){
        Integer[][] array = new Integer[arrAnswUser.length][];
        for (int i = 0; i < arrAnswUser.length; i++) {
            array[i]= new Integer[arrAnswUser[i].length];
            for (int j = 0; j < arrAnswUser[i].length; j++) {
                array[i][j] = arrAnsw[i][arrAnswUser[i][j]];
            }
        }
        return array;
    }

/*    public static void main(String[] args) {
        String[] arr = {"Внутренний нарушитель с высоким потенциалом",
                "Внешний нарушитель с низким потенциалом",
                "Внешний нарушитель со средним потенциалом, Внутренний нарушитель со средним потенциалом",
                "Внешний нарушитель с низким потенциалом, Внутренний нарушитель с низким потенциалом",
                "Внутренний нарушитель с низким потенциалом",
                "Внешний нарушитель со средним потенциалом, Внутренний нарушитель со средним потенциалом",
                "Внешний нарушитель с низким потенциалом, Внутренний нарушитель с низким потенциалом",
                "Внутренний нарушитель с низким потенциалом",
                "Внутренний нарушитель с низким потенциалом",
                "Внешний нарушитель с низким потенциалом, Внутренний нарушитель с низким потенциалом",
                "Внешний нарушитель с низким потенциалом, Внутренний нарушитель с низким потенциалом",
                "Внешний нарушитель со средним потенциалом"
        };
        String[][] arrres = new String[arr.length][];
        for (int i = 0; i < arr.length; i++) {
            arrres[i]=getArrParseSourceOfThreat(arr[i]);
        }
        for (int i = 0; i < arrres.length; i++) {
                System.out.println(Arrays.toString(arrres[i]));
        }
    }*/

    public static Integer[][] getArrParseSourceOfThreat(String text){
        List<String> listresult = new ArrayList<>();
        String[] arrfirst = text.split(" ");
        String REGEX = "\\bкот\\b";

        for (int i = 0; i < arrfirst.length; i++) {
            String input = arrfirst[i];
            if(input.length()<4) continue;
                if(input.substring(0,4).equals("Внеш")) {listresult.add("Внешний"); continue;}
                if(input.substring(0,4).equals("Внут")) {listresult.add("Внутренний");continue;}
                if(input.substring(0,4).equals("сред")) {listresult.add("Средний");continue;}
                if(input.substring(0,4).equals("низк")) {listresult.add("Низкий");continue;}
                if(input.substring(0,4).equals("высо")) {listresult.add("Высокий");}
        }
        String[] arr =  listresult.stream().toArray(String[]::new);
        String[][] arrResult = new String[2][arr.length/2];
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            arrResult[0][j]= arr[i];
            arrResult[1][j++]= arr[++i];
        }
        Integer[][] arrNumber = new Integer[2][arrResult[0].length];

        for (int i = 0; i < arrResult[0].length; i++) {
            switch (arrResult[0][i]){
                case "Внешний": arrNumber[0][i] = 1;
                    break;
                case "Внутренний": arrNumber[0][i] = 0;
                    break;
            }

            switch (arrResult[1][i]){
                case "Высокий": arrNumber[1][i] = 0;
                    break;
                case "Средний": arrNumber[1][i] = 1;
                    break;
                case "Низкий": arrNumber[1][i] = 2;
                    break;
            }
        }
        return arrNumber;
    }

    public static Integer[] getArrParseSourceOfThreatCalculationType(String[] text){
        Integer[] result = new Integer[text.length];
        for (int i = 0; i < text.length; i++) {
            switch (text[i].trim()){
                case "Внешний": result[i] = 1;
                    break;
                case "Внутренний": result[i] = 0;
                    break;
                case "Внешний, Внутренний": result[i] = 2;
                    break;
            }
        }
        return result;
    }
    public static Integer[] getArrParseSourceOfThreatCalculationY2(String[] text){
        Integer[] result = new Integer[text.length];
        for (int i = 0; i < text.length; i++) {
            switch (text[i].trim()){
                case "Высокий": result[i] = 0;
                    break;
                case "Средний": result[i] = 1;
                    break;
                case "Низкий": result[i] = 2;
                    break;
            }
        }
        return result;
    }

    public static Boolean getTrueFalseStream(Integer[][] arr, int index, int number){
        int localIndex = 0;
        if(arr[1].length==1) return arr[1][0]>=number;
        if(index==0) localIndex = 1;
        if(index==2) {
            return arr[1][0]>=number || arr[1][1]>=number;
        }
        return arr[1][localIndex]>=number;
    }
}
