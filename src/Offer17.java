/**
 * Created by zyt on 15/12/18 10:18.
 */
public class Offer17 {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        boolean result = false;
        if (root1 != null && root2 != null) {
            if (root1.val == root2.val)
                result = HasSameTree(root1, root2);
            if (!result)
                result = HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
        }
        return result;
    }

    public boolean HasSameTree(TreeNode root1, TreeNode root2) {
        if (root2 == null) return true;
        if (root1 == null) return false;
        if (root1.val != root2.val) return false;
        return HasSameTree(root1.left, root2.left) && HasSameTree(root1.right, root2.right);
    }
}
