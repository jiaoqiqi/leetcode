package Tree;

import java.util.*;

/**
 * Definition for a binary tree node.
 * public class Tree.TreeNode {
 * int val;
 * Tree.TreeNode left;
 * Tree.TreeNode right;
 * Tree.TreeNode(int x) { val = x; }
 * }
 */
//https://leetcode.com/problems/find-largest-value-in-each-tree-row/description/

public class TreeRowBigest {
    public List<Integer> largestValues(TreeNode root) {
        List bigestRow = new ArrayList();

        Queue<TreeNode> rowTree = new LinkedList<>();
        if (root == null){
            return bigestRow;
        }

        rowTree.add(root);
        while (!rowTree.isEmpty()){
            int n = rowTree.size();
            List row = new ArrayList();

            for (int i = 0; i < n; i++) {
                TreeNode node = rowTree.poll();
                row.add(node.val);
//                System.out.println(row);
                if(row.size()>=n){
                    bigestRow.add(Collections.max(row));
                }
//                System.out.println(Collections.max(row));;
                if (node.left!=null){
                    rowTree.offer(node.left);
                }
                if(node.right!=null){
                    rowTree.offer(node.right);
                }
            }
//            bigestRow.add(Collections.max(row));

        }

        return bigestRow;
    }

    public static void main(String[] args) {
        TreeRowBigest treeRowBigest = new TreeRowBigest();
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(5);
        treeNode.right=new TreeNode(2);
        treeNode.left.left = new TreeNode(6);
        treeNode.left.right = new TreeNode(9);
//        treeRowBigest.largestValues(treeNode);
        System.out.println(treeRowBigest.largestValues(treeNode));
    }
}
