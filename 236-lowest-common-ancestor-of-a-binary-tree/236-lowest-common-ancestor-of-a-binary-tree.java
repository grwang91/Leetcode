/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode, Integer> pMap = new HashMap<>();
        Map<TreeNode, Integer> qMap = new HashMap<>();
        int maxDepth = -1;
        TreeNode ans = null;
        
        findNode(root, p.val, 0, pMap);
        findNode(root, q.val, 0, qMap);
        
        for (TreeNode key : pMap.keySet()) {
            if(qMap.containsKey(key)) {
                if(maxDepth < pMap.get(key)) {
                    maxDepth = pMap.get(key);
                    ans = key;
                }
            }
        }
        
        return ans;
    }
    
    private boolean findNode(TreeNode root, int target, int depth, Map<TreeNode, Integer> map) {
        if(root == null) {
            return false;
        }
        
        map.put(root, depth);
        if(root.val == target){
            return true;
        }
        
        boolean foundLeft = findNode(root.left, target, depth+1, map);
        if(foundLeft) return true;
        boolean foundRight = findNode(root.right, target, depth+1, map);
        if(!foundRight) {
           map.remove(root); 
        }
        return foundRight;
        
    }
}