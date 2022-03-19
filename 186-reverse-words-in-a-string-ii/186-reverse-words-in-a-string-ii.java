class Solution {
    public void reverseWords(char[] s) {
        
        int start = 0;
        int end = s.length-1;
        
        while(start < end) {
            swap(s, start, end);
            start++;
            end--;
        }
        
        start = 0;
        for(int i=0; i<s.length; i++) {
            if(s[i] == ' ') {
                int curS = start;
                int curE = i-1;
                while(curS<curE) {
                    swap(s, curS, curE);
                    curS++;
                    curE--;
                }
                start = i+1;
            }
        }
        
        int curS = start;
        int curE = s.length-1;
        while(curS<curE) {
            swap(s, curS, curE);
            curS++;
            curE--;
        }
        
    }
    
    private void swap(char[] s, int start, int end) {
        char tmp = s[start];
        s[start] = s[end];
        s[end] = tmp;
    }
}