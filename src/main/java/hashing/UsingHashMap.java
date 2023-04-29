package hashing;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class UsingHashMap {
    public static void main(String[] args) {
        // Creating hashMap
        HashMap<String, Integer> map = new HashMap<>();
        // < Country(key), Population(value)>


        //Inserting - put()
        map.put("India" , 120);
        map.put("US", 30);
        map.put("China", 150);

        System.out.println(map);
        map.put("China", 30);
        map.put("china", 40);
        System.out.println(map);

        //Searching
        //search key - containsKey()
        if(map.containsKey("China")){
            System.out.println("China is present");
        }else{
            System.out.println("China is not present");
        }

        //get()
        System.out.println(map.get("china")); // exist --> return value corresponding to key
        System.out.println(map.get("Indonesia")); //doesnot exist --> return null

        //Iteration : using for each loop
        //Method - 1
        for(Map.Entry<String,Integer> e : map.entrySet()){
            System.out.println(e.getKey() + " " + e.getValue());
        }

        //Method - 2
        Set<String> keys = map.keySet();
        for(String key : keys){
            System.out.println(key + " " + map.get(key));
        }

        //Remove key,value pair -> remove(key)
        map.remove("china");
        System.out.println(map);
    }
}
