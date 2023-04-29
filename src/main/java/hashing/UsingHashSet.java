package hashing;

import java.util.HashSet;
import java.util.Iterator;
public class UsingHashSet {
    public static void main(String[] args) {
        //Creating
        HashSet<Integer> set = new HashSet<>(); // initial capacity -> 16, load factor -> 0.75
        //rehashing is done when the number of elements = 12 ; capacity * load factor =  16 * 0.75 = 12;

        //Insert - add();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(1); // duplicate - ignored

        //Search - contains()
        if(set.contains(1)){
            System.out.println("Set contains 1");
        }
        if(!set.contains(6)){
            System.out.println("Set doesnot contain 6");
        }

        //Delete - remove()
        set.remove(1);
        if(!set.contains(1)){
            System.out.println("Does not contain 1 - we deleted 1");
        }

        // Size - size()
        System.out.println("Size of set : " + set.size());


        // Print all elements
        System.out.println(set);

        //Iterator
        Iterator it = set.iterator();
        //hasNext() -->  checks whether next element is present or not
        //next() --> return next element
        while(it.hasNext()){
            System.out.print(it.next() + " ");
        }
    }
}
