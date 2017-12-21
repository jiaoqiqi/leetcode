package Tree;//https://leetcode.com/problems/find-bottom-left-tree-value/description/

public class BottomLeftTree {
    int h = 0;
    int result = 0;

    public int findBottomLeftValue(TreeNode root) {
        findBottomLeftValue(root, 1);
        return result;
    }

    public void findBottomLeftValue(TreeNode root, int depth) {
        if (h < depth) {
            result = root.val;
            h = depth;
        }
        if (root.left != null) findBottomLeftValue(root.left, depth + 1);
        if (root.right != null) findBottomLeftValue(root.right, depth + 1);
    }

    public static void main(String[] args) {
        BottomLeftTree bottomLeftTree = new BottomLeftTree();
        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(3);
        t1.right = new TreeNode(2);
        System.out.println(bottomLeftTree.findBottomLeftValue(t1));
    }
}
