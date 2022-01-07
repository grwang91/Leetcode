class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        
        TreeNode successor;
        
        if(p.right != null)
        {
            successor = p.right;
            while(successor.left != null)
            {
                successor = successor.left;
            }
            return successor;
        }
 
        return helper(root, p, null);
    }
    
    public TreeNode helper(TreeNode root, TreeNode p, TreeNode leftRoot)
    {
        if(root == p)
            return leftRoot;
    
        else if(p.val < root.val)
            return helper(root.left, p, root);
    
        else
            return helper(root.right, p, leftRoot);
    }
}