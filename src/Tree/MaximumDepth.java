package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepth {
    public int maxDepth(TreeNode root) {
        int dep = 0;
        if (root==null){
            return dep;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            dep++;
            int n = q.size();  //某一行元素个数
            for (int i = 0; i < n; i++) {
                TreeNode node = q.poll();
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
        }
        return dep;
    }

    public static void main(String []args){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        MaximumDepth maximumDepth = new MaximumDepth();
        System.out.println(maximumDepth.maxDepth(root));

    }

}
