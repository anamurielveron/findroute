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
            Node neighbor = edge.node;
            double totalCost = node.g + edge.cost;
            
            if(!toEvaluate.contains(neighbor) && !visitedNodes.contains(neighbor)){
                neighbor.parent= node;
                neighbor.g= totalCost;
                neighbor.f= neighbor.g + neighbor.getHeuristic();
                toEvaluate.add(neighbor);
            }else { //the neighbor node has been visited before 

                if(totalCost < neighbor.g){ //if ne
                    neighbor.parent= node;
                    neighbor.g= totalCost;
                    neighbor.f= neighbor.g + neighbor.getHeuristic();

                    if(visitedNodes.contains(neighbor)){
                        visitedNodes.remove(neighbor);
                        toEvaluate.add(neighbor);
                    }

                }
            }
            toEvaluate.remove(node);
            visitedNodes.add(node);

        }


        return Path;
    } 

}
