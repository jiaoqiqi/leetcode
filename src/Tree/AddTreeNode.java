package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddTreeNode {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String s1 = s.nextLine();
        String s2 = s.nextLine();
        if (s1==null || s2==null || s1.length()==0 || s2.length()==0 || s1.length()!=s2.length())
            return;
        String[] split = s1.split(" ");
        String[] split1 = s2.split(" ");

        int[] pre = new int[split.length];
        int[] in = new int[split1.length];

        for (int i=0;i<split.length;i++){
            pre[i] = Integer.parseInt(split[i]);
            in[i] = Integer.parseInt(split1[i]);
        }

        TreeNode root = reConstructBinaryTree(pre, in);

        if (root==null)
            System.out.println();
        else{
            convert(root);
            post(root);
            System.out.println();
        }
    }

    private static void post(TreeNode root) {
        if (root==null)
            return;
        post(root.left);
        System.out.print(root.val+" ");
        post(root.right);
    }

    public static List<Long> convert(TreeNode root){
        if(root==null)
            return new ArrayList<>();
        if (root.left==null && root.right==null){
            ArrayList<Long> list = new ArrayList<>();
            long val = root.val;
            root.val = 0;
            list.add(val);
            return list;
        }
        List<Long> list = new ArrayList<>();
        long val = root.val;
        root.val = 0;
        List<Long> left = convert(root.left);
        List<Long> right = convert(root.right);
        for (long i : left){
            root.val+=i;
            list.add(i);
        }
        for (long i : right){
            root.val+=i;
            list.add(i);
        }
        list.add(val);
        return list;
    }

    public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if (pre==null || in==null)
            return null;
        if (pre.length != in.length)
            return null;
        return constructBinaryTree(pre,0,pre.length-1,in,0,in.length-1);
    }

    private static TreeNode constructBinaryTree(int[] pre, int preStart, int preEnd,
                                                int[] in, int inStrat, int inEnd) {
        if (preStart > preEnd || inStrat > inEnd)
            return null;
        TreeNode root = new TreeNode(pre[preStart]);

        for (int i=inStrat;i<=inEnd;i++){
            if (in[i] == pre[preStart]){
                root.left = constructBinaryTree(pre,preStart+1,preStart+i-inStrat,
                        in,inStrat,i-1);
                root.right = constructBinaryTree(pre,preStart+i-inStrat+1,preEnd,
                        in,i+1,inEnd);
                break;
            }
        }
        return root;
    }
}
//class TreeNode {
//    long val;
//    TreeNode left;
//    TreeNode right;
//    TreeNode(int x) { val = x; }
//}
