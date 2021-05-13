class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Integer> stack = new Stack<>();
        
        for (char c : num.toCharArray()) {
            
            while(!stack.isEmpty() && k>0 && c-'0' < stack.peek()) {
                stack.pop();
                k--;
            }
            stack.push(c-'0');
        }
        
        while(k>0) {
            stack.pop();
            k--;
        }
        
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append((char)(stack.pop()+'0'));
        }
        String s = sb.reverse().toString();
        char[] cArr = s.toCharArray();
        for (int i=0; i<cArr.length; i++) {
            if(cArr[i]=='0')
                cArr[i]=' ';
            else
                break;
        }
        s = new String(cArr).trim();
        
        return s.length()==0? "0":s;
    }
}