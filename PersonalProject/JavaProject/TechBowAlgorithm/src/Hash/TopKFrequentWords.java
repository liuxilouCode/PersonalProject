package Hash;

import java.util.*;

/**
 * @Author Yi Liu
 * @Date 8/4/22
 * @SpecificTime 2:42 PM
 */
public class TopKFrequentWords {
    //use Max Heap
    public List<String> topK (String[] words, int k){
        List<String> result = new LinkedList<>();
        Map<String, Integer> map = new HashMap<>();
        for (String word:words){
            map.put(word, map.getOrDefault(word,0)+1);
        } //if there isn't a word, then by default the value is 0 and we add this new word in and the value becomes +1
        //if the word is already in it, then we get its value and +1

        //max heap
        PriorityQueue<Map.Entry<String, Integer>>pq = new PriorityQueue<>(
                (a,b) ->a.getValue() == b.getValue()?b.getKey().compareTo(a.getKey())
                :a.getValue()-b.getValue());//this is a min heap
        //lambda function decides the priority
        //the function actually guarantees that when having the same frequencies, the words have
        //higher alphabetical order will be returned first
        //if we want a max heap, then we simply reverse the order to b.getvalue - a.getvalue

        for (Map.Entry<String, Integer> entry :map.entrySet()){
            pq.offer(entry);
            if (pq.size()>k) pq.poll(); //if the size of the queue is greater than k, then poll the top element
            //since the top element is the word that has lowest frequency
        }

        while (!pq.isEmpty()){
            result.add(0,pq.poll().getKey());
        }

        return result;
    }
}
