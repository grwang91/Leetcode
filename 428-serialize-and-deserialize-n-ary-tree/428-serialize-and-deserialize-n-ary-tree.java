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

class Codec {
    // Encodes a tree to a single string.
    public String serialize(Node root) {
        if(root == null) {
            return "";
        }
        Queue<Node> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        q.add(root);
        
        while(!q.isEmpty()) {
            Node current = q.poll();
            sb.append("i"+current.val);
            sb.append("n"+current.children.size());
            
            for (Node child : current.children) {
                q.add(child);
            }
        }
        return sb.toString();
    }
	
    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if(data.length() == 0) {
            return null;
        }
        data = data.substring(1);
        String[] split = data.split("i");
        Node head = null;
        Queue<Node> values = new LinkedList<>();
        Queue<DeserNode> nums = new LinkedList<>();
        
        
        for (String s : split) {
            int val = Integer.parseInt(s.split("n")[0]);
            Node node = new Node(val, new ArrayList<>());
            values.add(node);
            int childrenNum = Integer.parseInt(s.split("n")[1]);
            nums.add(new DeserNode(node, childrenNum));
        }
        
        head = values.poll();
        Node tmp = head;
        while(!nums.isEmpty()) {
            DeserNode current = nums.poll();
            Node currentNode = current.node;
            
            for (int i=0; i<current.childrenNum; i++) {
                currentNode.children.add(values.poll());
            }
        }
        return head;
    }
    
    class DeserNode {
        Node node;
        int childrenNum;
        
        public DeserNode(Node node, int childrenNum) {
            this.node = node;
            this.childrenNum = childrenNum;
        }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));