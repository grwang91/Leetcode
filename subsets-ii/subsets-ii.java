class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        ArrayList<Integer> tmp = new ArrayList<>();
        output.add(new ArrayList<>());
        Arrays.sort(nums);
        
        backtrack(nums, 0, tmp, output);
        
        return output;
        
    }
    
    private void backtrack(int[] nums, int idx, ArrayList<Integer> tmp, List<List<Integer>> output) {
        
        for (int i=idx; i<nums.length; i++) {
            if(i!=idx && nums[i] == nums[i-1]) {
                continue;
            }
            
            tmp.add(nums[i]);
            output.add((List<Integer>)tmp.clone());
            backtrack(nums,i+1,tmp,output);
            tmp.remove(tmp.size()-1);
        }
    }
}