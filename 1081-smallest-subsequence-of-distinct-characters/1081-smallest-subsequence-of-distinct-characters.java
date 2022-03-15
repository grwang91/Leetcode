class Solution {
    public String smallestSubsequence(String s) {
        int[] cnt = new int[26];
        Stack<Character> stack = new Stack<>();
        boolean[] exist = new boolean[26];
        
        for(char c: s.toCharArray()) {
            cnt[c-'a']++;
        }
        
        for(char c: s.toCharArray()) {
            while(!stack.isEmpty() && stack.peek() > c && cnt[stack.peek()-'a'] > 0 && !exist[c-'a']) {
                char popped = stack.pop();
                exist[popped-'a'] = false;
            }
            cnt[c-'a']--;
            if(!exist[c-'a']) {
                stack.push(c);    
                exist[c-'a'] = true;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}