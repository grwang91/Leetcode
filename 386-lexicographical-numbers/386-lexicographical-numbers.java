class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> ans = new ArrayList<>();
        
        for (int i=1; i<=9; i++) {
            dfs(i, ans, n);
        }
        return ans;
    }
    
    private void dfs(int num, List<Integer> ans, int n) {
        if(num > n) {
            return;
        }
        
        ans.add(num);
        
        for(int i=0; i<=9; i++) {
            dfs(10*num+i, ans, n);
        }
    }
}