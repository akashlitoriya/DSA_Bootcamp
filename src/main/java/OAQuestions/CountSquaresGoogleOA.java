package OAQuestions;

import java.util.TreeMap;
import java.util.ArrayList;

public class CountSquaresGoogleOA {
    static class Pair{
        int x;
        int y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) {

    }
    private static int getSquareCount(ArrayList<Pair> p, TreeMap<Pair, Integer> points, Pair check){
        int count = 0;
        for(int i = 0; i < p.size(); i++){
            if(p.get(i).y == check.y){
                int tempCount = 1;
                int d = Math.abs(p.get(i).x - check.x);
                //checking square below
                tempCount *= points.get(new Pair(p.get(i).x, check.y));
                if(points.containsKey(new Pair(p.get(i).x, check.y - d))){
                    //tempCount
                }
            }
        }
        return 0;
    }
}
