
package linkedListQuestion;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
public class DesignTwitter {
    ArrayList[] connection;
    ListNode postHead;
    ListNode postTail;


    private class ListNode{
        int userId;
        int tweetId;
        ListNode next;
        ListNode prev;

        ListNode(){
            this.userId = 0;
            this.tweetId = 0;
            this.next = null;
            this.prev = null;
        }
        ListNode(int uId, int tId){
            this.userId = uId;
            this.tweetId = tId;
            this.next = null;
            this.prev = null;
        }
    }

    public DesignTwitter() {
        connection = new ArrayList[500];
        this.postHead = new ListNode();
        this.postTail = postHead;
    }

    public void postTweet(int userId, int tweetId) {
        ListNode tweet = new ListNode(userId, tweetId);
        postTail.next = tweet;
        tweet.prev = postTail;
        postTail = tweet;
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> feed = new ArrayList<>();
        int count = 0;
        if(postHead == postTail){
            return feed;
        }
        ListNode temp = postTail;
        while(count < 10 && temp != postHead){
            if(connection[userId] == null){
                if(temp.userId == userId){
                    feed.add(temp.tweetId);
                    count++;
                }
            }else{
                if(connection[userId].contains(temp.userId)){
                    feed.add(temp.tweetId);
                    count++;
                }
            }
            temp = temp.prev;
        }
        return feed;
    }

    public void follow(int followerId, int followeeId) {
        if(connection[followerId] == null){
            connection[followerId] = new ArrayList<Integer>();
            connection[followerId].add(followerId);
            connection[followerId].add(followeeId);

        }else{
            connection[followerId].add(followeeId);
        }
    }

    public void unfollow(int followerId, int followeeId) {
        Integer removed = followeeId;
        if(connection[followerId] != null){
            connection[followerId].remove(removed);
        }
    }

    public static void main(String[] args) {

    }
}
