class Solution {
    public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
        int s = 0;
        int T = 0;
        int point = 0;
        
        for (int i=0; i<calories.length; i++) {
            T+=calories[i];
            
            if(i-s+1 > k) {
                T-=calories[s++];
            } else if (i-s+1 < k) {
                continue;
            }
            if(T < lower) {
                point--;
            } else if (T > upper) {
                point++;
            }
        }
        
        return point;
    }
}