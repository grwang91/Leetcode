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
    double ans = 0;
    public double maximumAverageSubtree(TreeNode root) {
        dfs(root);
        
        return ans;
    }
    
    private Node dfs(TreeNode root) {
        if(root == null) {
            return new Node(0,0);
        }
        
        Node left = dfs(root.left);
        Node right = dfs(root.right);
        
        Node total = new Node(root.val+left.sum+right.sum, left.count+right.count+1);
        ans = Math.max(ans, (double)total.sum/total.count);
        
        return total;
    }
    
    class Node {
        int sum;
        int count;
        
        public Node(int sum, int count) {
            this.sum = sum;
            this.count = count;
        }
    }
}