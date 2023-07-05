import javax.swing.*;
import java.awt.*;
import java.util.*;

public class GraphDisplay extends JPanel {

    private ArrayList<Node> nodes;
    private ArrayList<String> path;
    private ArrayList<String> searchStatements;

    public GraphDisplay(ArrayList<Node> nodes, ArrayList<String> path) {
        this.nodes = nodes;
        this.path = path;
        this.searchStatements = new ArrayList<>();
    }

    public void setSearchStatements(ArrayList<String> searchStatements) {
        this.searchStatements = searchStatements;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int numVertices = nodes.size();
        int width = getWidth();
        int height = getHeight();
        int radius = Math.min(width, height) / 2;

        // Draw vertices
        for (int i = 0; i < numVertices; i++) {
            Node node = nodes.get(i);
            double angle = 2 * Math.PI * i / numVertices;
            int x = (int) (width / 2 + radius * Math.cos(angle));
            int y = (int) (height / 2 + radius * Math.sin(angle));

            // Highlight visited nodes
            if (path.contains(node.name)) {
                g.setColor(Color.RED);
                g.fillOval(x - 10, y - 10, 20, 20);
                g.setColor(Color.BLACK);
            } else {
                g.drawOval(x - 10, y - 10, 20, 20);
            }

            // Draw node name
            g.drawString(node.name, x - 5, y + 5);

            // Draw edges and weights
            for (Node.Edge edge : node.neighbors) {
                Node neighbor = edge.node;
                int neighborIndex = nodes.indexOf(neighbor);
                int x2 = (int) (width / 2 + radius * Math.cos(2 * Math.PI * neighborIndex / numVertices));
                int y2 = (int) (height / 2 + radius * Math.sin(2 * Math.PI * neighborIndex / numVertices));

                // Highlight edges on the path
                if (path.contains(node.name) && path.contains(neighbor.name)) {
                    g.setColor(Color.RED);
                } else {
                    g.setColor(Color.BLACK);
                }

                // Draw edge line
                g.drawLine(x, y, x2, y2);

                // Draw edge weight
                int weightX = (x + x2) / 2;
                int weightY = (y + y2) / 2;
                g.drawString(String.valueOf(edge.cost), weightX, weightY);
            }
        }

        // Draw heuristics table
        int tableX = 10;
        int tableY = 10;
        int cellWidth = 100;
        int cellHeight = 20;

        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(tableX, tableY, cellWidth, cellHeight * (numVertices + 1));

        g.setColor(Color.BLACK);
        g.drawRect(tableX, tableY, cellWidth, cellHeight * (numVertices + 1));

        g.drawString("Heuristics", tableX + 5, tableY + cellHeight);

        for (int i = 0; i < numVertices; i++) {
            Node node = nodes.get(i);
            String nodeName = node.name;
            double heuristic = node.h;

            g.drawString(nodeName + ": " + heuristic, tableX + 5, tableY + (i + 2) * cellHeight);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(800, 600); // Set the preferred size of the component
    }
}

class SearchStatementsPanel extends JPanel {

    private ArrayList<String> searchStatements;

    public SearchStatementsPanel(ArrayList<String> searchStatements) {
        this.searchStatements = searchStatements;
        setPreferredSize(new Dimension(200, 600));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int lineHeight = g.getFontMetrics().getHeight();
        int y = lineHeight;

        for (String statement : searchStatements) {
            g.drawString(statement, 5, y);
            y += lineHeight;
        }
    }

    @Override
    public Dimension getPreferredSize() {
        int lineHeight = getFontMetrics(getFont()).getHeight();
        int height = lineHeight * searchStatements.size();
        return new Dimension(200, height);
    }
}
