class Solution {
    public int minSwaps(String s) {
        int openIdx = s.length()-1;
        int swaps = 0;
        int sum = 0;
        
        for(int i=0; i<=openIdx; i++) {
            char c = s.charAt(i);
            if(c=='[') {
                sum++;
            } else if (sum!=0){
                sum--;
            } else {
                while(s.charAt(openIdx) == '[') {
                    openIdx--;
                }
                sum++;
                swaps++;
            }
        }
        return swaps;
    }
}