package linkedListQuestion;

public class ReverseLinkedList {
    static class ListNode{
        int val;
        ListNode next;
    }
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = head.next;
        while(curr != null){
            curr.next = prev;
            prev = curr;
            curr = next;
            if(next != null){
                next = next.next;
            }
        }
        head = prev;
        return head;
    }
}
