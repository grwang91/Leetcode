class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((p1,p2)->p2.count-p1.count);
        StringBuilder sb = new StringBuilder();
        
        if(a>0) pq.add(new Pair('a', a));
        if(b>0) pq.add(new Pair('b', b));
        if(c>0) pq.add(new Pair('c', c));
        
        char pre = '0';
        int cnt = 1;
        while(!pq.isEmpty()) {
            Pair cur = pq.poll();
            int count = cur.count;
            if(pre == cur.c) {
                if(cnt == 2) {
                    if(pq.isEmpty()) {
                        break;
                    }
                    Pair second = pq.poll();
                    sb.append(second.c);
                    pre = second.c;
                    cnt = 1;
                    if(second.count > 1) {
                        pq.add(new Pair(second.c, second.count-1));
                    }
                } else {
                    sb.append(cur.c);
                    cnt++;
                    count--;
                }
            } else {
                sb.append(cur.c);
                pre = cur.c;
                cnt = 1;
                count--;
            }
            if(count>0) {
                pq.add(new Pair(cur.c, count));
            }
        }
        
        return sb.toString();
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