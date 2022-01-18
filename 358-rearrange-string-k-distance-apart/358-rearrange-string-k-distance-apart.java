class Solution {
    public String rearrangeString(String s, int k) {
        int[] cnt = new int[26];
        PriorityQueue<Pair> pq = new PriorityQueue<>((p1,p2) -> p2.count-p1.count);
        Queue<Pair> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            cnt[c-'a']++;
        }
        for (int i=0; i<26; i++) {
            if(cnt[i] > 0) {
                pq.add(new Pair((char)(i+'a'), cnt[i]));
            }       
        }

        while(!pq.isEmpty()) {
            Pair current = pq.poll();
            sb.append(current.c);
            current.count--;
            q.add(current);
            if(q.size() > k-1) {
                Pair pre = q.poll();
                if(pre.count > 0)
                    pq.add(pre);
            }
        }
        String ans = sb.toString();
        return ans.length() == s.length() ? ans : "";
    }
    
    class Pair{
        char c;
        int count;
        
        public Pair(char c, int count) {
            this.c = c;
            this.count = count;
        }
    }
}