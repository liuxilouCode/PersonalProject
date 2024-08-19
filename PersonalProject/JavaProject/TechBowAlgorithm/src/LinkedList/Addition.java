package LinkedList;

/**
 * @Author Yi Liu
 * @Date 7/26/22
 * @SpecificTime 9:34 PM
 * In a sorted single linked list, how to implement addition method.
 * First, we need clarification. Are we adding a new node? Or are we adding (replacing) a new value?
 */
public class Addition extends MyLinkedList{
    //add by the order of the node's value
    public void add(ListNode node){
        if (head == null) {
            head = node;
        }
        ListNode temp = head;
        ListNode prev = new ListNode(0); //dummy head node
        prev.next = head;
        while((Integer)node.value >= (Integer)temp.value){
            prev = prev.next;
            temp = temp.next;
        }
        node.next = temp;
        prev.next = node;
    }

    //no dummy node version
    public void insert(ListNode node) {
        //pre-processing
        if (head == null || (Integer)node.value <= (Integer)head.value) {
            node.next = head;
            setHead(node);
        }
        ListNode prev = head;
        while (prev.next != null && (Integer)prev.next.value < (Integer)node.value) {
            //不再借用dummy node，一个previous.next的判断就只需要借用一个辅助节点
            prev = prev.next;
        }
        node.next = prev.next;
        prev.next = node;

    }

}
