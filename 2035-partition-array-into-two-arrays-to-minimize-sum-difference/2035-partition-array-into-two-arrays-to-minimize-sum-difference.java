class Solution {
    public int minimumDifference(int[] nums) {
        int n = nums.length/2, totalSum = 0;
        for (int num : nums) totalSum += num;
        
        // left(i) stores all subset sum of size i from the left part.
        // right defined in similar way
        List<List<Integer>> left = new ArrayList<>(n);
        List<List<Integer>> right = new ArrayList<>(n);
        for(int i=0;i<=n;++i) {
            left.add(new ArrayList<>());
            right.add(new ArrayList<>());
        }
        
        fillSubsetSum(nums, 0, n-1, left);
        fillSubsetSum(nums, n, 2*n-1, right);
        
        int minDiff = Integer.MAX_VALUE;
        for(int leftSubsetSize=0;leftSubsetSize<=n;++leftSubsetSize) {
            int rightSubsetSize = n - leftSubsetSize;
            
            for(int sum : left.get(leftSubsetSize)) {
                int minDiffLocal = (int) Math.abs(
                    findMinimalDifference(sum, right.get(rightSubsetSize), totalSum)
                );
                minDiff = Integer.min(minDiff, minDiffLocal);
            }
        }
        
        return minDiff;
    }
    
    /**
     * O(log(right.size()))
     */
    private int findMinimalDifference(int leftSum, List<Integer> right, int totalSum) {
        int low = 0, high = right.size()-1;
        int diff = 0, minDiff = Integer.MAX_VALUE;
        
        while (low <= high) {
            int mid = (low + high) / 2;
            diff = totalSum - 2*leftSum - 2*right.get(mid);
            minDiff = Integer.min(Math.abs(diff), minDiff);
            
            if (diff == 0)
                return 0;
            else if (diff > 0) low = mid+1;
            else high = mid-1;
        }
        
        return Integer.min(Math.abs(diff), minDiff);
    }
    
    /**
     * O(2^n)
     * 1 <= n <= 15 => 2^n ~ 2^15 = ~32k
     */
    private void fillSubsetSum(int[] nums, int low, int high, List<List<Integer>> resArray) {
        int n = high - low + 1;
        
        for(int i=0;i<(int)Math.pow(2, n);++i) {
            int subsetSum = 0;
            int size = 0;
            for(int j=0;j<16;++j) {
                if ((i & (1<<j)) > 0 && low+j<nums.length) {
                    subsetSum += nums[low+j];
                    ++size;
                }
            }
            
            resArray.get(size).add(subsetSum);
        }
        
        for(List<Integer> list : resArray) Collections.sort(list);
    }
}