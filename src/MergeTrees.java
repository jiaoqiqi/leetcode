//https://leetcode.com/problems/merge-two-binary-trees/description/
public class MergeTrees {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null){
            return t2;
        }
        if(t2 == null){
            return t1;
        }
        t1.val += t2.val;
        t1.left = mergeTrees(t1.left,t2.left);
        t1.right = mergeTrees(t1.right,t2.right);
        return t1;
    }
    private int printTree(TreeNode t){
        if (t == null){
            return  0;
        }
        System.out.println(t.val);
        System.out.println(printTree(t.left));
        System.out.println(printTree(t.right));
        return 0;
    }
    public static void main(String []args)throws NullPointerException{
        MergeTrees merge = new MergeTrees();

        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(3);;
        t1.right = new TreeNode(2);
        t1.left.left = new TreeNode(5);

        TreeNode t2 = new TreeNode(2);
        t2.left = new TreeNode(1);
        t2.right = new TreeNode(3);
        t2.left.right= new TreeNode(4);
        t2.right.right= new TreeNode(7);


        System.out.println(merge.printTree(merge.mergeTrees(t1,t2)));

    }

}
