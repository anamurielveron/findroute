//DRAFT FOR NODE CLASS (not final!!!)

import java.util.ArrayList;

public class Node implements Comparable<Node> {
    public String name;

    private static int count = 0;
    public int id;

    public Node parent = null;

    public List<Edge> neighbors; //??

    public double f = Double.MAX_VALUE; //g + h (total cost)
    public double g = Double.MAX_VALUE; //cost from start to this node
    public double h; //heuristic value (cost from this node to goal)

    Node(String name, double h){ //constructor
        this.name = name;
        this.h = h;
        this.id =  count++;
        this.neighbors = new ArrayList<Edge>();
    }

    @Override
    public int compareTo(Node n) { //compare heuristic values
        return Double.compare(this.f, n.f);
    }

    public static class Edge { //edge class
        public Node node;
        public int cost;

        Edge(Node node, int cost){
            this.node = node;
            this.cost = cost;
        }
    }

    public void addBranch(int cost, Node node) { //add branch to this node
        Edge newEdge = new Edge(node, cost);
        neighbors.add(newEdge);
    }

    public double getHeuristic() { //get heuristic value
        return this.h;
    }
}
