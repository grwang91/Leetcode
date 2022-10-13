class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> ans = new ArrayList<>();
        
        int idx = 0;
        for(int i=1; i<=n; i++) {
            if(idx == target.length) break;
            ans.add("Push");
            if(target[idx] != i) ans.add("Pop");
            else idx++;
        }
        
        return ans;
    }
}