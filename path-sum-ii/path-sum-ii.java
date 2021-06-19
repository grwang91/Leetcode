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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> output = new ArrayList<>();
        
        if(root == null)
            return output;
        
        ArrayList<Integer> tmp = new ArrayList<>();
        dfs(root, targetSum, 0, tmp, output);
        
        return output;
    }
    
    private void dfs(TreeNode root, int targetSum, int currentSum, ArrayList<Integer> tmp, List<List<Integer>> output) {

        
        currentSum+=root.val;
        tmp.add(root.val);
        
        if(root.left == null && root.right == null) {
            if(targetSum == currentSum) {
                output.add((List<Integer>)tmp.clone());
            }
            return;
        }
        if(root.left != null) {
            dfs(root.left,targetSum,currentSum,tmp,output);
            tmp.remove(tmp.size()-1);
        }
        
        if(root.right != null) {
            dfs(root.right,targetSum,currentSum,tmp,output);
            tmp.remove(tmp.size()-1);
        }
        
        
        
    }
}