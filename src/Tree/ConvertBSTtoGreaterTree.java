//https://leetcode.com/problems/convert-bst-to-greater-tree/description/

package Tree;

public class ConvertBSTtoGreaterTree {

    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        convert(root);
        return root;
    }

    public void convert(TreeNode cur) {
        if (cur == null) return;
        convert(cur.right);
        cur.val += sum;
        sum = cur.val;
        convert(cur.left);
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(13);
        ConvertBSTtoGreaterTree convertBSTtoGreaterTree = new ConvertBSTtoGreaterTree();
        convertBSTtoGreaterTree.convertBST(root);

    }
}
