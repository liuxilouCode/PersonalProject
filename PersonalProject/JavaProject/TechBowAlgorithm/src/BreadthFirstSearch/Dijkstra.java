package BreadthFirstSearch;

import java.util.PriorityQueue;

/**
 * @Author Yi Liu
 * @Date 8/13/22
 * @SpecificTime 11:39 AM
 * Shortest Path between any two nodes in a graph
 */
public class Dijkstra {
    public void dijkstra(GraphNode start){
        PriorityQueue<GraphNode> minHeap = new PriorityQueue<GraphNode>(
                (c1,c2) -> c1.distance-c2.distance
        );
    }
}
