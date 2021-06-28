class Solution {
    public boolean checkIfCanBreak(String s1, String s2) {
        char[] s1Arr = s1.toCharArray();
        char[] s2Arr = s2.toCharArray();
        
        Arrays.sort(s1Arr);
        Arrays.sort(s2Arr);
        
        boolean s1Bigger = true;
        boolean s2Bigger = true;
        
        for (int i=0; i<s1.length(); i++) {
            if(s1Arr[i] < s2Arr[i]) {
                s1Bigger = false;
            }
            if(s2Arr[i] < s1Arr[i]) {
                s2Bigger = false;
            }
        }
        
        return s1Bigger||s2Bigger;
    }
}