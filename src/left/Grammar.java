package left;

public class Grammar {
    private String left;
    private String right;
    private int id;
    private static int ID = 0;

    public Grammar() {
        super();
        id = ID++;
    }

    public Grammar(String left, String right) {
        super();
        this.left = left;
        this.right = right;
        id = ID++;
    }

    public String getLeft() {
        return left;
    }

    public void setLeft(String left) {
        this.left = left.replace(" ", "");
    }

    public String getRight() {
        return right;
    }

    public void setRight(String right) {
        this.right = right.replace(" ", "");
    }

    public int getId() {
        return id;
    }

    public String toString() {
        return "Grammar [left=" + left + ", right=" + right + "]";
    }
}
