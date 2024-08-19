package LinkedList;

/**
 * @Author Yi Liu
 * @Date 7/26/22
 * @SpecificTime 2:35 PM
 * Revers LinkedList by k units
 */
public class ReverseLinkedList {

    //we start with the simplest case: reverse by 1 unit
    //s1 iteration
    public static ListNode reverseList(ListNode head) {
        //corner case
        if (head == null || head.next == null) { // 第一步 corner case检查
            return head;
        }
        ListNode cur = head; //第二步  建立三个代节点
        ListNode prev = null;
        ListNode next = null;
        while (cur != null) {
            next = cur.next; //第三步 调动代节点
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
        //iterate到current和next变为null，prev变为原链表中的最后一个节点（即新链表的第一个节点）
    }

    //s2 recursion 最好的方法
    public static ListNode reverseLLRecursion(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        ListNode newHead = reverseLLRecursion(head.next);
        //wall 迭代不到base case，下面的code根本不会运行
        head.next.next = head;
        /**
         * 这里的逻辑有点难理解，能走到这一步说明recursion已经走到最后一层的case，那当前的头节点
         * 的下一个节点即为原链表的倒数第二个节点。那倒数第二个节点的next就是原链表的最后一个节点
         * 我们设置原链表的最后一个节点的next为"运行到这一步的头节点"（即原链表的倒数第二个节点）
         * 这样就实现了链子箭头的调转，然后依次类推调转所有节点的链子箭头
         */
        head.next = null;  //而这里head.next指向null，代表这段sub linked list的链子箭头调转完成
        return newHead;

        //这属于先迭代后办事的过程

    }

    //我们再来看一下先办事，后迭代的迭代过程
    public static ListNode reverseListRecursionVersionTwo(ListNode head, ListNode previous){
        //when we input the first head node, the previous node would be null
        if (head == null || head.next == null){
            return head;
        }
        ListNode next = head.next;
        head.next.next = head;
        head.next = previous;
        previous = head;
        return reverseListRecursionVersionTwo(next,previous);
    }

    //现在我们再扩大到每两个节点reverse一下， 即 reverse by 2
    public static ListNode reverseListByTwo(ListNode head) {
        if (head == null || head.next == null) { // 1
            return head;
        }
        ListNode subHead = reverseListByTwo(head.next.next); // 2
        head.next.next = head; // 3
        ListNode newHead = head.next; // 4
        head.next = subHead; // 5
        return newHead;
    }

    public static ListNode reverseListByThree(ListNode head){
        if (head == null || head.next == null || head.next.next == null){
            return head;
            //corner case, if the sublist isn't even long enough (not having three nodes),
            //we can't reverse is (or we reverse it by 1 depending on the project's requirement)
        }
        ListNode subHead = reverseListByThree(head.next.next.next);
        head.next.next.next = head.next;
        ListNode newHead = head.next.next;

        head.next.next = head;
        head.next = subHead; //the original head now became the last head of the sublist, thus, its next becomes the new subhead of the next sublist
        return newHead;

    }
    //reverse by k units is a bit difficult for now, save it for later


}
