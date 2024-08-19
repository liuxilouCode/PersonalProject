package Queue;

import java.util.Stack;

/**
 * @Author Yi Liu
 * @Date 7/29/22
 * @SpecificTime 3:29 PM
 */
public class StackMin<E> {
    private Stack<E> stackData;
    private Stack<E> stackMinTemp;

    public StackMin() {
        stackData = new Stack<E>();
        stackMinTemp = new Stack<E>();
    }

    public void push(E value){
        stackData.push(value);
        if (stackMinTemp.empty()||(Integer)stackMinTemp.peek()>=(Integer)value){
            stackMinTemp.push(value);
        }
    }

    public E pop(){
        if (stackData.empty()){
            return null;
        }
        else if (stackData.pop().equals(stackMinTemp.peek())){
            stackMinTemp.pop();
        }
        return stackData.pop();
    }

    public E top(){
        return stackData.empty()?null:stackData.peek();
    }

    public E min(){
        return stackData.isEmpty()?null: stackMinTemp.peek();
    }
}
