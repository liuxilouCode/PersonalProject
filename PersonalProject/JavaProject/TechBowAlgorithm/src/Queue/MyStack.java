package Queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author Yi Liu
 * @Date 7/29/22
 * @SpecificTime 2:27 PM
 * Use queue to implement a stack. It should have basic stack methods such as pop, push, and so on.
 */
public class MyStack<E> {
    private Queue<E> queueIn;
    private Queue<E> queueOut;
    private E top;

    public MyStack() {
        queueIn = new LinkedList<E>();
        queueOut = new LinkedList<E>();
    }

    public void push(E value){
        queueIn.add(value);
        top = value;
    }

    public void pop(){
        while (queueIn.size()>1){
            top = queueIn.remove();
            queueOut.add(top);
        }
        queueIn.remove();
        Queue<E> temp = queueIn;
        queueIn  = queueOut;
        queueOut = temp;
    }

    public boolean isEmpty(){
        return queueIn.isEmpty();
    }

    public E top(){
        return top;
    }
}
