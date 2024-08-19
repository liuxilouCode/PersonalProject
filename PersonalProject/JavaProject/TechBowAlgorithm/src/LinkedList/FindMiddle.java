package LinkedList;

/**
 * @Author Yi Liu
 * @Date 7/26/22
 * @SpecificTime 8:25 PM
 * 最简单的做法当然是遍历一次，得到整个链表的长度
 * 长度除以2，在遍历一次，找到那个元素，这样是two paths，遍历两次
 *
 * 然而面试的时候面试官可能会问，如何用one path（即一次遍历）达到目的
 *
 * 此时可以用双指针，即后指针是前指针速度的一半，这样前指针到达终点时，后指针正好在中点，提取后指针的node，
 * 一次遍历就可以达到目的 （fast指针走两步，slow指针走一步）
 */
public class FindMiddle {
    public ListNode findMiddle(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null && fast.next !=null){
            //一旦条件不满足，说明fast走到了链表最后一个node，while loop就停下了
            fast = fast.next.next;
            slow = slow.next;
        }
        //此时slow应该正好在中间
        return slow;
    }

    //同理，我们可以找到 1/n个节点
    public ListNode findNth(ListNode head, int n){
        if (head == null){
            return head;
        }
        ListNode temp = head;
        int count = 0;
        for (int i = 0; i < n; i++){
            if (temp.next != null){
                temp = temp.next;
            } else break;
            count++;
        }
        if (count<=n){return head;}
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            for (int i = 0; i< n; i++){
                fast = fast.next;
            }
            slow = slow.next;
        }
        return slow;
    }

}
