import java.util.ArrayList;

public class MainManila {
    public static void main(String[] args) {
    Node SH = new Node("Sherwood", 5570);
    SH.g=0;
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
    AL.addBranch(400, LTO);
    LTO.addBranch(210,TA);
    Node AS = new Node("Abad Santos", 0);
    TE.addBranch(1300, AS);
    TA.addBranch(2300, AS);

    ArrayList <String> Path = new ArrayList<>(AStar.Search(SH, AS));
    
    for (int i=0; i<Path.size(); i++){
        System.out.println(Path.get(i));
    }
}
}
