package recursion;
import java.util.*;
public class DiceRollSum {
    public static void main(String[] args) {
        int targetSum = 10;
        System.out.println("Possible Dice rolls : " + possibleDiceRoll("", targetSum));
    }
    public static List<String> possibleDiceRoll(String pro, int targetSum){
        if(targetSum == 0){
            List<String> list = new ArrayList<>();
            list.add(pro);
            return list;
        }
        int i = 1;
        List<String> ans = new ArrayList<>();
        while(i <= targetSum && i <= 6){
            char ch = (char)((int)'0' + i);
            ans.addAll(possibleDiceRoll(pro + ch, targetSum - i));
            i++;
        }
        return ans;
    }
    public static List<String> possibleDiceRollFace(String pro, int targetSum, int face){
        if(targetSum == 0){
            List<String> list = new ArrayList<>();
            list.add(pro);
            return list;
        }
        int i = 1;
        List<String> ans = new ArrayList<>();
        while(i <= targetSum && i <= face){
            char ch = (char)((int)'0' + i);
            ans.addAll(possibleDiceRollFace(pro + ch, targetSum - i, face));
            i++;
        }
        return ans;
    }
}
