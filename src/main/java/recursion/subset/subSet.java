package recursion.subset;
import java.util.*;
public class subSet {
    public static void main(String[] args) {
        int num[] = {1,2,3,4};
        System.out.println(subset(num));
    }
    private static List<List<Integer>> subset(int arr[]){
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        for(int i = 0; i < arr.length; i++){
            int size = ans.size();
            for(int j = 0; j < size; j++){
                ArrayList<Integer> subset = new ArrayList<>(ans.get(j));
                subset.add(arr[i]);
                ans.add(subset);
            }
        }
        return ans;
    }
}
