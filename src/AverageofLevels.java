//https://leetcode.com/problems/average-of-levels-in-binary-tree/description/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class AverageofLevels {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
         if (root == null){
             return result;
         }
         q.add(root);  //加进去第一层
//         TreeNode ro = q.poll();
//         System.out.println(ro.val);
         while(!q.isEmpty()){
             int n = q.size();  //某一行元素个数
             double sum = 0.0;
             for (int i = 0; i < n; i++) {
                 TreeNode node = q.poll();
                 sum += node.val;
                 if (node.left!=null){
                     q.offer(node.left);
                 }
                 if(node.right!=null){
                     q.offer(node.right);
                 }
             }
             result.add(sum/n);
         }
         return result;
    }

    public static void main(String []args){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        AverageofLevels averageofLevels = new AverageofLevels();
        System.out.println(averageofLevels.averageOfLevels(root));
    }


}