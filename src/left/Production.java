package left;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;


public class Production {
    private List<Grammar> productions = new LinkedList();       //产生式
    private List<String> symbols = new ArrayList();        //初始产生式非终结符
    private List<String> nonTerminatingSymbol = new ArrayList(); //LL(1)文法非终结符
    private List<String> terminatingSymbol = new ArrayList();    //LL(1)文法终结符

    public Production(List productions) {
        super();
        this.productions = productions;
        symbolProductions();
    }

    public List getProductions() {
        return productions;
    }

    public List getSymbols() {
        return symbols;
    }

    public List getNonTerminatingSymbol(){
        return nonTerminatingSymbol;
    }

    public List getTerminatingSymbol(){
        return terminatingSymbol;
    }

    public void removeLeftRecursion() {
        for (int i = 0; i < symbols.size(); i++) {
            for (int j = 0; j < i; j++) {
                iterativeReplacement(symbols.get(i), symbols.get(j));
            }
            removeLeftRecursion(symbols.get(i));
        }
        no_or_is_terminatingSymbol();
    }

    private void symbolProductions() {
        if (productions.size() != 0) {
            for (int i = 0; i < productions.size(); i++) {
                if (!((ArrayList) symbols).contains(productions
                        .get(i).getLeft().charAt(0))) {
                    symbols.add(String.valueOf(productions.get(i).getLeft().charAt(0)));
                }
            }
        }
    }

    private void no_or_is_terminatingSymbol() {
        for (int i = 0; i < productions.size(); i++) {
            if (!((ArrayList) nonTerminatingSymbol)
                    .contains(productions.get(i).getLeft())) {
                nonTerminatingSymbol.add(productions.get(i).getLeft());
            }
            if (productions.get(i).getLeft() == productions.get(i).getLeft()
                    .charAt(0)
                    + "'") {
                nonTerminatingSymbol.add(productions.get(i).getLeft());
            }
        }
        for (int i = 0; i < productions.size(); i++) {
            String temp = productions.get(i).getRight();
            temp = temp.replace("epsilon", "#");
            for (int j = 0; j < nonTerminatingSymbol.size(); j++) {
                temp = temp.replaceAll((String) nonTerminatingSymbol.get(j), "");
            }
            temp = temp.replaceAll("\\\\|", "");
            temp = temp.replaceAll("'", "");
            char[] chars = temp.toCharArray();
            for (int k = 0; k < chars.length; k++) {
                if (chars[k] == '#') {
                    if (!terminatingSymbol.contains("epsilon")) {
                        terminatingSymbol.add("epsilon");
                    }
                } else {
                    if (!terminatingSymbol.contains(String.valueOf(chars[k]))) {
                        terminatingSymbol.add(String.valueOf(chars[k]));
                    }
                }
            }
        }
    }

    private void iterativeReplacement(Object left, Object right) {
        ListIterator listIterator = productions.listIterator();
        while (listIterator.hasNext()) {
            String inRight = "";
            Grammar grammar = (Grammar) listIterator.next();
            if (grammar.getLeft().equals(left.toString())) {
                boolean isReplacement = false;
                String[] rights = grammar.getRight().split("\\\\|");
                for (int i = 0; i < rights.length; i++) {
                    if (rights[i].startsWith(right.toString())) {
                        isReplacement = true;
                    }
                }
                if (isReplacement) {
                    ListIterator _listIterator = productions
                            .listIterator();
                    while (_listIterator.hasNext()) {
                        Grammar _grammar = (Grammar) _listIterator.next();
                        if (_grammar.getLeft().equals(right.toString())) {
                            String[] _rights = _grammar.getRight().split("\\\\|");
                            for (int i = 0; i < rights.length; i++) {
                                boolean isCheck = false;
                                if (rights[i].startsWith(right.toString())) {
                                    isCheck = true;
                                    for (int j = 0; j < _rights.length; j++) {
                                        String temp = rights[i];
                                        inRight += (temp.replaceFirst(
                                                right.toString(), _rights[j]) + "|");
                                    }
                                }
                                if (!isCheck) {
                                    inRight += (rights[i] + "|");
                                }
                            }
                        }
                    }
                    if (inRight.length() != 0) {
                        listIterator.remove();
                        listIterator.add(new Grammar(left.toString(), inRight
                                .substring(0, inRight.length() - 1)));
                    }
                }
            }
        }
    }

    private void removeLeftRecursion(String left) {
        ListIterator listIterator = productions.listIterator();
        while (listIterator.hasNext()) {
            Grammar grammar = (Grammar) listIterator.next();
            if (grammar.getLeft().equals(left.toString())) {
                String[] rights = grammar.getRight().split("\\\\|");
                boolean isLeftRecursion = false;
                for (int i = 0; i < rights.length; i++) {
                    if (rights[i].startsWith(left.toString())) {
                        isLeftRecursion = true;
                    }
                }
                if (isLeftRecursion) {
                    listIterator.remove();
                    String oneRight = "", twoRight = "";
                    for (int i = 0; i < rights.length; i++) {
                        if (!rights[i].startsWith(left.toString())) {
                            oneRight += (rights[i]
                                    .concat(left.toString() + "'") + "|");
                        } else {
                            twoRight += (rights[i].replaceFirst(
                                    left.toString(), "").concat(
                                    left.toString() + "'") + "|");
                        }
                    }
                    listIterator.add(new Grammar(left.toString(), oneRight
                            .substring(0, oneRight.length() - 1)));
                    listIterator.add(new Grammar(left.toString() + "'",
                            twoRight.concat("epsilon")));
                }
            }
        }
    }

    @Override
    public String toString() {
        String temp = "非终结符: ";
        for (int i = 0; i < nonTerminatingSymbol.size(); i++) {
            temp += nonTerminatingSymbol.get(i) + " ";
        }
        temp+="  共计:"+nonTerminatingSymbol.size();
        temp += "\\n终结符: ";
        for (int i = 0; i < terminatingSymbol.size(); i++) {
            temp += terminatingSymbol.get(i) + "  ";
        }
        temp+="  共计:"+terminatingSymbol.size();
        temp += "\\n消除左递归后的文法:\\n";
        for (int i = 0; i < productions.size(); i++) {
            temp += (productions.get(i) + "\\n");
        }
        return temp;
    }
}
