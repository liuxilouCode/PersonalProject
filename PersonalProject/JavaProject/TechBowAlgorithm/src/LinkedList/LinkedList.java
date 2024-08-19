package LinkedList;

/**
 * @Author Yi Liu
 * @Date 7/28/22
 * @SpecificTime 10:40 PM
 * Create list nodes for double linked lists
 */
public class LinkedList<E>{ //todo Generics
    private ListNodeGenerics<E> head;
    private ListNodeGenerics<E> tail;
    int size;


    public LinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public E getValue(int index) {
        if (head == null || index < 0 || index > size -1){
            return null;
        }
        ListNodeGenerics<E> current = head;
        while (index > 0){
            current = current.next;
            index--;

        }
        return current.value;
    }

    public void addHead(E value){
        ListNodeGenerics<E> newHead = new ListNodeGenerics<E>(value);
        if (head == null){
            tail = newHead;
        } else {
            newHead.next = head;
            head.prev = newHead;
        }
        head = newHead;
        size++;
    }

    public void addTail(E value){
        ListNodeGenerics<E> newTail = new ListNodeGenerics(value);
        if (tail == null){ //说明此时head也是null
            head = newTail;
        } else {
            tail.next = newTail;
            newTail.prev = tail;
        }
        tail = newTail;
        size++;
    }

    public int setSize() {
        return size;
    }
}
