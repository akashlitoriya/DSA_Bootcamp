package heaps;

import java.util.ArrayList;
import java.util.Comparator;

public class heaps {
    public static void main(String[] args) {

    }

    class Heap<T extends Comparable<T>>{
        private ArrayList<T> list;

        Heap(){
            list = new ArrayList<>();
        }

        private void swap(int p, int q){
            T temp = list.get(p);
            list.set(p, list.get(q));
            list.set(q, temp);
        }

        private int getParent(int idx){
            return (idx - 1)/2;
        }

        private int left(int idx){
            return 2 * (idx) + 1;
        }

        private int right(int idx){
            return 2 * (idx) + 2;
        }

        public void insert(T val){
            list.add(val);
            upheap(list.size() - 1);
        }

        private void upheap(int idx){
            if(idx == 0) return ;

            int p = getParent(idx);
            if(list.get(idx).compareTo(list.get(p)) < 0){
                swap(p, idx);
                upheap(p);
            }

        }
    }
}
