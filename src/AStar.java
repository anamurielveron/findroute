import java.util.*;

public class AStar {
    public PriorityQueue<Node> visitedNodes = new PriorityQueue<>(); //Evaluated Nodes 
    public PriorityQueue<Node> toEvaluate = new PriorityQueue<>(); 

    public ArrayList<Node> Search (Node start, Node goal){
        ArrayList<Node> Path = new ArrayList<>();
        Node node;

        toEvaluate.add(start);
        start.f= start.g + start.getHeuristic();

        while (toEvaluate.size() != 0){
            node= toEvaluate.peek(); 
            if (node == goal)
                Path.add(node);
            return Path;
        }  

        for(int i= 0; i < node.neighbors.size(); i++){
            Node.Edge edge = node.neighbors.get(i);
            Node m = edge.node;
            double totalCost = node.g + edge.cost;
            
            //stpoped at line 7 of peseudocode
        
        }


        return Path;
    } 

}
