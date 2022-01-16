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
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> left = new ArrayList<>();
        List<Integer> leaves = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        
        left.add(root.val);
        if(root.left != null) {
            leftBoundary(root.left, true, left, leaves);
        }
        if(root.right != null) {
            rightBoundary(root.right, true, right, leaves);
        }
        for (int leaf : leaves) {
            left.add(leaf);
        }
        for (int i=right.size()-1; i>=0; i--) {
            left.add(right.get(i));
        }
        return left;
    }
    
    private void leftBoundary(TreeNode root, boolean isLeft, List<Integer> left, List<Integer> leaves) {
        if(isLeft) {
            left.add(root.val);
        } else if (root.left == null && root.right == null) {
            leaves.add(root.val);
        }
        
        if(root.left != null) {
            leftBoundary(root.left, isLeft, left, leaves);
            if(root.right != null)
                leftBoundary(root.right, false, left, leaves);
        } else if (root.right != null) {
            leftBoundary(root.right, isLeft, left, leaves);
        }
        
    }
    
    private void rightBoundary(TreeNode root, boolean isRight, List<Integer> right, List<Integer> leaves) {
        if(root.left == null && root.right == null) {
            leaves.add(root.val);
        } else if (isRight) {
            right.add(root.val);
        }
        
        if(root.right != null) {
            if(root.left != null)
                rightBoundary(root.left, false, right, leaves);
            rightBoundary(root.right, isRight, right, leaves);
        } else if (root.left != null) {
            rightBoundary(root.left, isRight, right, leaves);
        }
        
    }
}