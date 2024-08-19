package LinkedList;

import static LinkedList.ReverseLinkedList.reverseList;
import static LinkedList.ReverseLinkedList.reverseListByTwo;
import static LinkedList.ReverseLinkedList.reverseListByThree;
import static LinkedList.MergeLinkedList.mergeLinkedList;
/**
 * @Author Yi Liu
 * @Date 7/26/22
 * @SpecificTime 5:41 PM
 */
public class MyLinkedList {

    ListNode head;

    public void MyLinkedList() {

    }

    public void setHead(ListNode head) {
        this.head = head;
    }

    public void add(ListNode node){
        ListNode temp = head;
        while(true){
            if (temp.next == null){break;}
            else temp = temp.next;
        }

            temp.next = node;

    }

    public void list(){
        ListNode temp = head;
        while(true){
            if (temp == null){
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        ListNode node8 = new ListNode(8);
        ListNode node9 = new ListNode(9);
        ListNode node10 = new ListNode(10);
        ListNode node11 = new ListNode(11);
        MyLinkedList list = new MyLinkedList();
        MyLinkedList list2 = new MyLinkedList();
        list.setHead(node1);
//        list.add(node2);
        list.add(node3);
//        list.add(node4);
        list.add(node5);
//        list.add(node6);
        list.list();
        System.out.println("-----------");
//        reverseListByTwo(node1);
//        list.setHead(node2);
//        list.list();
//        System.out.println("-----------");
//        reverseListByThree(node1);
//        list.setHead(node3);
//        list.list();
        list2.setHead(node2);
        list2.add(node4);
        list2.add(node6);
        list2.add(node7);
        list2.add(node8);
        list2.add(node9);
        list2.list();
        System.out.println("-----------");
        MyLinkedList list3 = new MyLinkedList();
        list3.setHead(mergeLinkedList(node1,node2));
        list3.list();


    }
}
