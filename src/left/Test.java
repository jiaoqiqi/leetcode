package left;

import java.util.LinkedList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        System.out.println("The Productions of G");
        Grammar g1 = new Grammar("S", "Qc|c");
        Grammar g2 = new Grammar("Q", "Rb|b");
        Grammar g3 = new Grammar("R", "Sa|a");
        List g_productions = new LinkedList();
        g_productions.add(g3);
        g_productions.add(g2);
        g_productions.add(g1);
        Production g_production = new Production(g_productions);
        g_production.removeLeftRecursion();
        System.out.print(g_production);
        System.out.println("end G\\n");

        System.out.println("The Productions of H");
        Grammar h1 = new Grammar("E", "E+T|T");
        Grammar h2 = new Grammar("T", "T*F|F");
        Grammar h3 = new Grammar("F", "(E)|i");
        List h_productions = new LinkedList();
        h_productions.add(h1);
        h_productions.add(h2);
        h_productions.add(h3);
        Production h_production = new Production(h_productions);
        h_production.removeLeftRecursion();
        System.out.print(h_production);
        System.out.println("end H");

    }
}
