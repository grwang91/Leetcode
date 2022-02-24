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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums, 0, nums.length-1);
    }
    
    private TreeNode construct(int[] nums, int l, int r) {
        int max = -1;
        int idx = 0;
        for(int i=l; i<=r; i++) {
            if(nums[i] > max) {
                max = nums[i];
                idx = i;
            }
        }
        TreeNode root = new TreeNode(max);
        if(idx > l) {
            root.left = construct(nums, l, idx-1);
        }
        if(idx < r) {
            root.right = construct(nums, idx+1, r);
        }
        return root;
    }
}