import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class TwoSumInTree {
    List<Integer> result = new ArrayList();
    public boolean findTarget(TreeNode root, int k) {
        boolean flag = false;
        List<Integer> treeNodes = findNodes(root);
        for (int i = 0; i < treeNodes.size(); i++) {
            if (treeNodes.contains(k-treeNodes.get(i))){
                flag = true;
                break;
            }

        }
        return flag;
    }

    public List findNodes(TreeNode root) {
        if (root != null) {
            result.add(root.val);
            findNodes(root.left);
            findNodes(root.right);
        }
        return result;
    }

//    public boolean findTarget(TreeNode root, int k) {
//        HashSet<Integer> set = new HashSet<>();
//        return dfs(root, set, k);
//    }
//
//    public boolean dfs(TreeNode root, HashSet<Integer> set, int k){
//        if(root == null)return false;
//        if(set.contains(k - root.val))return true;
//        set.add(root.val);
//        return dfs(root.left, set, k) || dfs(root.right, set, k);
//    }

    public static void main(String[] args) {
        TwoSumInTree twoSumInTree = new TwoSumInTree();
        TreeNode t1 = new TreeNode(5);
        t1.left = new TreeNode(3);
        t1.left.left = new TreeNode(2);
        t1.left.right = new TreeNode(4);
        t1.right = new TreeNode(6);
        t1.left.right = new TreeNode(7);
        System.out.println(twoSumInTree.findNodes(t1));
        System.out.println(twoSumInTree.findTarget(t1,19));

    }

}
