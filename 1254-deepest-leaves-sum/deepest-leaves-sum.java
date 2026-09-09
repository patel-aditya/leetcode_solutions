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
    int depth = 0;
    void traverse(TreeNode root, int height){
        if(root == null) return;
        depth++;
        if(depth == height) res += root.val;
        traverse(root.left, height);
        traverse(root.right, height);
        depth--;
    }
    public int deepestLeavesSum(TreeNode root) {
        int height = getHeight(root);
        traverse(root, height);
        return res;
    }

    int getHeight(TreeNode node){
        if(node == null) return 0;
        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }
}