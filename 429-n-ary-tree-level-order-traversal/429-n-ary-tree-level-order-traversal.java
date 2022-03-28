/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        preorder(root, 0, ans);
        
        return ans;
    }
    
    private void preorder(Node root, int depth, List<List<Integer>> ans) {
        if(root==null) return;
        
        if(ans.size() < depth+1) {
            ans.add(new ArrayList<>());
        }
        
        ans.get(depth).add(root.val);
        
        for(Node n: root.children) {
            preorder(n, depth+1, ans);
        }
    }
}