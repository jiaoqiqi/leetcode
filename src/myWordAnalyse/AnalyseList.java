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
        //1.找到非终结符数组
        //2.为数组每一个元素，求其First集
        //  1.找到非终结符所对应的产生式 eg. E->aBc|b|De|$
        //  2.遍历产生式右部 {aBc , b , De , $}
        //  3.如果第一个字符是终结符 例如 aBc , b  则将a , b加入First(E);
        //  4.如果第一个字符是非终结符 例如 De 则将First(D)加入First(E)
        for (String s : nonTerminals) {
            firsts.put(s, getFirst(s));
        }
        System.out.println(firsts);
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

    private void setFollows(){
        for (String s : nonTerminals) {
            follows.put(s, getFollow(s));
        }
//        System.out.println(follows);
    }

    private ArrayList<String> getFollow(String leftAtRight) {
        ArrayList<String> follow = new ArrayList<>();
        follow.add("#");
        ArrayList LR = findNonTerminalAtRight(leftAtRight); //包含非终结符的右部的数组
        for (int i = 0; i < LR.size(); i++) {
            String containRight = LR.get(i).toString();  //每一个包含的本次要找的非终结符的字符串
            String[] splitContain = containRight.split("");
            if (!(leftAtRight.equals(splitContain[containRight.length() - 1]))) { //如果非终结符不在最后的位置
                String willAdd = splitContain[containRight.indexOf(leftAtRight) + 1];  //就找到他的下一个字符

                if (terminals.contains(willAdd)) { //如果是终结符直接加入follow集
                    follow.add(willAdd);
                } else {  //如果是非终结符，加入他除去$的first集
                    ArrayList<String> firstWillAdd = getFirst(willAdd);
                    System.out.println(firstWillAdd);
                    for (int j = 0; j < firstWillAdd.size(); j++) {
                        if (follow.contains(firstWillAdd.get(i))) {
                            continue;
                        } else if (!firstWillAdd.get(i).equals("$")) {
                            follow.add(firstWillAdd.get(i));
                        }

                    }
                }
            }
        }
//        System.out.println(follow);
        return follow;
    }

    private ArrayList<String> findNonTerminalAtRight(String LR) {
        ArrayList<String> findRight = new ArrayList<>();
        for (int i = 0; i < productions.size(); i++) {
            String[] rights = productions.get(i).right;
            for (int j = 0; j < rights.length; j++) {
                String right = rights[j];
//                System.out.println(right);
                if (right.contains(LR)) {
                    findRight.add(right);
                }

            }
        }

        return findRight;
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
