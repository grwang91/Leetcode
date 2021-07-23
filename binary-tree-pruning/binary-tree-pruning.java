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
    public TreeNode pruneTree(TreeNode root) {
        return findZero(root) ? null : root;
        
    }
    
    private boolean findZero(TreeNode root) {
        if(root == null)
            return true;
        
        boolean flag = true;
        if(root.val == 1)
            flag = false;
        
        
        boolean left = findZero(root.left);
        boolean right = findZero(root.right);
        
        if(left)
            root.left = null;
        if(right)
            root.right = null;
        
        return left&&right&&flag;
    }
}