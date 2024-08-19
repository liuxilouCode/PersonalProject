package Problems;

import LinkedList.ListNode;

import java.util.List;

/**
 * @Author Yi Liu
 * @Date 8/8/22
 * @SpecificTime 4:43 PM
 */
public class ShoppingCart {

    public static ListNode getShoppingCart(ListNode head, List<List<String>> queries){
        ListNode tail = head;
        while(tail.next!=null){
            tail = tail.next;
        }
        for (List<String> que : queries){
            if (que.get(0).equals("POP_HEAD")){
                if (head == null)return null;
                ListNode temp = head.next;
                head.next = null;
                head = temp;
            }
            else if (que.get(0).equals("PUSH_HEAD")){
                ListNode newHead = head;
                newHead.item = que.get(1);
                newHead.next = head;
                head = newHead;

            } else if (que.get(0).equals("PUSH_TAIL")){
                ListNode newTail = new ListNode(que.get(1));
                tail.next = newTail;
                tail = newTail;
            } else {
                throw new IllegalArgumentException("Invalid Input");
            }
        }
        return head;
    }
}
