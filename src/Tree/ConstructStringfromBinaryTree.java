package Tree;

public class ConstructStringfromBinaryTree {
    public String tree2str(TreeNode t) {
        if (t == null) return "";

        String result = t.val + "";

        String left = tree2str(t.left);
        String right = tree2str(t.right);

        if (left == "" && right == "") return result;
        if (left == "") return result + "()" + "(" + right + ")";
        if (right == "") return result + "(" + left + ")";
        return result + "(" + left + ")" + "(" + right + ")";

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
//        root.right.right = new TreeNode(5);

        ConstructStringfromBinaryTree constructStringfromBinaryTree = new ConstructStringfromBinaryTree();
//        constructStringfromBinaryTree.tree2str(root);
        System.out.println(constructStringfromBinaryTree.tree2str(root));
    }
}
