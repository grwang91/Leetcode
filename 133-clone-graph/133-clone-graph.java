/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        Map<Integer, Node> map = new HashMap<>();
        Node ans = new Node(1);
        map.put(1,ans);
        dfs(node, ans, map);
        
        return ans;
    }
    
    private void dfs(Node node, Node copy, Map<Integer, Node> map) {
        
        for (Node neighbor : node.neighbors) {
            if(!map.containsKey(neighbor.val)) {
                map.put(neighbor.val, new Node(neighbor.val));
                copy.neighbors.add(map.get(neighbor.val));
                dfs(neighbor, copy.neighbors.get(copy.neighbors.size()-1), map);
            } else {
                copy.neighbors.add(map.get(neighbor.val));
            }
        }
    }
}