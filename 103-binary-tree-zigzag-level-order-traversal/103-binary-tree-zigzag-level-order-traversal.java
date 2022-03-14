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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        
        preorder(root, 0, ans);
        for(int i=0; i<ans.size(); i++) {
            if(i%2==1) {
                Collections.reverse(ans.get(i));
            }
        }
        return ans;
    }
    
    private void preorder(TreeNode root, int depth, List<List<Integer>> ans) {
        if(root==null) return;
        
        if(ans.size() < depth+1) ans.add(new ArrayList<>());
        
        ans.get(depth).add(root.val);
        preorder(root.left, depth+1, ans);
        preorder(root.right, depth+1, ans);
        
    }
}