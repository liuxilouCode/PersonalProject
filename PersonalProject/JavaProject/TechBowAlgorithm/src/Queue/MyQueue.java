package Queue;

import java.util.Queue;
import java.util.Stack;

/**
 * @Author Yi Liu
 * @Date 7/29/22
 * @SpecificTime 1:40 AM
 *
 * Use stack only to create a queue. It needs to fulfill several basic functions of queue including
 * offer, poll, peek
 */
public class MyQueue<E> { //todo Generics
    //fields
    private Stack<E> stackIn;
    private Stack<E> stackOut;

    //methods
    public MyQueue(){
        stackIn = new Stack<E>();
        stackOut = new Stack<E>();
    }

    public void offer(E val){
        stackIn.push(val); //assuming no capacity restrictions
    }

    public E poll(){
        //Retrieves and removes the head of this queue, or returns null if this queue is empty.
        move();
        return stackOut.isEmpty()?null:stackOut.pop();
    }

    public E peek(){
        //Retrieves, but does not remove, the head of this queue, or returns null if this queue is empty.
        move();
        return stackOut.isEmpty()?null:stackOut.peek();
    }

    private void move() {
        if (stackOut.isEmpty()) {
            while (!stackIn.isEmpty()) {
                stackOut.push(stackIn.pop());
            }
        }
    }


}
