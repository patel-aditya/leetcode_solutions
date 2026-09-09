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
int depth = 0;
int maxDepth = 0;
void traverse(TreeNode root){
    if(root == null) return;
    depth++;
    traverse(root.left);
    traverse(root.right);
    maxDepth = Math.max(maxDepth, depth);
    depth--;
}
    public int maxDepth(TreeNode root) {
        traverse(root);
        return maxDepth;
    }
}