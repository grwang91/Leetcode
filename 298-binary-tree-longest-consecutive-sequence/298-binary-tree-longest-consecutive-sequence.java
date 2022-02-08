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
    int ans = 0;
    public int longestConsecutive(TreeNode root) {
        findConsecutive(root, -30002, 1);
        
        return ans;
    }
    
    private void findConsecutive(TreeNode root, int pre, int len) {
        if(root == null) return;
        
        if(pre+1 == root.val) {
            len++;
        } else {
            len = 1;
        }
        ans = Math.max(ans, len);
        pre = root.val;
        
        findConsecutive(root.left, pre, len);
        findConsecutive(root.right, pre, len);
    }
}