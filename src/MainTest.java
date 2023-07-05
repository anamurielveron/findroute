import javax.swing.*;
import java.awt.*;
import java.util.*;

public class MainTest {

    private static final int FRAME_WIDTH = 800;
    private static final int FRAME_HEIGHT = 600;

    public static void main(String[] args) {
        Node head = new Node("0", 3);
        head.g = 0;

        Node n1 = new Node("1", 2);
        Node n2 = new Node("2", 2);
        Node n3 = new Node("3", 2);

        head.addBranch(1, n1);
        head.addBranch(5, n2);
        head.addBranch(2, n3);
        n3.addBranch(1, n2);

        Node n4 = new Node("4", 1);
        Node n5 = new Node("5", 1);
        Node target = new Node("6", 0);

        n1.addBranch(7, n4);
        n2.addBranch(4, n5);
        n3.addBranch(6, n4);

        n4.addBranch(3, target);
        n5.addBranch(1, n4);
        n5.addBranch(3, target);

        ArrayList<Node> nodes = new ArrayList<>();
        nodes.add(head);
        nodes.add(n1);
        nodes.add(n2);
        nodes.add(n3);
        nodes.add(n4);
        nodes.add(n5);
        nodes.add(target);

        ArrayList<String> path = AStar.Search(head, target);
        ArrayList<String> searchStatements = AStar.searchStatements;

        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Graph Display");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);

            GraphDisplay graphDisplay = new GraphDisplay(nodes, path);

            JScrollPane graphScrollPane = new JScrollPane(graphDisplay);
            graphScrollPane.setPreferredSize(new Dimension(800, 600));

            SearchStatementsPanel searchStatementsPanel = new SearchStatementsPanel(searchStatements);
            JScrollPane searchStatementsScrollPane = new JScrollPane(searchStatementsPanel);
            searchStatementsScrollPane.setPreferredSize(new Dimension(200, 600));

            JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, graphScrollPane, searchStatementsScrollPane);
            splitPane.setDividerLocation(800);
            frame.getContentPane().add(splitPane);

            frame.setVisible(true);
        });
    }
}