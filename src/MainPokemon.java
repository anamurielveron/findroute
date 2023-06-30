import java.util.ArrayList;

public class MainTest {
    public static void main(String[] args) {
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

    ArrayList <String> Path = new ArrayList<>(AStar.Search(A, S));
    
    for (int i=0; i<Path.size(); i++){
        System.out.println(Path.get(i));
    }
}
}
