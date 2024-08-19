package DataStructure;

/**
 * @Author Yi Liu
 * @Date 8/6/22
 * @SpecificTime 4:18 PM
 */
public class MyStackByArray {//todo Generics or List
    //field
    int value;
    int pointer;

    int[] array;
    private static final int Default_Size = 10;

    //method
    public MyStackByArray(int capacity) {
        array = new int[capacity];
        pointer = -1;//左闭右闭区间
        //如果是左闭右开 则初始化pointer = 0
    }

    public MyStackByArray() {
        this(Default_Size);
    }

    // offer peek poll
    public boolean offer(int value){
        if (pointer==array.length) return false;
        array[++pointer] = value; //左闭右闭区间
        //如果是左闭右开区间 则是 array[pointer++] = value;
        return true;
    }

    public int poll(){
        if (pointer == -1) return -1;
        return array[pointer--]; //左闭右闭区间
        //如果是左闭右开区间 则是 return array[--pointer];
    }

    public int peek(){
        return (pointer==-1)?-1:array[pointer];
        //如果是左闭右开区间 则是 return (pointer==0)?-1:array[pointer-1];
    }
}
