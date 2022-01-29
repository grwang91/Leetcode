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
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> ans = new ArrayList<>();
        
        inorder(root, target, k, ans);
        
        return ans;
    }
    
    private void inorder(TreeNode root, double target, int k, List<Integer> ans) {
        if(root == null) {
            return;
        }
        
        inorder(root.left, target, k, ans);
        
        if(ans.size() < k) {
            ans.add(root.val);
        } else {
            if(diff(target, ans.get(0)) < diff(target, ans.get(k-1))) {
                ans.set(k-1, diff(target, ans.get(k-1)) > diff(target, root.val)? root.val: ans.get(k-1));
            } else {
                ans.set(0, diff(target, ans.get(0)) > diff(target, root.val)? root.val: ans.get(0));
            }
        }
        Collections.sort(ans);
        
        inorder(root.right, target, k, ans);
    }
    
    private double diff(double target, int val) {
        return Math.abs(target-val);
    }
}