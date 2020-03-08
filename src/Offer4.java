import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by zyt on 15/10/27 16:33.
 */
public class Offer4 {

    //  Definition for binary tree
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre == null || pre.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(pre[0]);
        int rootIndex = -1;
        for (int i = 0; i < in.length; i++) {
            if (in[i] == pre[0]) {
                rootIndex = i;
                break;
            }
        }
        root.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, 1 + rootIndex),
                Arrays.copyOfRange(in, 0, rootIndex));
        root.right = reConstructBinaryTree(Arrays.copyOfRange(pre, 1 + rootIndex, pre.length),
                Arrays.copyOfRange(in, rootIndex + 1, in.length));
        return root;
    }

    public void print(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.val);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

    public static void main(String[] args) {
        Offer4 offer4 = new Offer4();
        TreeNode root = offer4.reConstructBinaryTree(new int[]{1, 2, 4, 3, 5, 6}, new int[]{4, 2, 1, 5, 3, 6});
        offer4.print(root);
    }
}
