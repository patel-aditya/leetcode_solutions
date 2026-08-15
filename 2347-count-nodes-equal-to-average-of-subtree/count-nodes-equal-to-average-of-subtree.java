/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int res = 0;

    public int[] solve(TreeNode node) {
        if (node == null) {
            return new int[] { 0, 0 };
        }

        int[] left = solve(node.left);
        int[] right = solve(node.right);

        if ((left[1] + right[1] + node.val) / (left[0] + right[0] + 1) == node.val)
            res++;
        // System.out.println( sum +  " " + (1  + left + right));
        return new int[] { 1 + left[0] + right[0], node.val + left[1] + right[1] };
    }

    public int averageOfSubtree(TreeNode root) {
        solve(root);
        return res;
    }
}