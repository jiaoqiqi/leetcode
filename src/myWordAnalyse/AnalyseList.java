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
//        System.out.println("First集：");
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

    private void setFollows() {
        for (String s : nonTerminals) {
            follows.put(s, getFollow(s));
        }
//        System.out.println("Follow集");
//        System.out.println(follows);
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
                if (s.contains(leftAtRight)) {
//                    System.out.println(s);
                    String[] splitS = s.split("");
                    if (!leftAtRight.equals(splitS[splitS.length - 1])) {  //不在最后一个位置
                        String willAdd = splitS[s.indexOf(leftAtRight) + 1];
                        if (terminals.contains(willAdd) && !follow.contains(willAdd)) {  //后面跟的非终结符，直接加进去
                            follow.add(willAdd);
                        }
                        if (nonTerminals.contains(willAdd)) {  //后面跟的非终结符
//                            System.out.println(willAdd);
                            ArrayList<String> first = getFirst(willAdd);  //后面跟的非终结符的first
                            if (first.contains("$")) {    //后面跟的非终结符first里面有空 加产生式左部的follow
                                String left = LR.get(i).left;
                                if (willAdd.equals(left)) {
                                    for (int k = 0; k < getFirst(left).size(); k++) {
                                        if (follow.contains(getFirst(left).get(k)) || getFirst(left).equals("$")) {

                                            continue;
                                        } else {
                                            follow.add(getFirst(left).get(k));
                                        }
                                    }
                                }
                                for (int m = 0; m < getFollow(left).size(); m++) {
                                    if (follow.contains(getFollow(left).get(m))) {
                                        continue;
                                    } else {
                                        follow.add(getFollow(left).get(m));

                                    }
                                }
                            }
                        }
                    }
                    if (leftAtRight.equals(splitS[splitS.length - 1]) && getFirst(leftAtRight).contains("$")) { //如果他在最后一个而且first集里面有空
                        String left = LR.get(i).left;
                        if (!left.equals(leftAtRight)) {
                            for (int k = 0; k < getFollow(left).size(); k++) {
                                if (follow.contains(getFollow(left).get(k))) {
                                    continue;
                                } else {
                                    follow.add(getFollow(left).get(k));

                                }

                            }

                        }
                    }
                }

            }
        }
//        System.out.println(follow);
        if (follow.contains("$")) {
            follow.remove("$");
        }
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

    //构造分析表
    public void predictedTable() {
        String left;
        String right;
        String[] rights;
        ArrayList<String> follow = new ArrayList<String>();
        ArrayList<String> first = new ArrayList<String>();

        ArrayList<String> allNonTerminal = new ArrayList<String>();
        ArrayList<String> allTerminals = new ArrayList<String>();
        allNonTerminal.addAll(nonTerminals);
        allTerminals.addAll(terminals);
        allTerminals.add("#");

        int row = allNonTerminal.size();
        int col = allTerminals.size();

        //初始化为error
        String[][] M = new String[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                M[i][j] = "error";
            }

        }

        //构造分析表M的算法是：
        //(1) 对文法G的每个产生式A->a执行第二步和第三步;
        //(2) 对每个终结符a∈FIRST(A),把A->a加至M[A,a]中;
        //(3) 若ε∈FIRST(a),则把任何b∈FOLLOW(A)把A->a加至M[A,b]中;
        //(4) 把所有无定义的M[A,a]标上出错标志.

        for (int i = 0; i < productions.size(); i++) {
            left = productions.get(i).left;
            rights = productions.get(i).right;
            first = getFirst(left);

            for (int j = 0; j < rights.length; j++) {
                right = rights[j];
                if (!right.equals("$")){
                    String[] splitedRight = right.split("");
                    for (int k = 0; k < splitedRight.length; k++) {
                        String s = splitedRight[k];
                        int AIndex = allNonTerminal.indexOf(left);
                        int aIndex = allTerminals.indexOf(s);
                        if (allTerminals.contains(s) && first.contains(s)){
                            M[AIndex][aIndex] = right;
                        }

                    }
                }
            }

        }

        for (int i = 0 ; i < allTerminals.size() ; ++i){
            System.out.print(allTerminals.get(i) + " ");
        }
        System.out.println();

        for (int i = 0; i < row; i++) {
            System.out.print(allNonTerminal.get(i)+" ");

            for (int j = 0; j < col; j++) {
                System.out.print(M[i][j] + " ");
            }
            System.out.println();
        }

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
        analyseList.predictedTable();

    }
}
