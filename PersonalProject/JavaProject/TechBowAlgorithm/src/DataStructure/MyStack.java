package DataStructure;

import LinkedList.ListNode;

/**
 * @Author Yi Liu
 * @Date 8/4/22
 * @SpecificTime 11:44 PM
 */
public class MyStack<T> {
    //use single Linked List to make a stack
    //field
    private ListNode head;


    //method

    public MyStack() {
        head = null;
    }
    public void push(int item){

        ListNode newNode = new ListNode(item);
        newNode.next = head;
        head = newNode;
    }
    public ListNode pop(){
        if (head == null) return null;
        ListNode temp = head;
        head = head.next;
        temp.next = null;
        return temp;
    }
    public int peek(){
        if (head == null)return -1;
        else return head.value;
    }
}
