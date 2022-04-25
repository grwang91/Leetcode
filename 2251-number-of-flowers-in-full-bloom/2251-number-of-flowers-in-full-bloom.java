class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] persons) {
        PriorityQueue<Integer> start = new PriorityQueue<>();
        PriorityQueue<Integer> end = new PriorityQueue<>();
        PriorityQueue<Integer> p = new PriorityQueue<>();
        int[] ans = new int[persons.length];
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int[] flower: flowers) {
            start.add(flower[0]);
            end.add(flower[1]);
        }
        for(int person: persons) {
            p.add(person);
        }
        int cnt = 0;
        while(!p.isEmpty()) {
            int cur = p.poll();
            // System.out.println("======="+cur);
            if(map.containsKey(cur)) {
                continue;
            }
            
            while(!start.isEmpty() && start.peek() <= cur) {
                start.poll();
                cnt++;
            }
            // System.out.println(cnt);
            int e = -1;
            int endCount = 0;
            while(!end.isEmpty() && end.peek() < cur) {
                end.poll();
                cnt--;
            }
            // System.out.println(cnt);
            map.put(cur, cnt);    
            
        }
        
        for(int i=0; i<persons.length; i++) {
            ans[i] = map.get(persons[i]);
        }
        return ans;
    }
}