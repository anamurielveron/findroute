import java.util.*;

public class AStar {
    
    public static ArrayList<String> Search(Node start, Node goal) {
    PriorityQueue<Node> visitedNodes = new PriorityQueue<>(); // Evaluated Nodes
    PriorityQueue<Node> toEvaluate = new PriorityQueue<>();

    ArrayList<String> path = new ArrayList<>();
    Node node = start;

    toEvaluate.add(start);
    start.f = start.g + start.getHeuristic();

    while (!toEvaluate.isEmpty()) {
        node = toEvaluate.poll();
        if (node == goal) {
            break; // Found the goal node, exit the loop
        }

        for (Node.Edge edge : node.neighbors) {
            Node neighbor = edge.node;
            double totalCost = node.g + edge.cost;

            if (!toEvaluate.contains(neighbor) && !visitedNodes.contains(neighbor)) {
                neighbor.parent = node;
                neighbor.g = totalCost;
                neighbor.f = neighbor.g + neighbor.getHeuristic();
                toEvaluate.add(neighbor);
            } else { // The neighbor node has been visited before
                if (totalCost < neighbor.g) {
                    neighbor.parent= node;
                    neighbor.g = totalCost;
                    neighbor.f = neighbor.g + neighbor.getHeuristic();

                    if (visitedNodes.contains(neighbor)) {
                        visitedNodes.remove(neighbor);
                        toEvaluate.add(neighbor);
                    }
                }
            }
        }
        
        visitedNodes.add(node);
    }

    // Reconstruct the path if the goal node was found
    if (node == goal) {
        while (node != null) {
            path.add(0, node.name);
            node = node.parent;
        }
    }

    return path;
}

}
