class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        // Map<Integer, List<Integer>> map = new HashMap<>();
        int ans = 0;
        // map.computeIfAbsent(0, k -> new ArrayList<>()).add(0);
        Set<Integer> set = new HashSet<>();
        
        for(int a: arr) {
            set.add(a);
        }
        
        
        for(int i=0; i<arr.length; i++) {
            for (int j=i+1; j<arr.length; j++) {
                int a = arr[i];
                int b = arr[j];
                int len = 2;
                while(set.contains(a+b)) {
                    b = a+b;
                    a = b-a;
                    len++;
                }
                
                if(len>2) {
                    ans = Math.max(ans,len);
                }
            }
        }
        return ans;
        
    }
}