class Solution {
    public int fixedPoint(int[] arr) {
        int s = 0;
        int e = arr.length;
        int ans = arr.length;
        
        while(s<e) {
            int m = (s+e)/2;
            if(arr[m] == m) {
                ans = Math.min(ans, m);
                e = m;
            } else if (arr[m] > m){
                e=m;
            } else {
                s = m+1;
            }
        }
        
        return ans == arr.length? -1: ans;
    }
}