import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Pokemon {
    private static final int FRAME_WIDTH = 800;
    private static final int FRAME_HEIGHT = 600;

    Pokemon(){

    }

    public void run() {
        // Create nodes with the necessary information and connecting edges
        Node A = new Node("Mesagoza", 3087);
        A.g=0;
        
        Node B = new Node("Cortondo", 2997);
        Node C = new Node("Klawf", 1626);

        A.addBranch(257, B);
        A.addBranch(272, C);

        Node D = new Node("Artazon", 1661);
        Node E = new Node("Bombirdier", 3189);
        Node F = new Node("Giacomo", 2395);
        Node G = new Node("Iono", 664);
        Node H = new Node("Mela", 1009);
        Node O = new Node("Alfornada", 1525);
        

        C.addBranch(27, H);
        C.addBranch(29, D);
        D.addBranch(13, H);
        D.addBranch(181, G);
        H.addBranch(30, G);

        B.addBranch(246, O);
        B.addBranch(212, E);
        B.addBranch(133, F);

        Node I = new Node("Orthworm", 337);
        Node N = new Node("Great Tusk", 1378);
        Node J = new Node("Cascarrafa", 1655);

        E.addBranch(60, N);
        F.addBranch(25, J);
        G.addBranch(24, I);

        Node K = new Node("Atticus", 480);
        Node L = new Node("Medali", 1070);
        
        N.addBranch(348, L);
        J.addBranch(66, L);
        I.addBranch(97, K);
        L.addBranch(219, K);
        
        Node R = new Node("Tatsugiri", 469);
        Node M = new Node("Montenevera", 569);
        Node P = new Node("Glaseado", 329);
        
        L.addBranch(247, R);
        L.addBranch(214, M);
        K.addBranch(87, P);
        P.addBranch(5, M);

        Node Q = new Node("Ortega", 476);
        Node S = new Node("Eri", 0);

        R.addBranch(61, Q);
        M.addBranch(102, Q);
        Q.addBranch(476, S);

        // Add nodes to an arraylist
        ArrayList<Node> nodes = new ArrayList<>();
        nodes.add(A);
        nodes.add(B);
        nodes.add(C);
        nodes.add(D);
        nodes.add(E);
        nodes.add(F);
        nodes.add(G);
        nodes.add(H);
        nodes.add(I);
        nodes.add(J);
        nodes.add(K);
        nodes.add(L);
        nodes.add(M);
        nodes.add(N);
        nodes.add(O);
        nodes.add(P);
        nodes.add(Q);
        nodes.add(R);
        nodes.add(S);

        ArrayList<String> path = AStar.Search(A, S); // Calculate the path
        ArrayList<String> searchStatements = AStar.searchStatements;

        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Paldea Region (Pokemon Violet/Scarlet)");
            frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
            frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

            GraphDisplay graphDisplay = new GraphDisplay(nodes, path);

            JScrollPane graphScrollPane = new JScrollPane(graphDisplay);
            graphScrollPane.setPreferredSize(new Dimension(800, 600));

            //Split pannel for search statements
            SearchStatementsPanel searchStatementsPanel = new SearchStatementsPanel(searchStatements);
            JScrollPane searchStatementsScrollPane = new JScrollPane(searchStatementsPanel);
            searchStatementsScrollPane.setPreferredSize(new Dimension(200, 600));

            JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, graphScrollPane, searchStatementsScrollPane);
            splitPane.setDividerLocation(1200);
            frame.getContentPane().add(splitPane);

            frame.setVisible(true);
        });
    }
}
