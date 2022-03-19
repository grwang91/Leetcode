class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> tmp = new ArrayList<>();
        
        findFactor(n, tmp, ans);
        
        return ans;
    }
    
    private void findFactor(int n, ArrayList<Integer> tmp, List<List<Integer>> ans) {
        if(n==1) {
            if(tmp.size() > 1)
                ans.add((ArrayList<Integer>)tmp.clone());
            return;
        }
        
        for(int i=1; i<=Math.sqrt(n); i++) {
            if(i==1) {
                tmp.add(n/i);
                findFactor(i, tmp, ans);
                tmp.remove(tmp.size()-1);
                continue;
            }
            if(n%i == 0) {
                if(tmp.size() == 0 || tmp.get(tmp.size()-1) <= i) {
                    tmp.add(i);
                    findFactor(n/i, tmp, ans);
                    tmp.remove(tmp.size()-1);
                }
                
            }
        }
    }
}