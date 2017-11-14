package myWordAnalyse;


import java.io.File;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashMap;

public class AnalyseList {

    ArrayList<Production> productions = new ArrayList<Production>();
    ArrayList<String> nonTerminals = new ArrayList<String>();
    ArrayList<String> terminals = new ArrayList<String >();
    HashMap<String, ArrayList<String>> firsts = new HashMap<>();

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
//        for (int i = 0; i < nonTerminals.size(); i++) {
//            System.out.println(nonTerminals.get(i));
//        }
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
                            terminals.contains(rights[i])) {
                        continue;
                    } else {
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

    public void setFirst() {

        //终结符的first集
        for (int i = 0; i < terminals.size(); i++) {
            ArrayList first = new ArrayList();
            first.add(terminals.get(i));
//            System.out.println(first);
            firsts.put(terminals.get(i),first);
        }
//        System.out.println(firsts);

        for (int i = 0; i < nonTerminals.size(); i++) {
            ArrayList first = new ArrayList<String>();
            firsts.put(nonTerminals.get(i), first);
        }
//        System.out.println(firsts);

        boolean flag;
        while(true){
            flag = true;
            String left;
            String right;
            String[] rights;

            for (int i = 0; i < productions.size(); i++) {
                left = productions.get(i).returnLeft();
//                System.out.println(left);
                rights = productions.get(i).returnRights();

                for (int j = 0; j < rights.length; j++) {
                    right = rights[j];
//                    System.out.println(right);

                    if (!right.equals("$")){
                        for (int k = 0; k < firsts.get(right).size(); k++) {
                            if (firsts.get(left).contains(firsts.get(right).get(k))){
                                continue;
                            }else {
                                firsts.get(left).add(firsts.get(right).get(k));
                                flag=false;
                            }
                        }
                    }
                    if (isCanBeNull(right)){
                        continue;
                    }else{
                        break;
                    }
                }

            }
            if (flag == true){
                break;
            }
        }
//        System.out.println(firsts);
    }

    public boolean isCanBeNull(String symbol) {
        String[] rights;
        for (int i = 0; i < productions.size(); i++) {
            // 找到产生式
            if (productions.get(i).toString().equals(symbol)) {
                rights = productions.get(i).returnRights();
                if (rights[0].equals("$")) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        AnalyseList analyseList = new AnalyseList();
        analyseList.setProductions();
        analyseList.setNonTerminals();
        analyseList.setTerminals();
        analyseList.setFirst();
    }
}
