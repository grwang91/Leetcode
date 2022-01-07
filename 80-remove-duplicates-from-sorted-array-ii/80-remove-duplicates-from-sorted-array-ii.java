class Solution {
    public int removeDuplicates(int[] nums) {

   int pointer = 0;
    int count = 0;
    int temp = nums[0];
    
    for(int i = 0; i < nums.length; i++){

        if(nums[i] == temp){
            count++;

        }else{
            temp = nums[i];
            count = 1;
        }
        
        if(count <= 2){
            nums[pointer] = nums[i];
            pointer++;
        }
    }
    
    return pointer;
}
}