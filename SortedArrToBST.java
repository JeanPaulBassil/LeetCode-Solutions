public class SortedArrToBST {

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

    private void add(TreeNode child, TreeNode parent){
        if (child.val < parent.val) parent.left = child;
        else parent.right = child;
    }
    private void sub(int start, int end, TreeNode root, int[] nums) {
        int mid = (start + end) / 2;
        TreeNode temp = new TreeNode(nums[mid]);
        add(temp, root);
        if (mid - 1 >= start) sub(start, mid - 1, temp, nums);
        if (end >= mid + 1) sub(mid + 1, end, temp, nums);
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        int mid = nums.length / 2;
        TreeNode root = new TreeNode(nums[mid]);
        if (mid - 1 >= 0) sub(0, mid - 1, root, nums);
        if (mid + 1 <= nums.length - 1) sub(mid + 1, nums.length - 1, root, nums);
        return root;
    }

    public static void main(String[] args) {
        SortedArrToBST sa = new SortedArrToBST();
        sa.sortedArrayToBST(new int[]{1, 3});
    }
}
