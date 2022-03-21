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
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        Set<Integer> set = new HashSet<>();
        preorderSet(root1, set);
        
        return findSum(root2, set, target);
    }
    
    private void preorderSet(TreeNode root, Set<Integer> set) {
        if(root == null) return;
        
        set.add(root.val);
        preorderSet(root.left, set);
        preorderSet(root.right, set);
    }
    
    private boolean findSum(TreeNode root, Set<Integer> set, int target) {
        if(root == null) return false;
        
        if(set.contains(target-root.val)) return true;
        
        return findSum(root.left, set, target) || findSum(root.right, set, target);
    }
}