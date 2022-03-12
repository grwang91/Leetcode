class Solution {
    int diff = Integer.MAX_VALUE;
    public int minimumDifference(int[] nums) {
        List<List<Integer>> sum1 = new ArrayList<>();
        List<List<Integer>> sum2 = new ArrayList<>();
        for(int i=0; i<=nums.length/2; i++) {
            sum1.add(new ArrayList<>());
            sum2.add(new ArrayList<>());
        }
        int sum = 0;
        int diff = Integer.MAX_VALUE;
        
        for(int num: nums) {
            sum+=num;
        }
        
        for(int i=0; i<(1<<nums.length/2); i++) {
            int curSum = 0;
            int mask = 1;
            int idx = 0;
            while(mask > 0) {
                if(((mask) & (i<<nums.length/2)) != 0) {
                    curSum+=nums[idx];
                }
                mask = mask<<1;
                idx++;
            }
            sum1.get(ones(i)).add(curSum);
        }
        
        for(int i=0; i<(1<<nums.length/2); i++) {
            int curSum = 0;
            int mask = 1;
            int idx = 0;
            while(mask > 0) {
                if(((mask) & i) != 0) {
                    curSum+=nums[idx];
                }
                mask = mask<<1;
                idx++;
            }
            sum2.get(ones(i)).add(curSum);
        }
        
        for(int i=0; i<nums.length/2; i++) {
            Collections.sort(sum1.get(i));
            Collections.sort(sum2.get(i));
        }
        
        for(int i=0; i<sum1.size(); i++) {
            for(int j=0; j<sum1.get(i).size(); j++) {
                int val = sum1.get(i).get(j);
                List<Integer> arr = sum2.get(nums.length/2-i);
                int s = 0, e = arr.size();
                while(s<e) {
                    int m = (s+e)/2;
                    int curSum = val+arr.get(m);
                    
                    if(curSum > sum/2) {
                        e = m;
                        diff=Math.min(diff, Math.abs(sum-2*curSum));
                    } else {
                        s = m+1;
                        diff=Math.min(diff, Math.abs(sum-2*curSum));
                    }
                }
            }
        }
        
        return diff;
    }
    
    private int ones(int a) {
        int mask = 1;
        int one=0;
        while(mask>0) {
            if((a&mask) !=0) {
                one++;
            }
            mask = mask<<1;
        }
        return one;
    }
    
}