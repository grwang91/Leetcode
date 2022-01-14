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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<Node> traversedOutput = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        dfs(root, 0, 0, traversedOutput);
        
        Collections.sort(traversedOutput, (n1, n2) -> n1.column == n2.column ? n1.depth - n2.depth : n1.column-n2.column);
        
        int preColumn = -10000;
        for (Node n : traversedOutput) {
            if(preColumn != n.column) {
                ans.add(new ArrayList<>());
                preColumn = n.column;
            }
            ans.get(ans.size()-1).add(n.val);
        }
        
        return ans;
    }
    
    private void dfs(TreeNode root, int depth, int column, List<Node> traversedOutput) {
        if(root == null) {
            return;
        }
        
        traversedOutput.add(new Node(root.val, depth, column));
        dfs(root.left, depth+1, column-1, traversedOutput);
        dfs(root.right, depth+1, column+1, traversedOutput);
    }
    
    class Node {
        int val;
        int depth;
        int column;
        
        public Node(int val, int depth, int column) {
            this.val = val;
            this.depth = depth;
            this.column = column;
        }
    }
}