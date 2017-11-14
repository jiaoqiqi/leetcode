//https://leetcode.com/problems/invert-binary-tree/description/

public class InvertTree {

    public TreeNode invertTree(TreeNode root) {

        if (root==null){
            return root;
        }
        if(root!=null){
            TreeNode change=root.left;
            root.left = root.right;
            root.right = change;
            invertTree(root.left);
            invertTree(root.right);
        }
        return root;

    }

    public void printTree(TreeNode root){

        if (root!=null){
            System.out.println(root.val);
            printTree(root.left);
            printTree(root.right);
        }
    }

    public static void main(String[] args) {
     InvertTree invertTree = new InvertTree();
        TreeNode t1 = new TreeNode(1);
        t1.left= new TreeNode(3);
        t1.right = new TreeNode(2);
        invertTree.printTree(t1);
        invertTree.invertTree(t1);
        System.out.println("After invert");
        invertTree.printTree(t1);

    }
}
