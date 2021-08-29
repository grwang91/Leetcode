class Solution {
    public int[] rearrangeArray(int[] nums) {
        // Arrays.sort(nums);
        for(int i=1;i<nums.length-1;i++){
            if(2*nums[i]==(nums[i-1]+nums[i+1]))
            swap(nums,i,i+1);
        }
        for(int i=nums.length-2;i>0;i--){
            if(2*nums[i]==(nums[i-1]+nums[i+1]))
            swap(nums,i,i-1);
        }
        return nums;
    }
    private void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}