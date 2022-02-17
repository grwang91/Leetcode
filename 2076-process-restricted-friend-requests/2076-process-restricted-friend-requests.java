class Solution {
    public boolean[] friendRequests(int n, int[][] restrictions, int[][] requests) {
        int[] parent = new int[n];
        boolean[] ans = new boolean[requests.length];
        
        for(int i=0; i<n; i++) {
            parent[i] = i;
        }
        
        for(int i=0; i<ans.length; i++) {
            int[] request = requests[i];
            int a = getParent(parent, request[0]);
            int b = getParent(parent, request[1]);
            boolean flag = false;
            
            for(int[] restriction: restrictions) {
                int x = getParent(parent, restriction[0]);
                int y = getParent(parent, restriction[1]);
                
                if(a==x && b==y || a==y && b==x) {
                    flag = true;
                    break;
                }
            }
            if(flag) continue;
            union(parent, a, b);
            ans[i] = true;
        }
        return ans;
    }
    
    private int getParent(int[] parent, int a) {
        if(parent[a] == a) return a;
        
        return parent[a] = getParent(parent, parent[a]);
    }
    
    private void union(int[] parent, int a, int b) {
        a = getParent(parent, a);
        b = getParent(parent, b);
        if(a<b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }
}