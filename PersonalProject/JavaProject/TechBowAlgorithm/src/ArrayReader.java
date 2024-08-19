import java.sql.Array;

/**
 * @Author Yi Liu
 * @Date 7/23/22
 * @SpecificTime 3:12 PM
 * 无功能性，辅助解题
 */
public class ArrayReader {
    public int index;
    public Object get(int i){
        Object o = new Object();
        o = i;

        return o instanceof Integer ? i: null;

    }


}


