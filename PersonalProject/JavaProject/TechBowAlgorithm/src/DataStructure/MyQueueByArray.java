package DataStructure;

import java.util.ArrayList;

/**
 * @Author Yi Liu
 * @Date 8/6/22
 * @SpecificTime 3:03 PM
 * We just designed a queue with linked list. Now, please design a queue with an array.
 */
public class MyQueueByArray { //todo Generics and array list

    private int[] array; //由于array对泛型的支持有限，我们用int
    private int head;
    private int tail;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public MyQueueByArray(int capacity){
        array = new int[capacity];
        head = 0;
        tail = 0;
        size = 0;
    }

    public MyQueueByArray() {
        this(DEFAULT_CAPACITY);
    }

    public boolean offer(int value){ //todo Expand
        if (size == array.length){return false;}
        array[tail] = value;
        tail = (tail+1)%array.length; //预防性编程，防止出界
        //circular array 我们利用取余的方式来用环转数组来防止出界，只有当size=array length的时候
        //我们就说整个数组满了
        //我们不用tail++的原因是假设数组长度为10，head在index 3，tail在index 9，tail++直接出界，但数组根本没满
        //所以tail+1取数组长度余可以保证在queue没满的时候tail可以像环一样往后走（即走到index 0）
        size++;
        return true;
    }

    public int poll(){
        if (size == 0) return -1;
        int res = array[head];
        head = (head+1)% array.length;
        //不直接head++理由同上
        size--;
        return res;
    }

    public int peek(){
        return size==0?-1:array[head];
    }
}
