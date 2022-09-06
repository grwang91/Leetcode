class Solution {
    public int mostBooked(int n, int[][] meetings) {
        int[] cnt = new int[n];
        Arrays.sort(meetings, (m1, m2)-> m1[0]-m2[0]);
        PriorityQueue<Integer> ready = new PriorityQueue<>();
        PriorityQueue<Pair> used = new PriorityQueue<>((p1,p2)->p1.fin==p2.fin? p1.num-p2.num: p1.fin-p2.fin);
        int ans = -1;
        int max = 0;
        for(int i=0; i<n; i++) {
            ready.add(i);
        }
        
        for(int[] meeting: meetings) {
            while(!used.isEmpty() && used.peek().fin <= meeting[0]) {
                ready.add(used.poll().num);
            }
            if(!ready.isEmpty()) {
                int num = ready.poll();
                cnt[num]++;
                used.add(new Pair(num, meeting[1]));
            } else {
                Pair p = used.poll();
                cnt[p.num]++;
                used.add(new Pair(p.num, p.fin+meeting[1]-meeting[0]));
            }
        }
        
        for(int i=0; i<n; i++) {
            if(cnt[i] > max) {
                max = cnt[i];
                ans = i;
            } else if (cnt[i] == max) {
                ans = Math.min(ans, i);
            }
        }
        return ans;
        
    }
    
    class Pair {
        int num;
        int fin;
        
        public Pair(int num, int fin) {
            this.num = num;
            this.fin = fin;
        }
    }
}