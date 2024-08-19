import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toMap;

/**
 * @Author Yi Liu
 * @Date 8/15/22
 * @SpecificTime 2:56 PM
 */
public class FinalOrdering {
    public static List<Integer> findFinalOrdering(List<Integer> cards, List<Integer> cardsBefore, List<Integer> cardsAfter){
        int length = cards.size();
        List<Integer> result = new ArrayList<>(Collections.nCopies(length,0));
        Map<Integer, Integer> map;
        map = IntStream.range(0,cards.size()).boxed().collect(
                toMap(cards::get, Function.identity())
        );
        System.out.println(map);
        for (int i = 0; i < cardsBefore.size(); i++){
            int beforeIdx = map.get(cardsBefore.get(i));
            int afterIdx = map.get(cardsAfter.get(i));
            if (beforeIdx > afterIdx){
                map.put(cardsBefore.get(i),afterIdx);
                for (int j=afterIdx;j < beforeIdx;j++){
                        map.put(cards.get(j),map.get(cards.get(j))+1);
                }
            } else if(beforeIdx<afterIdx){
                map.put(cardsBefore.get(i),afterIdx-1);
                for (int j =beforeIdx+1;j < afterIdx ;j++){
                        map.put(cards.get(j),map.get(cards.get(j))-1);
                }
            }
            System.out.println(map);
        }
        for (int k = 0; k < length;k++){
            result.set(map.get(cards.get(k)),cards.get(k));
        }
        return result;

        //time complexity o(n^2)
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(2);
//        list.add(1);
//        list.add(5);
//        list.add(4);
        List<Integer> before = new ArrayList<>();
        List<Integer> after = new ArrayList<>();
        before.add(2);
        before.add(3);
        after.add(3);
        after.add(2);
        System.out.println(list);
        System.out.println(before);
        System.out.println(after);

        List<Integer> result = findFinalAgain(list,before,after);
        System.out.println(result);
    }

    public static List<Integer> findFinal(List<Integer> cards,
                                          List<Integer> cardsBefore,
                                          List<Integer> cardsAfter){
        int length = cards.size();
        List<Integer> result = new ArrayList<>(Collections.nCopies(length,0));
        Collections.copy(result,cards);
        for (int i = 0; i < cardsBefore.size(); i++){
            int afterIdx = result.indexOf(cardsAfter.get(i));
            int beforeIdx = result.indexOf(cardsBefore.get(i));
            int before = result.remove(result.indexOf(cardsBefore.get(i)));
            if (beforeIdx>afterIdx) result.add(afterIdx,before);
            else result.add(afterIdx-1,before);
        }
        return result;
        //time complexity O(n^2)
    }

    public static List<Integer> findFinalAgain(List<Integer> cards,
                                          List<Integer> cardsBefore,
                                          List<Integer> cardsAfter){
        if (cards.size()==2) {
            List<Integer> easyResult = new ArrayList<>();
            easyResult.add(cardsBefore.get(cardsBefore.size()-1));
            easyResult.add(cardsAfter.get(cardsAfter.size()-1));
            return easyResult;
        }

        ListNode head = new ListNode(cards.get(0));
        List<ListNode> list = new ArrayList<ListNode>();
        for (int i = 0; i < cards.size();i++){
            if(i == 0) {
                list.add(head);
            } else {
                list.add(new ListNode(cards.get(i)));
            }
        }

        Map<Integer, Integer> map;
        map = IntStream.range(0,cards.size()).boxed().collect(
                toMap(cards::get, Function.identity())
        );

        for (int j = 0; j < cards.size();j++){
            if (j!= cards.size()-1) list.get(j).next = list.get(j+1);
            if (j != 0) list.get(j).previous = list.get(j-1);
        }

        for (int k = 0; k < cardsBefore.size();k++){
            int beforeIdx = map.get(cardsBefore.get(k));
            int afterIdx = map.get(cardsAfter.get(k));
            ListNode temp = new ListNode(0);
            ListNode beforeNode = list.get(beforeIdx);
            ListNode afterNode = list.get(afterIdx);
            if(beforeNode.next == afterNode) continue;
            if (afterNode == head){
                temp.next = afterNode;
                afterNode.previous = temp;
                temp.value = beforeNode.value;
                if (beforeNode.next != null) {
                    beforeNode.next.previous = beforeNode.previous;
                    beforeNode.previous.next = beforeNode.next;
                } else{
                    beforeNode.previous.next = null;
                }
                head = temp;
            }
             else if (beforeNode == head){
                ListNode newHead = head.next;
                newHead.previous = null;
                head = newHead;
                temp.next = afterNode;
                temp.previous = afterNode.previous;
                afterNode.previous.next = temp;
                afterNode.previous = temp;
                temp.value = beforeNode.value;
            } else if (beforeNode != head){
                beforeNode.next.previous = beforeNode.previous;
                beforeNode.previous.next = beforeNode.next;
                temp.next = afterNode;
                temp.previous = afterNode.previous;
                afterNode.previous.next = temp;
                afterNode.previous = temp;
                temp.value = beforeNode.value;
            }
            list.set(beforeIdx,temp);

        }
        List<Integer> result = new ArrayList<>();
        ListNode curr = head;

        while(curr != null){
            result.add(curr.value);
            curr = curr.next;
        }
        return result;

    }



}


class ListNode{
    public int value;
    public ListNode next;
    public ListNode previous;

    public ListNode(int value) {
        this.value = value;
        next = null;
        previous = null;
    }

}

