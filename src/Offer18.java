/**
 * Created by zyt on 15/12/20 20:44.
 */
public class Offer18 {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public void Mirror(TreeNode root) {
        if (root == null) return;
        TreeNode tree = root.left;
        root.left = root.right;
        root.right = tree;
        Mirror(root.left);
        Mirror(root.right);
    }
}
