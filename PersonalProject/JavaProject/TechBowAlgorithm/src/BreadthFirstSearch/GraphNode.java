package BreadthFirstSearch;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Yi Liu
 * @Date 8/12/22
 * @SpecificTime 4:25 PM
 * 为Dijstra准备的node
 */
public class GraphNode {
    public int value;
    public boolean visited;
    public int distance;

    Map<GraphNode, Integer> adjacentNodes = new HashMap<>();

    public void addDestination(GraphNode destination, int distance){
        adjacentNodes.put(destination,distance);
    }

    public GraphNode() {
    }
}
