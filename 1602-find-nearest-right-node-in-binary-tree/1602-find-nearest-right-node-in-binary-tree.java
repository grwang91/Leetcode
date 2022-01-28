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
    TreeNode ans = null;
    boolean flag = false;
    int targetDepth = 0;
    public TreeNode findNearestRightNode(TreeNode root, TreeNode u) {
        inorder(root, u, 0);
        
        return ans;
    }
    
    private void inorder(TreeNode root, TreeNode u, int depth) {
        if(root == null) {
            return;
        }
        
        if(flag && depth == targetDepth) {
            ans = root;
            flag = false;
            return;
        }
        
        if(root.val == u.val) {
            flag = true;
            targetDepth = depth;
        }
        
        inorder(root.left, u, depth+1);
        inorder(root.right, u, depth+1);
    }
}