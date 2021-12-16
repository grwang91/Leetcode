class Solution {
    public int[] processQueries(int[] queries, int m) {
        int n = queries.length;
        int[] ans = new int[n];
        
        List<Integer> arr = new ArrayList<>();
        for (int i=1; i<=m; i++) {
            arr.add(i);
        }
        
        for(int i=0; i<n; i++) {
            int idx = findIdx(arr, queries[i]);
            ans[i] = idx;
            arr.remove(idx);
            arr.add(0,queries[i]);
        }
        
        return ans;
    }
    
    private int findIdx(List<Integer> arr, int target) {
        for (int i=0; i<arr.size(); i++) {
            if(arr.get(i) == target) {
                return i;
            }
        }
        return -1;
    }
}