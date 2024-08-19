package LinkedList;

/**
 * @Author Yi Liu
 * @Date 7/28/22
 * @SpecificTime 11:02 PM
 */
public class ListNodeGenerics <E>{
    ListNodeGenerics<E> next;
    ListNodeGenerics<E> prev;
    E value;

    public ListNodeGenerics(E value) {
        this.value = value;
    }
}
