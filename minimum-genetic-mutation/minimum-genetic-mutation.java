class Solution {
    public int minMutation(String start, String end, String[] bank) {
        boolean[] check = new boolean[bank.length];
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(start,0));
        
        while(!q.isEmpty()) {
            Node current = q.poll();
            String str = current.str;
            if(str.equals(end))
                return current.num;
            
            for(int i=0; i<bank.length; i++) {
                if(!check[i] && dist(str,bank[i])==1) {
                    check[i] = true;
                    q.add(new Node(bank[i],current.num+1));
                }
            }
        }
        return -1;
    }
    
    static class Node {
        String str;
        int num;
        
        public Node(String str, int num) {
            this.str = str;
            this.num = num;
        }
    }
    
    private int dist(String a, String b) {
        int cnt = 0;
        
        for (int i=0; i<a.length(); i++) {
            if(a.charAt(i)==b.charAt(i))
                continue;
            cnt++;
        }
        return cnt;
    }
}