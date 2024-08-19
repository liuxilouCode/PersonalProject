package LinkedList;

/**
 * @Author Yi Liu
 * @Date 7/27/22
 * @SpecificTime 2:06 PM
 * Given two sorted linked lists, how to merge them?
 */
public class MergeLinkedList {
    public static ListNode mergeLinkedList (ListNode head1, ListNode head2){
        if (head1 == null & head2 !=null){return head2;}
        else if(head1 !=null & head2 == null){return head1;}
        else if(head1 == null && head2 == null){throw new IllegalArgumentException();}
        else{
            ListNode curr1 = head1;
            ListNode curr2 = head2; //we try not to touch/change the original two linkedlists
            ListNode head;
            ListNode current;
            if (head1.value<=head2.value){
                head = head1;
                curr1 = head1.next;
            } else {
                head = head2;
                curr2 = head2.next;
            }
            current = head;

            while(curr1.next!=null && curr2.next != null){
                if (curr1.value <= curr2.value){
                    current.next = curr1;
                    curr1 = curr1.next;
                } else {
                    current.next = curr2;
                    curr2 = curr2.next;
                }
                current = current.next;
            }

            while(curr1.next!=null){
                    current.next = curr1;
                    curr1 = curr1.next;
                    current = current.next;
            }

            while(curr2.next!=null){
                    current.next = curr2;
                    curr2 = curr2.next;
                    current = current.next;
            }

            return head;
        }
    }

    public ListNode recursionMerge(ListNode head1, ListNode head2,ListNode currentHead){
        if (head1 == null & head2 !=null){return head2;}
        else if(head1 !=null & head2 == null){return head1;}
        else if(head1 == null && head2 == null){return null;}
        else{
                if (head1.value<=head2.value){
                    currentHead = head1;
                    currentHead.next = recursionMerge(head1.next,head2,currentHead.next);
                } else {
                    currentHead = head2;
                    currentHead.next = recursionMerge(head1,head2.next,currentHead.next);
                }
        }
        return currentHead;
    }
}
