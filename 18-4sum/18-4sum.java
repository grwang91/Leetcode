class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        Set<String> set = new HashSet<>();
        
        for(int i=0; i<nums.length; i++) {
            // if(i>0 && nums[i] == nums[i-1]) continue;
            for(int j=i+1; j<nums.length; j++) {
                // if(j>i+1 && nums[j] == nums[j-1]) continue;
                int curTarget = target-nums[i]-nums[j];
                int s = j+1;
                int e = nums.length-1;
                
                while(s<e) {
                    int sum = nums[s]+nums[e];
                    if(sum == curTarget) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(nums[i]);
                        sb.append(nums[j]);
                        sb.append(nums[s]);
                        sb.append(nums[e]);
                        String hash = sb.toString();
                        if(!set.contains(hash)) {
                            ans.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[s], nums[e])));
                            set.add(hash);
                        }
                            
                        s++;
                    } else if (sum < curTarget) {
                        s++;
                    } else {
                        e--;
                    }
                }
            }
        }
        return ans;
    }
}