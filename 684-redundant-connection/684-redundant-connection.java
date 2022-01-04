class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int[] parent = new int[edges.length+1];
        for (int i=0; i<parent.length; i++) {
            parent[i] = i;
        }
        
        for (int[] edge : edges) {
            if(getParent(parent, edge[0]) == getParent(parent, edge[1])) {
                return edge;
            }
            
            union(parent, edge[0], edge[1]);
        }
        
        return null;
    }
    
    private int getParent(int[] parent, int x) {
        if(parent[x] == x) return x;
        return parent[x] = getParent(parent, parent[x]);
    }
    
    private void union(int[] parent, int a, int b) {
        a = getParent(parent,a);
        b = getParent(parent,b);
        if(a<b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }
}