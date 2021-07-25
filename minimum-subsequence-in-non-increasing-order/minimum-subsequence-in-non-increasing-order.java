class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        Integer[] numsArr = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(numsArr, Collections.reverseOrder());
        int sum = 0;
        int partialSum = 0;
        List<Integer> arr = new ArrayList<>();
        
        for (int num : numsArr) {
            sum+=num;
        }
        
        for (int num : numsArr) {
            arr.add(num);
            partialSum += num;
            sum -= num;
            if(partialSum > sum) {
                break;
            }
        }
        
        return arr;
        
    }
}