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
        PriorityQueue<Integer> pq = new PriorityQueue<>((i1, i2) -> diff(target,i1)-diff(target,i2)>0? -1: 1);
        
        inorder(root, target, k, pq);
        
        return new ArrayList<>(pq);
    }
    
    private void inorder(TreeNode root, double target, int k, PriorityQueue<Integer> pq) {
        if(root == null) {
            return;
        }
        
        inorder(root.left, target, k, pq);
        pq.add(root.val);
        if(pq.size() > k) {
            pq.poll();
        } 
        
        inorder(root.right, target, k, pq);
    }
    
    private double diff(double target, int val) {
        return Math.abs(target-val);
    }
}