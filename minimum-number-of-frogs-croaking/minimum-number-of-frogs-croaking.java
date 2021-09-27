class Solution {
    public int minNumberOfFrogs(String croakOfFrogs) {
        int[] count = new int[5];
        int ans = 0;
        
        for (char c : croakOfFrogs.toCharArray()) {
            if(c=='c') {
                count[0]++;
                ans = Math.max(ans,count[0]);
            } else if (c=='r') {
                if(count[0] <= count[1]) {
                    return -1;
                }
                count[1]++;
            } else if (c=='o') {
                if(count[1] <= count[2]) {
                    return -1;
                }
                count[2]++;
            } else if (c=='a') {
                if(count[2] <= count[3]) {
                    return -1;
                }
                count[3]++;
            } else if (c=='k') {
                if(count[3] <= count[4]) {
                    return -1;
                }
                for(int i=0; i<4; i++) {
                    count[i]--;
                }
            }
        }
        
        for (int i=0; i<5; i++) {
            if(count[i] != 0) {
                return -1;
            }
        }
        return ans;
    }
}