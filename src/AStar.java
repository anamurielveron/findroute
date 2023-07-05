import java.util.*;

public class AStar {

    public static ArrayList<String> searchStatements;
    

    public static String printQueue (PriorityQueue<Node> pq){
        String temp= "";
        for(Node n : pq)
            temp= temp.concat(n.name + " ");
        return temp;
    }

    public static ArrayList<String> Search(Node start, Node goal) {
    PriorityQueue<Node> visitedNodes = new PriorityQueue<>(); // Evaluated Nodes
    PriorityQueue<Node> toEvaluate = new PriorityQueue<>();
    ArrayList<String> path = new ArrayList<>();
    Node node = start;
    searchStatements= new ArrayList<>();

    toEvaluate.add(start);
    start.f = start.g + start.getHeuristic();

    while (!toEvaluate.isEmpty()) {
        node = toEvaluate.poll();//node is set to the head of the queue
        searchStatements.add(node.name + "  is now being evaluated.");

        if (node == goal) {
            searchStatements.add(node.name + "  is the goal node. Search complete.");
            break; // Found the goal node, exit the loop
        }

        for (Node.Edge edge : node.neighbors) { //For every neighboring edge
            Node neighbor = edge.node;
            double totalCost = node.g + edge.cost;

            if (!toEvaluate.contains(neighbor) && !visitedNodes.contains(neighbor)) {
                neighbor.parent = node;
                neighbor.g = totalCost;
                neighbor.f = neighbor.g + neighbor.getHeuristic();
                toEvaluate.add(neighbor);

                searchStatements.add("Evaluating... ");
                searchStatements.add(node.name+" to "+ neighbor.name);
                searchStatements.add("Edge costs: "+totalCost);
                searchStatements.add("Heuristic cost: "+ neighbor.getHeuristic() +" + edge cost: " + neighbor.g+ "= "+ neighbor.f);

            } else { // The neighbor node has been visited before
                if (totalCost < neighbor.g) {
                    neighbor.parent= node;
                    neighbor.g = totalCost;
                    neighbor.f = neighbor.g + neighbor.getHeuristic();

                    searchStatements.add("Evaluating... ");
                    searchStatements.add("Edge costs: "+ totalCost + "< Edge cost: " + neighbor.g);
                    searchStatements.add(node.name+" to "+ neighbor.name);
                    searchStatements.add("Edge costs: "+totalCost);
                    searchStatements.add("Heuristic cost: "+ neighbor.getHeuristic() +" + edge cost: " + neighbor.g+ "= "+ neighbor.f);

                    if (visitedNodes.contains(neighbor)) {
                        visitedNodes.remove(neighbor);
                        toEvaluate.add(neighbor);
                    }
                }
            }
            searchStatements.add("Visited nodes: "+ printQueue(visitedNodes));
            searchStatements.add("Nodes to evaluate: "+ printQueue(visitedNodes));
        }
        
        visitedNodes.add(node);
        searchStatements.add("Visited nodes:"+ printQueue(visitedNodes));
    }

    // Reconstruct the path if the goal node was found
    if (node == goal) {
        while (node != null) {
            path.add(0, node.name);
            node = node.parent;
        }
    }

    searchStatements.add("Best path: " + path);
    return path;
}

}
