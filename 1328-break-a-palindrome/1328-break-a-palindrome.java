class Solution {
    public String breakPalindrome(String palindrome) {
        if(palindrome.length() == 1) {
            return "";
        }
        
        char[] arr = palindrome.toCharArray();
        for (int i=0; i<palindrome.length()/2; i++) {
            char c = arr[i];
            
            if(c=='a' || palindrome.length()%2==1 && i == palindrome.length()/2) continue;
            
            arr[i] = 'a';
            return String.valueOf(arr);
        }
        
        arr[arr.length-1]='b';
        return String.valueOf(arr);
    }
}