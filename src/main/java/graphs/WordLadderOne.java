package graphs;

import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

public class WordLadderOne {
    public static void main(String[] args) {

    }
    class Pair{
        String val;
        int level;
        Pair(int level, String val){
            this.level = level;
            this.val = val;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int level = 1;
        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < wordList.size(); i++){
            set.add(wordList.get(i));
        }
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(level, beginWord));
        while(!q.isEmpty()){
            Pair node = q.poll();
            //changing words
            for(int i = 0; i < node.val.length(); i++){
                //alphabet
                for(int j = 0; j < 26; j++){
                    String temp = node.val.substring(0, i) + (char)(j + 97) + node.val.substring(i + 1);
                    if(set.contains(temp)){
                        if(temp.equals(endWord)){
                            return node.level + 1;
                        }
                        q.add(new Pair(node.level + 1, temp));
                        set.remove((String)temp);
                    }
                }
            }
        }
        return 0;
    }
}
