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
    public int maxSumBST(TreeNode root) {
        findMax(root);
        
        return ans;
    }
    
    private Node findMax(TreeNode root) {
        if(root == null) {
            return null;
        }
        
        Node left = findMax(root.left);
        Node right = findMax(root.right);
        
        if((left == null || left.isBST && left.max < root.val) && (right == null || right.isBST && right.min > root.val)) {
            int sum = root.val;
            sum+=left==null? 0: left.sum;
            sum+=right==null? 0: right.sum;
            int max = right == null? root.val: right.max;
            int min = left == null? root.val: left.min;
            ans = Math.max(ans,sum);
            return new Node(sum, max, min, true);
        }
        
        return new Node(0,0,0,false);
    }
    
    class Node {
        int sum;
        int max;
        int min;
        boolean isBST;
        
        public Node(int sum, int max, int min, boolean isBST) {
            this.sum = sum;
            this.max = max;
            this.min = min;
            this.isBST = isBST;
        }
    }
}