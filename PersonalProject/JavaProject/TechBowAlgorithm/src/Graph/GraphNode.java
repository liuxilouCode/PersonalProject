package Graph;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @Author Yi Liu
 * @Date 8/4/22
 * @SpecificTime 10:42 PM
 */
public class GraphNode { //todo Generics
    //Field
    String name;
    int value;
    ArrayList<GraphNode> neighbors;

    public GraphNode(int value) {
        this.value = value;
        neighbors = new ArrayList<GraphNode>();
    }
}
