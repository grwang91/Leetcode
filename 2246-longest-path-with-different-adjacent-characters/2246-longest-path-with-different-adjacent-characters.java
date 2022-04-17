class Solution {
    int ans = 0;
    public int longestPath(int[] parent, String s) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for(int i=0; i<parent.length; i++) {
            int from = parent[i];
            int to = i;
            
            if(!map.containsKey(from)) {
                map.put(from, new ArrayList<>());
            }
            
            map.get(from).add(to);
        }
        
        return postOrder(0, map, s). max;
    }
    
    private Pair postOrder(int root, Map<Integer, List<Integer>> map, String s) {
        if(!map.containsKey(root)) {
            return new Pair(1, 1);
        }
        int max = 0;
        int first = 0;
        int second = 0;
        for(int next: map.get(root)) {
            Pair pre = postOrder(next, map, s);
            max = Math.max(pre.max, max);
            
            if(s.charAt(next) != s.charAt(root)) {

                if(pre.cnt > first) {
                    second = first;
                    first = pre.cnt;
                } else if (pre.cnt > second) {
                    second = pre.cnt;
                }
            }


        }
        max = Math.max(max, 1+first+second);
        return new Pair(max, 1+first);
    }
    
    class Pair {
        int max;
        int cnt;
        
        public Pair(int max, int cnt) {
            this.max = max;
            this.cnt = cnt;
        }
    }
}