class Solution {
    public int maximumGain(String s, int x, int y) {
        int ans = 0;
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        char pre = 'a';
        char cur = 'b';
        int p1 = x;
        int p2 = y;
        if(x<y) {
            pre = 'b';
            cur = 'a';
            p1 = y;
            p2 = x;
        }
        
        for(char c : s.toCharArray()) {
            if(c==cur && !stack1.isEmpty() && stack1.peek() == pre) {
                stack1.pop();
                ans+=p1;
                continue;
            }
            stack1.push(c);
        }        
        
        while(!stack1.isEmpty()) {
            char c = stack1.pop();
            if(c==cur && !stack2.isEmpty() && stack2.peek() == pre) {
                stack2.pop();
                ans+=p2;
                continue;
            }
            stack2.push(c);
        }
        return ans;
    }
}