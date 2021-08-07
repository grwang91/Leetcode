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
    long MOD = 1000000007;
    long mid = -1;
    public int maxProduct(TreeNode root) {
        long totalSum = getTotalSum(root);
        getMidNum(root,totalSum);
        long ans = (long)(mid*(totalSum-mid));
        return (int)(ans%MOD);
        
    }
    
    private long getTotalSum(TreeNode root) {
        if(root == null)
            return 0;
        
        return root.val+getTotalSum(root.left)+getTotalSum(root.right);
    }
    
    private long getMidNum(TreeNode root, long total) {
        if(root == null)
            return 0;
        
        long left = getMidNum(root.left, total);
        long right = getMidNum(root.right,total);
        mid = getMin(left,right,mid,total);
        
        return root.val+left+right;
    }
    
    private long getMin(long left, long right, long m, long total) {
        long out;
        if(Math.abs(total/2-left) <= Math.abs(total/2-right)) {
            out = left;
        } else {
            out = right;
        }
        if(Math.abs(total/2-out) > Math.abs(total/2-m)) {
            out = m;
        }
        return out;
    }

}