class Solution {
    public int maximumSum(int[] arr) {
        int ans = arr[0];
        int notDeleted = arr[0];
        int deleted = 0;
        
        for(int i=1; i<arr.length; i++) {
            deleted = Math.max(notDeleted, deleted+arr[i]);
            notDeleted = Math.max(notDeleted+arr[i], arr[i]);
            ans = Math.max(ans, Math.max(deleted, notDeleted));
        }
        
        return ans;
    }
}