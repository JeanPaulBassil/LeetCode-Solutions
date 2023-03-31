import java.util.ArrayList;
import java.util.List;

public class BinTreeInOrder {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    private void inOrderHelper(TreeNode root, List<Integer> lst){
        if (root.left != null) inOrderHelper(root.left, lst);
        lst.add(root.val);
        if (root.right != null) inOrderHelper(root.right, lst);
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> output = new ArrayList<>();
        if (root == null) return output;
        inOrderHelper(root, output);
        return output;
    }
}
