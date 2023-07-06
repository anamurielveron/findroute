import javax.swing.*;
import java.awt.*;
import java.util.*;

public class MainManila {
    private static final int FRAME_WIDTH = 800;
    private static final int FRAME_HEIGHT = 600;

    public static void main(String[] args) {
        // Create nodes with the necessary information and connecting edges
        Node SH = new Node("Sherwood", 5570);
        SH.g = 0;
        Node PG = new Node("Pedro Gil", 4870);
        SH.addBranch(1600, PG);
        Node PF = new Node("Padre Faura", 3920);
        PG.addBranch(1500, PF);
        Node AL = new Node("Angel Linao", 4290);
        PF.addBranch(1000, AL);
        Node PA = new Node("Paz", 4560);
        PF.addBranch(1300, PA);
        AL.addBranch(500, PA);
        Node UN = new Node("UN Avenue", 3770);
        PF.addBranch(1300, UN);
        Node OT = new Node("Otis", 4250);
        PA.addBranch(700, OT);
        Node LE = new Node("Legarda", 3470);
        OT.addBranch(2500, LE);
        Node IN = new Node("Intramuros", 2370);
        UN.addBranch(1600, IN);
        Node NM = new Node("National Museum", 2960);
        UN.addBranch(1600, NM);
        Node LA = new Node("Lavenderos", 3390);
        IN.addBranch(3400, LA);
        Node NE = new Node("Nepomuceno", 2940);
        NM.addBranch(1900, NE);
        Node LO = new Node("Loyola", 2710);
        NE.addBranch(600, LO);
        LE.addBranch(1000, LO);
        Node QB = new Node("Quezon Blvd", 2340);
        LA.addBranch(1300, QB);
        Node DJ = new Node("Doroteo Jose", 1810);
        LA.addBranch(1800, DJ);
        QB.addBranch(800, DJ);
        Node RR = new Node("Reina Regente", 1210);
        DJ.addBranch(1000, RR);
        Node AM = new Node("Almeda", 1940);
        RR.addBranch(1800, AM);
        Node TE = new Node("Tecson", 1300);
        AM.addBranch(1300, TE);
        Node TA = new Node("Tayuman", 2300);
        DJ.addBranch(1600, TA);
        Node LTO = new Node("LTO Tayuman", 1980);
        AM.addBranch(400, LTO);
        LTO.addBranch(210, TA);
        Node AS = new Node("Abad Santos", 0);
        TE.addBranch(1300, AS);
        TA.addBranch(2300, AS);

        // Add nodes to an arraylist
        ArrayList<Node> nodes = new ArrayList<>();
        nodes.add(SH);
        nodes.add(PG);
        nodes.add(PF);
        nodes.add(AL);
        nodes.add(PA);
        nodes.add(UN);
        nodes.add(OT);
        nodes.add(LE);
        nodes.add(IN);
        nodes.add(NM);
        nodes.add(LA);
        nodes.add(NE);
        nodes.add(LO);
        nodes.add(QB);
        nodes.add(DJ);
        nodes.add(RR);
        nodes.add(AM);
        nodes.add(TE);
        nodes.add(TA);
        nodes.add(LTO);
        nodes.add(AS);

        ArrayList<String> path = AStar.Search(SH, AS); // Calculate the path
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
