package Tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {
    List<Integer> result = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root != null) {
            inorderTraversal(root.left);
//            visted(subTree);
            result.add(root.val);
            inorderTraversal(root.right);
        }
        return result;

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        BinaryTreeInorderTraversal binaryTreeInorderTraversal = new BinaryTreeInorderTraversal();
        System.out.println(binaryTreeInorderTraversal.inorderTraversal(root));
    }
}
