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
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if(root == null) return root;
        
        List<Integer> list = new ArrayList<>();
        
        postorder(root, list);
        TreeNode ans = new TreeNode(list.get(0));
        TreeNode cur = ans;
        int idx = 1;
        while(cur != null && idx<list.size()) {
            cur.left = list.get(idx)==null? null: new TreeNode(list.get(idx));
            idx++;
            if(idx == list.size()) break;
            cur.right = list.get(idx)==null? null: new TreeNode(list.get(idx));
            idx++;
            cur = cur.right;
        }
        
        // for(int i=0; i<list.size(); i++) {
        //     System.out.println(list.get(i));
        // }

        return ans;
    }
    
    private void postorder(TreeNode root, List<Integer> list) {
        if(root != null && root.left == null && root.right == null) {
            list.add(root.val);
            return;
        }
        
        if(root != null)
            postorder(root.left, list);
        if(root != null)
            postorder(root.right, list);
        list.add(root==null? null: root.val);
    }
}