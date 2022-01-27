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
    public int findDistance(TreeNode root, int p, int q) {
        int ans = 0;
        ArrayList<Boolean> tmp = new ArrayList<>();
        List<Boolean> locP = findNode(root, p, tmp);
        List<Boolean> locQ = findNode(root, q, tmp);
        
        boolean flag = false;
        for (int i=0; i<Math.min(locP.size(), locQ.size()); i++) {
            if(flag) {
                ans++;
                continue;
            }
            if(locP.get(i)==locQ.get(i)) {
                continue;
            }
            ans+=2;
        }
        
        ans+=Math.abs(locP.size()-locQ.size());
        
        return ans;
    }
    
    private List<Boolean> findNode(TreeNode root, int val, ArrayList<Boolean> tmp) {
        if(root==null) {
            return null;
        }
        
        if(root.val == val) {
            return (ArrayList<Boolean>)tmp.clone();
        }
        
        tmp.add(true);
        List<Boolean> left = findNode(root.left, val, tmp);
        tmp.remove(tmp.size()-1);
        
        tmp.add(false);
        List<Boolean> right = findNode(root.right, val, tmp);
        tmp.remove(tmp.size()-1);
        
        return left==null? right: left;
        
    }
}