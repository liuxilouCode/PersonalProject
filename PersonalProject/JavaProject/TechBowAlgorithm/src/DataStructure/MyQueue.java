package DataStructure;

import LinkedList.ListNode;

/**
 * @Author Yi Liu
 * @Date 8/5/22
 * @SpecificTime 12:17 AM
 */
public class MyQueue {//todo Generics
    //Fields
    private ListNode head,tail;

    public MyQueue() {
        head = null;
        tail = null;
    }

    public void offer(int value){
        ListNode newNode = new ListNode(value);
        if (tail == null){ //tail=null说明head=null
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }

    }

    public int poll(){
        if (head == null) return -1;
        ListNode temp = head;
        if (head == tail){ //说明只有一个值,因为我们使用list node来实现queue，如果head=tail则说明是同一个节点，故只有一个值
            head=null;
            tail = null;
        } else {
            head = head.next;
            head.prev = null;
            temp.next = null;
        }
        return temp.value;
    }

    public int peek(){
        if (head == null) return -1;
        else return head.value;
    }
}
