class Solution {
    public void duplicateZeros(int[] arr) {
        int[] ans = new int[arr.length];
        int idx = 0;
        
        for (int i=0; i<arr.length; i++) {
            if(idx >= arr.length) break;
            
            ans[idx++] = arr[i];
            
            if(arr[i] == 0 && idx < arr.length) {
                ans[idx++] = arr[i];
            }
        }
        
        for (int i=0; i<arr.length; i++) {
            arr[i] = ans[i];
        }
    }
}