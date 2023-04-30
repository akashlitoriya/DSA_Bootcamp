package linkedListQuestion;
import java.util.Stack;

public class ReorderList {
    class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
            this.next = null;
        }
    }
    //Approach - 1 :
    /*
    1-Find the middle element and store all the elements after middle into a stack
    2-Make middle's next null
    3-Now till stack is not empty ->
    a- Temp's next will be next of element at top of stack
    b- pop the stack
    c- update temp's next to popped
    d- temp will be update with popped;
     */
    public void reorderList(ListNode head) {
        ListNode mid = getMiddle(head);
        Stack<ListNode> st = new Stack<>();
        ListNode ptr = mid.next;
        while(ptr != null){
            st.push(ptr);
            ptr = ptr.next;
        }
        mid.next = null;
        ListNode temp = head;
        while(!st.isEmpty()){
            ListNode popped = st.pop();
            if(temp.next != null){
                popped.next = temp.next;
                temp.next = popped;
            }
            temp = popped.next;
        }
    }
    private ListNode getMiddle(ListNode head){
        ListNode temp = head;
        ListNode slow = temp;
        ListNode fast = temp;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
