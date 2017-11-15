package myWordAnalyse;


import java.io.File;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashMap;

public class AnalyseList {

    ArrayList<Production> productions = new ArrayList<Production>();
    ArrayList<String> nonTerminals = new ArrayList<String>();
    ArrayList<String> terminals = new ArrayList<String>();
    HashMap<String, ArrayList<String>> firsts = new HashMap<>();
    HashMap<String, ArrayList<String>> follows = new HashMap<>();

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
//                            rights[i].equals("$") ||
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
        //1.找到非终结符数组
        //2.为数组每一个元素，求其First集
        //  1.找到非终结符所对应的产生式 eg. E->aBc|b|De|$
        //  2.遍历产生式右部 {aBc , b , De , $}
        //  3.如果第一个字符是终结符 例如 aBc , b  则将a , b加入First(E);
        //  4.如果第一个字符是非终结符 例如 De 则将First(D)加入First(E)
        for (String s : nonTerminals) {
            firsts.put(s, getFirst(s));
        }
//        System.out.println(firsts);
    }

    private ArrayList<String> getFirst(String left) {
        //非终结符都是产生式左部
        //所以根据非终结符找到对应的产生式
        Production p = findProd(left);
        ArrayList<String> first = new ArrayList<>();
        //遍历产生式的各个右部
        for (String r : p.right) {
            //如果第一个字符是终结符  直接添加进去
            String symbol = String.valueOf(r.charAt(0));
            if (terminals.contains(symbol)) { //看他的第一个字符是否在终结字符里边
                first.add(symbol);
            } else { //如果是非终结符 则递归
                first.addAll(getFirst(symbol));
            }
        }
        return first;
    }

    private Production findProd(String left) {
        Production findLeft = productions.get(0);
        for (int i = 0; i < productions.size(); i++) {
            if (productions.get(i).left.equals(left)) {
                findLeft = productions.get(i);
                break;
            }
        }
//        System.out.println(findLeft.left);
        return findLeft;
    }

    private void setFollows(){
        for (String s : nonTerminals) {
            follows.put(s, getFollow(s));
        }
        System.out.println(follows);
    }

    private ArrayList<String> getFollow(String leftAtRight) {
        ArrayList<String> follow = new ArrayList<>();
        follow.add("#");
        ArrayList<Production> LR = findNonTerminalAtRight(leftAtRight); //右部包含非终结符的产生式的数组
        for (int i = 0; i < LR.size(); i++) {
            String[] containRight = LR.get(i).right;  //每一个包含本次要找的非终结符的字符串
            for (int j = 0; j < containRight.length; j++) {
                String s = containRight[j];
//                System.out.println(s);
                if (s.contains(leftAtRight)){
                    String[] splitS = s.split("");
                    if (!leftAtRight.equals(splitS[splitS.length-1])){  //不在最后一个位置
                        String willAdd = splitS[s.indexOf(leftAtRight) +1];
                        if (terminals.contains(willAdd) && !follow.contains(willAdd)){  //后面跟的非终结符，直接加进去
                            follow.add(willAdd);
                        }
                        if(nonTerminals.contains(willAdd)){ //后面跟的非终结符，加进去他的follow集
                            for (int k = 0; k < getFollow(willAdd).size(); k++) {
                                if (!follow.contains(getFollow(willAdd).get(k))){
                                    follow.add(getFollow(willAdd).get(k));
                                }
                            }

                            ArrayList<String> first = getFirst(willAdd);  //后面跟的非终结符first里面有空
                            while (first.contains("$")){
                                for (int k = 0; k < first.size(); k++) {
                                    if (!first.get(k).equals("$") && !follow.contains(first.get(k))){
                                        follow.add(first.get(k));
                                    }

                                }
                            }
                        }
                    }
                    if (leftAtRight.equals(splitS[splitS.length-1])){ //如果他在最后一个而且first集里面有空
                        if (getFirst(leftAtRight).contains("$")){
                            String left = LR.get(i).left;
                            follow.addAll(getFirst(left));
                        }
                    }
                }

            }
        }
//        System.out.println(follow);
        return follow;
    }

    private ArrayList<Production> findNonTerminalAtRight(String LR) {
        ArrayList<Production> findRight = new ArrayList<Production>();
        for (int i = 0; i < productions.size(); i++) {
            String[] rights = productions.get(i).right;
            for (int j = 0; j < rights.length; j++) {
                String right = rights[j];
//                System.out.println(right);
                if (right.contains(LR)) {
                    findRight.add(productions.get(i));
                }
            }
        }
        return findRight;
    }




    public static void main(String[] args) {
        AnalyseList analyseList = new AnalyseList();
        analyseList.setProductions();
        analyseList.setNonTerminals();
        analyseList.setTerminals();
        analyseList.setFirst();
//        analyseList.findNonTerminalAtRight("F");
//        analyseList.getFollow("E");
        analyseList.setFollows();

    }
}
