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
    public int largestBSTSubtree(TreeNode root) {
        checkBST(root);
        
        return ans;
    }
    
    private Node checkBST(TreeNode root) {
        if(root == null) {
            return new Node(0, true, Integer.MAX_VALUE,Integer.MIN_VALUE);
        }
        
        Node left = checkBST(root.left);
        Node right = checkBST(root.right);
        
        if(left.BST && right.BST && root.val < right.min && root.val > left.max) {
            ans = Math.max(left.size+right.size+1, ans);
            return new Node(left.size+right.size+1, true, Math.min(root.val,left.min), Math.max(root.val, right.max));
        }
        
        return new Node(left.size+right.size+1, false, 0, 0);
    }
    
    class Node {
        int size;
        boolean BST;
        int min;
        int max;
        
        public Node(int size, boolean BST, int min, int max) {
            this.size = size;
            this.BST = BST;
            this.min = min;
            this.max = max;
        }
    }
}