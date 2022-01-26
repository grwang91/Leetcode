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
    public String smallestFromLeaf(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        sb.append((char)(root.val+'a'));
        return dfs(root, sb);
    }
    
    private String dfs(TreeNode root, StringBuilder sb) {

        if(root.left == null && root.right==null) {
            return reverseString(sb.toString());
        }
        
        String left = "";
        String right = "";
        
        if(root.left != null) {
            sb.append((char)(root.left.val+'a'));
            left = dfs(root.left, sb);
            sb.deleteCharAt(sb.length()-1);
        }
        
        if(root.right != null) {
            sb.append((char)(root.right.val+'a'));
            right = dfs(root.right, sb);
            sb.deleteCharAt(sb.length()-1);
        }
        
        if(left.equals("")) {
            return right;
        } else if (right.equals("")) {
            return left;
        } 
        return left.compareTo(right) > 0? right : left;
    }
    
    private String reverseString(String s) {
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }
}