package myWordAnalyse;

import java.io.File;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashMap;

public class AnalyseList {

    ArrayList productions = new ArrayList<myWordAnalyse.Production>();
    ArrayList nonTerminals = new ArrayList<String>();
    ArrayList terminals = new ArrayList<String>();
    HashMap<String, ArrayList<String>> firsts;

    public void setProductions() {
        try {
            File file = new File("grammar.txt");
            RandomAccessFile randomfile = new RandomAccessFile(file, "r");

            String line;
            String left;
            String right;
            Production production;
            while ((line = randomfile.readLine()) != null) {
                left = line.split("->")[0];
//                System.out.println(left);
                right = line.split("->")[1];
//                System.out.println(right);
                production = new Production(left, right.split(""));
                productions.add(production);

            }
            randomfile.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setNonTerminals() {
        try {
            File file = new File("grammar.txt");
            RandomAccessFile randomFile = new RandomAccessFile(file, "r");
            String line;
            String left;
            while ((line = randomFile.readLine()) != null) {
                left = line.split("->")[0].trim();
                if (nonTerminals.contains(left)) {
                    continue;
                } else {
                    nonTerminals.add(left);
                }
            }
            randomFile.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
//        System.out.println(nonTerminals);
        for (int i = 0; i < nonTerminals.size(); i++) {
            System.out.println(nonTerminals.get(i));
        }
    }

    public void setTerminals() {
        try {
            File file = new File("grammar.txt");
            RandomAccessFile randomFile = new RandomAccessFile(file, "r");
            String line;
            String right;
            String[] rights;
            while ((line = randomFile.readLine()) != null) {
                right = line.split("->")[1].trim();
                rights = right.split("");
                for (int i = 0; i < rights.length; i++) {
                    if (nonTerminals.contains(rights[i]) ||
                            rights[i].equals("$") ||
                            rights[i].equals("|") ||
                            terminals.contains(rights[i])){
                        continue;
                    }
                    else{
                        terminals.add(rights[i]);
                    }
                }
            }
            randomFile.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
//        System.out.println(terminals);
    }


    public static void main(String[] args) {
        AnalyseList analyseList = new AnalyseList();
        analyseList.setProductions();
        analyseList.setNonTerminals();
        analyseList.setTerminals();
    }

}



