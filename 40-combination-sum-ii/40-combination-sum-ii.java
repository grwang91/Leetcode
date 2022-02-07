class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> tmp = new ArrayList<>();
        Arrays.sort(candidates);
        
        backTrack(candidates, -1, target, tmp, ans);
        
        return ans;
    }
    
    private void backTrack(int[] candidates, int idx, int target, ArrayList<Integer> tmp, List<List<Integer>> ans) {
        if(target <= 0) {
            if(target == 0) {
                ans.add((ArrayList<Integer>)tmp.clone());
            }
            return;
        }
        int pre = -1;
        for (int i=idx+1; i<candidates.length; i++) {
            if(pre == candidates[i]) {
                continue;
            }
            pre = candidates[i];
            tmp.add(candidates[i]);
            backTrack(candidates, i, target-candidates[i], tmp, ans);
            tmp.remove(tmp.size()-1);
        }
    }
}