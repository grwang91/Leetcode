class Solution {
    String ans = "";
    int diff = Integer.MAX_VALUE;
    public String nextClosestTime(String time) {
        char[] digits = new char[4];
        digits[0] = time.charAt(0);
        digits[1] = time.charAt(1);
        digits[2] = time.charAt(3);
        digits[3] = time.charAt(4);
        
        backTrack(digits, "", time.substring(0,2)+time.substring(3));
        
        return ans;
    }
    
    private void backTrack(char[] digits, String cur, String time) {
        if(cur.length()==4) {
            int curDiff = countDiff(cur, time);
            // System.out.println(cur + " " + curDiff);
            if(curDiff < diff) {
                diff = curDiff;
                ans = cur.substring(0,2)+":"+cur.substring(2);
            }
            return;
        }
        for(int i=0; i<4; i++) {
            backTrack(digits, cur+digits[i], time);
        }
    }
    
    private int countDiff(String s, String time) {
        int diff = 0;
        int sh = Integer.parseInt(s.substring(0,2));
        int sm = Integer.parseInt(s.substring(2));
        int th = Integer.parseInt(time.substring(0,2));
        int tm = Integer.parseInt(time.substring(2));
        if(sh > 23 || sm > 59) {
            return Integer.MAX_VALUE;
        }
        
        diff+=tm > sm? 60+sm-tm: sm-tm;
        diff+=tm > sm? 60*(sh-1-th): 60*(sh-th);
        if(time.compareTo(s) >= 0) {
            diff+=24*60;
        } 
        
        return diff;
    }
}