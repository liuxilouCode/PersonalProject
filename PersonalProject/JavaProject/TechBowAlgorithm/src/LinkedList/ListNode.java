package LinkedList;

/**
 * @Author Yi Liu
 * @Date 7/26/22
 * @SpecificTime 2:46 PM
 */
public class ListNode {
    public int value;
    public ListNode next;
    public ListNode prev;
    public ListNode tail;
    public String item;

    public ListNode(int value) {
        this.value = value;
    }

    public ListNode(String item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "value=" + value +
                ", next=" + next +
                '}';
    }
}
