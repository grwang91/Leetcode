class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((p1,p2)->p2.c-p1.c);
        int[] count = new int[26];
        
        for(char c: s.toCharArray()) {
            count[c-'a']++;
        }
        
        for(int i=0; i<26; i++) {
            if(count[i] == 0) continue;
            
            pq.add(new Pair((char)(i+'a'), count[i]));
        }
        
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()) {
            Pair largest = pq.poll();
            Pair secondLarge = pq.poll();
            
            if(secondLarge == null) {
                sb.append(Character.toString(largest.c).repeat(Math.min(repeatLimit, largest.cnt)));
                continue;
            }
            
            int cnt1 = largest.cnt;
            int cnt2 = secondLarge.cnt;
            
            while(cnt1 > 0 && cnt2 > 0) {
                if(cnt1 > repeatLimit) {
                    sb.append(Character.toString(largest.c).repeat(repeatLimit));
                    sb.append(secondLarge.c);
                    cnt2--;
                    cnt1-=repeatLimit;
                } else {
                    sb.append(Character.toString(largest.c).repeat(cnt1));
                    cnt1=0;
                }
            }
            if(cnt1 > 0) {
                pq.add(new Pair(largest.c, cnt1));
            }
            if(cnt2 > 0) {
                pq.add(new Pair(secondLarge.c, cnt2));
            }
        }
        
        return sb.toString();
    }
    
    class Pair {
        char c;
        int cnt;
        
        public Pair (char c, int cnt) {
            this.c = c;
            this.cnt = cnt;
        }
    }
}