class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        PriorityQueue<String> minHeap = new PriorityQueue<>((s1,s2)->compareString(s1,s2));
        
        for (String n : nums) {
            
            if(minHeap.size() < k) {
                minHeap.add(n);
                continue;
            }
            
            if(compareString(minHeap.peek(),n) < 0) {
                minHeap.add(n);
                minHeap.poll();
            }
        }
        
        return minHeap.peek();
    }
    
    private int compareString(String a, String b) {
        if(a.length() == b.length()) {
            for (int i=0; i<a.length(); i++) {
                if(a.charAt(i) == b.charAt(i)) {
                    continue;
                }
                
                return a.charAt(i) - b.charAt(i);
            }
        }
        
        return a.length() - b.length();
    }
}