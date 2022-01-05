class Solution {
    public int numSteps(String s) {
        int ans = 0;
        while(!s.equals("1")) {
            ans++;
            if(s.charAt(s.length()-1)=='1') {
                s = add(s);
            } else {
                s = s.substring(0,s.length()-1);
            }
        }
        
        return ans;
    }
    
    private String add(String s) {
        char[] arr = s.toCharArray();
        
        boolean adder = true;
        for (int i=arr.length-1; i>=0; i--) {
            if(adder) {
                if(arr[i] == '0') {
                    arr[i] = '1';
                    adder = false;
                } else {
                    arr[i] = '0';
                    adder = true;
                }
            }
        }
        
        return adder? "1"+new String(arr) : new String(arr); 
    }
}