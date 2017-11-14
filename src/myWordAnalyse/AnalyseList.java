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
                production = new Production(left, right.split("\\|"));
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

//    public void setFirst() {
//
//        //终结符的first集
//        for (int i = 0; i < terminals.size(); i++) {
//            ArrayList first = new ArrayList();
//            first.add(terminals.get(i));
////            System.out.println(first);
//            firsts.put(terminals.get(i),first);
//        }
////        System.out.println(firsts);
//
//        for (int i = 0; i < nonTerminals.size(); i++) {
//            ArrayList first = new ArrayList<String>();
//            firsts.put(nonTerminals.get(i), first);
//        }
////        System.out.println(firsts);
//
//        boolean flag;
//        while(true){
//            flag = true;
//            String left;
//            String right;
//            String[] rights;
//            for (int i = 0; i < productions.size(); i++) {
//                left = productions.get(i).returnLeft();
//                rights = productions.get(i).returnRights();
//
//                for (int j = 0; j < rights.length; j++) {
//                    String s = rights[j];
//                    right = rights[j];
//                    System.out.println(s);
//
//                    if (!right.equals("$")) {
////                        System.out.println(right);
//                        for (int k = 0; k < right.length(); k++) {
//                            String[] splitRight = right.split("");
//                            for (int l = 0; l < splitRight.length; l++) {
//                                if (firsts.get(left).contains(splitRight[l])){
//                                    continue;
//                                }
//                                else{
//                                    firsts.get(left).add(splitRight[i]);
////                                    flag = false;
//                                }
//
//                            }
////                            if (firsts.get(left).contains(firsts.get(right).get(k))){
////                                continue;
////                            }else {
////                                firsts.get(left).add(firsts.get(right).get(k));
////                                flag = false;
////                            }
//
//                        }
////                        for (int k = 0; k < firsts.get(right).size(); k++) {
////                            if (firsts.get(left).contains(firsts.get(right).get(k))) {
////                                continue;
////                            } else {
////                                firsts.get(left).add(firsts.get(right).get(k));
////                                flag = false;
////                            }
////                        }
//                    }
//                    if (isCanBeNull(right)){
//                        continue;
//                    }else{
//                        break;
//                    }
//                }
//            }
//            if (flag == true){
//                break;
//            }
//        }
////        System.out.println(firsts);
//    }
//
//    public boolean isCanBeNull(String symbol) {
//        String[] rights;
//        for (int i = 0; i < productions.size(); i++) {
//            // 找到产生式
//            if (productions.get(i).toString().equals(symbol)) {
//                rights = productions.get(i).returnRights();
//                if (rights[0].equals("$")) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
public void setFirst() {
    //1.找到非终结符数组
    //2.为数组每一个元素，求其First集
    //  1.找到非终结符所对应的产生式 eg. E->aBc|b|De|$
    //  2.遍历产生式右部 {aBc , b , De , $}
    //  3.如果第一个字符是终结符 例如 aBc , b  则将a , b加入First(E);
    //  4.如果第一个字符是非终结符 例如 De 则将First(D)加入First(E)
    for (String s : nonTerminals){
        firsts.put(s , GetFirst(s));
    }
    System.out.println(firsts);
}

    private ArrayList<String> GetFirst(String left){
        //非终结符都是产生式左部
        //所以根据非终结符找到对应的产生式
        Production p = FindProd(left);
        ArrayList<String> first = new ArrayList<>();
        //遍历产生式的各个右部
        for (String r : p.right){
            //如果第一个字符是终结符  直接添加进去
            String symbol = String.valueOf(r.charAt(0));
            if(terminals.contains(symbol)){ //看他的第一个字符是否在终结字符里边
                first.add(symbol);
            } else { //如果是非终结符 则递归
                first.addAll(GetFirst(symbol));
            }
        }
        return first;
    }

    private Production FindProd(String left) {
        Production findLeft = productions.get(0);
        for (int i = 0; i < productions.size(); i++) {
             if (productions.get(i).left.equals(left)){
                 findLeft =  productions.get(i);
                 break;
             }
        }
        System.out.println(findLeft.left);
        return findLeft;
    }

    public static void main(String[] args) {
        AnalyseList analyseList = new AnalyseList();
        analyseList.setProductions();
        analyseList.setNonTerminals();
        analyseList.setTerminals();
        analyseList.setFirst();
    }
}
