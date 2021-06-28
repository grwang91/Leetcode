class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> output = new ArrayList<>();
        Map<String,Integer> count = new HashMap<>();
        PriorityQueue<String> pq = new PriorityQueue<>((s1,s2) ->
                                                      count.get(s1) == count.get(s2) ?
                                                      s2.compareTo(s1) : count.get(s1)-count.get(s2));
        
        int n = words.length;
        for (int i=0; i<n; i++) {
            count.put(words[i],count.getOrDefault(words[i],0)+1);     
        }
        
        for (String key : count.keySet()) {
            pq.add(key);
            
            if(pq.size() > k) {
                pq.poll();
            } 
        }
        Stack<String> stack = new Stack<>();
        while(!pq.isEmpty()) {
            stack.push(pq.poll());
        }
        while(!stack.isEmpty()) {
            output.add(stack.pop());
        }
        return output;
        
    }
}