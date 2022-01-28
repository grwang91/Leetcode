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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null) {
            return false;
        }
        
        if(root.val == subRoot.val) {
            if (checkSame(root, subRoot)) {
                return true;
            }
        }
        
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
    
    private boolean checkSame(TreeNode root, TreeNode subRoot) {
        if(root == null) {
            return true;
        }
        
        if(root.val != subRoot.val) {
            return false;
        }
        
        if(root.left == null && subRoot.left != null || root.left != null && subRoot.left == null || root.right == null 
           && subRoot.right != null || root.right != null && subRoot.right == null) {
            return false;
        }
        
        return checkSame(root.left, subRoot.left) && checkSame(root.right, subRoot.right);
    }
}