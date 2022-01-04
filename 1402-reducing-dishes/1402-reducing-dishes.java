class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        
        int coefficient = 0;
        int selected = 0;
        
        for (int i=satisfaction.length-1; i>=0; i--) {
            int tmp = coefficient + selected + satisfaction[i];
            if(tmp >= coefficient) {
                coefficient = tmp;
                selected+=satisfaction[i];
            }
        }
        
        return coefficient;
    }
}