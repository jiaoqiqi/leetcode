//https://leetcode.com/problems/trim-a-binary-search-tree/description/

public class TimeTree {
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) return null;

        if (root.val < L) return trimBST(root.right, L, R);
        if (root.val > R) return trimBST(root.left, L, R);

        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);

        return root;
    }

    public static void main(String []args) {
        TimeTree timeTree = new TimeTree();
        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(0);
        t1.right = new TreeNode(2);
        TreeNode note = timeTree.trimBST(t1, 1, 2);

    }
}
