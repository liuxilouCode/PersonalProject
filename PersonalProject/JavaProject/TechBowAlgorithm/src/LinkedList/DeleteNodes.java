package LinkedList;

/**
 * @Author Yi Liu
 * @Date 7/27/22
 * @SpecificTime 1:47 PM
 * In a sorted linked list, how to delete repetitive elements
 * e.g {1,2,3,3,3,3,3,3,4,5,6} remove all 3s
 * suppose that you know the head node
 */
public class DeleteNodes {
    public void deleteNodes(ListNode head, int value){
        if (head == null|| head.value == value){
            head = null;
            return;
        }
        ListNode temp = head;
        while(temp.next != null){
            if (temp.next.value != value){
                temp = temp.next;
            } else {
                ListNode subTemp = temp.next;
                while(subTemp.value == value){
                    subTemp = subTemp.next;
                }
                temp.next = subTemp;
                break;
            }
        }
    }
}
