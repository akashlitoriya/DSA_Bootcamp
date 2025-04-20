package OAQuestions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class SortDatesIBM {
    public static void main(String[] args) {
        String date[] = {"4 Jan 1990", "18 Nov 2002", "10 Dec 2000", "4 May 1980"};
        sortDates(date);
        System.out.println(Arrays.toString(date));
    }
    static class Date{
        int day;
        int month;
        int year;
        String mon;
        Date(int day, int month, int year, String mon){
            this.day = day;
            this.month = month;
            this.year = year;
            this.mon = mon;
        }
    }
    private static void sortDates(String date[]){
        int n = date.length;
        HashMap<String, Integer> month = new HashMap<>();
        month.put("Jan", 1);
        month.put("Feb", 2);
        month.put("Mar", 3);
        month.put("Apr", 4);
        month.put("May", 5);
        month.put("Jun", 6);
        month.put("Jul", 7);
        month.put("Aug", 8);
        month.put("Sep", 9);
        month.put("Oct", 10);
        month.put("Nov", 11);
        month.put("Dec", 12);

        PriorityQueue<Date> pq = new PriorityQueue<>((a,b)->(a.year == b.year)? (a.month == b.month)? a.day - b.day: a.month - b.month : a.year - b.year);
        for(int i = 0; i < n; i++){
            String temp[] = date[i].split(" ");
            Date dt = new Date(Integer.parseInt(temp[0]), month.get(temp[1]), Integer.parseInt(temp[2]), temp[1]);
            pq.add(dt);
        }

        for(int i = 0; i < n; i++){
            Date dt = pq.poll();
            String temp = "" + dt.day + " " + dt.mon + " " + dt.year;
            date[i] = temp;
        }

    }
}
